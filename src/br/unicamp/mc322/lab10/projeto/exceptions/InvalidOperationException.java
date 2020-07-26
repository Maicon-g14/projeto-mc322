package br.unicamp.mc322.lab10.projeto.exceptions;

import java.util.InputMismatchException;

@SuppressWarnings("serial")
public class InvalidOperationException extends InputMismatchException {

	public InvalidOperationException(String s) {
		super(s);
	}
}
