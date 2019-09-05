public class Treasure  implements Obsevable{
    private Location location;
    private HashMap<Observer,Location>hm =new HashMap<>();

    public Treasure(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location=location;
    }

    @Override
    public void addObserver(Observer observer) {
        if (observer instanceof SwimmerThread){
            SwimmerThread swimmer= (SwimmerThread) observer;
            hm.put(swimmer,swimmer.getSwimmer().getLocation());
            Notify();
        }


    }

    @Override
    public void removeObserver(Observer observer) {
        hm.remove(observer);

    }
    public void Notify(){
        for (Map.Entry<Observer,Location> entry :hm.entrySet()

        ) {
            if (entry.getKey() instanceof SwimmerThread){
                if (entry.getValue()==this.location){
                    entry.getKey().update("The Target was Achchived");


                }
            }

        }

    }
}