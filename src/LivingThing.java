public abstract class LivingThing {
    private String name;
    private int age;
    private Location location;

    //constructor for  inhabitant without name.......For Lotus
    public LivingThing() {
    }
    //constructor for inhabitant name and age..........For swimmer
    public LivingThing(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //constructor for inhabitant with only name.........For fish
    public LivingThing(String name) {
        this.name = name;
    }
    //getter for name
    public String getName() {
        return name;
    }
    //setter for name
    public void setName(String name) {
        this.name = name;
    }
    public Location getLocation() {
        return location;
    }
    //set the location for inhabitant
    public void setLocation(Location location) {
        this.location=location;
        location.addLiverThing(this);
    }
}