package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/*
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    private List<Entry<String>> nodes = new LinkedList<>();

    public CustomTree() {
        this.root = new Entry<>("0");
        nodes.add(root);
    }

    @Override
    public boolean add(String elementName) {
        Entry<String> element = new Entry<>(elementName);
        boolean needToEdit = true;
        for (Entry<String> entry : nodes) {
            if (entry.isAvailableToAddChildren()) {
                needToEdit = false;
                if (entry.availableToAddLeftChildren == true) {
                    nodes.add(element);
                    element.parent = entry;
                    entry.leftChild = element;
                    entry.availableToAddLeftChildren = false;
                    break;
                } else {
                    nodes.add(element);
                    element.parent = entry;
                    entry.rightChild = element;
                    entry.availableToAddRightChildren = false;
                    break;
                }
            }
        }
        if (needToEdit) {
            Entry<String> nodeToEdit = nodes.get((size()-1)/2+1);
            nodeToEdit.availableToAddRightChildren = true;
            nodes.add(element);
            element.parent = nodeToEdit;
            nodeToEdit.leftChild = element;
        }
        return true;
    }

    public String getParent(String s) {
        String parentName = null;
        for (Entry<String> entry : nodes) {
            if (entry.elementName.equals(s)) {
                parentName =  entry.parent.elementName;
                break;
            }
        }
        return parentName;
    }

    public Entry<String> getNodeByName(String s) {
        Entry<String> firstNodeWithName = null;
        for (Entry<String> entry : nodes) {
            if (entry.elementName.equals(s)) {
                firstNodeWithName =  entry;
                break;
            }
        }
        return firstNodeWithName;
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof String)) throw new UnsupportedOperationException();
        Queue <Entry<String>> queueToRemove = new LinkedList<>();
        List <String> names = new LinkedList<>();
        String elementName = (String) o;
        queueToRemove.add(getNodeByName(elementName));
        while (!queueToRemove.isEmpty()) {
            Entry<String> entry = queueToRemove.poll();
            names.add(entry.elementName);
            if (entry.leftChild != null) queueToRemove.add(entry.leftChild);
            if (entry.rightChild != null) queueToRemove.add(entry.rightChild);
        }
        for (String s : names) {
            for (int i = 0; i < nodes.size(); i++) {
                Entry<String> en = nodes.get(i);
                if (s.equals(en.elementName)) {
                    nodes.remove(en);
                    break;
                }
            }
        }
        return true;
    }

    @Override
    public int size() {
        return nodes.size()-1;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren | availableToAddRightChildren;
        }

    }
}
