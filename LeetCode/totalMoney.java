class Solution {
    public int totalMoney(int n) {
        if (n < 8) { 
            return (n * (n + 1)) / 2;
        }      
        return ((28 + (28 + (7*(n/7-1)))) * (((28 + (7 *(n / 7-1))) - 28) / 7 + 1) / 2) + (((((n / 7) + 1) + ((n / 7) + 1) + ((n % 7) - 1)) * (n % 7)) / 2);
    }
}
