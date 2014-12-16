package annotations;

import annotations.annotations.AntonInit;
import annotations.annotations.AntonService;
import annotations.services.ServiceA;
import annotations.services.ServiceB;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Starter {

	public static void main(String[] args) {
		System.out.println("Annotation app starter.");

		inspectService(ServiceA.class);
		inspectService(ServiceB.class);
	}

	private static void inspectService(Class<?> clazz) {
		System.out.println(" --- --- --- ");
		System.out.println("Inspecting class " + clazz);

		System.out.println("Class annotations:");
		Annotation[] annotations = clazz.getDeclaredAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println(annotation);
		}

		if (clazz.isAnnotationPresent(AntonService.class)) {
			System.out.println("AntonService annotation is present.");

			System.out.println("Class methods:");
			Method[] methods = clazz.getDeclaredMethods();
			for (Method method : methods) {
				System.out.println(method.getName());

				if (method.isAnnotationPresent(AntonInit.class)) {
					System.out.println("~Annotation AntonInit is present.");
					callInit(method, clazz);
				}
			}

		} else {
			System.out.println("AntonService annotation is NOT present.");
		}
	}

	private static void callInit(final Method method, final Class<?> clazz) {
		System.out.println("Calling init method");
		try {
			method.invoke(clazz.newInstance());
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}


}
