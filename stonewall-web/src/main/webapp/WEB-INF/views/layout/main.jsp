<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
	<head>
		<title><tiles:insertAttribute name="title" ignore="true" /></title>
		<link rel="stylesheet" href="<c:url value="/styles/main.css" />"
			type="text/css">
		<script type="text/javascript" src="<c:url value="/styles/jquery-1.9.1.min.js" />"></script>
	</head>
	<body>
		<script type="text/javascript">
			function toggleDiv(link) {
				$(link).next().slideToggle();
			}
			$(document).ready(function(){
				$(".clickable").attr("title","Click to expand");
			});
		</script>
		<div id="body">
			<div id="header">
				<tiles:insertAttribute name="header" />
			</div>
			<div id="content">
				<div id="menu">
					<tiles:insertAttribute name="menu" />
				</div><div id="main">
					<tiles:insertAttribute name="body" />
				</div>
				<div id="footer" class="outline">
					<footer>
						<tiles:insertAttribute name="footer" />
					</footer>
				</div>
			</div>
		</div>
	</body>
</html>
