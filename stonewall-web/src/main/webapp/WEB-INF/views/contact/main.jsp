<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
Thank you for using stonewall's website. If you have any questions,
comments or would like to be contacted by us please submit a request and
we will get back to you as soon as possible. Alternatively you can
contact us directly on 021-4371923
<c:if test="${response != null && response.success}">
	<div class="sucess">Email sent sucessfully</div>
</c:if>
<c:if test="${response != null && !response.success}">
	<div class="failed">Email failed to send. Please try again later or email <a class="email" href="mailto:john@stonewallgardencentre.com">john@stonewallgardencentre.com</a> directly</div>
</c:if>
<div class="contact">
	<form method="post" enctype="multipart/form-data">
		<fieldset>
			<div>
				<label for="email">Email Address</label> <input id="email"
					title="Email Address to respond to" type="text" name="email" />
			</div>
			<div>
				<label for="phoneNumber">Phone Number</label> <input
					id="phoneNumber" title="Phone Number to contact" type="text"
					name="phoneNumber" />
			</div>
			<div>
				<label for="name">Name</label> <input id="name"
					title="Name of customer" type="text" name="name" />
			</div>
			<div>
				<label for="message">Comment / question</label>
				<textarea id="message" title="Comment or question" name="message"></textarea>
			</div>
		</fieldset>
		<div class="submit">
			<input type="submit" title="Submit comment / question."
				value="Submit comment / question." />
		</div>
	</form>
</div>
