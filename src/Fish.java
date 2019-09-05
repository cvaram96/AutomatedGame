public class Fish extends LivingThing implements Activity{
    // constructor for the fish
    public Fish(String name) {
        super(name);
        GameDemo.Inhabitants.add(this);
    }

    //methods for overriding
    @Override
    public void canSwim(Location after) {
        //fish doesn't swim
    }

    @Override
    public void eat() {
        // it will implement in subclasses
    }

}