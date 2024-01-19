import java.io.*;
import java.util.Scanner;
public class Old_User 
{
    int choice;
    Scanner sc=new Scanner(System.in);

    void operation() throws IOException
    {
        System.out.println("\n**************** Select Your Transaction ***************\n");
        System.out.print("\n1. Transfer \t\t\t 2. Balance Enquiry");
        System.out.println("\n\n3. Deposit Money \t\t 4. Withdraw Money");
        System.out.println("\n5. Exit"); 
        System.out.print("\n-> Enter Your Choice: "); //asking choice
        choice=sc.nextInt();

        switch(choice)
        {
            case 1:
                System.out.println("\n---------------- Welcome to Transfer Mode -------------\n");
                Transfer t = new Transfer();
                t.transfer_amt();//calling specific function
                break;

            case 2:
                System.out.println("\n----------------- Welcome to Balance Inquiry Mode ---------------\n");
                Balance_Inquiry bi =new Balance_Inquiry();
                bi.inquiry();//calling its function
                break;

            case 3:
                System.out.println("\n----------------- Welcome to Deposit Mode ---------------------\n");
                Deposit b=new Deposit();
                b.deposit_mon();
                break;

            case 4:
                System.out.println("\n----------------- Welcome to Withdraw Mode---------------------\n");
                Withdraw w=new Withdraw();
                w.withdraw_mon();
                break;

            case 5:
                System.exit(0);
                break;//exiting the module
            default:
                System.out.println("Invalid Choice");
                //user();

        }

    }
    

}
