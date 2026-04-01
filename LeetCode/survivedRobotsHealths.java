class Solution {
    class Robot {
    	public int pos; 
    	public int health;
        public char dir; 
        public int idx;
    	
    	public Robot(int pos, int health, char dir, int idx) {
    		this.pos = pos; 
    		this.health = health;
            this.dir = dir; 
            this.idx = idx;
        }
    }
    
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Robot> ls = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
        	ls.add(new Robot(positions[i], healths[i], directions.charAt(i), i));
        }
        Collections.sort(ls, (a, b) -> a.pos - b.pos);
        Stack<Robot> st = new Stack<>();
        List<Robot> sur = new ArrayList<>();
        for (Robot ro : ls) {
            if (ro.dir == 'R') {
                st.push(ro);
            } else {
                while(!st.isEmpty() && ro.health > 0) {
                    Robot top = st.peek();
                    if (top.health < ro.health) {
                        st.pop();
                        ro.health--;
                    } else if (top.health > ro.health) { 
                        top.health--;
                        ro.health = 0;
                    } else {
                        st.pop();
                        ro.health = 0;
                    }
                }
                if (ro.health > 0) {
                    sur.add(ro);
                }
            }
        }
        sur.addAll(st);
        Collections.sort(sur, (a, b) -> a.idx - b.idx);
        List<Integer> result = new ArrayList<>();
        for (Robot r : sur) {
            result.add(r.health);
        }
        return result;
    }
}
