package com.fred.common.rightaop;

public class RightItemCodeUtil {

	/** The right item code local. */
	private static ThreadLocal<String> rightItemCodeLocal = new ThreadLocal<String>();

	/**
	 * Gets the right item code.
	 *
	 * @return the right item code
	 */
	public static String getRightItemCode() {
		return getRightItemCodeLocal().get();
	}

	/**
	 * Gets the right item code local.
	 *
	 * @return the right item code local
	 */
	public static ThreadLocal<String> getRightItemCodeLocal() {
		String code = (String) rightItemCodeLocal.get();
		if (code == null) {
			rightItemCodeLocal.set("");
		}
		return rightItemCodeLocal;
	}

	/**
	 * Sets the right item code local.
	 *
	 * @param rightItemCode the new right item code local
	 */
	public static void setRightItemCodeLocal(String rightItemCode) {
		rightItemCodeLocal.set(rightItemCode);
	}

	private RightItemCodeUtil() {

	}
}
