import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddNewClient implements Operation
{
    public void operation(DressDAO database, Scanner sc,User user)
    {   
        System.out.println("Enter the client id:");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the first name:");
        String firstname=sc.next();
		System.out.println("Enter the last name:");
		String lastname=sc.next();
		System.out.println("Enter the email:");
		String email=sc.next();
		System.out.println("Enter the phone number:");
		String phone=sc.next();
        sc.nextLine();
        System.out.println("Enter the address:");
		String address=sc.next();
        sc.nextLine();

		try{
            String insert = "INSERT INTO clients (id,firstname, lastname, email, phone, address) VALUES " +
                "('" +id+"','"+ firstname + "', '" + lastname + "', '" + email + "', '" + phone + "', '" + address +  "')";
                database.getStatement().execute(insert);
			System.out.println("client inserted");
        }
        catch(SQLException e)
        {
          e.printStackTrace();
        }

        
    }
    public static void showclients(DressDAO database)
        {  try
            {
                String showclients="select * from clients";
                ResultSet rs= database.getStatement().executeQuery(showclients);

                System.out.println("-----------------------Client List----------------------");

                while(rs.next())
                {
                    System.out.println("ID:"+rs.getInt("id")+":"+"FirstName:"+rs.getString("firstname")+":"+"LastName:"+rs.getString("lastname")+"email:"+rs.getString("email")+":"+"phone:"+rs.getInt("phone")+":"+"Address:"+rs.getString("address"));
                }
            }
            catch(SQLException e)
            {
              e.printStackTrace();
            }
           

        }
}
