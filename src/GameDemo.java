public class GameDemo {
    public static ArrayList<Activity> Inhabitants = new ArrayList<Activity>();
    public static ArrayList<Swimmer> swimmers=new ArrayList<>();
    public static NormalSwimmer NS1 = new NormalSwimmer("Normal Swimmer A", 21);
    public static NormalSwimmer NS2 = new NormalSwimmer("Normal Swimmer B", 21);
    public static SuperSwimmer SS1 = new SuperSwimmer("Super Swimmer A", 18);
    public static SuperSwimmer SS2 = new SuperSwimmer("Super Swimmer B", 2);
    public static  NormalFish NF1 = new NormalFish("Normal Fish A");
    public static NormalFish NF2 = new NormalFish("Normal Fish B");
    public static RubberFish RF1 = new RubberFish("Rubber Fish A");
    public static RubberFish RF2 = new RubberFish("Rubber Fish B");
    public static KillerFish KF1 = new KillerFish("Killer Fish A");
    public static KillerFish KF2 = new KillerFish("Killer Fish B");
    public static Lotus L1 = new Lotus();
    public static Lotus L2 = new Lotus();
    public static Lotus L3 = new Lotus();
    public static Lotus L4 = new Lotus();
    public static Lotus L5 = new Lotus();
    public static ThreadGroup swimmerThreads = new ThreadGroup("SwimmerThreadGroup");


    public static void main(String[] args) {
        try{Thread.currentThread().sleep(1000);}catch (InterruptedException e){}
        System.out.println("The NEVER EVER GIVE UP game is started now");
        try{Thread.currentThread().sleep(150);}catch (InterruptedException e){}
        String s= "Loading Game 3...2...1... now";
        for(int i=0;i<s.length();i++){
            System.out.print(s.charAt(i));
            try{Thread.currentThread().sleep(150);}catch (InterruptedException e){}

        }

        Grid Lake = new Grid("Nazoma");
        Treasure treasure=Lake.getTreasure();
        Random Indice = new Random();
        NF1.setLocation(Grid.locations[Indice.nextInt(11)][Indice.nextInt(11)]);
        NF2.setLocation(Grid.locations[Indice.nextInt(11)][Indice.nextInt(11)]);
        RF1.setLocation(Grid.locations[Indice.nextInt(11)][Indice.nextInt(11)]);
        RF2.setLocation(Grid.locations[Indice.nextInt(11)][Indice.nextInt(11)]);
        KF1.setLocation(Grid.locations[Indice.nextInt(11)][Indice.nextInt(11)]);
        KF2.setLocation(Grid.locations[Indice.nextInt(11)][Indice.nextInt(11)]);
        L1.setLocation(Grid.locations[Indice.nextInt(11)][Indice.nextInt(11)]);
        L2.setLocation(Grid.locations[Indice.nextInt(11)][Indice.nextInt(11)]);
        L3.setLocation(Grid.locations[Indice.nextInt(11)][Indice.nextInt(11)]);
        L4.setLocation(Grid.locations[Indice.nextInt(11)][Indice.nextInt(11)]);
        L5.setLocation(Grid.locations[Indice.nextInt(11)][Indice.nextInt(11)]);
        try{Thread.currentThread().sleep(150);}catch (InterruptedException e){}
        System.out.println("Your grid ready to access");
        for (int i = 0; i < Grid.locations.length; i++) {
            for (int j = 0; j < Grid.locations[i].length; j++){
                System.out.print("|" + Grid.locations[i][j].getX());
                System.out.print(Grid.locations[i][j].getY() + "|");
                try{Thread.currentThread().sleep(100);}catch (InterruptedException e){}

            }
            System.out.println("");
        }
        try{Thread.currentThread().sleep(1000);}catch (InterruptedException e){}
        System.out.println(RF1.getName() + " is in [" + RF1.getLocation().getX() + "][" + RF1.getLocation().getY() + "]");
        try{Thread.currentThread().sleep(300);}catch (InterruptedException e){}
        System.out.println(RF2.getName() + " is in [" + RF2.getLocation().getX() + "][" + RF2.getLocation().getY() + "]");
        try{Thread.currentThread().sleep(300);}catch (InterruptedException e){}
        System.out.println(KF1.getName() + " is in [" + KF1.getLocation().getX() + "][" + KF1.getLocation().getY() + "]");
        try{Thread.currentThread().sleep(300);}catch (InterruptedException e){}
        System.out.println(KF2.getName() + " is in [" + KF2.getLocation().getX() + "][" + KF2.getLocation().getY() + "]");
        try{Thread.currentThread().sleep(300);}catch (InterruptedException e){}
        System.out.println("Lotuses are in " + L1.getLocation().getX() + " " + L1.getLocation().getY() + "," + L2.getLocation().getX() + " " + L2.getLocation().getY() + "," + L3.getLocation().getX() + " " + L3.getLocation().getY() + "," + L4.getLocation().getX() + " " + L4.getLocation().getY() + "," + L5.getLocation().getX() + " " + L5.getLocation().getY());
        try{Thread.currentThread().sleep(300);}catch (InterruptedException e){}
        System.out.println(NF1.getName() + " is in [" + RF1.getLocation().getX() + "][" + RF1.getLocation().getY() + "]");
        try{Thread.currentThread().sleep(300);}catch (InterruptedException e){}
        System.out.println(NF2.getName() + " is in [" + RF1.getLocation().getX() + "][" + RF1.getLocation().getY() + "]");
        try{Thread.currentThread().sleep(300);}catch (InterruptedException e){}

        SwimmerThread SST1=new SwimmerThread(swimmerThreads,"Super Swimmer A",SS1,treasure);
        SwimmerThread SST2=new SwimmerThread(swimmerThreads,"Super swimmer B",SS2,treasure);
        SwimmerThread NST1=new SwimmerThread(swimmerThreads,"Normal Swimmer A",NS1,treasure);
        SwimmerThread NST2=new SwimmerThread(swimmerThreads,"Normal Swimmer B",NS2,treasure);
        SST1.start();
        SST2.start();
        NST1.start();
        NST2.start();
    }

}
class SwimmerThread extends Thread implements Observer{
    private Swimmer swimmer;
    private Treasure treasure;

