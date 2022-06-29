package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class AdvanceByOffsets {
  @EpiTest(testDataFile = "advance_by_offsets.tsv")
  public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
    // TODO - you fill in here.
	  int futher_reach = 0;
	  int end = maxAdvanceSteps.size() - 1;
	  for(int i = 0; i <= futher_reach && futher_reach <= end; i++) {
		  futher_reach = Math.max(futher_reach, maxAdvanceSteps.get(i) + i);
	  }
    return futher_reach >= end;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "AdvanceByOffsets.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
