package project;

import java.util.Scanner;

public class Main_
{
	public static void main(String args[])throws Exception
	{
		
	Scanner sc=new Scanner(System.in);
	System.out.println("Welcome To Honda");
	System.out.println("Enter 1 for admin Enter 2 for customer");
	int c=sc.nextInt();
	String Username = "Honda";
	if(c==1)
	{
		int Password=123;
		System.out.println("Enter username");
		String username = sc.next();
		System.out.println("Enter password");
		int password = sc.nextInt();
		if(Username==username&& Password==password)
		{
		
		System.out.println("Welcome admin");
		int choice = sc.nextInt();
		
		do
		{
			System.out.println("Enter your choice 1.Add Data:\n2.Delete data\n3.Edit data\n4.Display data\n5.EXIT\n");
			System.out.println("Select an option");
			
			
			switch(choice)
			{
			case 1:
				
				System.out.println("Enter car name:");
				String name=sc.next();
				System.out.println("Enter model number:");
				int num=sc.nextInt();
				System.out.println("Enter total number of colours:");
				int color=sc.nextInt();
				
				for(int i=0;i<color;i++)
				{
				System.out.println("Enter colour along with quantity:");
				String colour=sc.next();
				int quantity=sc.nextInt();
				
				}
				
				break;
			
			case 2:
			//	a.Display();
				
				
				
			case 3:
			//	a.allowances();
				break;
				
			case 4:
			//	a.calculatesalary();
				break;
			
			case 5:
				break;
				
				default:
				System.out.println("Incorrect choice");
			}
		}
		
		while(choice!=5);
		sc.close();
	}

		
		}
		
		
		
	
	else
	{   System.out.println("Enter username");
	    String username = sc.next();
	    if(Username==username)
	    {
		Customer c1 = new Customer();
	    }
	}
	
	}
	
	
}
