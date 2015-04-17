public class Appliance implements Comparable{
    public Appliance(int weight,int power,double price){
        this.weight = weight;
        this.power = power;
        this.price = price;
    }
    protected int weight;
    protected int power;
    protected double price;
    public int compareTo(Object x){
        Appliance temp = (Appliance) x;
        if (temp.getRating()>getRating()) {
            return 1;
        }else if (temp.getRating() < getRating()){
            return -1;
        }else if (temp.getRating() == getRating()){
            return 0;
        }return 0;
    }
    public int getRating(){
        return (int) ((price * 1000) + (1000 / weight) + (power * 100));
    }

}
