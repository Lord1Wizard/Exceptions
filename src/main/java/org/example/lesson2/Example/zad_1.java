//Запишите в файл следующие строки:
//        Анна=4
//        Елена=5
//        Марина=6
//        Владимир=?
//        Константин=?
//        Иван=4
//        Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив (либо HashMap, если студенты с ним знакомы).
//        В отдельном методе нужно будет пройти по структуре данных, если сохранено значение ?, заменить его на соответствующее число.
//        Если на каком-то месте встречается символ, отличный от числа или ?, бросить подходящее исключение.Записать в тот же файл данные с замененными символами ?.
//
package org.example.lesson2.Example;

import java.io.*;

public class zad_1 {
    public static void main(String[] args) {
        try {
            writeFile(readFile("C:\\Users\\Wizard\\YandexDisk\\GeekBrains\\Исключения в программировании и их обработка\\Exceptions\\Exceptions\\src\\main\\java\\org\\example\\lesson2\\Example\\test.txt"),"C:\\Users\\Wizard\\YandexDisk\\GeekBrains\\Исключения в программировании и их обработка\\Exceptions\\Exceptions\\src\\main\\java\\org\\example\\lesson2\\Example\\test.txt");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String[][] readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int i = 0;
        while (reader.readLine() != null) {
            i++;
        }
        reader.close();
        reader = new BufferedReader(new FileReader(fileName));
        String[][] result = new String[i][2];
        for (int j = 0; j < i; j++) {
            String[] temp = reader.readLine().split("=");
            if (!temp[1].equals("?")){
                try {
                    int a= Integer.parseInt(temp[1]);
                }catch(Exception e){
                    e.printStackTrace();
                    System.out.println("Неверное значение "+ temp[1]);
                }
            }else {

                temp[1]=String.valueOf(temp[0].length());
            }
            result[j][0]=temp[0];
            result[j][1]=temp[1];
        }
        reader.close();
        return result;
    }

    public static void writeFile(String[][] arr,String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < arr.length; i++) {
            StringBuilder temp = new StringBuilder(arr[i][0]+"="+arr[i][1]+"\n");
            writer.write(temp.toString());
        }
        writer.close();
    }

}
