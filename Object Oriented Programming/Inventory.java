package Umang;
import java.io.*;

public class Inventory {
    public static void main(String[] args){
        try {
            File filein = new File("D:/JAVA/Files/inputfile3.txt");
            DataOutputStream doutfile = new DataOutputStream(new FileOutputStream(filein));
            DataInputStream din = new DataInputStream(System.in);
            String tempString = null;
            System.out.flush();
            System.out.println("Enter Item code number");
            tempString = din.readLine();
            int code = Integer.parseInt(tempString);
            System.out.flush();
            System.out.println("Enter the cost of items");
            tempString = din.readLine();
            float cost = Float.valueOf(tempString);
            System.out.flush();
            System.out.println("Enter the number of items");
            tempString = din.readLine();
            int num = Integer.parseInt(tempString);
            doutfile.writeInt(code);
            doutfile.writeDouble(cost);
            doutfile.writeInt(num);
            doutfile.close();



            DataInputStream dinfile= new DataInputStream( new FileInputStream(filein));
            int CODE= (dinfile.readInt());
            float COST= (dinfile.readFloat());
            int NUM= (dinfile.readInt());
            dinfile.close();
            System.out.println("Code:"+CODE);
            System.out.println("Cost:"+COST);
            System.out.println("Number of Items:"+NUM);
            float totalcost= COST*NUM;
            System.out.println("Total Cost:"+totalcost);

        }
        catch(Exception e){}
    }
}
