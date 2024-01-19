class EraserThread implements Runnable//inbuilt classes
{
   private boolean stop;//to stop while password ends
 
   public EraserThread(String prompt)
   {
       System.out.print(prompt);
   }

   public void run () //called by start()
   {
      stop = true;//changing status
      while (stop)
      {
         System.out.print("\010*");
         try
         {
            Thread.currentThread();//calling currentThread()
            Thread.sleep(1);//using inbuilt functions here sleeping for 1ms
         }
         catch(InterruptedException ie)
         {
            System.out.println("Interrupted");
         }
      }
   }

   public void stopMasking()
   {
      this.stop = false;//while password ends
   }
}


class Pin_Hack
{
   String Pin(String s)
   {
      String password = Password.readPassword(s);
      return password;
   }
}
