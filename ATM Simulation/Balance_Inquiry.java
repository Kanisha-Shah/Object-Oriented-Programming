import java.io.*;
public class Balance_Inquiry extends Transfer
{
    Balance_Inquiry() throws IOException
    {

    }

    void inquiry() throws IOException
    {
        int flag=0,p2=0;

        String Bank_name="",Balance="";
        File f1 = new File("Record.txt");

        BufferedReader br = new BufferedReader(new FileReader(f1));//110 -> 100 as a string read

        System.out.print("\n-> Please Enter Your Card Number: ");
        number=sc.nextLine();

        System.out.print("\n-> Card Holder's Name: ");
        name=sc.nextLine();//scanning details
              
        String initial = br.readLine();
 
        while(initial != null && flag==0)
        {               
            if(("Card Number: "+number).equals(initial))
            {                
                flag=1;
                initial=br.readLine();
                temp1=initial;//storing pin
                Balance=br.readLine();//stores name
                Bank_name=br.readLine();//stores bank name
                Bank_name=br.readLine();//stores bank name
            }

            else
            {
                initial=br.readLine();
            }

        }

        br.close();
        if(flag==0)
        {
            System.out.println("\n-------------------------- No such Card Number exist -----------------------\n");
            operation();
        }

        else
        {
            String s="\n-> Enter Your Pin:   ";
            Pin_Hack p1 =new Pin_Hack();
            pin=p1.Pin(s);            
            pin=pin.trim();//validating pin

            if(("Pin: "+pin).equals(temp1))
            {
                System.out.println("\n------------------------- Pin Matched Successfully ---------------------------\n");
                p2=1;
            }

            else
            {
                System.out.println("\n-------------------------- Please enter your Pin again ----------------------\n");
                s="\n-> Enter Your Pin:  ";
                pin=p1.Pin(s);            
                pin=pin.trim();//giving a chance

                if(("Pin: "+pin).equals(temp1))
                {
                    System.out.println("\n---------------------- Pin Matched Successfully ------------------------\n");
                    p2=1;
                }

                else
                {
                    System.out.println("\n----------------------- Incorrect Pin ----------------------\n");
                    operation();
                }

            }

            if(p2==1)
            {
                Bank_name=Bank_name.substring(11);//removing initial data

                System.out.println("\n*Details: \n");
                System.out.println("\nAccount Holder: "+name);
                System.out.println("\nCard Number: "+number);
                System.out.println("\nBank Name: "+Bank_name);
                
                String arr[]=Balance.split(":");
                Balance=arr[1].trim();
                present_amt_acc1=Integer.parseInt(Balance);

                System.out.println("\nYour Current Balance is: "+present_amt_acc1);//printing details
                operation();
            }
            
        }

        

    }
}
