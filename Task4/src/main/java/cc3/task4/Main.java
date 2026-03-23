package cc3.task4;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args){
        
        Repository repo = new Repository.RepositoryBuilder().setDatabasePath().build();
        
        List<Hardware> devices = repo.getAllHardware();
        
            Map<Integer, Integer> laptopTally = new HashMap<>();
            Map<Integer, Integer> phoneTally = new HashMap<>();
            
            int totalLaptops = 0;
            int totalPhones = 0;

            System.out.printf("%-5s | %-15s | %-15s | %-10s%n", "ID", "BRAND", "SPEC", "TYPE");
            System.out.println("------------------------------------------------------------");
            
            for(Hardware item : devices) {
                
                System.out.printf("%-5d | %-15s | %-15s | %-10s%n",
                        item.getId(),
                        item.getBrand(),
                        item.interpretSpec(),
                        item.getClass().getSimpleName());
                int specValue = item.getSpec();
                
                if (item instanceof Laptop) {
                    totalLaptops++;
                    laptopTally.put(specValue, laptopTally.getOrDefault(specValue, 0) + 1);
                    
                } else if (item instanceof Phone) {
                    totalPhones++;
                    phoneTally.put(specValue, phoneTally.getOrDefault(specValue, 0) + 1);
                }
            }
            
            System.out.println("\n--- Hardware Summary ---");
            System.out.println("Total Laptops: " + totalLaptops);
            System.out.println("Total Phones: " + totalPhones);
            System.out.println("Total Hardware Items: " + devices.size());
            
            System.out.println("\n--- Specs Breakdown ---");
            
            laptopTally.forEach((spec, count) ->
                    System.out.println("Laptops with " + spec + "GB: " + count));
 
            phoneTally.forEach((spec, count) ->
                    System.out.println("Phones with " + spec + "MP: " + count));
             
    }
}