

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class AddNewAdmin implements Operation{

	
	public void operation(DressDAO database,Scanner sc, User user)
	{
		System.out.println("Enter the first name:");
		String firstname=sc.next();
		System.out.println("Enter the last name:");
		String lastname=sc.next();
		System.out.println("Enter the email:");
		String email=sc.next();
		System.out.println("Enter the phone number:");
		String phone=sc.next();
		sc.nextLine();
		String password,confirmpass;
		do
		{
			System.out.println("Enter the password:");
            password = sc.nextLine(); 

            System.out.println("Enter the confirm password:");
            confirmpass = sc.nextLine();

            if (!password.equals(confirmpass)) {
                System.out.println(" Passwords do not match! Try again.");
            }
		} while (!password.equals(confirmpass));
		
		int accType=1;
		
		try
		{
			ResultSet rs= database.getStatement().executeQuery("SELECT  count(*) from users;");
			int id=0;
			if(rs.next())
			{
				id = rs.getInt(1);
			}
			
			String insert = "INSERT INTO users (firstname, lastname, email, phone, password, accType) VALUES " +
                "('" + firstname + "', '" + lastname + "', '" + email + "', '" + phone + "', '" + password + "', " + accType + ")";

			database.getStatement().execute(insert);
			System.out.println("admin created");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		
	}

	public static void showadmin(DressDAO database)
	{
		try{
			String showadmin="select * from users";
			ResultSet rs= database.getStatement().executeQuery(showadmin);

			System.out.println("-----------------------Admin List----------------------");

			while(rs.next())
			{
				System.out.println("FirstName:"+rs.getString("firstname")+":"+"Lastname:"+rs.getString("lastname")+":"+"email:"+rs.getString("email")+":"+"phone:"+rs.getString("phone")+":"+"Password:"+rs.getString("password")+":"+"Acctype:"+rs.getInt("accType"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}



