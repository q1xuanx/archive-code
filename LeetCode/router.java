class Router {

    class Packet {
        int source; 
        int destination;
        int timestamp; 
        public Packet(int src, int des, int timestamp) { 
            this.source = src; 
            this.destination = des;
            this.timestamp = timestamp;
        }

        @Override
        public boolean equals(Object obj) { 
            if (obj == null) return false;
            if (!(obj instanceof Packet packet)) { 
                return false;
            }
            return this.source == packet.source && this.destination == packet.destination && this.timestamp == packet.timestamp;
        }

        @Override 
        public int hashCode() { 
            int hash = 3; 
            hash = 53 * hash + this.source; 
            hash = 53 * hash + this.destination; 
            hash = 53 * hash + this.timestamp; 
            return hash;
        }
    }

    Queue<Packet> queue = new LinkedList<>();
    Set<Packet> checkExist = new HashSet<>();
    Map<Integer, List<Integer>> destionationCount = new HashMap<>();
    int maxLimit = 0;

    public Router(int memoryLimit) {
        this.maxLimit = memoryLimit;
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        Packet newPack = new Packet(source, destination, timestamp);
        if (checkExist.contains(newPack)) { 
            return false;
        }
        if (queue.size() == maxLimit) {
            Packet packetRemove = queue.poll();
            checkExist.remove(packetRemove);
            List<Integer> lst = destionationCount.get(packetRemove.destination);
            lst.remove(0);
            if (lst.isEmpty()) destionationCount.remove(packetRemove.destination);
        }
        queue.add(newPack);
        checkExist.add(newPack);
        destionationCount.putIfAbsent(newPack.destination, new ArrayList<>());
        destionationCount.get(newPack.destination).add(newPack.timestamp);
        return true;
    }
    
    public int[] forwardPacket() {
        Packet pck = queue.poll();
        if (pck == null) {
            return new int[]{};
        }
        checkExist.remove(pck);
        List<Integer> lst = destionationCount.get(pck.destination);
        lst.remove(0);
        if (lst.isEmpty()) destionationCount.remove(pck.destination);
        return new int[]{pck.source, pck.destination, pck.timestamp};
    }
    
    public int lowerBound(List<Integer> lst, int target, int start, int end) {
        int l = start, r = end; 
        while (l < r) { 
            int mid = (l + r) / 2;
            if (lst.get(mid) >= target) { 
                r = mid; 
            } else if (lst.get(mid) < target){
                l = mid + 1;
            } 
        }
        return l;
    }

    public int upperBound(List<Integer> lst, int target, int start, int end) {
        int l = start, r = end; 
        while (l < r) { 
            int mid = (l + r) / 2;
            if (lst.get(mid) > target) { 
                r = mid;
            } else {
                l = mid + 1;
            } 
        }
        return l;
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> getDestinationList = destionationCount.get(destination); 
        if (getDestinationList == null || getDestinationList.isEmpty()) return 0;
        int l = lowerBound(getDestinationList, startTime, 0, getDestinationList.size());
        int r = upperBound(getDestinationList, endTime, 0, getDestinationList.size());
        return r - l;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */
