import java.io.*;
import java.util.Scanner;
public class Transfer extends Old_User
{
    Scanner sc=new Scanner(System.in);
    int flag=0;
    String pin,name,name1;
    String number=new String();
    String temp1="",temp2="";
    int present_amt_acc1,trans_amt,amt,present_amt_acc2,curr_bal_acc2,curr_bal_acc1;

    String Old_data="",New_data="";

    void transfer_amt() throws IOException
    {
        int val=validate();//calling a function to validate the state of user

        if(val==1)
        {

            System.out.print("\n-> Enter the amount to be Transfered (in Rs.):   ");
            amt=sc.nextInt();//while such user exist, asking the amount to be transfered

            String arr[]=temp1.split(":");//here using split() splitting the string i.e. balance 
            temp1=arr[1].trim();//trimming for safety purpose
            present_amt_acc1=Integer.parseInt(temp1);//converting to int

            if(present_amt_acc1>=amt)
            {
                System.out.println("\n------------- Transaction is possible ------------\n");
                transaction(amt);//if lunpsum amount is present then only it is going further 
            }

            else
            {
                System.out.println("\n------------------ Balance is not sufficient ------------------");
                operation();//returns to main menu
            }
            
        } 
        operation();
    }
    
    int validate() throws IOException
    {
        
        File f1 = new File("Record.txt");
        BufferedReader br = new BufferedReader(new FileReader(f1));//opening a file in read mode

        System.out.println("\n------------------ Personal Details --------------\n");
        System.out.print("\n-> Please Enter Your Card Number: ");
        number=sc.nextLine().trim();

        System.out.print("\n-> Card Holder's Name: ");
        name=sc.nextLine().trim();//scanning details
              
        String initial = br.readLine();//here it stores the first line of file and then goes further
 
        while(initial != null && flag==0)
        {               
            if(("Card Number: "+number).equals(initial))//checking with the name
            {                
                flag=1;
                initial=br.readLine();
                temp2=initial;//storing pin
                temp1=br.readLine();//storing current amount

            }

            else
            {
                initial=br.readLine();
            }

        }
        br.close();
        if(flag==0)
        {
            System.out.println("\n--------------- No such Card Number exist --------------");
            return 0;
        }

        else
        {
            String s="\n-> Enter Your Pin number:   ";
            Pin_Hack p1 =new Pin_Hack();
            pin=p1.Pin(s);            
            pin=pin.trim();//asking pin

            if(("Pin: "+pin).equals(temp2))//if it gets equal to the data present in file transaction is possible
            {
                System.out.println("\n------------------- Pin Matched Successfully ----------------\n");
                return 1;
            }

            else
            {
                System.out.println("\n------------------------- Please enter your Pin again ----------------------\n");
                s="\n-> Enter Your Pin:  ";
                pin=p1.Pin(s);            
                pin=pin.trim();//giving a chance

                if(("Pin: "+pin).equals(temp2))
                {
                    System.out.println("\n--------------------- Pin Matched Successfully ----------------------\n");
                    return 1;
                }

                else
                {
                    System.out.println("\n----------------------- Incorrect Pin -----------------------------\n");
                    return 0;
                }

            }
        }
               

    }


    void transaction(int amt) throws IOException
    {
        int flag=0;
        String card_num2;
        sc.nextLine();
        System.out.print("\n-> Enter in which Account you want to transfer Money(in Rs.):   ");
        card_num2=sc.nextLine();

        System.out.print("\n-> Card Holder's Name:  ");
        name1=sc.nextLine();//asking details of the person in which it should be transfered

        File f1 = new File("Record.txt");
        BufferedReader br = new BufferedReader(new FileReader(f1));//110 -> 100 as a string read
        
        String initial = br.readLine();//again reading the first line

        while(initial != null && flag==0)
        {               
            if(("Card Number: "+card_num2).equals(initial))
            {                
                flag=1;
                initial=br.readLine();
                temp1=br.readLine();//storing balance
            }

            else
            {
                initial=br.readLine();
            }
        }
        br.close();//closing file

        if(flag==0)
        {
            System.out.println("\n----------------------------- No such Card Number exist ------------------------\n");
            operation();//if not returns to the last menu
        }

        else
        {
            String arr[]=temp1.split(":");

            temp1=arr[1].trim();
            
            present_amt_acc2=Integer.parseInt(temp1);//for the person in which amt adds

            curr_bal_acc2 = amt + present_amt_acc2;
            
            f1 = new File("Record.txt");
            br = new BufferedReader(new FileReader(f1));
            String hack=br.readLine();//again opening the file

            while(hack!=null)
            {
                Old_data=Old_data+hack+System.lineSeparator();//storing whole file data into the string

                hack=br.readLine();
            }

            String ex1=name1+"'s Balance: "+temp1;//forming string to be replaced
            String ex2=name1+"'s Balance: "+curr_bal_acc2;
            New_data=Old_data.replace(ex1,ex2);

            PrintWriter pw = new PrintWriter("Record.txt");// 100 -> 100

            pw.write(New_data);//writing whole data again

            br.close();
            pw.flush();
            pw.close();//closing all pointers

        }

        // The person who transfers the money
        f1 = new File("Record.txt");
        br = new BufferedReader(new FileReader(f1));//110 -> 100 as a string read

        initial = br.readLine();
        int flag1=0;

        while(initial != null && flag1==0)
        {               
            if(("Card Number: "+number).equals(initial))
            {                
                flag1=1;
                initial=br.readLine();
                temp2=br.readLine();
            
            }

            else
            {
                initial=br.readLine();
            }
        }
        br.close();
        if(flag1==0)
        {
            System.out.println("\n------------------------- No such Card Number exist ------------------");
            operation();
        }

        else
        {
            String arr[]=temp2.split(":");
            temp2=arr[1].trim();
            present_amt_acc1=Integer.parseInt(temp2);//holder

            trans_amt=present_amt_acc1-amt;//modifying its balance

            File f2 = new File("Record.txt");

            br = new BufferedReader(new FileReader(f2));//110 -> 100 as a string read

            String Old_data2="";
            String hack=br.readLine();

            while(hack!=null)
            {
                Old_data2=Old_data2+hack+System.lineSeparator();

                hack=br.readLine();
            }

            String ex1=name+"'s Balance: "+temp2;
            String ex2=name+"'s Balance: "+trans_amt;
            New_data=Old_data2.replace(ex1,ex2);//replacing the string after finding

            PrintWriter pw = new PrintWriter("Record.txt");// 100 -> 100

            pw.print(New_data);//overwriting whole data into the file

            br.close();
            pw.flush();
            pw.close();
            //closing all pointers
            System.out.println("\n-------------------- Transaction Successfull -------------------\n");
            operation();
        }
    }
}

