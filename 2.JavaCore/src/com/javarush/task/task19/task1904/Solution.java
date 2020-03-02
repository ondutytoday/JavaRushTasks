package com.javarush.task.task19.task1904;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner = null;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
           String string = fileScanner.nextLine();
           String date = string.substring(string.length()-10, string.length());
           date = date.trim();
           SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            Date realDate = null;
            try {
                realDate = dateFormat.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String [] params = string.split(" ");

           Date dateOfBirth = new Date ();

           return new Person(params[1], params [2], params [0], realDate );
        }

        //GregorianCalendar calendar = new GregorianCalendar(year, month, day);


        /*Традиционно пришлось порубиться с датой и форматом:
        String[] pers = fileScanner.nextLine().split(" ", 4);
        // считываем строку сканером в массив строк разделенный на 4 части пробелом,
        думаю тут понятно почему на 4 а не больше.
        SimpleDateFormat dateFormat = new SimpleDateFormat("d M y", Locale.ENGLISH);
        String d = pers[3];
        String first = pers[1];
        String middleName = pers[2];
        String lastName = pers [0];
        Date date = dateFormat.parse(d);

        */
        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
