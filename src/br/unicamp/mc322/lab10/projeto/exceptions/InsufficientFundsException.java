package br.unicamp.mc322.lab10.projeto.exceptions;

@SuppressWarnings("serial")
public class InsufficientFundsException extends IllegalStateException {

	public InsufficientFundsException(String s) {
		super(s);
	}
}
