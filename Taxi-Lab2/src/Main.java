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
        System.out.printf("Pessoa Motorista %d (%s) criada com sucesso.\n",taxist[i].getCabbieid(),taxist[i].getName());
      }
      for(int i =0;i<5;i++){
        VehicleInfoGenerator a = new VehicleInfoGenerator();
        Vehicle b = new Vehicle(a.getVehicleId(),a.getRegistrationNumber(),a.getModel(),a.getYear(),taxist[i].getCabbieid());
        taxist[i].setveiculo(b.getVehicleid());
        carros[i]=b;
        System.out.printf("Veiculo %d (%s %s) criada com sucesso.\n",carros[i].getVehicleid(),carros[i].getModel(),carros[i].getRegistrationnumber());
      }
      PassengerInfoGenerator a = new PassengerInfoGenerator();
      Passenger passageiro = new Passenger(a.getPassengerId(),a.getName(),a.getEmail(),a.getPhone());
      passa[0]= passageiro;
      System.out.printf("Pessoa passsageira %d (%s) criada com sucesso.\n",passa[0].getUserid(),passa[0].getName());
      passa[0].update("email",passa[0].getName()+"@outlook.com");
      System.out.printf("Campo 'email' foi atualizado para pessoa %s\n",passa[0].getUserid());
      Ride corrida = new Ride();
      corrida.requestRide(passa[0].getUserid(),"Terminal Barao", "Unicamp", taxist);
      Payment pagamento = new Payment();
      corrida.finalizacorrida(pagamento);

    }

}
