import java.util.*;
public class Ride {
    //Adicionar os atributos da classe Ride
    private String rideid;
    private String userid;
    private String cabbeid;
    private String vehicleid;
    private String pickupLocation;
    private String droplocation;
    private String status;
    private double fare;
    //Adicionar os métodos da classe Ride
    public void requestRide(String Userid,String embarque,String destino,Cabbie[] taxist){
        this.userid = Userid;
        this.pickupLocation = embarque;
        this.droplocation = destino;
        this.fare = calculafare(destino);
        Cabbie prov = achacabbie(taxist);
        this.cabbeid = prov.getid();// pode muda o nome depende doque vc fazer
        prov.getstatus(true);// pode muda o nome depende doque vc fazer
        updateRideStatus(true);

    }
    private Cabbie achacabbie(Cabbie[] taxi){
        Random rnd = new Random();
        int len =  taxi.length;
        int rn3 = rnd.nextInt(len);
        return taxi[rn3];

    }
    private void updateRideStatus(boolean estatus){
        if (estatus)this.status = "Em andamento";
        else this.status = "Finalizada";
    }
    private double calculafare(String args){
        Random rnd = new Random();
        int len = rnd.nextInt(30);
        int len2 = args.length();
        return (len*len2)/10;
    }
    public String getrideid(){
        return this.rideid;
    }
    public double getfare(){
        return this.fare;
    }
    public void finalizacorrida(Payment pagamento,String metodo){
        pagamento.processapagamento(this.getrideid(),metodo,this.getfare());
        updateRideStatus(false);
    }

}
