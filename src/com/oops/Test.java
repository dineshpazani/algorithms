package com.oops;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {

		/*
		 * StringBuffer sb = new StringBuffer("abc"); StringBuffer s2 = sb.reverse();
		 * System.out.println(s2);
		 * 
		 * Set<Integer> set = new HashSet<>();
		 * 
		 * set.add(null);
		 */

		String[] str = { "a", "b", "c" };

		getAll(str).ifPresent(a -> a.forEach(System.out::println));
	}

	public static Optional<List<Ref>> getAll(String[] str) {
		return Optional.of(Arrays.stream(str).map(Ref::new).collect(Collectors.toList()));

	}

}

class Ref {

	String ref;
	String check;

	public Ref(String ref) {
		super();
		this.ref = ref;
	}

}

interface C {

}

class A implements C {

	public void a1() {

	}
}

class B implements C {

	public String a1(String a) {
		return a;
	}

}
