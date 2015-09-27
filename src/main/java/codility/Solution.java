package codility;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    @Test
    public void test() {
        assertThat(solution(new int[]{-1, 3, -4, 5, 1, -6, 2, 1})).isIn(1, 3, 7);
        assertThat(solution(new int[]{1, 2, 1})).isEqualTo(1);
        assertThat(solution(new int[]{1, 2, 3, 3, 2, 1})).isEqualTo(-1);
    }

    public static int solution(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }

        long sumPrefix = 0, sumSuffix = 0;
        for (int i : A) {
            sumSuffix += i;
        }

        if (sumSuffix - A[0] == 0) {
            return 0;
        }
        if (sumSuffix - A[A.length - 1] == 0) {
            return A.length - 1;
        }

        sumSuffix -= A[0];

        for (int i = 1; i < A.length - 1; i++) {
            sumPrefix += A[i - 1];
            sumSuffix -= A[i];

            if (sumPrefix == sumSuffix) {
                return i;
            }
        }

        return -1;
    }
}