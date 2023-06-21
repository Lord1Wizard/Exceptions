package org.example.lesson3.hw;
// Popov Sergey Nikolaevich 07.07.1997 353535 m
// Попов Сергей Николаевич 07.07.1997 353535 m
// Попов Артем Сергеевич 07.07.1997 353535 m
import java.io.*;
import java.nio.file.FileSystemException;

public class Hw_3 {
    public static void main(String[] args) {
        Person perNew = new Person();
        try {
            perNew = new Person(fillArray(inputStr()));
            savePerson(perNew);
        }catch (RuntimeException e){
            System.out.println(e);
        }catch (FileSystemException e){
            System.out.println(e);
        }
        System.out.println(perNew.toString());

    }
    public static String[] fillArray(String text){
        String[] arr = text.split(" ");
        if (arr.length!=6){
            throw new RuntimeException("Неверное количесиво параметров");
        }
        return arr;
    }
    public static String inputStr() {
        System.out.println("Введите фамилию, имя, отчество, дату рождения (в формате dd.mm.yyyy), номер телефона (число без разделителей) и пол(символ латиницей f или m), разделенные пробелом");
        System.out.print("ввод -> ");
        String text;
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            text = bf.readLine();
        }catch (IOException e)
        {
            throw new RuntimeException("Произошла ошибка при работе с консолью" + e);
        }
        return text;
    }
    public static void savePerson(Person person) throws FileSystemException {
        File file = new File(person.getFirstName().toLowerCase() + ".txt");
        try (FileWriter fileWriter = new FileWriter(file, true))
        {
            if (file.length() > 0)
            {
                fileWriter.write(System.getProperty( "line.separator" ));
            }
            fileWriter.write(person.toString());
        }catch (IOException e)
        {
            throw new FileSystemException("Возникла ошибка при работе с файлом "+e);
        }

    }
}
