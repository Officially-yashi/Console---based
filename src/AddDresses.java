import java.sql.SQLException;
import java.util.Scanner;



public class AddDresses implements Operation
{
    public void operation (DressDAO database,Scanner sc,User user)
    {
           System.out.println("Enter the dress name:");
        String dressName = sc.nextLine();

        System.out.println("Enter the price:");
        double price = sc.nextDouble();
        sc.nextLine(); 

        System.out.println("Is the dress available? (true/false):");
        boolean available = sc.nextBoolean();
        sc.nextLine(); 

        try {
            String insertQuery = "INSERT INTO dresses (id, name, price, available) VALUES (NULL, '" 
                     + dressName + "', " + price + ", " + available + ")";


            
            database.getStatement().executeUpdate(insertQuery);
            System.out.println("Dress added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
