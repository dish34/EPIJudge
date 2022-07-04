package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Collections;
import java.util.List;
public class ApplyPermutation {
  public static void applyPermutation(List<Integer> perm, List<Integer> A) {
    // TODO - you fill in here.
	for (int i = 0; i < A.size(); i++) {
		int next = i;
		if (perm.get(next) >= 0)
		{
			Collections.swap(A, i, perm.get(next));
			int temp = perm.get(next);
			perm.set(next,  perm.get(next) - perm.size());
			next = temp;
		}
	}
    return;
  }
  @EpiTest(testDataFile = "apply_permutation.tsv")
  public static List<Integer> applyPermutationWrapper(List<Integer> perm,
                                                      List<Integer> A) {
    applyPermutation(perm, A);
    return A;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ApplyPermutation.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
