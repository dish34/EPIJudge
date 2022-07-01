package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class PrimeSieve {
  @EpiTest(testDataFile = "prime_sieve.tsv")
  // Given n, return all primes up to and including n.
  public static List<Integer> generatePrimes(int n) {
    // TODO - you fill in here.
	List<Integer> prime = new ArrayList<>();
	Boolean[] isPrime = new Boolean[n + 1];
	Arrays.fill(isPrime, Boolean.TRUE);
	isPrime[0] = false;
	isPrime[1] = false;
	for (int i = 2; i <= n; i++) {
		if (isPrime[i]) {
			prime.add(i);
			for (int j = i; j <= n; j += i) {
				isPrime[j] = false;
			}
		}
	}

	return prime;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PrimeSieve.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
