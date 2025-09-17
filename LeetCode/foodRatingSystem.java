// Watch out with Reference value in Java it very tricky =.=~
class FoodRatings {

    class Item  {
        int rate;
        String name;
        String cuisine; 

        public Item(int rate, String name, String cuisine) {
            this.rate = rate;
            this.name = name;
            this.cuisine = cuisine;
        }

        public void setRate(int rate) {
            this.rate = rate;
        }

        public String getName() {
            return this.name;
        }

        public int getRate() {
            return this.rate;
        }

        public String getCuisine() {
            return this.cuisine;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    
    Map<String, PriorityQueue<Item>> foodList = new HashMap<>();
    Map<String, Item> cuisineMap = new HashMap<>();


    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length; 
        for (int i = 0; i < n; i++) {
            Item item = new Item(ratings[i], foods[i], cuisines[i]);
            foodList.putIfAbsent(cuisines[i], new PriorityQueue<>(
                (a, b) -> {
                    if (a.getRate() != b.getRate()) {
                        return b.getRate() - a.getRate();
                    }
                    return a.getName().compareTo(b.getName());
            }));
            foodList.get(cuisines[i]).add(item);
            cuisineMap.put(foods[i], item);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Item prev = cuisineMap.get(food);
        Item current = new Item(newRating, food, prev.getCuisine());
        cuisineMap.put(food, current);
        prev.name = "";
        foodList.get(prev.getCuisine()).add(current);
    }
    
    public String highestRated(String cuisine) {
        while(foodList.get(cuisine).peek().getName().equals("")){
            foodList.get(cuisine).remove();
        }
        return foodList.get(cuisine).peek().getName();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
