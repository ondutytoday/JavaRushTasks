package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws Exception{
        System.out.println(new Solution(4));
        //File file = File.createTempFile("java", null);
        File file = new File("1.txt");
        ObjectOutput os = new ObjectOutputStream(new FileOutputStream(file));
        Solution sol = new Solution(5);
        os.writeObject(sol);
        os.close();
        ObjectInput is = new ObjectInputStream(new FileInputStream(file));
        Solution sol2 = (Solution) is.readObject();
        System.out.println(sol.string);
        System.out.println(sol2.string);
    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
