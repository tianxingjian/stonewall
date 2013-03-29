<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<ul>
	<li><a href='<c:url value="/welcome"/>'>Welcome</a></li>
	<li><a href='<c:url value="/plants"/>'>Plants</a></li>
	<li><a href='<c:url value="/landscaping"/>'>Landscaping</a></li>
	<li><a href='<c:url value="/annual"/>'>Annual Sale</a></li>
	<li><a href='<c:url value="/friends"/>'>Friends of Stonewall</a></li>
	<li><a href='<c:url value="/faq"/>'>FAQ</a></li>
	<li><a href='<c:url value="/contact"/>'>Contact Us</a></li>

	<!-- Need to figure out how to float this right -->
	<li class="loginLink"><security:authorize
			ifAnyGranted="ROLE_USER,ROLE_ADMIN">
			<!-- Lets use the default login until i create a page to do it. -->
			<a href="<c:url value="/j_spring_security_logout"/>"
				style="font-size: 15px;">Logout: <security:authentication
					property="principal.username" />
			</a>
		</security:authorize> <security:authorize ifNotGranted="ROLE_USER,ROLE_ADMIN">
			<a href="<c:url value="/login"/>" style="font-size: 20px; margin-left: 10px;">Login</a>
		</security:authorize></li>
</ul>