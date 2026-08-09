import java.util.*;

class Solution {
    public int[] sortedSquares(int[] nums) {

        // Create two lists
        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();

        // Separate negative and positive numbers
        for (int num : nums) {
            if (num < 0) {
                neg.add(num);
            } else {
                pos.add(num);
            }
        }

        // Case 1: No negative numbers
        if (neg.size() == 0) {

            for (int i = 0; i < pos.size(); i++) {
                int square = pos.get(i) * pos.get(i);
                pos.set(i, square);
            }

            int[] result = new int[pos.size()];

            for (int i = 0; i < pos.size(); i++) {
                result[i] = pos.get(i);
            }

            return result;
        }

        // Case 2: No positive numbers
        if (pos.size() == 0) {

            for (int i = 0; i < neg.size(); i++) {
                int square = neg.get(i) * neg.get(i);
                neg.set(i, square);
            }

            Collections.reverse(neg);

            int[] result = new int[neg.size()];

            for (int i = 0; i < neg.size(); i++) {
                result[i] = neg.get(i);
            }

            return result;
        }

        // Square all negative numbers
        for (int i = 0; i < neg.size(); i++) {
            int square = neg.get(i) * neg.get(i);
            neg.set(i, square);
        }

        // Reverse negative squared array
        Collections.reverse(neg);

        // Square all positive numbers
        for (int i = 0; i < pos.size(); i++) {
            int square = pos.get(i) * pos.get(i);
            pos.set(i, square);
        }

        // Final result array
        int[] result = new int[nums.length];

        // Two pointers
        int i = 0;
        int j = 0;
        int k = 0;

        // Merge negative and positive arrays
        while (i < neg.size() && j < pos.size()) {

            if (neg.get(i) <= pos.get(j)) {

                result[k] = neg.get(i);

                i++;
                k++;

            } else {

                result[k] = pos.get(j);

                j++;
                k++;
            }
        }

        // Remaining negative elements
        while (i < neg.size()) {

            result[k] = neg.get(i);

            i++;
            k++;
        }

        // Remaining positive elements
        while (j < pos.size()) {

            result[k] = pos.get(j);

            j++;
            k++;
        }

        return result;
    }
}