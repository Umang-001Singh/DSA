package Umang;
import java.io.*;

public class SequenceBuffer {
public static void main(String[] args){
    try {
        FileInputStream file1 = null;
        FileInputStream file2 = null;
        SequenceInputStream file3 = null;
        file1 = new FileInputStream("D:/JAVA/Files/inputfile.txt");
        file2 = new FileInputStream("D:/JAVA/Files/inutfile1.txt");
        file3 = new SequenceInputStream(file1, file2);
        BufferedInputStream bin = new BufferedInputStream(file3);
        BufferedOutputStream bout = new BufferedOutputStream(System.out);
        int ch = 0;
        while ((ch = bin.read()) != -1) {
            bout.write((char) ch);
        }
        bin.close();
        bout.close();
        file2.close();
        file1.close();
    }
    catch(FileNotFoundException e) {
        System.out.println("File not found");
    }
    catch(IOException e){}
}
}
