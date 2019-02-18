package br.com.guttomarttins.ssb.util;

public class DocumentoBR {

	private static final int[] weightCPF = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
	private static final int[] weightCNPJ = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

	private static int calculate(final String str, final int[] weight) {
		int sum = 0;
		for (int i = str.length() - 1, digit; i >= 0; i--) {
			digit = Integer.parseInt(str.substring(i, i + 1));
			sum += digit * weight[weight.length - str.length() + i];
		}
		sum = 11 - sum % 11;
		return sum > 9 ? 0 : sum;
	}

	public static boolean isValidCPF(final String ssn) {
		if ((ssn == null) || (ssn.length() != 11) || ssn.matches(ssn.charAt(0) + "{11}"))
			return false;

		final Integer digit1 = calculate(ssn.substring(0, 9), weightCPF);
		final Integer digit2 = calculate(ssn.substring(0, 9) + digit1, weightCPF);
		return ssn.equals(ssn.substring(0, 9) + digit1.toString() + digit2.toString());
	}

	public static boolean isValidCNPJ(final String tin) {
		if ((tin == null) || (tin.length() != 14) || tin.matches(tin.charAt(0) + "{14}"))
			return false;

		final Integer digit1 = calculate(tin.substring(0, 12), weightCNPJ);
		final Integer digit2 = calculate(tin.substring(0, 12) + digit1, weightCNPJ);
		return tin.equals(tin.substring(0, 12) + digit1.toString() + digit2.toString());
	}

}
