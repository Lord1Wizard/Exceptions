package org.example.lesson1.hw;

import java.io.File;

public class hw_1_1 {
    public static void main(String[] args) {
        System.out.println(getFileSize(new File("C:\\Users\\Wizard\\YandexDisk\\GeekBrains\\Исключения в программировании и их обработка\\Exceptions\\Exceptions\\src\\main\\java\\org\\example\\lesson1\\hw\\hw_1.java")));
//        System.out.println(divide(10,0));
        int[] a = new int[]{1,2,3};
        int[] b = new int[]{1,2,0};
        divArray(a,b);
//        System.out.println(ints[10]);

    }

    public static int [] divArray(int[] x1,int[] x2) {
        if(x1.length!=x2.length){
            throw new RuntimeException("Длины массивов не равны");
        }
        int[] rez= new int[x1.length];
        for (int i = 0; i < x1.length; i++) {
            rez[i]=divide(x1[i], x2[i]);

        }
        return rez;

    }
    public static int divide(int a1, int a2){
        if (a2==0){
            throw new RuntimeException("Divide by zero not permitted");
        }
        return a1/a2;
    }
    public static long getFileSize(File file){
        if(!file.exists()){
            return -1;
        }
        return file.length();
    }
}
