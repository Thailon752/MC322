import java.util.*;
public class Ride {
    //Adicionar os atributos da classe Ride
    private String rideid;
    private int userid;
    private int cabbeid;
    private int vehicleid;
    private String pickupLocation;
    private String droplocation;
    private String status;
    private double fare;
    //Adicionar os métodos da classe Ride
    public void requestRide(int Userid,String embarque,String destino,Cabbie[] taxist,Payment pagamento){
        this.userid = Userid;
        this.pickupLocation = embarque;
        this.droplocation = destino;
        System.out.printf("Corrida chamada por pessoa passageira %d de %s a %s\n",this.userid,this.pickupLocation,this.droplocation);
        Cabbie prov = achacabbie(taxist);
        this.cabbeid = prov.getCabbieid();// pode muda o nome depende doque vc fazer
        this.vehicleid = prov.getVehicleId();
        System.out.printf("Corrida atendida por pessoa motorista %d rating %.2f\n",this.cabbeid,prov.getRating());
        prov.setStatus(true);// pode muda o nome depende doque vc fazer //pergunta de thailon-> <tu pegou um get pra setar status isso não seria um setter?> 
        updateRideStatus(true);
        finalizacorrida(pagamento,prov);
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
        System.out.printf("Valor da corrida definida por: %.2f\n",(double)(len*len2)/10);
        return (len*len2)/10;
    }
    public String getrideid(){
        return this.rideid;
    }
    public double getfare(){
        return this.fare;
    }
    private void finalizacorrida(Payment pagamento,Cabbie taxista){// recebe umm objeto pagamento e chama um processo para fazer o pagamento
        this.fare =  calculafare(this.pickupLocation+this.droplocation);
        Scanner sc = new Scanner(System.in);
        String metodo = "";
        float note = 0;

        int a = 0;
        while (a == 0) {
            System.out.printf("Forma de pagamento: ");
            metodo =  sc.nextLine();
            System.out.printf("Forma de pagamento %s\n",metodo);
            a = pagamento.processapagamento(this.getrideid(),metodo,this.getfare());
        }
        System.err.println("Corrida finalizada.");
        System.out.print("digite a nota do motorista indo de 0 a 5: ");
        note = sc.nextFloat();
        taxista.getaval(note);
        updateRideStatus(false);
        sc.close();
        
    }

}
