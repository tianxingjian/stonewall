package com.stonewall.web.email;

import java.util.ArrayList;
import java.util.List;

/**
 * A POJO containing the status of an action and a {@link List} of messages. This is mainly used as a DTO for the
 * presentation layer
 */
public class StatusResponse {

	private boolean success;
	private List<String> message;

	public StatusResponse() {
		this.message = new ArrayList<String>();
	}

	public StatusResponse(boolean success) {
		super();
		this.success = success;
		this.message = new ArrayList<String>();
	}

	public StatusResponse(boolean success, String message) {
		super();
		this.success = success;
		this.message = new ArrayList<String>();
		this.message.add(message);
	}

	public StatusResponse(boolean success, List<String> message) {
		super();
		this.success = success;
		this.message = message;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<String> getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message.add(message);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String mess : message) {
			sb.append(mess + ", ");
		}

		return "StatusResponse [success=" + success + ", message=" + sb.toString() + "]";
	}
}
