package Arrays;

import java.util.Scanner;

public class Area {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        System.out.println("Enter the radius of the circle");
        double radius=in.nextDouble();
        double Area=ABCD(radius);
        System.out.println("Area:"+Area);
    }
    public static double ABCD(double rad){
        double area=0.0;
        area=3.14 * rad * rad;
        return area;
    }
}
