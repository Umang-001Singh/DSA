package Umang;
import java.io.*;

public class ReadWriteBytes {
    public static void main(String[] args) {
        try {
            File infile = new File("D:/JAVA/Files/inutfile1.txt");
            DataOutputStream ous = new DataOutputStream(new FileOutputStream(infile));
            for (int i = 0; i < 20; i++) {
                ous.writeInt((int) (Math.random() * 100));
            }
            ous.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
        }
        try{
            File infile = new File("D:/JAVA/Files/inutfile1.txt");
            DataInputStream ins=new DataInputStream( new FileInputStream(infile));
            for(int j=0;j<20;j++){
                int num= ins.readInt();
                System.out.print(num+ " ");
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        catch(IOException e){}
    }
}