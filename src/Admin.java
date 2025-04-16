import java.util.Scanner;

public class Admin extends User {
    
    private Operation[] operations = new Operation[]{
        new AddNewAdmin() ,
        new AddDresses(),
        new AddNewClient(),
        
    };

    public Admin() {
        super();
    }

    public void show(DressDAO database, Scanner sc) {
        Client client = new Client();
        AddNewClient addclient=new AddNewClient();
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add new Admin");
            System.out.println("2. Add dresses");
            System.out.println("3. Add client");
            System.out.println("4. View Dresses");
            System.out.println("5. Show clients");
            System.out.println("6. Show Admin");
            System.out.println("7. Close");
            
            System.out.print("Choose an option: ");
            int i = sc.nextInt();
            sc.nextLine(); 

            if (i == 7) {
                System.out.println("Exiting Admin Panel...");
                break;
            }
           else if(i==4)
            {
                Client .viewDress(database);
            }
           else if(i==5)
            {
                AddNewClient.showclients(database);
            }
           else if(i==6)
            {
                AddNewAdmin.showadmin(database);
            }

            else if (i < 1 || i > operations.length) {
                System.out.println("Invalid choice. Please select a valid option.");
            } else {
                operations[i - 1].operation(database, sc, this);
            }
        }
    }
}
