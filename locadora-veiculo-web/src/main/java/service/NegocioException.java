package service;

import org.hibernate.metamodel.domain.Superclass;

public class NegocioException extends Exception{
	
	public NegocioException(String message) {
		super(message);
	}
}
