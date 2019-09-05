public abstract class Swimmer extends LivingThing implements Activity{
    private SwimFin swimFin;
    private boolean isLive = true;
    private Lotus l;
    //The constructor for Swimmer,the swim fin creates when a swimmer construct
    public Swimmer(String name, int age) {
        super(name, age);
        SwimFin swimFin=new SwimFin();
        this.swimFin=swimFin;
        GameDemo.swimmers.add(this);
    }
    //checking the swimmer containing swimfin
    public boolean isHasSwimFin(){
        if (swimFin==null){
            return false;
        }
        else{
            return true;

        }
    }
    // setter for live status
    public void setLive(boolean live) {
        isLive = live;
    }
    //getting live status
    public boolean isLive() {
        return isLive;
    }
    //get lotus
    public Lotus getLotus() {
        return l;
    }
//set lotus

    public void setLotus(Lotus l) {
        this.l = l;
    }

    // the method for immortal
    public boolean isImmortal(){
        if (this.getLotus()!=null){
            return true;
        }
        else{
            return false;
        }
    }
    // Swim method  for swimmer and it is override from activity interface
    @Override
    public void canSwim(Location after) {
        int X1=this.getLocation().getX();
        int Y1=this.getLocation().getY();
        int X2=after.getX();
        int Y2=after.getY();
        if (isLive() && isHasSwimFin()) {
            if (after.hasSwimmer()) {
                this.setLocation(this.getLocation());
            } else {
                if ((((X2 == (X1 + 1)) | (X2 == X1 - 1)) && (Y2 == Y1)) | (((Y2 == (Y1 + 1)) | (Y2 == Y1 - 1)) && (X2 == X1))) {
                    if (sqrt((Math.pow((5 - X1), 2) + Math.pow((5 - Y1), 2))) >= sqrt((Math.pow((5 - X2), 2) + Math.pow((5 - Y2), 2)))) {
                        this.getLocation().deleteLiverThing(this);
                        this.setLocation(after);
                        if (after.hasLotus()) {
                            Lotus l = new Lotus();
                            this.setLotus(l);
                        }
                    }
                } else {
                    this.setLocation(this.getLocation());

                }
            }

        }
        else{
            this.setLocation(this.getLocation());


        }
    }
    // eat method override from activity
    @Override
    public void eat() {
        //swimmer eating
    }
    // set the swim fin for swimmer
    public void setSwimFin(SwimFin swimFin) {
        this.swimFin = swimFin;
    }


}