    public Swimmer getSwimmer() {
        return swimmer;
    }

    public void setSwimmer(Swimmer swimmer) {
        this.swimmer = swimmer;
    }

    public Treasure getTreasure() {
        return treasure;
    }

    public void setTreasure(Treasure treasure) {
        this.treasure = treasure;
    }

    public SwimmerThread(ThreadGroup group, String name, Swimmer swimmer, Treasure treasure) {
        super(group, name);
        this.swimmer = swimmer;
        this.treasure=treasure;
    }


    @Override
    public void run() {
        boolean move = true;

        Random Indice = new Random();
        swimmer.setLocation(Grid.locations[Indice.nextInt(11)][Indice.nextInt(11)]);
        while (move) {
            GameDemo.KF1.eat(swimmer);
            GameDemo.RF1.eat(swimmer);
            GameDemo.KF2.eat(swimmer);
            GameDemo.RF2.eat(swimmer);
            synchronized (Location.class) {
                if (swimmer.isLive() == false) {
                    System.out.println("The swimmer " + swimmer.getName() + " is  killed");
                    GameDemo.swimmers.remove(swimmer);
                    move = false;
                    Thread.currentThread().interrupt();
                    System.out.println("The current swimmers count="+GameDemo.Inhabitants.size());
                    break;
                } else if (swimmer.isHasSwimFin() == false) {
                    System.out.println(swimmer.getName() + "'s swimfin is eaten");
                    move = false;
                    Thread.currentThread().interrupt();
                    break;

                } else {
                    Location lastLocation = swimmer.getLocation();
                    int nowX = lastLocation.getX();
                    int nowY = lastLocation.getY();
                    int newX;
                    int newY;
                    if (nowY < 0 | nowX < 0) {
                        newX = (nowX + Indice.nextInt(4));
                        newY = (nowY + Indice.nextInt(4));
                    } else if (nowY > 10 | nowX > 10) {
                        newX = nowX - Indice.nextInt(4);

                        newY = nowY - Indice.nextInt(4);

                    } else if (nowX > -1 && nowY > -1 && nowX < 11 && nowY < 11) {
                        newX = (nowX - 2) + Indice.nextInt(5);
                        newY = (nowY - 2) + Indice.nextInt(5);
                    } else {
                        newX = 0;
                        newY = 0;
                    }
                    if (newX > -1 && newY > -1 && newX < 11 && newY < 11) {
                        Location assumeLocation = Grid.locations[newX][newY];
                        swimmer.canSwim(assumeLocation);
                        try {
                            sleep(100);
                        } catch (InterruptedException e) {
                        }
                        if (lastLocation != swimmer.getLocation()) {
                            System.out.println(swimmer.getName() + " swims to" + nowX + " " + nowY + " to  " + newX + " " + newY);
                            treasure.addObserver(this);
                        }
                    }


                }

            }
        }




    }

    @Override
    public void update(String s){
        System.out.println("The target was Achieved by " + swimmer.getName()+".  The available swimmers counts are "+GameDemo.Inhabitants.size());
        GameDemo.swimmerThreads.stop();
        System.out.println(s+swimmer.getName());


    }
}