package org.example.lesson3.hw;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private String firstName ;
    private String lastName ;
    private String patronymic ;
    private Date dateOfBirth;
    private Integer tel;
    private String sex;

    private Person(String firstName, String lastName, String patronymic, Date dateOfBirth, Integer tel, String sex){
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.dateOfBirth =  dateOfBirth;
        this.tel = tel;
        this.sex = sex;
    }
    public Person(String[] arr){
        setFirstName(arr[0]);
        setLastName(arr[1]);
        setPatronymic(arr[2]);
        setDateOfBirth(arr[3]);
        setTel(arr[4]);
        setSex(arr[5]);
    }
    public Person(){
        this.firstName = null;
        this.lastName = null;
        this.patronymic = null;
        this.dateOfBirth =  null;
        this.tel = null;
        this.sex = null;
    }

    private Boolean checkName(String name){
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isLetterOrDigit(name.charAt(i))) {
                throw new RuntimeException("Недопустимый символ");
            }
        }
        return true;
    }
    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
        return "<" + firstName + '>' +
                "<" + lastName + '>' +
                "<" + patronymic + '>' +
                "<" + format.format(dateOfBirth) + '>' +
                "<" + tel + '>' +
                "<" + sex + '>';
    }

    private void setFirstName(String firstName) {
        try {
            checkName(firstName);
            this.firstName = firstName;
        }catch (RuntimeException e){
            throw new RuntimeException(e+" в фамилии");
        }
    }

    private void setLastName(String lastName) {
        try {
            checkName(lastName);
            this.lastName = lastName;
        }catch (RuntimeException e){
            throw new RuntimeException(e+" в имени");
        }
    }

    private void setPatronymic(String patronymic) {
        try {
            checkName(patronymic);
            this.patronymic = patronymic;
        }catch (RuntimeException e){
            throw new RuntimeException(e+" в отчестве");
        }
    }

    private void setDateOfBirth(String dateOfBirth) {
        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
        try
        {
            this.dateOfBirth = format.parse(dateOfBirth);
        }catch (ParseException e)
        {
            throw new RuntimeException("Неверный формат даты рождения "+e);
        }

    }

    private void setTel(String tel) {
        try
        {
            this.tel= Integer.parseInt(tel);
        }
        catch (NumberFormatException e)
        {
            throw new NumberFormatException("Неверный формат телефона");
        }
//        this.tel = tel;
    }

    private void setSex(String sex) {
        if (!sex.toLowerCase().equals("m") && !sex.toLowerCase().equals("f"))
        {
            throw new RuntimeException("Неверно введен пол");
        }
            this.sex = sex.toLowerCase();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Integer getTel() {
        return tel;
    }

    public String getSex() {
        return sex;
    }
}
