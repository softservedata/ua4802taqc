package com.softserve.edu;

import java.util.Scanner;

public class AppCalc {

    /*
    // Spagetti Code, mixed, non testability
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a;
        double b;
        double c;
        System.out.print("a = ");
        a = scanner.nextDouble();
        System.out.print("b = ");
        b = scanner.nextDouble();
        c = a + b;
        System.out.println("c = " + c);
    }
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("a = ");
        double a = scanner.nextDouble();
        System.out.print("b = ");
        double b = scanner.nextDouble();
        //
        Calc calc = new Calc();
        System.out.println("sum = " + calc.add(a, b));
        //
        scanner.close();
    }
}
