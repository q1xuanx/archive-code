// The formular is -> (oldBit * 2 + newBit)

public static long castToBin(String s) {
    long dec = 0;
    for (char c : s.toCharArray()) {
        dec = dec * 2 + (c - '0');
    }
    return dec;
}
