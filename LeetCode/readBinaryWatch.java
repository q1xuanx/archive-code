// 0011 -> 2 bit
// 0001 -> 1 bit 
// 2 + 1 == turnedOn -> add to result 
public List<String> readBinaryWatch(int turnedOn) {
    List<String> result = new ArrayList<>();

    for (int i = 0; i < 12; i++) {
        for (int j = 0; j < 60; j++) {
            int totalBit = Integer.bitCount(i) + Integer.bitCount(j);

            if (totalBit == turnedOn) {
                String dateTime = String.format("%d:%02d", i, j);
                result.add(dateTime);
            }
        }
    }

    return result;
}
