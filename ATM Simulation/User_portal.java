import java.io.*;
import java.util.Scanner;
public class User_portal 
{
    public static void main(String args[]) throws IOException 
    {
        //handles an exception
        Welcome();
        user();//forming a static interface for user
    }

    static void user() throws IOException
    {
        int choice;
        Scanner sc=new Scanner(System.in);
        System.out.println("\n1. Sign Up");
        System.out.println("\n2. Login");
        System.out.println("\n3. Exit");
        System.out.print("\nEnter Your Current State: ");
        choice=sc.nextInt();//asking the choice

        switch(choice)
        {
            case 1:
                New_User user = new New_User();
                user.data();//calling function of New_User class

            case 2:
                Old_User user1 = new Old_User();
                user1.operation();//calling function of Old_User class

            case 3:
                System.out.println("\n-------------- THANKYOU ----------------\n");
                System.exit(0);

            default:
                System.out.println("\nEnter a valid Choice\n");
                    
        }

        sc.close();
    }

    static void Welcome() {
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(" \t\t\t\t\t\t\tWELCOME TO KANISHA'S ATM ");
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(" \t\t\t\t\t\tTHE MOST EASIEST WAY FOR TRANSACTION");
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------------------------\n\n");

    }
        
}
