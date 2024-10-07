package cabbieManager;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Objects;

import utils.CabbieInfoGenerator;

@XmlRootElement(name = "cabbie")
public class Cabbie extends Person {
    private String cabbieId;
    private float rate;
    private String licenseNumber;
    private boolean isBusy;
    private String name;

    public Cabbie() {
    }

    @Override
    public void register() {
        CabbieInfoGenerator cab = new CabbieInfoGenerator();
        this.name = cab.getName();
        this.email = cab.getEmail();
        this.phone = cab.getPhone();
        this.cabbieId = cab.getCabbieId();
        this.rate = cab.getRate();
        this.licenseNumber = cab.getLicenseNumber();
        this.isBusy = false;
        System.out.println("Pessoa motorista " + this.cabbieId + " (" + this.name + ") criada com sucesso");
    }

    @Override
    public void update(String field, String newValue) {
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
                this.rate = Float.parseFloat(newValue);
                break;
            case "licenseNumber":
                this.licenseNumber = newValue;
                break;
            case "isBusy":
                this.isBusy = Boolean.parseBoolean(newValue);
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

    @XmlElement(name = "cabbieId")
    public String getCabbieId() {
        return this.cabbieId;
    }

    public void setCabbieId(String cabbieId) {
        this.cabbieId = cabbieId;
    }

    @XmlElement(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "isBusy")
    public boolean getIsBusy() {
        return this.isBusy;
    }

    public void setIsBusy(boolean value) {
        this.isBusy = value;
    }

    @XmlElement(name = "rate")
    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    @XmlElement(name = "licenseNumber")
    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    @Override
    public String toString() {
        return "Cabbie:" + this.cabbieId + this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Cabbie) {
            Cabbie cabbie = (Cabbie) o;
            return Objects.equal(this.cabbieId, cabbie.getCabbieId());
        }
        return false;
    }
}

