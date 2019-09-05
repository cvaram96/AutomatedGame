
public class RubberFish extends Fish {
    public RubberFish(String name) {
        super(name);
    }
    //the method for eating swimmer's swimFin
    public void eat(Swimmer swimmer) {
        if (swimmer.getLocation()==this.getLocation()){
            if (swimmer.isHasSwimFin()==true){
                swimmer.setSwimFin(null);
            }
        }
    }
}