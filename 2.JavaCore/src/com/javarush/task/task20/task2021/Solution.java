package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {

        private void writeObject (ObjectOutputStream out) throws NotSerializableException {
            throw new NotSerializableException();
        }

        private void readObject (ObjectInputStream in) throws NotSerializableException {
            throw new NotSerializableException();
        }
     }

    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream bot = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bot);
        oos.writeObject(new SubSolution());
        ByteArrayInputStream bit = new ByteArrayInputStream(bot.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bit);
        SubSolution sob = (SubSolution) ois.readObject();


    }
}
