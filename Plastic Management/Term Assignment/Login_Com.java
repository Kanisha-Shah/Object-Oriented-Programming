import java.util.Scanner;
class Login_Com 
{
    String name;
    String customer_id;
    private String password;
    private String securityAns;
    Scanner sc=new Scanner(System.in);
    
	void input()
    {
		System.out.println("Welcome to Committe Loging:");
        int ch;
        do
        {
            System.out.print("Are you \n1.Existing User \n2.New User \nEnter your choice: ");
            ch=sc.nextInt();
			switch(ch)
			{
				case 1:existingCom();break;  
				case 2:newCom();break;  
				default:System.out.println("Enter valid choice: ");break;
			}
		}while(ch==1);
    }
	void existingCom()
	{
		String temp;
		System.out.print("Enter your name: ");
        name=sc.nextLine();
		int ch;
        sc.nextLine();
        
		System.out.print("Do you remember your password \npress 1 for yes \nelse any other number ");
		ch=sc.nextInt();
		if (ch==1)
        {
			int p=2;
			for(int i=0;i<2;i++)
			{
				System.out.print("Enter your Password: ");
				temp=sc.nextLine();
				sc.nextLine();
				if(temp.equals(password))
				{
					System.out.println("Login Successful!");
					break;
				}
				else 
				{
					System.out.println("Your Password doesn't match try again! \n"+(p--)+" Attempts left"); 
				}
	
			}

			if(p==0)
			{
				System.out.println("Try again Later!\n");
			}
					
		}
		else
		{
			int p=2;
            for(int i=0;i<2;i++)
            {
                
                System.out.print("Enter your Security answer to the question \nWhat is the name of your first school?  ");
                temp=sc.nextLine();
                sc.nextLine();
                
                if(temp.equals(securityAns))
                {
                    System.out.print("Enter your new Password: ");
                    password=sc.nextLine();
                    break;
                }
                else if(i==0)
                {
                    System.out.println("Your account is locked!");
                    break;

                }
                else
                {
                    
                    System.out.println("Your Security Answer doesn't match try again! \n"+(p--)+" Attempts left" );

                }
                
            }

            if(p==0)
            {
                System.out.println("Try again Later!\n");
            }
            
            }

		}
	}
	void newCom()
	{
		System.out.println("Enter your name: ");
		name=sc.nextLine();
		sc.nextLine();
		System.out.println("Enter your Password: ");
		password=sc.nextLine();
		System.out.println("Enter your Security answer (in case you forget your password) \nWhat is the name of your first school?: ");
		securityAns=sc.nextLine();
	}
}
