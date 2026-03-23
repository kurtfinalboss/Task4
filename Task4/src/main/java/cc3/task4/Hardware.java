package cc3.task4;

public class Hardware {
    protected int spec, id;
    protected String brand, type;
    
    protected Hardware(String brand, int spec, String type, int id){
        this.spec = spec;
        this.brand = brand;
        this.type = type;
        this.id = id;
    }
    
    public int getSpec(){
        return spec;
    }
    
    public String getBrand(){
        return brand;
    }
    
    public String getType(){
        return type;
    }
    
    public int getId(){
        return id;
    }
    
    public String interpretSpec(){
        return spec + " Spec";
    }
    
}
