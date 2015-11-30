package beatmycode;

import java.math.BigDecimal;
import java.text.Bidi;

public class SumDigits {

	public static String input = "584953223151206601144050668486739631204776665749110379809424368883526782222839370546366112787775116";
	public static int[] firstSums;

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		BigDecimal n = new BigDecimal(input);
		if (n.compareTo(bd(1)) < 0) {
			System.out.println(n);
		} else {
			calculateFirstSums();
			if (n.compareTo(bd(10)) < 0) {
				System.out.println(firstSums[n.intValue()]);
			} else {
				BigDecimal sum = new BigDecimal(firstSums[9]);
				for (BigDecimal i = bd(10); i.compareTo(n) <= 0; i.add(bd(1))) {
					sum = sum.add(sumDigits(i));
				}
				System.out.println(sum);
			}
		}
	}
	
	private static BigDecimal bd(int n){
		return new BigDecimal(n);
	}

	private static void calculateFirstSums() {
		firstSums = new int[10];
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum = sum + i;
			firstSums[i] = sum;
		}
	}

	private static BigDecimal sumDigits(BigDecimal n) {
		int exp = (int) Math.floor(Math.log10(n.doubleValue()));
		BigDecimal sum = bd(0);
		long number = n.longValue();
		for (int i = exp; i >= 0; i--) {
			long base = (long) Math.pow(10, i);
			int first = (int) (number / base);
			sum = sum.add(bd(first));
			number = (number - (first * base));
		}
		return sum;
	}

}
