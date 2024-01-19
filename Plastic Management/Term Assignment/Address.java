import java.util.Scanner;
class Address
{
	Scanner sc=new Scanner(System.in);
    String city=new String();
    String area=new String();
	String street=new String();
	int pincode;
	int choice[]=new int[3];

    void getAddress()
	{
		do
		{
			System.out.println("\n***************Enter Your Address****************\n");
			System.out.println("\n 1. Ahmedabad");
			System.out.println("\n 2. Rajkot");
			System.out.println("\n 3. Surat");

			System.out.print("\n Enter Your Choice for City name:  ");
			choice[0]=sc.nextInt();

			if(choice[0]<1||choice[0]>3)
			{
				System.out.println("\nInvalid Choice");
			}
			else
			{
				System.out.println("\n 1. North");
				System.out.println("\n 2. East");
				System.out.println("\n 3. West");
				System.out.println("\n 4. South");
				System.out.print("\nEnter Your Choice for Area name:  ");
				choice[1]=sc.nextInt();
			}
			
		}while(choice[0]<1||choice[0]>3||choice[1]<1||choice[1]>4);

		if(choice[0]==1)
		{
			city="Ahmedabad";
			area();
		}

		else if(choice[0]==2)
		{
			city="Rajkot";
			area();
		}

		else if(choice[0]==3)
		{
			city="Surat";
			area();
		}

		System.out.print("\nEnter Street name:  ");
		street=sc.nextLine();
		sc.nextLine();
		

		System.out.print("\nEnter Pincode:");
		pincode=sc.nextInt();
	}

	void area()
	{
		if(choice[1]==1)
		{
			area="North";
		}
		else if(choice[1]==2)
		{
			area="East";
		}
		else if(choice[1]==3)
		{
			area="West";
		}
		else 
		{
			area="South";
		}
	}
    //displays address
    void displayAddress()
    {
        System.out.println("Address is:\n" + "\n" + street + "\n"+ area + "\n"+ city + "\n" + pincode);
    }


} 