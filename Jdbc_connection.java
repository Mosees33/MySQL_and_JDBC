package internshala.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Jdbc_connection 
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_mgmt","root","$20AZ3530Mos");
			
			PreparedStatement psmt = con.prepareStatement("insert into employee values(?,?,?)");
			
			//to read the user input
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			while(true)
			{
				System.out.println("Employee no:");
				int eno = Integer.parseInt(br.readLine());
				
				System.out.println("Employee name:");
				String name = br.readLine();
				
				System.out.println("Employee salary:");
				int salary = Integer.parseInt(br.readLine());
				
				psmt.setInt(1, eno);
				psmt.setString(2, name);
				psmt.setInt(3, salary);
				int count = psmt.executeUpdate();		
				
				if(count > 0)
					System.out.println(count +" record inserted");
				
				else
					System.out.println("No record found");
				
				System.out.println("Do you want to continue ");
				String ch = br.readLine();
				if(ch.equalsIgnoreCase("no"))
					break;
			}
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
}
}
