package cc3.task4;
import java.sql.*;
import java.util.*;

public class Repository {
    private final String DBURL;
        
    private Repository(RepositoryBuilder builder){
        this.DBURL = builder.dbUrl;
    }
        
    public List<Hardware> getAllHardware() {
        List<Hardware> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DBURL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM tbl_hardware")) {

            while (rs.next()) {
                String type = rs.getString("type");
                String brand = rs.getString("brand");
                int spec = rs.getInt("spec");
                int id = rs.getInt("id");

                if ("Laptop".equalsIgnoreCase(type)) {
                    list.add(new Laptop.LaptopBuilder().setBrand(brand).setSpec(spec).setType(type).setId(id).build());
                } else {
                    list.add(new Phone.PhoneBuilder().setBrand(brand).setSpec(spec).setType(type).setId(id).build());
                }
            }
        } catch (SQLException e) { 
            System.out.println("Error: " + e.getMessage()); }
        return list;
    }
    public static class RepositoryBuilder{
        private String dbUrl;
        
        public RepositoryBuilder setDatabasePath(){
            this.dbUrl = "jdbc:sqlite:D:\\NitbensProject\\Task_4.db";
            return this;
        }
        public Repository build() {
            if (dbUrl == null) throw new IllegalStateException("Database path not set!");
            return new Repository(this);
        }
    }
}