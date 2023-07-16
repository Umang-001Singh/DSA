package Pattern;

public class pattern1d
{// open class
    public static void main(String[] args)
    {// open main
        for (int i = 1; i <= 5; i++)
        {// open loop
            for (int j = 1; j <= i; j++)

                System.out.print(j);
            for (int k = 4; k >= i; k--)
                System.out.print("#");
            System.out.println();
        }// close loop

    }// close main
}//close class

