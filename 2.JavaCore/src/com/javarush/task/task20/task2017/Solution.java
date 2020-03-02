package com.javarush.task.task20.task2017;

import java.io.*;

/* 
Десериализация
*/
public class Solution implements Serializable {
    public A getOriginalObject(ObjectInputStream objectStream) {
        try {
            A a = (A) objectStream.readObject();
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ooops!");
            return null;
        }
    }

    public class A implements Serializable{
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) throws Exception{
        File file = new File ("1.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        Solution sol = new Solution();
        //A test = sol.new A();
        B test = sol.new B();
        oos.writeObject(test);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        //test = (B) sol.getOriginalObject(ois);
        A a = sol.getOriginalObject(ois);

        ois.close();


    }
}
