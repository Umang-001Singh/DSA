package Umang;
import java.io.*;

public class ReadBytes {
    public static void main(String[] args){
        try {
            File infile = new File("D:/JAVA/Files/inputfile.txt");
            FileInputStream ins = new FileInputStream(infile);
            int ch=0;
            while ((ch=ins.read()) != -1) {
                System.out.print((char)ch);
            }
            ins.close();

        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
