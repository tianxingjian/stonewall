<%@ page import="com.stonewall.web.model.Plant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
	$(document).ready(function(){
		$(".expandable").hide();
	});
</script>
<div class="displayCategories">
	<c:forEach items="${categories}" var="categorie" varStatus="row">
		<div class="displayCategorie">
			<a href="#" onclick="toggleDiv(this)" class="clickable">${categorie.key}</a>
			<div class="expandable">
				<c:forEach items="${categorie.value}" var="plant" varStatus="row">
					<label>${plant.name}</label><br />
				</c:forEach>
			</div>
		</div>
	</c:forEach>
</div>
<security:authorize ifAnyGranted="ROLE_ADMIN">
	<h4>PrePopulate plants</h4>
	<form method="post">
		<input value="PrePopulate Plants" type="submit" />
	</form>
</security:authorize>
