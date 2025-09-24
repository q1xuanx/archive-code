
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) { 
            return "0";
        }

        StringBuilder result = new StringBuilder();

        if ((numerator < 0) ^ (denominator < 0)) { 
            // false false = false 
            result.append("-");
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        result.append(num / den);
        num %= den;
        if (num == 0) return result.toString();
        result.append(".");
        Map<Long, Integer> remind = new HashMap<>();

        while (num != 0) {
            if (remind.containsKey(num)) {
                int index = remind.get(num);
                result.insert(index, "(");
                result.append(")");
                break;
            }
            remind.put(num, result.length());
            num *= 10;
            result.append(num / den);
            num %= den;
        }
        return result.toString();
    }
}

// 10^4 = 10000
