public class Location {
    private int x;//this is the x value for location
    private int y;//this is the y value for location
    private ArrayList<LivingThing> livingThings =new ArrayList<LivingThing>();//list for inhabitants which in same location
    private Treasure treasure;//location for treasure

    //constructor for location
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
    //add the inhabitant to the inhabitant list
    public void addLiverThing(LivingThing livingThing){
        livingThings.add(livingThing);

    }
    //getter method for inhabitant list
    public ArrayList<LivingThing> getLivingThings() {
        return livingThings;
    }
    // getter X coordinate of Location
    public int getX() {
        return x;
    }
    // set the X coordinate of Location
    public void setX(int x) {
        this.x = x;
    }
    //// getter Y coordinate of Location
    public int getY() {
        return y;
    }
    // set the Y coordinate of Location
    public void setY(int y) {
        this.y = y;
    }
    // delete the inhabitant in the list
    public void deleteLiverThing(LivingThing livingThing){
        livingThings.remove(livingThing);
    }
    //check the location if  it has swimmer or else
    public boolean hasSwimmer() {
        boolean s=false;
        for (LivingThing x : livingThings) {
            if (x instanceof Swimmer)
                s=true;
        }
        return s;
    }
    //checking the lotus object if in the Location
    public boolean hasLotus() {
        boolean s=false;
        for (LivingThing x : livingThings) {
            if (x instanceof Lotus)
                s=true;
        }
        return s;
    }
    //getter for the treasure
    public Treasure getTreasure() {
        return treasure;
    }
    // set the treasure to the location
    public void setTreasure(Treasure treasure) {
        this.treasure = treasure;
    }
}
