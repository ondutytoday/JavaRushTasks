package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize = Integer.MAX_VALUE;
    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean containsPartOfName = true;
        boolean containsContent = true;
        boolean isMore = true;
        boolean isLess = true;
        if (partOfName != null && !file.toString().contains(partOfName)) {
            containsPartOfName = false;
        }
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        String stringContent = new String(content);
        if(partOfContent != null && !stringContent.contains(partOfContent)) {
            containsContent = false;
        }
        if (minSize > 0 && content.length <= minSize) {
            isMore = false;
        }
        if (maxSize != Integer.MAX_VALUE && content.length >= maxSize) {
            isLess = false;
        }
        if (containsContent && containsPartOfName && isLess && isMore) {
            foundFiles.add(file);
        }

        return super.visitFile(file, attrs);
    }

    public void setPartOfName(String amigo) {
        this.partOfName = amigo;
    }

    public void setPartOfContent(String programmer) {
        this.partOfContent = programmer;
    }

    public void setMinSize(int i) {
        this.minSize = i;
    }

    public void setMaxSize(int i) {
        this.maxSize = i;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
