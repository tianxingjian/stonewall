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
<div class="displayFaqs">
	<c:forEach items="${faqEntrys}" var="faqEntry">
		<div class="displayFaq">
			<a href="#" onclick="toggleDiv(this)" class="clickable">${faqEntry.question}</a>
			<div class="expandable">
				<label>${faqEntry.answer}</label><br />
				<security:authorize ifAnyGranted="ROLE_ADMIN">
					<form method="post" action='<c:url value="/faq"/>'>
						<label class="inline-block" for="question">Question</label><input id="question" name="question" value="${faqEntry.question}"/><br/>
						<label class="inline-block" for="answer">Answer</label><input id="answer" name="answer" value="${faqEntry.answer}" /><br/>
						<input name="_method" type="hidden" value="put">
						<input name="id" type="hidden" value="${faqEntry.id}">
						<input type="submit" value="Update FAQ" />
					</form>
					<form method="post" action='<c:url value="/faq"/>'>
						<input name="_method" type="hidden" value="delete">
						<input name="id" type="hidden" value="${faqEntry.id}">
						<input type="submit" value="Delete FAQ" />
					</form>
				</security:authorize>
			</div>
		</div>
	</c:forEach>
</div>
<security:authorize ifAnyGranted="ROLE_ADMIN">
	<div class="addFaq">
		<a href="#addFaq" onclick="toggleDiv(this)" class="clickable">Add another FAQ</a>
		<div class="expandable" id="addFaq">
			<form method="post" action='<c:url value="/faq"/>'>
				<label class="inline-block" for="question">Question</label><input id="question" name="question" /><br/>
				<label class="inline-block" for="answer">Answer</label><input id="answer" name="answer" /><br/>
				<p>
					<input type="submit" value="Add FAQ" />
				</p>
			</form>
		</div>
	</div>
</security:authorize>