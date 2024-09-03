// João Pedro Rogeri Pavão Ra:242346
// Thailon Mendes de Oliveira Ra:266861



package Taxi;
import java.util.Scanner;  
public class Main {
    public static void main(String [] args){
        Passenger passageiro = new Passenger();
        Cabbie taxista = new Cabbie();
        Taxi taxi = new Taxi();
        taxi.acabo();
        
        taxista.setName("Roberto");

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome e o destino:");
        String nome = sc.nextLine();
        String destino = sc.nextLine();

        passageiro.setName(nome);
        passageiro.setDestination(destino);
        String[] K = new String[4];
        K[0] = "Ligacao";
        K[1]= "Resposta";
        K[2]="Viagem";
        K[3]="Sair";

        System.out.printf("%s decidiu o destino (%s): \n",passageiro.getName(),passageiro.getDestination());
        System.out.printf("%s liga para o taxista: \n",passageiro.getName());
        for (int i=0;i<4;i++){
            System.out.printf("%s: \n",passageiro.getName());
            passageiro.performrole(destino,K[i]);
            if(i==3)break;
            System.out.printf("%s: \n",taxista.getName());
            taxista.performrole(destino,K[i]);

        }
        taxi.acabo();

        
        sc.close();


        
    }
}
