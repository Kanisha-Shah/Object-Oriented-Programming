import java.io.*;
public class Withdraw extends Transfer
{
    Withdraw() throws IOException
    {

    }

    void withdraw_mon() throws IOException
    {
        int x= validate();
        if(x==1)
        {
            System.out.println("\n-> Enter the amount to be Withdrawn: \n");
            amt=sc.nextInt();

            String arr[]=temp1.split(":");
            temp1=arr[1].trim();
            present_amt_acc1=Integer.parseInt(temp1);//converting to int

            if(amt>20000)//it should not exceed
            {
                System.out.println("\n------------------ More than 20,000 Rs. can't be Withdrawn ------------------\n");
                operation();
            }

            else
            {
                int status=withdraw();

                if(status==1)
                {
                    System.out.println(amt +" Rs. successfully withdrawn\n");//giving the update
                    operation();
                }

                else
                {
                    operation();
                }
            }
        }
    }

    int withdraw() throws IOException
    {
        int flag1=0;
        sc.nextLine();

        File f1 = new File("Record.txt");
        BufferedReader br = new BufferedReader(new FileReader(f1));//110 -> 100 as a string read

        String initial = br.readLine();//storing first line of file

        while(initial != null && flag1==0)
        {               
            if(("Card Number: "+number).equals(initial))
            {                
                flag1=1;
                initial=br.readLine();
                temp2=br.readLine();//storing balance
            
            }

            else
            {
                initial=br.readLine();
            }
        }
        br.close();//closing file
        if(flag1==0)
        {
            System.out.println("\n----------------------------- No such Card Number exist -------------------------\n");
            return 0;
        }

        else
        {
            String arr[]=temp2.split(":");
            temp2=arr[1].trim();
            int present_amt_acc1=Integer.parseInt(temp2);//converting to int

            int trans_amt=present_amt_acc1-amt;//modifying balance 

            File f2 = new File("Record.txt");
            br = new BufferedReader(new FileReader(f2));//110 -> 100 as a string read

            String Old_data2="";//initialising with null
            String hack=br.readLine();

            while(hack!=null)
            {
                Old_data2=Old_data2+hack+System.lineSeparator();//storing whole file data into the string

                hack=br.readLine();
            }

            String ex1=name+"'s Balance: "+temp2;
            String ex2=name+"'s Balance: "+trans_amt;//forming strings to be changed
            New_data=Old_data2.replace(ex1,ex2);//replacing line

            PrintWriter pw = new PrintWriter("Record.txt");// 100 -> 100

            pw.print(New_data);
            br.close();
            pw.flush();
            pw.close();
            //closing all files
            return 1;
            
        }
    }
}

