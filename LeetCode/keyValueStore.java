class TimeMap {

    class TimeData {
        String atitude; 
        int timeStamp;

        public TimeData(String atitude, int timeStamp) {
            this.atitude = atitude; 
            this.timeStamp = timeStamp;
        }

        public int getTimeStamp() {
            return this.timeStamp;
        }

        public String getAtitude() {
            return this.atitude;
        }
    }

    Map<String, List<TimeData>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new TimeData(value, timestamp));
    }  
    
    public String get(String key, int timestamp) {
        String currentAtitude = "";
        if (map.get(key) == null) {
            return currentAtitude;
        }
        List<TimeData> times = map.get(key);
        // System.out.println(times.size());
        int left = 0, right = times.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (times.get(mid).getTimeStamp() <= timestamp) {
                currentAtitude = times.get(mid).getAtitude();
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return currentAtitude;
    }
}
