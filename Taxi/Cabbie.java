package Taxi;

public class Cabbie extends Person {

    private void atender(){
        System.out.printf("Olá meu nome é %s \n",this.getName());
    }
    private void acaminho(){
        System.out.printf("Estou indo para o local de embarque\n");
        for (int n=0;n<3;n++){
            for(int i=0;i<10000;i++){
                for(int j=0;j<200000;j++){
                }
            }
            System.out.println("... ");
        }
        System.out.printf("Cheguei ao local de embarque\n");
    }
    
    private void viagem(String destino){
        System.out.printf("Seguindo para %s \n",destino);
        for (int n=0;n<3;n++){
            for(int i=0;i<10000;i++){
                for(int j=0;j<200000;j++){
                }
            }
            System.out.println("... ");
        }
        System.out.println("Chegamos ao destino");
    }

    @Override
    public void performrole(String destino,String acao){
        if(acao.equalsIgnoreCase("Ligacao")){
            this.atender();
        }
        if(acao.equalsIgnoreCase("Resposta"))
        {
            this.acaminho();
        }
        if(acao.equalsIgnoreCase("viagem")){
            this.viagem(destino);
        }
    }
    

    
}
