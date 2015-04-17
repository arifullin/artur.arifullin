public class Vacum extends Appliance {
    private int volume;
    private final int stdVolume = 5;
    public Vacum(int weight,int power,double price,int x){
        super(weight,power,price);
        volume = x;
    }
    public int getRating(){
       return (int)(super.getRating()*((double)volume/stdVolume));
       /* return price*1000+1000/weight+power*100+volume; */
    }

}
