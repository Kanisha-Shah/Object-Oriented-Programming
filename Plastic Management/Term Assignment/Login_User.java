import java.util.Scanner;
class Login_User extends Address
{
    String name;
    String customer_id;
    private String password;
    private String securityAns;
    Scanner sc=new Scanner(System.in);

    void input()
    {
        int ch;
        String temp;
        do
        {
            System.out.print("\n1.Existing User \n2.New User \nEnter your choice: ");
            ch=sc.nextInt();

            switch(ch)
            {
                case 1:
                    existingUser();
                    break;
                        
                case 2:
                    newUser();
                    break;  
                
                default:                
                    System.out.println("\nEnter valid choice: ");


            }  

            System.out.print("\nDo you want to continue? Press \"1\" for yes \n");
            System.out.print("\nEnter Your choice: ");
            ch=sc.nextInt();

        }while(ch==1);

    }

    void existingUser()
    {
        int ch;
        String temp;

        System.out.print("\nEnter your name: ");
        name=sc.nextLine();
        sc.nextLine();

        System.out.print("\nDo you remember your password \npress \"1\" for yes, else any other number ");
        System.out.print("\nEnter Your choice: ");
        ch=sc.nextInt();

        if (ch==1)
        {
            System.out.print("\n------You Have 3 attempts!----\n");
            for(int i=0;i<=2;i++)
            {
                System.out.print("\nEnter your Password:  ");
                temp=sc.nextLine();
                sc.nextLine();

                if(temp.equals(password))
                {
                    System.out.println("\n--------Login Successful------\n");
                    break;
                }
                else 
                {
                    System.out.println("\nYour Password doesn't match try again! \n"); 
                    if(i==2)
                    {
                        System.out.println("\n--------You exceeded your attempts!-------\n"); 

                    }
                }

            }
    
        }
        else
        {
            System.out.print("\n----------You Have 3 attempts to enter correct Security Password!---------\n");

            
            for(int i=0;i<=2;i++)
            {
                
                System.out.print("\nEnter a Security answer to the question \n\nQues- What is the name of your first school? ");
                System.out.print("\nEnter Your choice: ");
                temp=sc.nextLine();
                sc.nextLine();

                if(temp.equals(securityAns))
                {
                    System.out.print("\nEnter your New Password: ");
                    password=sc.nextLine();
                    
                    break;
                }
               
                else
                {
                    
                    System.out.println("\n---------Your Security Answer doesn't match try again!------- \n");
                    if(i==2)
                    {
                        System.out.println("\n------------You exceeded your attempts!-----------------\n"); 

                    }
                }
                sc.nextLine();
                
            }       
            
        }

    }

    void newUser()
	{
		System.out.print("\nEnter your Username:  ");
		name=sc.nextLine();
        sc.nextLine();

		System.out.print("\nEnter your Password:  ");
        password=sc.nextLine();
        sc.nextLine();
        
		System.out.print("\n\nEnter your Security answer (in case you forget your password) \n\nQues- What is the name of your first school? : ");
        securityAns=sc.nextLine();
        sc.nextLine();
        
        getAddress();
	}

}
