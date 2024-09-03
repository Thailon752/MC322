package Taxi;
import java.util.Scanner; 

public class Passenger extends Person {
    private String destination;
    private static boolean gorjeta;

    public void dados(String nome,String destino){
        this.setName(nome);
        setDestination(destino);
    }
    public static void setgorjeta(boolean x){
        gorjeta = x;
    }
    public static boolean getgorjeta(){
        return gorjeta;
    }

    public  void setDestination(String destino) {
        this.destination = destino;
    }
    public String getDestination(){
        return this.destination;
    }
    private void chama_taxi(){
        System.out.println("Ligando...");
        for (int n=0;n<3;n++){
            for(int i=0;i<10000;i++){
                for(int j=0;j<200000;j++){
                }
            }
            System.out.println("... ");
        }
    }
    private void resposta(){
        System.out.println("Preciso de um taxi na minha localizacao");
    }
    private void fala_destino(String destino){
        System.out.printf("Quero ir para %s\n",getDestination());
    }
    private void pagar(boolean gorjeta){
        if(gorjeta){
            System.out.println("Aqui está o valor da corrida e uma gorjeta");
        }
        else{
            System.out.println("Aqui está o valor da corrida");
        }
    }
    private void sair(){
        System.out.println("Obrigado e ate a proxima");
        System.out.printf("%s sai do taxi\n",getName());

    }
    private void entra_no_taxi(){
        System.out.printf("%s entra no taxi\n",getName());
    }
    @Override
    public void performrole(String destino,String acao){

        if(acao.equalsIgnoreCase("Ligacao")){
            this.chama_taxi();
        }
        if(acao.equalsIgnoreCase("Resposta")){
            this.resposta();
        }
        if(acao.equalsIgnoreCase("viagem")){
            this.entra_no_taxi();
            this.fala_destino(destino);
            
        }
        if(acao.equalsIgnoreCase("sair")){
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite 's' paga dar gorjeta e 'n' para nao dar:");
            String c = sc.next();
            if(c.equalsIgnoreCase("s")){
                this.pagar(true);
            }
            else{
                this.pagar(false);
            }
            
            this.sair();
            sc.close();
            
        }


    }


    
}