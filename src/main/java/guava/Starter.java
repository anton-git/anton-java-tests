package guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;

import java.util.Arrays;

public class Starter {

	public static void main(String[] args) {
		joinerTest();
		charMathcer();
//		Optional
	}

	private static void joinerTest() {
		String result =
				Joiner
				.on(" - ")
				.useForNull("oO")
				.join(Arrays.asList("1", null, "3", "4"));

		System.out.println(result);
	}

	private static void charMathcer() {

		int count = CharMatcher
						.anyOf("-=_")
						.countIn("1-32=__23-2");

		System.out.println(count);

	}
}
