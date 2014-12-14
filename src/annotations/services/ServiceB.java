package annotations.services;

import annotations.annotations.AntonInit;
import annotations.annotations.AntonService;

//@AntonService
public class ServiceB {

	static {
		System.out.println("ServiceB class initializing.");
	}

	{
		System.out.println("ServiceB object initializing.");
	}

	@AntonInit
	public void init() {
		System.out.println("ServiceB object custom initializing.");
	}
}
