package com.javarush.task.task27.task2712.ad;

import java.util.List;
import java.util.stream.Collectors;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager instance;
    private AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager() {
    }

    public static StatisticAdvertisementManager getInstance() {
        if (instance == null) instance = new StatisticAdvertisementManager();
        return instance;
    }

    public List<Advertisement> getActiveVideo() {
        List<Advertisement> list = storage.list()
                .stream()
                .filter(advertisement -> advertisement.getHits() > 0)
                .collect(Collectors.toList());

        return list;
    }

    public List<Advertisement> getArchivedVideo() {
        List<Advertisement> list = storage.list()
                .stream()
                .filter(advertisement -> advertisement.getHits() == 0)
                .collect(Collectors.toList());

        return list;
    }
}
