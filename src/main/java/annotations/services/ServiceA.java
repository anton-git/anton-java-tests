package annotations.services;

import annotations.annotations.AntonInit;
import annotations.annotations.AntonService;

@AntonService
public class ServiceA {

	static {
		System.out.println("ServiceA class initializing.");
	}

	{
		System.out.println("ServiceA object initializing.");
	}

	@AntonInit
	public void init() {
		System.out.println("ServiceA object custom initializing.");
	}

}
