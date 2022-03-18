package rakhcheev;

import java.util.*;

public class Attractions {

    // Создаем поля для данных об достопримечательностях:
    private final String name;              // Имя;
    private final double timeForVisit;      // Время на посещение;
    private final int importance;           // Важность;
    private final double importanceToTime;  // Отношение количества важности ко времени посещения.

    // Getters and Setters.
    public int getImportance() {
        return importance;
    }

    public double getTimeForVisit() {
        return timeForVisit;
    }

    public double getImportanceToTime() {
        return importanceToTime;
    }

    public String getName() {
        return name;
    }

    // Конструктор.
    public Attractions(String name, double timeForVisit, int importance) {
        this.name = name;
        this.timeForVisit = timeForVisit;
        this.importance = importance;
        importanceToTime = (double) importance / timeForVisit; // Вычисление количества важности ко времени посещения
    }

    // Вычисление оптимального пути
    public static List<Attractions> searchBestWay(List<Attractions> attractions, int all_time) {
        // Создаем ArrayList, в который помещаем нужные достопримечательности и переменную free_time, для оставшегося времени;
        List<Attractions> resultWay = new ArrayList<>();
        double free_time = all_time;

        // Создаем ещё один ArrayList, для отсортированного по отношению количества важности ко времени посещения, ArrayList'а;
        // и с помощью компаратора задаём логику сортировки;
        List<Attractions> sortAttractions = new ArrayList<>(attractions);
        sortAttractions.sort((attraction1, attraction2) -> {
            if (attraction1.importanceToTime < attraction2.importanceToTime) return 1;
            else if (attraction1.importanceToTime > attraction2.importanceToTime) return -1;
            else return 0;
        });

        // Проходим отсортированный лист до тех пор, пока есть свободное время и помещаем пройденные достопримечательности в итоговый лист;
        for (Attractions attraction : sortAttractions)
            if (free_time - attraction.getTimeForVisit() > 0) {
                resultWay.add(attraction);
                free_time -= attraction.getTimeForVisit();
            } else break;

//        System.out.println("Осталось времени - " + free_time);
        return resultWay;
    }

    // Установка данных из ТЗ.
    public static void setUpAttractions(List<Attractions> attractions) {

        String[] arrayData = ("Исаакиевский собор\t5\t10\n" +
                "Эрмитаж\t8\t11\n" +
                "Кунсткамера\t3,5\t4\n" +
                "Петропавловская крепость\t10\t7\n" +
                "Ленинградский зоопарк\t9\t15\n" +
                "Медный всадник\t1\t17\n" +
                "Казанский собор\t4\t3\n" +
                "Спас на Крови\t2\t9\n" +
                "Зимний дворец Петра I\t7\t12\n" +
                "Зоологический музей\t5,5\t6\n" +
                "Музей обороны и блокады Ленинграда\t2\t19\n" +
                "Русский музей\t5\t8\n" +
                "Навестить друзей\t12\t20\n" +
                "Музей восковых фигур\t2\t13\n" +
                "Литературно-мемориальный музей Ф.М. Достоевского\t4\t2\n" +
                "Екатерининский дворец\t1,5\t5\n" +
                "Петербургский музей кукол\t1\t14\n" +
                "Музей микроминиатюры «Русский Левша»\t3\t18\n" +
                "Всероссийский музей А.С. Пушкина и филиалы\t6\t1\n" +
                "Музей современного искусства Эрарта\t7\t16\n").split("\\n");


        for (String data : arrayData) {
            String[] array = data.split("\\t");
            attractions.add(new Attractions(array[0], Double.parseDouble(array[1].replace(",", ".")), Integer.parseInt(array[2])));
        }

    }

    // Для вывода в консоль
    @Override
    public String toString() {
        return name +
                "\n\tВремя на посещение: " + timeForVisit +
                "\n\tВажность: " + importance;
    }
}
