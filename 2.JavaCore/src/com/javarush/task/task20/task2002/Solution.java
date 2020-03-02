package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("1.txt", null);
//            System.out.println(yourFile.getAbsolutePath());
//            System.out.println(yourFile.getName());
//            System.out.println(yourFile.getAbsoluteFile());
//            System.out.println(yourFile.getCanonicalFile());
//            System.out.println(yourFile.getCanonicalPath());
//            System.out.println(yourFile.getParent());
//            System.out.println(yourFile.getTotalSpace());
//            System.out.println(yourFile.toPath());

            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Vanya");
            user.setLastName("Vasilev");
            user.setBirthDate(new Date(Calendar.getInstance().getTimeInMillis()));
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(loadedObject.equals(javaRush));
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter pw = new PrintWriter(outputStream);
            pw.println(this.users.size());
            if (users.size() > 0) {
                for (User u : users) {
                    pw.println(u.getFirstName());
                    pw.println(u.getLastName());
                    pw.println(u.getBirthDate().getTime());
                    pw.println(u.isMale());
                    pw.println(u.getCountry().getDisplayName());
                }
            }
            pw.flush();
            pw.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            int usersSize = Integer.parseInt(br.readLine());
            if (usersSize > 0) {
                for (int i = 0; i < usersSize; i++) {
                    User u = new User();
                    u.setFirstName(br.readLine());
                    u.setLastName(br.readLine());
                    u.setBirthDate(new Date(Long.parseLong(br.readLine())));
                    u.setMale(Boolean.parseBoolean(br.readLine()));
                    u.setCountry(User.Country.valueOf(br.readLine().toUpperCase()));
                    users.add(i, u);
                }
            }
            br.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
