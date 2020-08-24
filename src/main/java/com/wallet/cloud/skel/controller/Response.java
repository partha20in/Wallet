package com.wallet.cloud.skel.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<T> {

	private Status status;
	private T payload;
	private String details;
	private static String message = "Credit/debit amount should be more than 0,TransactionId should be Unique and provide valid account and player details";

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;

	}

	

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	

	public static <T> Response<T> badRequest() {
		Response<T> response = new Response<>();
		response.setStatus(Status.BAD_REQUEST);
		return response;
	}

	public static <T> Response<T> ok() {
		Response<T> response = new Response<>();
		response.setStatus(Status.OK);
		return response;
	}

	public static <T> Response<T> unauthorized() {
		Response<T> response = new Response<>();
		response.setStatus(Status.UNAUTHORIZED);
		return response;
	}

	public static <T> Response<T> validationException() {
		Response<T> response = new Response<>();
		response.setStatus(Status.VALIDATION_EXCEPTION);
		return response;
	}

	public static <T> Response<T> wrongCredentials() {
		Response<T> response = new Response<>();
		response.setStatus(Status.WRONG_CREDENTIALS);
		return response;
	}

	public static <T> Response<T> accessDenied() {
		Response<T> response = new Response<>();
		response.setStatus(Status.ACCESS_DENIED);
		return response;
	}

	public static <T> Response<T> exception() {
		Response<T> response = new Response<>();
		response.setStatus(Status.EXCEPTION);
		response.setDetails(message);
		return response;
	}

	public static <T> Response<T> notFound() {
		Response<T> response = new Response<>();
		response.setStatus(Status.NOT_FOUND);
		return response;
	}

	public static <T> Response<T> duplicateEntity() {
		Response<T> response = new Response<>();
		response.setStatus(Status.DUPLICATE_ENTITY);
		return response;
	}

	public enum Status {
		OK, BAD_REQUEST, UNAUTHORIZED, VALIDATION_EXCEPTION, EXCEPTION, WRONG_CREDENTIALS, ACCESS_DENIED, NOT_FOUND,
		DUPLICATE_ENTITY
	}
}