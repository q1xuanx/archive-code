class MovieRentingSystem {

    class MovieKey { 
        int movie; 
        int shop; 

        public MovieKey(int movie, int shop) { 
            this.movie = movie; 
            this.shop = shop;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof MovieKey movieKey)) {
                return false;
            }
            return this.movie == movieKey.movie && this.shop == movieKey.shop;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 53 * hash + this.movie;
            hash = 53 * hash + this.shop;
            return hash;
        }
    }

    class MovieInfo {
        int shop; 
        int movie; 
        int price; 
        
        public MovieInfo (int shop, int movie, int price) {  
            this.shop = shop;
            this.movie = movie; 
            this.price = price; 
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof MovieInfo mvInfo)) {
                return false;
            }
            return this.movie == mvInfo.movie 
                    && this.shop == mvInfo.shop 
                    && this.price == mvInfo.price;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 53 * hash + this.movie;
            hash = 53 * hash + this.price;
            hash = 53 * hash + this.shop;
            return hash;
        }

    }

    // n shop
    // movie will belong to shop 
    // cheapest movie with price will be selected  

    Map<MovieKey, MovieInfo> mapMovieKey = new HashMap<>();
    Map<Integer, TreeSet<MovieInfo>> unrentMap = new HashMap<>();  
    TreeSet<MovieInfo> rented = new TreeSet<>((a,b) -> {
        if (a.price == b.price && a.shop == b.shop) {
            return a.movie - b.movie;
        }else if (a.price == b.price) {
            return a.shop-b.shop;
        }
        return a.price - b.price;
    });

    public MovieRentingSystem(int n, int[][] entries) {
        for (int i = 0; i < entries.length; i++) { 
            MovieKey mvKey = new MovieKey(entries[i][1], entries[i][0]);
            unrentMap.putIfAbsent(entries[i][1], new TreeSet<>((a,b) -> {
                if (a.price == b.price) {
                    return a.shop-b.shop;
                }
                return a.price - b.price;
            }));
            unrentMap.get(entries[i][1]).add(new MovieInfo(entries[i][0], entries[i][1], entries[i][2]));
            mapMovieKey.put(mvKey, new MovieInfo(entries[i][0], entries[i][1], entries[i][2]));
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> searchResult = new ArrayList<>();
        TreeSet<MovieInfo> mvInfo = unrentMap.get(movie);
        if (mvInfo == null) {
            return searchResult;
        }
        int maxSize = mvInfo.size() > 5 ? 5 : mvInfo.size();
        for (MovieInfo mv : mvInfo) {
            searchResult.add(mv.shop);
            maxSize--;
            if (maxSize == 0) break;
        }
        return searchResult;
    }
    
    public void rent(int shop, int movie) {
        MovieInfo mv = mapMovieKey.get(new MovieKey(movie, shop));
        rented.add(mv);
        unrentMap.get(movie).remove(mv);
    }
    
    public void drop(int shop, int movie) {
        MovieInfo mv = mapMovieKey.get(new MovieKey(movie, shop));
        rented.remove(mv);
        unrentMap.get(movie).add(mv);
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        if (rented == null) {
            return result;
        }
        int maxSize = rented.size() > 5 ? 5 : rented.size();
        for (MovieInfo mv : rented) {
            result.add(Arrays.asList(mv.shop, mv.movie));
            maxSize--;
            if (maxSize == 0) break;
        }
        return result;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 
 entrie[0] = index of shop 
 entrie[1] = movie 
 entrie[2] = price

 */
