class Address
{
    String city=new String();
    String area=new String();
    String street=new String();
    String block=new String();
    int pincode;

    void getAddress()
	{
		System.out.print("\nEnter City name:");
		city=sc.nextLine;
		System.out.print("\nEnter Area name:");
		area=sc.nextLine;
		System.out.print("\nEnter Street name:");
		street=sc.nextLine;
		System.out.print("\nEnter Block number/name:");
		block=sc.nextLine;
		System.out.print("\nEnter Pincode:");
		pincode=sc.nextInt;
	}

    //displays address
    void displayAddress()
    {
        System.out.println("Address is:\n" + block + "\n" + street + "\n"+ area + "\n"+ city + "\n" + pincode);

    }


} 