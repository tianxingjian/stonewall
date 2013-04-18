<%@ page import="com.stonewall.web.model.Plant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
	var counter = 0;
	function addAnotherImage(button) {
		counter++;
		$('<p><input id="files[' + counter + ']" class="marginLeft" name="files[' + counter + ']" type="file" accept="image/*" /><input type="button" onClick="removeAnotherImage(this)" value="Remove"/></p>').insertBefore($(button).parent());
	}
	function removeAnotherImage(button) {
		$(button).parent("p").remove();
	}	 
</script>
<div class="displayLandscaping">
	<c:forEach items="${landscapingJobs}" var="landscapingJob">
		<div class="displayJob">
			<a href="#" onclick="toggleDiv(this)" class="clickable">${landscapingJob.name} <br />
			<c:if test="${landscapingJob.description != null && landscapingJob.description != ''}">${landscapingJob.description}</c:if></a>
			<div class="expandable">
				<security:authorize ifAnyGranted="ROLE_ADMIN">
					<form method="post" action='<c:url value="/landscaping"/>'>
						<label class="inline-block" for="name">Name</label><input id="name" name="name" value="${landscapingJob.name}"/><br/>
						<label class="inline-block" for="description">description</label><input id="description" name="description" value="${landscapingJob.description}" /><br/>
						<input name="_method" type="hidden" value="put">
						<input name="id" type="hidden" value="${landscapingJob.id}">
						<input type="submit" value="Update Job" />
					</form>
					<form method="post" action='<c:url value="/landscaping/addphoto"/>' enctype="multipart/form-data">
						<input name="id" type="hidden" value="${landscapingJob.id}">
						<label class="inline-block" for="picture">Add a image</label><input id="picture" name="picture" type="file" accept="image/*" />
						<input type="submit" value="Add Image" />
					</form>
					<form method="post" action='<c:url value="/landscaping"/>'>
						<input name="_method" type="hidden" value="delete">
						<input name="id" type="hidden" value="${landscapingJob.id}">
						<input type="submit" value="Delete Job" />
					</form>
				</security:authorize>
				<div class="display_images">
					<c:forEach items="${landscapingJob.pictures}" var="picture">
						<a href='<c:url value="/resources/pictures/${picture.fileName}"/>' target="_blank">
							<img src='<c:url value="/resources/pictures/${picture.fileName}"/>'>
						</a>
						<security:authorize ifAnyGranted="ROLE_ADMIN">
							<a href='<c:url value="/landscaping/delete/${landscapingJob.id}/${picture.id}"/>'>
								<img id="delete_image" src='<c:url value="/resources/delete.png"/>'>
							</a>
						</security:authorize>
					</c:forEach>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
<security:authorize ifAnyGranted="ROLE_ADMIN">
	<div class="addLandscapingJob">
		<a href="#" onclick="toggleDiv(this)" class="clickable">Add another job</a>
		<div class="expandable">
			<form id="multipartFileList" enctype="multipart/form-data" method="post" action='<c:url value="/landscaping"/>'>
				<label class="inline-block" for="name">Name</label><input id="name" name="name" /><br/>
				<label class="inline-block" for="description">description</label><input id="description" name="description" /><br/>
				<label class="inline-block" for="files[0]">Image</label><input id="files[0]" name="files[0]" type="file" accept="image/*" />
				<p>
					<input type="button" class="marginLeft" onClick="addAnotherImage(this)" value="Upload another image"/>
				</p>
				<p>
					<input type="submit" value="Add Job" />
				</p>
			</form>
		</div>
	</div>
</security:authorize>