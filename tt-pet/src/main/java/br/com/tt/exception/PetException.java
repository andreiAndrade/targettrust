package br.com.tt.exception;

public class PetException extends Exception {

	private static final long serialVersionUID = 1L;

	public PetException(PetExceptionType petExceptionType, Throwable cause) {
		super(petExceptionType.getDescricao(), cause);

	}

	public PetException(PetExceptionType petExceptionType) {
		super(petExceptionType.getDescricao());

	}

}
