package br.unicamp.mc322.lab10.projeto.exceptions;

@SuppressWarnings("serial")
public class InvalidTypeException extends IllegalArgumentException {

	public InvalidTypeException(String s) {
		super(s);
	}
}
