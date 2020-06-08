package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        List<Advertisement> list = new ArrayList<>();
        for (Advertisement adv : storage.list()) {
            if (adv.getHits() > 0 && adv.getDuration() <=timeSeconds) {
                list.add(adv);
            }
        }
        if (list.isEmpty()) throw new NoVideoAvailableException();
        list.sort(Comparator.comparingLong(Advertisement::getAmountPerOneDisplaying).thenComparing(Advertisement::getDuration));
        Collections.reverse(list);
        List<Advertisement> finalList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (timeSeconds >= list.get(i).getDuration()) {
                finalList.add(list.get(i));
                list.get(i).revalidate();
                timeSeconds = timeSeconds - list.get(i).getDuration();
            }
        }
        finalList.forEach(o -> ConsoleHelper.writeMessage(o.toString()));
    }

    /*//суммируем длительность всего списка
    private double calcDuration (List <Advertisement> list){
        double sumD = list.stream().mapToDouble(Advertisement::getDuration).sum();
        return sumD;
    }

    //суммируем стоимость всего списка
    private double calcPrice (List <Advertisement> list) {
        double sumP = list.stream().mapToDouble(Advertisement::getAmountPerOneDisplaying).sum();
        return sumP;
    }

    //проверяем является ли данный список лучшим решением или нет
    private void checkSet (List <Advertisement> list) {
        if (bestAdv == null) {
            if (calcDuration(list) <= timeSeconds) {
                bestAdv = list;
                bestPrice = calcPrice(list);
            }
        } else {
            if (calcDuration(list) <=timeSeconds && calcPrice(list) > bestPrice) {
                bestAdv = list;
                bestPrice = calcPrice(list);
            }
        }
    }
    //создаем все наборы перестановок значений через рекурсию
    private void makeAllSets (List <Advertisement> list) {
        if (list.size() > 0) {
            checkSet(list);
        }
        for (int i = 0; i < list.size() ; i++) {
            List<Advertisement> newList = list;
            newList.remove(i);
            makeAllSets(newList);
        }
    }

    private List<Advertisement> getBestAdv () {
        return bestAdv;
    }*/
}
