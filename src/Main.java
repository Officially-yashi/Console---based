import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DressDAO database = new DressDAO();
        
        System.out.println("Welcome to Dress Rental System");
        System.out.println("1. Login as Admin");
        System.out.println("2. Login as Client");
        System.out.print("Choose an option: ");
        
        int choice = sc.nextInt();
        User user;
        
        if (choice == 1) {
            user = new Admin(); 
        } else {
            user = new Client();
        }
        
        user.show(database, sc);
       
    }
}

