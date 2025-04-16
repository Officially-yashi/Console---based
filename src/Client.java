

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Client extends User{
	 
		public Client()
		{
			super();
			
		}
		
		public void show(DressDAO database,Scanner sc)
		{ while(true)
			{

			
			System.out.println("1. View Dress :");
			System.out.println("2. Rent Dress :");
			System.out.println("3. Return Dress :");
			System.out.println("4. Show My Rentdresses :");
			System.out.println("5. Quit");

			System.out.println("Choose an option:");
			int choice=sc.nextInt();
			sc.nextLine();


			switch(choice)
			{
				case 1:
				viewDress(database);
				break;
				case 2:
				rentDress(database, sc);
				break;
				case 3:
				returnDress(database,sc);
				break;
				case 4:
				showmyrentDress(database);
				break;
				case 5:
				return;
				
			}
		  }
	    }

		public static void viewDress(DressDAO database)
		{
			try{
				ResultSet rs=database.getStatement().executeQuery("SELECT * FROM dresses  WHERE available = 1;");

				while(rs.next())
				{
					System.out.println("Dress id:"+rs.getInt("id")+":"+"Name:"+rs.getString("name")+":"+rs.getDouble("price"));
				}
			}
			catch (SQLException e) {
            e.printStackTrace();
           }
		}

		private void rentDress(DressDAO database,Scanner sc)
		{
			System.out.println("enter the dress id you want to rent:");
			int dressid=sc.nextInt();

			try{

				ResultSet check = database.getStatement().executeQuery("SELECT available FROM dresses WHERE id=" + dressid);
        if (check.next() && check.getInt("available") == 1) 
		      {

				int rows=database.getStatement().executeUpdate("update dresses set available=0 where id="+dressid);
				database.getStatement().executeUpdate("INSERT INTO rentdresses (clientid, dressid) VALUES (" + this.getId() + ", " + dressid + ")");
            
					System.out.println("Rented successfully");
				}
				else{
					System.out.println("already rented");
				}
		

			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}


		private void returnDress(DressDAO database,Scanner sc)
		{
			
			System.out.println("enter the dress id you want to return:");
			int dressid=sc.nextInt();

			try
			{
                int rows=database.getStatement().executeUpdate("update dresses set available =1 where id="+dressid);
			

				if (rows > 0) {
					System.out.println("Dress is now available.");
					int deletedrows=database.getStatement().executeUpdate("DELETE FROM rentdresses WHERE dressid = " + dressid + " AND clientid = " + this.getId());
				if(deletedrows>0)
				{  
					System.out.println("return successfully");
				}
				else{
					System.out.println("dress id not found");
				}
			}
		}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

		private void showmyrentDress(DressDAO database)
		{
			try
	         {    String query=
				      "SELECT d.id, d.name, d.price FROM dresses d " +
                       "JOIN rentdresses r ON d.id = r.dressid " +
                       "WHERE r.clientid = " + this.getId();
				
				

               ResultSet rs= database.getStatement().executeQuery(query);
			   boolean found=false;
			   while(rs.next())
			   {  found=true;
				System.out.println("dressid:"+rs.getInt("id")+":"+"name:"+rs.getString("name")+ ", Price: " + rs.getDouble("price"));
			   }

			   if(!found)
			   {
				System.out.println("you have not any dresses in rent");
			   }
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
	}







