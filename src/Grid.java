public class Grid {
    //set the name for Grid
    String name;
    Treasure treasure;
    //creating 2D location list for the grid
    public static Location[][] locations = new Location[11][11];
    //creating constructor with Locations add the treasure in location[5][5]
    public Grid(String name) {
        System.out.println("Constructing the "+name);
        this.name=name;
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                this.locations[i][j] = new Location(i, j);
            }
        }
        Treasure treasure=new Treasure(locations[5][5]);
        this.treasure=treasure;
        locations[5][5].setTreasure(treasure);
    }


    //setter for inhabitant which place is should be
    public void addLiverThing(LivingThing livingThing, Location location){
        location.addLiverThing(livingThing);
    }
    public Treasure getTreasure(){
        return treasure;
    }
}