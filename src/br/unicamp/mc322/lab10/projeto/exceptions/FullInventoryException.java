package br.unicamp.mc322.lab10.projeto.exceptions;

@SuppressWarnings("serial")
public class FullInventoryException extends IllegalStateException {

	public FullInventoryException(String s) {
		super(s);
	}
}
