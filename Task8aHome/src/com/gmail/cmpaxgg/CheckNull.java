package com.gmail.cmpaxgg;

public interface CheckNull {
	public int NOT_NULL = 3;

	public static int checkNull(Object a, Object b) {
		if (a == null && b != null) {
			return 1;
		}
		if (a != null && b == null) {
			return -1;
		}
		if (a == null && b == null) {
			return 0;
		}
		return NOT_NULL;
	}
}
