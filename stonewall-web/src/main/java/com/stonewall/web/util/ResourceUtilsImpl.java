package com.stonewall.web.util;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ResourceUtilsImpl implements InitializingBean, ResourceUtils {

	private static final Logger logger = Logger.getLogger(ResourceUtilsImpl.class);

	@Autowired
	private ServletContext servletContext;

	private String resourceDir;

	public String getPictureDirectory() {
		if (resourceDir == null) {
			resourceDir = servletContext.getRealPath("/resources/pictures/");
			logger.debug("resourceDir is set to : " + resourceDir);
		}
		return resourceDir;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(servletContext);
	}

}
