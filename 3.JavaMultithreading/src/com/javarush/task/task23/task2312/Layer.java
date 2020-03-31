package com.javarush.task.task23.task2312;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Layer extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(java.awt.Color.GREEN); //Задаем цвет элементов зеленый
        //Рисуем прямоугольник показывающий край поля справа
        g.fillRect(Room.game.getWidth() * 10, 0, 10, (Room.game.getWidth() * 10) + 10);
        //Рисуем прямоугольник показывающий край поля снизу
        g.fillRect(0, Room.game.getHeight() * 10, (Room.game.getHeight() * 10) + 10, 10);
        //Рисуем прямоугольник показывающий мышь
        g.fillRect(Room.game.getMouse().getX()*10, Room.game.getMouse().getY()*10, 10, 10);
        //Получаем секции змейки
        List<SnakeSection> getsection = Room.game.getSnake().getSections();
        for (int i = 0; i < getsection.size(); i++) {
            //Рисуем по очереди секции змейки
            g.fillRect(getsection.get(i).getX()*10, getsection.get(i).getY()*10, 10, 10);
        }
    }
}
