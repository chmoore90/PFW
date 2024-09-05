package class_practice;

import java.util.LinkedList;
import java.util.ListIterator;

public class Class_Lesson {

	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		LinkedList words = new LinkedList<>();
		@SuppressWarnings("unchecked")
		ListIterator<String> iter = words.listIterator();

		while (iter.hasNext()) {
			for (int i =0; i < words.size(); i++) {
				if (i % 2 == 0) {
					iter.next();
					continue;
				} else {
					System.out.println(words.get(i));
					iter.next();
				}
			}

		}

	}

	static int addition(int A[], int n) {
		if (n == 0) {
			return A[n];
		} else {
			return addition(A, n-1) + A[n];
		}
	}

	static int multi(int x, int y) {
		if (y == 0) {
			return 0;
		} else {
			return x + multi(x, y-1);
		}
	}

	static String print_backwards(String string) {
		if (string.isEmpty()) {
			return string;
		} else {
			return print_backwards(string.substring(1)) + string.charAt(0);
		}
	}

	static int find_max(int[] A, int n) {
		if (A.length == 0) {
			return n;
		} else {
			int[] arr = new int[A.length - 1];
			arr = A.clone();
			if (A[A.length-1] > n) {
				return find_max(arr, A[A.length-1]);
			} else {
				return find_max(arr, n);
			}


		}
	}

}
