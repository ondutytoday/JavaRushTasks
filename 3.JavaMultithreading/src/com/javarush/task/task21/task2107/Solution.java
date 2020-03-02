package com.javarush.task.task21.task2107;

import javax.jws.soap.SOAPBinding;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable{

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    @Override
    public Object clone() throws CloneNotSupportedException {
        Solution clone = new Solution();
        clone.users = new LinkedHashMap<String, User>();
        for (Map.Entry<String, User> entry : this.users.entrySet() ) {
            clone.users.put(entry.getKey(), (User) entry.getValue().clone());
        }
        return clone;
    }

    //@Override
    /*public String toString() {
        return "Solution{" +
                "users=" + users +
                '}';
    }*/

    public static class User implements Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User)) return false;

            User user = (User) o;

            if (age != user.age) return false;
            return name != null ? name.equals(user.name) : user.name == null;
        }

        @Override
        public int hashCode() {
            int result = age;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            User clone = new User(age, name);
            return clone;
        }

        /*@Override
        public String toString() {
            return "User{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }*/
    }
}
