import java.io.*;
import java.util.Scanner;
public class New_User 
{
        String User_Name;
        private String pin;//for privary purpose only child can activate this data
        String Bank_Name;
        private String Card_Num;//same for the card Number
        int Balance;

        Scanner sc=new Scanner(System.in);
    
        void data() throws IOException
        {

            File f1 = new File("Record.txt");//locating a pointer at the start of a file
            FileWriter f = new FileWriter(f1, true); // Here due to lack of charcter forming error can't use this
            PrintWriter pw = new PrintWriter(f);// It is comparitively reliable

            System.out.print("\n-> Full Name: ");
            User_Name= sc.nextLine();

            System.out.print("\n-> Bank Name: ");
            Bank_Name=sc.nextLine();

            System.out.print("\n-> Amount to be Deposited: ");
            Balance=sc.nextInt();

            String s="\n-> Enter Your Pin number:  ";
            Pin_Hack p =new Pin_Hack();//calling a class for scanning PIN
            pin=p.Pin(s);            
            pin=pin.trim();//trimming for safety purpose
            
            String pin2=pin;//storing for checking again

            System.out.println();
            s="\n-> Please confirm Your Pin: ";
            pin=p.Pin(s);            
            pin=pin.trim();
        
            if(pin2.equals(pin)==true)//if they are same
            {
                System.out.println("\n--------- Pin Confirmed -------\n");
            }

            else
            {
                System.out.println("\n----------- Please Enter Pin correctly -----------\n");
                s="\n-> Enter Your Pin again: ";
                pin=p.Pin(s);            
                pin=pin.trim();//Giving a chance
            }

            int num =(int)(Math.random()*1000000000);//generating a random no. for Card_Number
            Card_Num = Integer.toString(num);

            System.out.println("\n------------------- Please Note Down Your Alloted Card Number ----------------\n");
            System.out.println("\n Your Card Number is:    "+Card_Num);

            pw.write("\nCard Number: "+Card_Num);
            pw.write("\nPin: "+pin);
            pw.write("\n"+User_Name+"'s Balance: " +Balance);
            pw.write("\nUser Name: " +User_Name);
            pw.write("\nBank Name: " +Bank_Name);//writing whole data into the file called Record

            pw.write("\n*****************************************\n");
            

            pw.flush();//to clear any buffer if present
            pw.close();//closing the file
        }


}
