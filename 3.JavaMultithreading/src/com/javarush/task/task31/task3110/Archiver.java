package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) {

            Operation operation = null;
            do {
                try {
                    operation = askOperation();
                    CommandExecutor.execute(operation);
                } catch (WrongZipFileException wzfe) {
                    ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
                } catch (Exception e) {
                    ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
                }
            } while (!Operation.EXIT.equals(operation));
            /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the whole path of archive file including file name:");
            String fileOfArchiver = reader.readLine();
            ZipFileManager zipFileManager = new ZipFileManager(Paths.get(fileOfArchiver));
            System.out.println("Enter the whole path of file you want to archive including file name:");
            String fileToArchive = reader.readLine();
            zipFileManager.createZip(Paths.get(fileToArchive));
            reader.close();
            new ExitCommand().execute();*/
    }

    public static Operation askOperation() throws IOException {
        String s = "Выберите операцию:\n" +
                "0 - упаковать файлы в архив\n" +
                "1 - добавить файл в архив\n" +
                "2 - удалить файл из архива\n" +
                "3 - распаковать архив\n" +
                "4 - просмотреть содержимое архива\n" +
                "5 - выход\n";
        ConsoleHelper.writeMessage(s);
        int operation = ConsoleHelper.readInt();
        return Operation.values()[operation];
    }
}
