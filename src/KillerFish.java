public class KillerFish extends Fish {
    public KillerFish(String name) {
        super(name);
    }
    //eating method for killerFish
    public void eat(Swimmer swimmer) {
        if (this.getLocation()==swimmer.getLocation()){
            if (swimmer.isImmortal()!=true){
                swimmer.setLive(false);
                this.getLocation().deleteLiverThing(swimmer);
                GameDemo.Inhabitants.remove(swimmer);
            }

        }
    }
}