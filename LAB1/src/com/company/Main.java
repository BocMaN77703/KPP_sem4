package com.company;
import java.util.Scanner;
import java.lang.Math;

public class Main
{

    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter real part: ");
        int real=in.nextInt();
        System.out.println("Enter imaginary part: ");
        int imaginary=in.nextInt();
        System.out.printf("Module: %.1f\n", Math.sqrt(Math.pow(real,2)+Math.pow(imaginary,2)));
        System.out.printf("Phase: %.2f\n", Math.atan2(imaginary, real));
        //System.out.printf("Phase: %.2f\n", Math.atan2(real, imaginary));
    }
}
