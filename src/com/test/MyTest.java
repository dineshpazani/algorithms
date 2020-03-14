package com.test;

import java.util.ArrayList;
import java.util.List;

public class MyTest {

	public static void main(String[] args) {

		System.out.println(new Solution().solution("BAR"));

	}

}

class Solution {
	public int solution(String S) {

		List<String> pStr = new ArrayList<>();

		Integer total = 0;

		String str = S;
		int n = str.length();
		permute(str, 0, n - 1, pStr);

		System.out.println(pStr);

		for (String s : pStr) {
			if (!isConsecVowels(s) && !isSecondMatch(s)) {
				total++;
			}
		}

		for (int i = 0; i < pStr.size(); i++) {

			if (i > 0) {
				if (pStr.get(i - 1).charAt(0) == pStr.get(i).charAt(0)) {
					total--;
				}
			}

		}

		return total;

	}

	public boolean isSecondMatch(String original) {

		int h1 = original.length() / 2;

		System.out.println(original.substring(0, h1) + " " + original.substring(h1, original.length()));
		if (original.substring(0, h1).equals(original.substring(h1, original.length())))
			return true;

		return false;

	}

	private boolean isConsecVowels(String word) {

		int check = 0;

		word = word.trim();
		char[] carr = word.toCharArray();

		char fred = carr[0];

		if ((fred == 'A') || (fred == 'E') || (fred == 'I') || (fred == 'O') || (fred == 'U')) {
			return true;
		}

		for (char c : carr) {
			if ((c == 'A') || (c == 'E') || (c == 'I') || (c == 'O') || (c == 'U')) {
				check++;
			} else {
				if (check >= 0)
					check--;
			}

			if (check > 1)
				return true;

		}

		return false;
	}

	private void permute(String str, int l, int r, List pStr) {
		if (l == r) {
			// System.out.println(str);
			pStr.add(str);
		} else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r, pStr);
				str = swap(str, l, i);
			}
		}
	}

	public String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
}

class A {

	public void a1() {

	}

	public int a1(int a) {
		return a;

	}
}
