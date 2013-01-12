package com.stonewall.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.stonewall.web.dao.LandscapingRepositoryImpl;
import com.stonewall.web.dao.PictureRepository;
import com.stonewall.web.model.LandscapingJob;
import com.stonewall.web.model.MultipartFileList;
import com.stonewall.web.model.Picture;
import com.stonewall.web.util.ResourceUtils;

/**
 * Handles requests for the landscaping page
 */
@RequestMapping("landscaping")
@Controller
public class LandscapingController implements InitializingBean {

	private static final Logger logger = Logger.getLogger(LandscapingController.class);

	@Autowired
	private LandscapingRepositoryImpl landscapingRepo;

	@Autowired
	private PictureRepository pictureRepo;

	@Autowired
	private ResourceUtils utils;

	public LandscapingController() {
		logger.info("initialising lanscaping controller");
	}

	@RequestMapping(method = RequestMethod.GET)
	public void landscapingGet(ModelMap model) {
		logger.debug("Received landscaping get request");
		populateModel(model);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void landscapingPost(ModelMap model, @ModelAttribute("multipartFileList") MultipartFileList multipartFileList) {
		logger.debug("Received post landscape:" + multipartFileList.toString());
		LandscapingJob landscapingJob = new LandscapingJob();
		landscapingJob.setName(multipartFileList.getName());
		landscapingJob.setDescription(multipartFileList.getDescription());
		if (multipartFileList != null && multipartFileList.getFiles() != null) {
			for (MultipartFile image : multipartFileList.getFiles()) {
				if (image.getSize() > 0) {
					landscapingJob.getPictures().add(addPicture(image));
				}
			}
		}
		landscapingRepo.save(landscapingJob);
		populateModel(model);
	}

	@RequestMapping(value = "addphoto", method = RequestMethod.POST)
	public String addPicture(ModelMap model, @RequestParam("id") String id, @RequestParam("picture") MultipartFile picture) {
		logger.debug("Received add photo request for id:" + id);
		LandscapingJob job = landscapingRepo.findById(id);
		if (job != null && !picture.isEmpty()) {
			job.getPictures().add(addPicture(picture));
			logger.debug("Found job and adding photo");
			landscapingRepo.save(job);
		}
		populateModel(model);
		return "landscaping";
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void updateLandscaping(ModelMap model, @RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("description") String description) {
		logger.debug("Updating landscape with id:" + id);
		LandscapingJob job = landscapingRepo.findById(id);
		if (job != null) {
			job.setName(name);
			job.setDescription(description);
		}
		landscapingRepo.save(job);
		populateModel(model);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteLandscaping(ModelMap model, @RequestParam("id") String id) {
		logger.debug("Removing landscape with id:" + id);
		landscapingRepo.delete(id);
		populateModel(model);
	}

	@RequestMapping(value = "delete/{job_id}/{picture_id}", method = RequestMethod.GET)
	public String deletePhoto(ModelMap model, @PathVariable String job_id, @PathVariable String picture_id) {
		logger.debug("Deleting photo with picture id " + picture_id + " job id " + job_id);
		LandscapingJob job = landscapingRepo.findById(job_id);
		Picture remove = null;
		for (Picture pic : job.getPictures()) {
			if (pic != null) {
				if (picture_id.equals(pic.getId())) {
					remove = pic;
				}
			}
		}
		if (remove != null) {
			job.getPictures().remove(remove);
			pictureRepo.delete(remove);
			landscapingRepo.save(job);
		} else {
			logger.warn("Failed to find picture to delete");
		}
		populateModel(model);
		return "landscaping";
	}

	private Picture addPicture(MultipartFile image) {
		Picture picture = new Picture();
		String fileName = image.getOriginalFilename();
		picture.setName(fileName);
		int pos = fileName.lastIndexOf('.');
		String ext = fileName.substring(pos + 1);
		String filename = UUID.randomUUID().toString() + "." + ext;
		File pictureFile = new File(utils.getPictureDirectory(), filename);
		picture.setPicture(pictureFile);
		picture.setFileName(filename);
		pictureFile.getParentFile().mkdirs();
		OutputStream os = null;
		try {
			os = new FileOutputStream(pictureFile);
			FileCopyUtils.copy(image.getInputStream(), os);
		} catch (Exception e) {
			logger.error("Error writing image file to filesystem", e);
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					logger.error("Error closing image stream after exception", e);
				}
			}
		}
		return picture;
	}

	private void populateModel(ModelMap model) {
		List<LandscapingJob> landscapingJobs = landscapingRepo.findAll();
		if (logger.isDebugEnabled()) {
			for (LandscapingJob lb : landscapingJobs) {
				logger.debug(lb.toString());
			}
		}
		model.addAttribute("landscapingJobs", landscapingJobs);
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) {
		logger.error("Exception in Landcaping controller", e);
		ModelAndView mv = new ModelAndView("landscaping");
		populateModel(mv.getModelMap());
		return mv;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(landscapingRepo, "Autowiring of landscapingRepository failed");
		Assert.notNull(pictureRepo, "Autowirign of pictureRepository failed");
	}

}
