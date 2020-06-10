package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.NoAvailableVideoEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private final StatisticManager manager = StatisticManager.getInstance();
    private int timeSeconds;


    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        Collections.sort(storage.list(), new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int result = Long.compare(o1.getAmountPerOneDisplaying(), o2.getAmountPerOneDisplaying());
                if (result != 0)
                    return -result;

//                long oneSecondCost1 = o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration();
//                long oneSecondCost2 = o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration();
//                    result = Long.compare(oneSecondCost1, oneSecondCost2);
//                    if (result != 0)
//                        return result;
                int duration1 = o1.getDuration();
                int duration2 = o2.getDuration();
                result = Integer.compare(duration1, duration2);
                if (result != 0)
                    return -result;
                int countVideo1 = o1.getHits();
                int countVideo2 = o2.getHits();
                return Integer.compare(countVideo1, countVideo2);
            }
        });

        int timeLeft = timeSeconds;
        ArrayList<Advertisement> optimalVideoSet = new ArrayList<>();
        long amount = 0;
        int totalDuration = 0;
        for (Advertisement advertisement : storage.list()) {
            if (timeLeft < advertisement.getDuration()) {
                continue;
            }
            if (advertisement.getHits() <= 0) {
                continue;
            }
            timeLeft -= advertisement.getDuration();
            advertisement.revalidate();
            optimalVideoSet.add(advertisement);
            amount += advertisement.getAmountPerOneDisplaying();
            totalDuration += advertisement.getDuration();
        }
        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(
                optimalVideoSet,
                amount,
                totalDuration));
        for (Advertisement advertisement : optimalVideoSet) {
            ConsoleHelper.writeMessage(advertisement.getName() + " is displaying... "
                    + advertisement.getAmountPerOneDisplaying() + ", "
                    + advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration());
        }

        if (timeLeft == timeSeconds) {
            throw new NoVideoAvailableException();
        }
    }
        /*List<Advertisement> list = new ArrayList<>();
        for (Advertisement adv : storage.list()) {
            if (adv.getHits() > 0 && adv.getDuration() <=timeSeconds) {
                list.add(adv);
            }
        }
        if (list.isEmpty()) {
            EventDataRow event = new NoAvailableVideoEventDataRow(timeSeconds);
            throw new NoVideoAvailableException();
        }
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
        EventDataRow event = new VideoSelectedEventDataRow(finalList,
                finalList.stream().mapToLong(Advertisement::getAmountPerOneDisplaying).sum(),
                finalList.stream().mapToInt(Advertisement::getDuration).sum());
        manager.register(event);
        finalList.forEach(o -> ConsoleHelper.writeMessage(o.toString()));
    }*/

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
