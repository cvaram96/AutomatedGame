public class Quiz {
    ArrayList<Swimmer> QuizSwimmers;
    Location location;

    public Quiz(Location location) {
        this.location = location;
    }

    public void setSwimmer(Swimmer swimmer){
        QuizSwimmers.add(swimmer);
    }
    public void removeSwimmer(Swimmer swimmer){
        QuizSwimmers.remove(swimmer);
    }
    public void achivedTreasure(Swimmer swimmer){
        synchronized (location){
            if (swimmer.getLocation()==location){
                notifyAll();
                System.out.println(swimmer.getName()+"is achived the target and win the Quiz");

            }
        }

    }
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}