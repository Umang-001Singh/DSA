package Umang;
import java.io.*;

public class RandomIO {
    public static void main(String[] args) {
        try {
            RandomAccessFile file = null;
            file = new RandomAccessFile("D:/JAVA/Files/inputfile2.txt","rw");
            file.writeChar('A');
            file.writeInt(25);
            file.writeDouble(3.141);
            file.seek(0);
            System.out.println(file.readChar());
            System.out.println(file.readInt());
            System.out.println(file.readDouble());
            file.seek(2);
            System.out.println(file.readInt());
            file.seek(file.length());
            file.writeBoolean(false);
            file.seek(4);
            System.out.println(file.readBoolean());
            file.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
            catch(IOException e){}



    }
}
