package com.stonewall.web.email;

public interface EmailService {
	public StatusResponse send(EmailMessage message);
}
