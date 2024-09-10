import java.util.*;
public class Ride {
    //Adicionar os atributos da classe Ride
    private String rideid;
    private String userid;
    private int cabbeid;
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
        this.cabbeid = prov.getCabbieid();// pode muda o nome depende doque vc fazer
        prov.setStatus(true);// pode muda o nome depende doque vc fazer //pergunta de thailon-> <tu pegou um get pra setar status isso não seria um setter?> 
        updateRideStatus(true);

    }
    private Cabbie achacabbie(Cabbie[] taxi){// Funcao que pega um taxi aleatório de um vetor de taxi
        Random rnd = new Random();
        int len =  taxi.length;
        int rn3 = rnd.nextInt(len);
        return taxi[rn3];

    }
    private void updateRideStatus(boolean estatus){// só seta o estatus da corrida
        if (estatus)this.status = "Em andamento";
        else this.status = "Finalizada";
    }
    private double calculafare(String args){// calcula o valor da corrida pelo tamanho da string do destino multipliocada por um valor aleatorio
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
    public void finalizacorrida(Payment pagamento,String metodo){// recebe umm objeto pagamento e chama um processo para fazer o pagamento
        pagamento.processapagamento(this.getrideid(),metodo,this.getfare());
        updateRideStatus(false);
    }

}
