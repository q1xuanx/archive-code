

class FindPrime {

    private static final int n = 1000005;
    private static boolean[] prime;

    public static void main(String[] args) {
        prime = new boolean[n];
        prime[0] = prime[2] = true;
        // Find Prime number using Sieve of Eratosthenes
        for (int i = 2; i <= 1000; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j+= i) {
                    prime[j] = true; 
                }
            }
        }
    }
}