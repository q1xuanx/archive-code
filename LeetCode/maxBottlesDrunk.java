class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int currentBottles = numBottles;
        int exchangedBottles = 0;
        while (numBottles >= numExchange) {  
            numBottles -= numExchange;
            exchangedBottles++; 
            numExchange++;
        }
        return currentBottles + exchangedBottles + ((exchangedBottles + numBottles) / numExchange);
    }
}
