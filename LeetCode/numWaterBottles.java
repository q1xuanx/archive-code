class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        if (numBottles < numExchange) return numBottles;
        if (numBottles == numExchange) return numBottles + 1;
        int result = numBottles, remind = 0;
        while (numBottles >= numExchange) {
            remind = numBottles % numExchange;
            numBottles /= numExchange; 
            result += numBottles;
            numBottles += remind;
        }
        return result;
    }
}
