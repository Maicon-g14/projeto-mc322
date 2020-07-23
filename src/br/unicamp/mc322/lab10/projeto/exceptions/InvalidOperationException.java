package br.unicamp.mc322.lab10.projeto.exceptions;

import java.util.InputMismatchException;

public class InvalidOperationException extends InputMismatchException {

	public InvalidOperationException(String s) {
		super(s);
	}
}
