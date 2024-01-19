import java.util.Scanner;
class Plastic_Gen
{
    Scanner sc=new Scanner(System.in);
    String plast_types[]={"Transparent","Translucent","Black"};
    float w[]=new float[3];
    float weight;


    void plasticType()
    {   

    
        int ch;
        do
        {
            System.out.println(" 1. "+plast_types[0]);
            System.out.println(" 2. "+plast_types[1]);
            System.out.println(" 3. "+plast_types[2]);

            System.out.print("\nSelect Your Plastic Type: ");
            ch=sc.nextInt(); 
            System.out.print("\nEnter your estimated weight in \"grams\" ");
            weight=sc.nextFloat();
            switch(ch)
            {
                case 1:
                    
                    
                    w[0]+=weight;
                    break;

                case 2:
                    
                    w[1]+=weight;
                    break;

                case 3:
                    
                    w[2]+=weight;
                    break;

            }  
            
            System.out.print("\nPress \"0\" to End else any other key");
            ch=sc.nextInt();

        }
        while(ch!=0);
    }
    void displayWeight()
    {
        System.out.println("-> Final Weight\n");
        System.out.println("Transparent: "+w[0]);
        System.out.println("\nTransclusent: "+w[1]);
        System.out.println("\nBlack: "+w[2]);
    }
    
}
    
}