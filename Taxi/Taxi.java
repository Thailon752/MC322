package Taxi;

public class Taxi{
    private  String destination;
    private  boolean isHailed;
    public  void acabo(){
        this.destination="";
        this.isHailed=false;
    }
    public  void setchamado(){
        this.isHailed = true ;
    }
    public boolean getchamado(){
        return isHailed;
    }
    public void setdestination(String destino){
         this.destination = destino;
    }
    public  String getdestino(){
        return destination;
    }
}