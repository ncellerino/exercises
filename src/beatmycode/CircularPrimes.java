package beatmycode;

import java.util.Arrays;

public class CircularPrimes {

	public static void main(String[] args) {
		String input = "BMC_TEST_INPUT_MAGIC";
		int N = Integer.parseInt(input);

		rotate(N);
		int circulars = 0;
		if (N <= 1000000) {
			boolean[] primes = getPrimes(N);
			for (int i = 2; i < primes.length; i++) {
				if(primes[i]){
					if(isCircular(i)){
						circulars++;
					}
				}
			}
		}
		System.out.println(circulars);
	}
	
	private static boolean isCircular(int N){
		int rotated = N;		
		do{
			rotated = rotate(rotated);
			if(!isPrime(rotated)){
				return false;
			}
		}while(rotated != N);				
		return true;
	}
	
	//532 --> 2*100 + 53
	private static int rotate(int N){
		int digits = (int)Math.floor(Math.log10(N));
		int base = (int)Math.pow(10, digits);
		int first = N/base;
		int lastDigit = N%(base*first);
		return lastDigit*(base) + first;
		
	}

	private static boolean isPrime(int n) {
		int i = 2;
		while (i * i <= n) {
			if (n % i == 0) {
				return false;
			}
			i++;
		}
		return true;
	}

	private static boolean[] getPrimes(int N) {
		boolean[] primes = new boolean[N + 1];
		Arrays.fill(primes, true);
		int i = 2;
		primes[0] = false;
		primes[1] = false;
		while (i * i <= N) {
			if (primes[i]) {
				int j = i * i;
				while (j <= N) {
					primes[j] = false;
					j = j + i;
				}
			}
			i++;
		}
		return primes;
	}
}
