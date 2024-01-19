import java.io.*;
public class Password {

    public static String readPassword (String prompt)
    {
       EraserThread et = new EraserThread(prompt);//using inbuilt class which erases the thread
       Thread mask1 = new Thread(et);
       mask1.start();//calls run()
 
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       String password = "";//initialing password
 
       try
       {
            password = in.readLine();
       }
       catch (IOException inx)
       {
            System.out.println("Interrupted");
       }

       et.stopMasking();//while it ends

       return password;
    }
 }
