package org.example.lesson2.hw;

import java.util.Scanner;

public class hw_2_1 {
    public static void main(String[] args) {
        System.out.println("Введите число:");
        float a = inputNum();
        System.out.println("Введенное число: "+ a );
        zad2();
        zad3();
        System.out.println("Введите строку : ");
        try {
            inputStr();
        }catch (RuntimeException e){
            System.out.println(e);
        }

    }

    public static float inputNum(){
        Scanner sc = new Scanner(System.in);
        Float num = null ;
        while (num==null){
            try {
            num = Float.parseFloat(sc.next());
            } catch (Exception e){
                System.out.println("Неверный формат! Введите число:");
            }
        }
        return num;
    }
    public static String inputStr(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (str==null) {
            throw  new RuntimeException("Строка не может быть пустой");
        }
        return str;
    }
    public static void zad2(){
        try {
            int d = 0;
            int[] intArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (IndexOutOfBoundsException e){
            System.out.println("Массив выходит за пределы своего размера!");
        }

    }
    public static void zad3(){
        try
        {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        }
        catch (ArithmeticException e)
        {
            System.out.println("Указатель не может указывать на null!");
        }
        catch (IndexOutOfBoundsException ex)
        {
            System.out.println("Массив выходит за пределы своего размера!");
        }
        catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }
    public static void printSum(Integer a, Integer b)
    {
        System.out.println(a + b);
    }
}
