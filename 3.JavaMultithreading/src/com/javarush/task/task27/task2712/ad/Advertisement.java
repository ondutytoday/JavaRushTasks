package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    //файл видео
    private Object content;
    //название видео
    private String name;
    // начальная сумма, стоимость рекламы в копейках. Используем long, чтобы избежать проблем с округлением
    private long initialAmount;
    //стоимость одного просмотра рекламного ролика в копейках
    private long amountPerOneDisplaying;
    //количество оплаченных показов
    private int hits;
    //длительность в секундах
    private int duration;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        this.amountPerOneDisplaying = hits <= 0 ? 0 : (long) (initialAmount/hits);
    }

    public void revalidate() throws UnsupportedOperationException {
        if (hits <= 0) throw  new UnsupportedOperationException();
        hits--;
    }

    public String getName() {
        return name;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public int getDuration() {
        return duration;
    }

    public int getHits() {
        return hits;
    }

    @Override
    public String toString() {
        return name + " is displaying... " +
                amountPerOneDisplaying +
                ", " + (amountPerOneDisplaying*1000/duration);
    }
}
