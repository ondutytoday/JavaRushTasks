package com.javarush.task.task27.task2712.statistic;


import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;
import java.util.stream.Collectors;

public class StatisticManager {
    private static StatisticManager instance;
    private StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();
    private Map<Date, Long> advertisementProfit = new TreeMap<>(Collections.reverseOrder());
    private Map<Date, Map<String, Integer>> cookWorkloading = new TreeMap<>(Collections.reverseOrder());

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        if (instance == null) {
            instance = new StatisticManager();
        }
        return instance;
    }

    public Map<Date, Long> getAdvertisementProfit() {
        List<EventDataRow> list = statisticStorage.storage.get(EventType.SELECTED_VIDEOS);
        for (EventDataRow e : list ) {
            advertisementProfit.merge(e.getDate(), ((VideoSelectedEventDataRow) e).getAmount(), (oldVal, newVal) -> oldVal + newVal);
        }
       /* advertisementProfit = statisticStorage.storage.get(EventType.SELECTED_VIDEOS)
                .stream()
                .collect(Collectors.groupingBy
                        (EventDataRow::getDate, Collectors.summingLong
                                (e -> ((VideoSelectedEventDataRow) e).getAmount())));*/
        return advertisementProfit;
    }

    public Map<Date, Map<String, Integer>> getCookWorkloading() {
/*        List<CookedOrderEventDataRow> list = new ArrayList<>();
        list.addAll((Collection<? extends CookedOrderEventDataRow>) statisticStorage.storage.get(EventType.COOKED_ORDER));
        cookWorkloading = cookWorkloadCasted.stream()
                .collect(Collectors.groupingBy(coedr -> removeTime(coedr.getDate()),
                        Collectors.groupingBy(
                                CookedOrderEventDataRow::getCookName,
                                Collectors.summingInt(CookedOrderEventDataRow::getTime)
                        )
                ));*/
        return cookWorkloading;
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    public void register(Cook cook) {
        cooks.add(cook);
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        private StatisticStorage() {
            for (EventType e : EventType.values()) {
                storage.put(e, new ArrayList<>());
            }
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }
    }
}
