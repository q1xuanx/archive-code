class Solution {
    public int compareVersion(String version1, String version2) {
        String []seprateVer1 = version1.split("\\.");
        String []seprateVer2 = version2.split("\\.");
        int n = seprateVer1.length > seprateVer2.length ? seprateVer1.length : seprateVer2.length;
        for (int i = 0; i < n; i++) {
            String castValue1 = seprateVer1.length > i ? seprateVer1[i] : "0";
            String castValue2 = seprateVer2.length > i ? seprateVer2[i] : "0";
            int num1 = Integer.parseInt(castValue1);
            int num2 = Integer.parseInt(castValue2);
            //System.out.println(num1 + " " + num2);
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
        }
        return 0;
    }
}
