package taxi3;
import utils.CabbieInfoGenerator;

public class Cabbie extends Person{
    private String cabbieId;
    private float rating;
    private String licenseNumber;
    private boolean status;

    public float getRate() {
        return rating;
    }
    
    public void setaval(float avalia){
        calcularating(avalia);
    }
    private void calcularating(float avalia){
        this.rating=((this.rating+avalia)/2);

    }

    public String getCabbieid() {
        return this.cabbieId;
    }
    public boolean getstatus(){
        return this.status;
    }
    

    
    /**
     * Registers a cabbie by generating random information.
     * This method assigns a random name, email, phone number, cabbie ID, rate and
     * license number to the cabbie.
     * 
     */
    @Override
    public void register() {

        CabbieInfoGenerator cab = new CabbieInfoGenerator();
        this.name = cab.getName();
        this.email = cab.getEmail();
        this.phone = cab.getPhone();
        this.cabbieId = cab.getCabbieId();
        this.rating = cab.getRate();
        this.licenseNumber = cab.getLicenseNumber();
        System.out.println("Pessoa motorista " + this.cabbieId + " (" + this.name + ") criada com sucesso");
    
    }

    /**
     * Updates a field of the cabbie.
     * 
     * @param field The field to be updated.
     * @param newValue The new value for the field.
     * 
     * The valid fields are:
     * <ul>
     * <li>name</li>
     * <li>email</li>
     * <li>phone</li>
     * <li>cabbieId</li>
     * <li>rate</li>
     * <li>licenseNumber</li>
     * </ul>
     * 
     * If the field is not valid, a message is printed and the field is not updated.
     */
    @Override
    public void update(String field, String newValue){

        boolean validField = true;

        switch (field) {
            case "name":
                this.name = newValue;
                break;
            case "email":
                this.email = newValue;
                break;
            case "phone":
                this.phone = newValue;
                break;
            case "cabbieId":
                this.cabbieId = newValue;
                break;
            case "rate":
                this.rating = Float.parseFloat(newValue);
                break;
            case "licenseNumber":
                this.licenseNumber = newValue;
                break;
            default:
                validField = false;
                System.out.println("Campo inválido");
                break;
        }

        if (validField) {
            System.out.println("Campo " + field + " foi atualizado com sucesso!");
        }

        return;
    }
    
    
    /**
     * Gets the ID of the cabbie.
     * 
     * @return the ID of the cabbie (a UUID)
     */
    public String getCabbieId() {
        return this.cabbieId;
    }

    /**
     * Returns a string representation of the object.
     * 
     * The format is: "email name phone cabbieId rate licenseNumber"
     * 
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return String.format(this.email, this.name, this.phone, this.cabbieId, this.rating, this.licenseNumber);
    }



}
