package rakhcheev;

import java.util.*;

public class Main {
    // Константы из ТЗ.
    private static final int FULL_TIME = 48;
    private static final int TIME_FOR_SLEEP = 8;
    private static final int COUNT_OF_SLEEP = 2;

    public static void main(String[] args) {
        List<Attractions> attractions = new ArrayList<>(); // Создаем массив для достопримечательностей;
        Attractions.setUpAttractions(attractions); // С помощью статического метода заполняем его;

        int time = FULL_TIME - (TIME_FOR_SLEEP*COUNT_OF_SLEEP); // Вычисляем свободное время, которое можем потратить на достопримечательности;

        List<Attractions> bestWay = Attractions.searchBestWay(attractions,time); // С помощью статического метода, вычисляем оптимальный путь;

        for(Attractions attraction : bestWay) System.out.println(attraction); // Выводим оптимальный путь посещения


    }
}
