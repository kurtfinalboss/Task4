package cc3.task4;

public class Phone extends Hardware{
    
    private Phone(PhoneBuilder builder){
        super(builder.brand, builder.spec, builder.type, builder.id);
    }
    
    @Override
    public String interpretSpec(){
        return SPEC + " Megapixels";
    }
    
    public static class PhoneBuilder{
        
        private String brand, type;
        private int spec, id;
        
        public PhoneBuilder setBrand(String brand){
            this.brand = brand;
            return this;
        }
        
        public PhoneBuilder setSpec(int spec){
            this.spec = spec;
            return this;
        }
        
        public PhoneBuilder setType(String type){
            this.type = type;
            return this;
        }
        
        public PhoneBuilder setId(int id){
            this.id = id;
            return this;
        }
        
        public Phone build(){
            return new Phone(this);
        }
        
    }
}
