package cc3.task4;

public class Laptop extends Hardware {
    
    private Laptop(LaptopBuilder builder){
        super(builder.brand, builder.spec, builder.type, builder.id);
    }
    
    @Override
    public String interpretSpec(){
        return SPEC + " GB RAM";
    }
    
    public static class LaptopBuilder{
        private String brand, type;
        private int spec, id;
        
        public LaptopBuilder setBrand(String brand){
            this.brand = brand;
            return this;
        }
        
        public LaptopBuilder setSpec(int spec){
            this.spec = spec;
            return this;
        }
        
        public LaptopBuilder setType(String type){
            this.type = type;
            return this;
        }
        
        public LaptopBuilder setId(int id){
            this.id = id;
            return this;
        }
        
        public Laptop build(){
            return new Laptop(this);
        }
    }
}
