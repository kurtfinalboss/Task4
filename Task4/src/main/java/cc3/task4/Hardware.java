package cc3.task4;

public class Hardware {
    
    protected final int SPEC, ID;
    protected final String BRAND, TYPE;
    
    protected Hardware(String brand, int spec, String type, int id){
        this.SPEC = spec;
        this.BRAND = brand;
        this.TYPE = type;
        this.ID = id;
    }
    
    public int getSpec(){
        return SPEC;
    }
    
    public String getBrand(){
        return BRAND;
    }
    
    public String getType(){
        return TYPE;
    }
    
    public int getId(){
        return ID;
    }
    
    public String interpretSpec(){
        return SPEC + " Spec";
    }
}
