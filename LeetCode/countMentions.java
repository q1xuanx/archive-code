// 3433. Count Mentions Per User

class Solution {
    class Mention {
        public String type;
        public int timeStamp;
        public int[] ids;

        public Mention(String type, int timeStamp, String[] item) {
            this.type = type;
            this.timeStamp = timeStamp;
            this.ids = new int[item.length];
            for (int i = 0; i < item.length; i++) {
                if ("HERE".equals(item[i])) {
                    this.ids[i] = 777;
                    continue;
                }
                if ("ALL".equals(item[i])) {
                    this.ids[i] = 888;
                    continue;
                }
                ids[i] = Integer.parseInt(item[i].replace("id", ""));
            }
        }

        @Override
        public String toString() {
            return this.type + " " + this.timeStamp + " " + Arrays.toString(this.ids);
        }

        public int getTimeStamp() {
            return timeStamp;
        }
        
        public String getType() {
            return type;
        }
    }

    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        List<String> types = List.of("OFFLINE", "MESSAGE");
        List<Mention> lst = new ArrayList<>();
        for (List<String> event : events) {
            String type = event.get(0);
            int timeStamp = Integer.parseInt(event.get(1));
            String[] ids = event.get(2).split(" ");
            lst.add(new Mention(type, timeStamp, ids));
        }

        lst.sort(Comparator.comparing(Mention::getTimeStamp).thenComparing(m -> types.indexOf(m.getType())));
            
        int[] result = new int[numberOfUsers];
        int[] mentionWhenOffline = new int[numberOfUsers];
        Arrays.fill(result, 0);
        Arrays.fill(mentionWhenOffline, 0);
        
        for (Mention mention : lst) {
            if ("MESSAGE".equals(mention.type)) {
                if (mention.ids[0] == 777) {
                    mentionUser(result, "HERE", new int[1], mention.timeStamp, mentionWhenOffline);
                } else if (mention.ids[0] == 888) {
                    mentionUser(result, "ALL", new int[1], mention.timeStamp, mentionWhenOffline);
                } else {
                    mentionUser(result, "NORMAL", mention.ids, mention.timeStamp, mentionWhenOffline);
                }
            } else {
                offlineUserHandle(result, mentionWhenOffline, mention.ids[0], mention.timeStamp);
            }
        }
        for (int i = 0; i < numberOfUsers; i++) {
            if (result[i] < 0) {
                result[i] = mentionWhenOffline[i];
            }
        }
        return result;
    }

    public void mentionUser(int[] result, String mentionType, int[] mentioned, int timeStamp, int[] mentionWhenOffline) {
        if ("ALL".equals(mentionType)) {
            for (int i = 0; i < result.length; i++) {
                if (result[i] < 0 && ((result[i] * (-1)) + 60) > timeStamp) {
                    mentionWhenOffline[i]++;
                }else if(result[i] < 0 && ((result[i] * (-1)) + 60) <= timeStamp) {
                    result[i] = mentionWhenOffline[i] + 1;
                    mentionWhenOffline[i] = 0;
                } else {
                    result[i]++;
                }
            }
        } else if ("HERE".equals(mentionType)) {
            for (int i = 0; i < result.length; i++) {
                if (result[i] < 0 && (result[i] * (-1) + 60) > timeStamp) continue;
                else if (result[i] < 0 && (result[i] * (-1) + 60) <= timeStamp) {
                    result[i] = mentionWhenOffline[i] + 1;
                    mentionWhenOffline[i] = 0;
                } else result[i]++;
            }
        } else {
            for (int i = 0; i < mentioned.length; i++) {
                if (result[mentioned[i]] < 0 && ((result[mentioned[i]] * (-1)) + 60) <= timeStamp) {
                    result[mentioned[i]] = mentionWhenOffline[mentioned[i]] + 1;
                    mentionWhenOffline[mentioned[i]] = 0;
                } else if (result[mentioned[i]] < 0 && ((result[mentioned[i]] * (-1)) + 60) > timeStamp) {
                    mentionWhenOffline[mentioned[i]]++;    
                } else if (result[mentioned[i]] >= 0) {
                    result[mentioned[i]]++;
                }
            }
        }
    }

    public void offlineUserHandle(int[] result, int[] mentionWhenOffline, int currentOffline, int timeStamp) {
        mentionWhenOffline[currentOffline] =  result[currentOffline] > 0 ? result[currentOffline] : mentionWhenOffline[currentOffline];
        result[currentOffline] = -timeStamp;
    }
}
