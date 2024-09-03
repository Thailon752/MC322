package Taxi;

public abstract class Person {
    private String name;

    public String getName() {
        return name;
    }
    //SETER
    protected void setName(String name) {
        this.name = name;
    }
    
    public abstract void performrole(String destino,String acao);
    
};
