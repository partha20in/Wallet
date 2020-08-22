package com.wallet.cloud.skel.exception;

public class PlayerAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PlayerAlreadyExistsException() {
		super();
	}

	public PlayerAlreadyExistsException(String message) {
		super(message);
	}

}
