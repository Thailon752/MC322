import java.util.ArrayList;
import utils.*;
public class Main {
    public static void main(String[] args) throws Exception {
        //Aqui você deve realizar a simulação do funcionamento do sistema.
      Passenger[] passa = new Passenger[5];
      Cabbie[] taxist = new Cabbie[5];
      Vehicle[] carros = new Vehicle[5];
      
      for(int i =0;i<5;i++){
        CabbieInfoGenerator a = new CabbieInfoGenerator();
        Cabbie b = new Cabbie(a.getCabbieId(), a.getName(), a.getEmail(), a.getPhone(), a.getLicenseNumber());
        taxist[i]=b;
      }
        
    }

}
