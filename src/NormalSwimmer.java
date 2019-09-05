public class NormalSwimmer extends Swimmer {
    public NormalSwimmer(String name, int age) {
        super(name, age);
        System.out.println("Constructing the "+this.getName());

    }
    //override the canSwim method
}