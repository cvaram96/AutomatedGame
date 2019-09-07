public class SuperSwimmer extends Swimmer {
    private Binocular binocular;
    //constructing the super swimmer with Binocular
    public SuperSwimmer(String name, int age) {
        super(name, age);
        System.out.println("Constructing the "+this.getName());
        Binocular binocular=new Binocular();
        this.binocular=binocular;
    }
    //getter for binocular
    public Binocular getBinocular() {
        return binocular;
    }

    //setter for binocular
    public void setBinocular(Binocular binocular) {
        this.binocular = binocular;
    }
    //checking the super swimmer has  binocular
    public boolean isHasBinocular(){
        if (getBinocular()==null){
            return false;
        }
        else{
            return true;
        }
    }
    // override the canswim method for super swimmer
    @Override
    public void canSwim(Location after) {
        int X1=this.getLocation().getX();
        int Y1=this.getLocation().getY();
        int X2=after.getX();
        int Y2=after.getY();
        if (isLive() && isHasSwimFin()) {
            if(after.hasSwimmer()){
                this.setLocation(this.getLocation());
            }
            else{
                if ((((X2==(X1+1))|(X2==X1-1))&& (Y2==Y1)) | (((Y2==(Y1+1)) | (Y2==Y1-1))&& (X2==X1)) ){
                    if (after.hasLotus()) {
                        this.getLocation().deleteLiverThing(this);
                        this.setLocation(after);
                        Lotus l = new Lotus();
                        this.setLotus(l);
                    }
                    else{
                        if (sqrt((Math.pow((5 - X1), 2) + Math.pow((5 - Y1), 2))) >= sqrt((Math.pow((5 - X2), 2) + Math.pow((5 - Y2), 2)))) {
                            this.getLocation().deleteLiverThing(this);
                            this.setLocation(after);
                        }
                    }
                }
                else{
                    this.setLocation(this.getLocation());

                }
            }

        }
        else{
            this.setLocation(this.getLocation());


        }
    }


}