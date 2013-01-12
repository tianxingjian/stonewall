package com.stonewall.web.email;

import java.io.Serializable;

public class EmailMessage implements Serializable {

	private static final long serialVersionUID = -4093981756240899937L;
	private String subject;
	private String body;
	private String receiverName;
	private String receiverEmail;

	public EmailMessage() {
		super();
	}

	public EmailMessage(String subject, String body, String receiverName, String receiverEmail) {
		super();
		this.subject = subject;
		this.body = body;
		this.receiverName = receiverName;
		this.receiverEmail = receiverEmail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverEmail() {
		return receiverEmail;
	}

	public void setReceiverEmail(String receiverEmail) {
		this.receiverEmail = receiverEmail;
	}
}
