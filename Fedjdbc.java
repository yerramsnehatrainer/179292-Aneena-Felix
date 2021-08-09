package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Fedjdbc extends conn {

		
		public static void main(String[] args) throws SQLException 
		{
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","root");
			Statement s=c.createStatement();
			
			Fedjdbc obj = new Fedjdbc();
			System.out.println(".........WELCOME TO BANK............");
		    obj.database(c,s);
			obj.create(c, s);
			obj.insert(c, s);
			obj.display(c,s);
			
		}
		}


	class conn
		{
			String sql;
			
			void database(Connection c, Statement s) throws SQLException
			{
				String sql = "create database fed4";
				s.executeUpdate(sql);
				
			}
			void create(Connection c, Statement s) throws SQLException
			{
				sql = "create table fed4.customer_details (id int not null  auto_increment primary key, name varchar(50), age int not null)";
				s.executeUpdate(sql);
				System.out.println("ENTER DETAILS .....");
			}	
			
			
			void insert(Connection c, Statement s) throws SQLException
			{ 
				Scanner scanner = new Scanner(System.in);	
				System.out.println("Enter you name: ");
				String name = scanner.nextLine();
				System.out.println("Enter you age: ");
				String age = scanner.nextLine();
                sql = "insert into fed4.customer_details (name,age) values " + "( '" + name + " ',"+ age + ")";
				s.executeUpdate(sql);
				
				System.out.println("Enter you name: ");
				String name1 = scanner.nextLine();
				System.out.println("Enter you age: ");
				String age1 = scanner.nextLine();
				sql = "insert into fed4.customer_details (name,age) values " + "( '" + name1 + " ',"+ age1 + ")";
				s.executeUpdate(sql);
				
				System.out.println("Enter you name: ");
				String name2 = scanner.nextLine();
				System.out.println("Enter you age: ");
				String age2 = scanner.nextLine();
				sql = "insert into fed4.customer_details (name,age) values " + "( '" + name2 + " ',"+ age2 + ")";
                s.executeUpdate(sql);
		        System.out.println("CUSTOMER DETAILS ARE INSERTED");
			
			}
			
			
			
			void display(Connection c, Statement s) throws SQLException
			{
				sql = "Select * from fed3.customer_details";
				ResultSet rs=s.executeQuery(sql);
				while(rs.next())
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
				c.close();
				System.out.println(".....Thank you for banking....");
			}
			
		}

	
			
		