import java.io.*;
public class Deposit extends Transfer
{
    Deposit() throws IOException
    {

    }
    void deposit_mon() throws IOException
    {
        int x= validate();

        if(x==1)
        {
            System.out.print("\n-> Enter the amount to be Deposited (in Rs.):\n\n");
            amt=sc.nextInt();//scanning amount to be deposited

            String arr[]=temp1.split(":");
            temp1=arr[1].trim();
            present_amt_acc1=Integer.parseInt(temp1);

            if(amt>0)//if fixes this constrainnt
            {
                int res=deposit(amt);//asking status

                if(res==1)
                {
                    System.out.println(amt +" Rs. Deposited successfully");//printing status
                    operation();
                }

                else
                {
                    operation();
                }
            }

            else
            {
                System.out.println("\n------------------ Can't Deposit This Amount --------------------\n");
                operation();
            }
        }

        else
        {

        }
    }

    int deposit(int amt) throws IOException
    {
        int flag=0;
    
        File f1 = new File("Record.txt");
        BufferedReader br = new BufferedReader(new FileReader(f1));//110 -> 100 as a string read
        
        String initial = br.readLine();//taking data line by line

        while(initial != null && flag==0)
        {               
            if(("Card Number: "+number).equals(initial))
            {                
                flag=1;
                initial=br.readLine();
                temp1=br.readLine();//balance
            }

            else
            {
                initial=br.readLine();
            }
        }
        br.close();//closing file

        if(flag==0)
        {
            System.out.println("\n------------------------ No such Card Number exist -------------------------\n");
            return 0;
        }

        else
        {
            String arr[]=temp1.split(":");
        
            temp1=arr[1].trim();
            
            present_amt_acc2=Integer.parseInt(temp1);//converting balance to int

            int curr_bal_acc2 = amt + present_amt_acc2;
            
            f1 = new File("Record.txt");
            br = new BufferedReader(new FileReader(f1));//opening a file

            String hack=br.readLine();

            String Old_data="";//asigning it to null
            while(hack!=null)
            {
                Old_data=Old_data+hack+System.lineSeparator();//storing data which even taakes care of \r and \n

                hack=br.readLine();
            }

            String ex1=name+"'s Balance: "+temp1;
            String ex2=name+"'s Balance: "+curr_bal_acc2;
            New_data=Old_data.replace(ex1,ex2);//replacing data from old to new

            PrintWriter pw = new PrintWriter("Record.txt");

            pw.write(New_data);//writing whole data
        
            br.close();
            pw.flush();
            pw.close();
            //closing all file pointers
            return 1;
        }
    }
}
