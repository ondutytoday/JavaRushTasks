package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.*;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private static final Map<Operation, Command> allKnownCommandsMap;
    static {
        allKnownCommandsMap = new HashMap<>();
        allKnownCommandsMap.put(Operation.ADD, new ZipAddCommand());
        allKnownCommandsMap.put(Operation.CREATE, new ZipCreateCommand());
        allKnownCommandsMap.put(Operation.CONTENT, new ZipContentCommand());
        allKnownCommandsMap.put(Operation.EXTRACT, new ZipExtractCommand());
        allKnownCommandsMap.put(Operation.REMOVE, new ZipRemoveCommand());
        allKnownCommandsMap.put(Operation.EXIT, new ExitCommand());
    }
    private CommandExecutor () {}

    public static void execute (Operation operation) throws Exception{
        allKnownCommandsMap.get(operation).execute();
    }
}
