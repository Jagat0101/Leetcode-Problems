class Solution {
    public int maximumWealth(int[][] accounts) {

        int maxWealth = 0;

        for (int row = 0; row < accounts.length; row++) {

            int currentWealth = 0;

            for (int col = 0; col < accounts[row].length; col++) {
                currentWealth += accounts[row][col];
            }

            if (currentWealth > maxWealth) {
                maxWealth = currentWealth;
            }
        }

        return maxWealth;
    }
}