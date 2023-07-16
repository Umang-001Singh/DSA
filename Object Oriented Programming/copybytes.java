package Umang;
import java.io.*;

public class copybytes {
    public static void main(String[] args) {
        try {
            File infile = new File("D:/JAVA/Files/inputfile.txt");
            File outfile = new File("D:/JAVA/Files/outputfile.txt");

            FileInputStream ins = new FileInputStream(infile);
            FileOutputStream ous = new FileOutputStream(outfile);
            byte byteRead = (byte) ins.read();
            while (byteRead != -1) {
                byteRead = (byte) ins.read();
                ous.write(byteRead);
            }
            ins.close();
            ous.close();
        } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }
}
