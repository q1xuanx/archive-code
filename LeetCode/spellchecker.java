class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>(Arrays.asList(wordlist));
        Map<String,String> caseMap = new HashMap<>();
        Map<String,String> vowelMap = new HashMap<>();
        for (String word : wordlist) { 
            String lowerString = word.toLowerCase();
            String deVowel = devowel(lowerString);
            caseMap.putIfAbsent(lowerString, word);
            vowelMap.putIfAbsent(deVowel, word);
        }
        String [] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) { 
            String value = queries[i];
            String caseValue = value.toLowerCase();
            String devowls = devowel(caseValue);
            if (exact.contains(value)) {
                result[i] = value;
            }else if (caseMap.containsKey(caseValue)) {
                result[i] = caseMap.get(caseValue);
            }else if (vowelMap.containsKey(devowls)) {
                result[i] = vowelMap.get(devowls);
            }else {
                result[i] = "";
            }
        }
        return result;
    }

    public String devowel(String s){
        char []arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) { 
            if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                arr[i] = '*';
            }
        }
        return new String(arr);
    }
}
