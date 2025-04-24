package ru.javaprojects.spchecker;

import ru.javaprojects.spchecker.sp.SpDocument;

import java.util.*;

public class AggregatorTestData {
    public static Map<SpDocument, Document> aggregatedDocuments = Map.ofEntries(
            Map.entry(new SpDocument("АБВГ.301412.847СБ", "СБОРОЧНЫЙ ЧЕРТЕЖ"), new Document("АБВГ.301412.847СБ", "СБОРОЧНЫЙ ЧЕРТЕЖ", new TreeSet<>(Set.of("АБВГ.301412.847")))),
            Map.entry(new SpDocument("АБВГ.741128.977", "ПАНЕЛЬ"), new Document("АБВГ.741128.977", "ПАНЕЛЬ", new TreeSet<>(Set.of("АБВГ.301412.847")))),
            Map.entry(new SpDocument("АБВГ.711141.044", "КОЛЕСО"), new Document("АБВГ.711141.044", "КОЛЕСО", new TreeSet<>(Set.of("АБВГ.301412.847", "АБВГ.301412.849", "АБВГ.468362.046")))),
            Map.entry(new SpDocument("ЧИПС.723111.235", "ВТУЛКА"), new Document("ЧИПС.723111.235", "ВТУЛКА", new TreeSet<>(Set.of("АБВГ.301412.847", "АБВГ.468362.046")))),
            Map.entry(new SpDocument("СКИД.757471.010-01", "КОНТАКТ В-1,8 ОСТ 4.209.007-82"), new Document("СКИД.757471.010-01", "КОНТАКТ В-1,8 ОСТ 4.209.007-82", new TreeSet<>(Set.of("АБВГ.301412.847")))),
            Map.entry(new SpDocument("АБВГ.301412.849 СБ", "СБОРОЧНЫЙ ЧЕРТЕЖ"), new Document("АБВГ.301412.849 СБ", "СБОРОЧНЫЙ ЧЕРТЕЖ", new TreeSet<>(Set.of("АБВГ.301412.849")))),
            Map.entry(new SpDocument("ХБ6.367.031", "ШАРНИР"), new Document("ХБ6.367.031", "ШАРНИР", new TreeSet<>(Set.of("АБВГ.301412.849")))),
            Map.entry(new SpDocument("АБВГ.301412.824", "ПАНЕЛЬ"), new Document("АБВГ.301412.824", "ПАНЕЛЬ", new TreeSet<>(Set.of("АБВГ.301412.849")))),
            Map.entry(new SpDocument("АБВГ.687282.089", "УСТРОЙСТВО УПРАВЛЕНИЯ"), new Document("АБВГ.687282.089", "УСТРОЙСТВО УПРАВЛЕНИЯ", new TreeSet<>(Set.of("АБВГ.301412.849")))),
            Map.entry(new SpDocument("АБВГ.687283.086", "УСТРОЙСТВО КОММУТАЦИИ"), new Document("АБВГ.687283.086", "УСТРОЙСТВО КОММУТАЦИИ", new TreeSet<>(Set.of("АБВГ.301412.849")))),
            Map.entry(new SpDocument("ХБ8.637.665-01", "ОБРАМЛЕНИЕ"), new Document("ХБ8.637.665-01", "ОБРАМЛЕНИЕ", new TreeSet<>(Set.of("АБВГ.301412.849")))),
            Map.entry(new SpDocument("ФЫВА.716531.008", "СТОЙКА"), new Document("ФЫВА.716531.008", "СТОЙКА", new TreeSet<>(Set.of("АБВГ.301412.849")))),
            Map.entry(new SpDocument("АБВГ.468362.046СБ", "СБОРОЧНЫЙ ЧЕРТЕЖ"), new Document("АБВГ.468362.046СБ", "СБОРОЧНЫЙ ЧЕРТЕЖ", new TreeSet<>(Set.of("АБВГ.468362.046")))),
            Map.entry(new SpDocument("АБВГ.468362.046Э3", "СХЕМА ЭЛЕКТРИЧЕСКАЯ ПРИНЦИПИАЛЬНАЯ"), new Document("АБВГ.468362.046Э3", "СХЕМА ЭЛЕКТРИЧЕСКАЯ ПРИНЦИПИАЛЬНАЯ", new TreeSet<>(Set.of("АБВГ.468362.046")))),
            Map.entry(new SpDocument("АБВГ.468362.046ПЭ3", "ПЕРЕЧЕНЬ ЭЛЕМЕНТОВ"), new Document("АБВГ.468362.046ПЭ3", "ПЕРЕЧЕНЬ ЭЛЕМЕНТОВ", new TreeSet<>(Set.of("АБВГ.468362.046")))),
            Map.entry(new SpDocument("АБВГ.468362.046ТУ", "ТЕХНИЧЕСКИЕ УСЛОВИЯ"), new Document("АБВГ.468362.046ТУ", "ТЕХНИЧЕСКИЕ УСЛОВИЯ", new TreeSet<>(Set.of("АБВГ.468362.046")))),
            Map.entry(new SpDocument("АБВГ.468362.046РР", "РАСЧЕТ НАДЕЖНОСТИ"), new Document("АБВГ.468362.046РР", "РАСЧЕТ НАДЕЖНОСТИ", new TreeSet<>(Set.of("АБВГ.468362.046")))),
            Map.entry(new SpDocument("АБВГ.468362.046И33", "ИНСТРУКЦИЯ ПО ПРОГРАММИРОВАНИЮ МИКРОСХЕМ"), new Document("АБВГ.468362.046И33", "ИНСТРУКЦИЯ ПО ПРОГРАММИРОВАНИЮ МИКРОСХЕМ", new TreeSet<>(Set.of("АБВГ.468362.046")))),
            Map.entry(new SpDocument("АБВГ.468362.046Д4", "КОМПЛЕКТ КАРТ ДЛЯ ОЦЕНКИ ПРАВИЛЬНОСТИ ПРИМЕНЕНИЯ ЭРИ"), new Document("АБВГ.468362.046Д4", "КОМПЛЕКТ КАРТ ДЛЯ ОЦЕНКИ ПРАВИЛЬНОСТИ ПРИМЕНЕНИЯ ЭРИ", new TreeSet<>(Set.of("АБВГ.468362.046")))),
            Map.entry(new SpDocument("АБВГ.468362.046Д33", "ДАННЫЕ ПРОЕКТИРОВАНИЯ"), new Document("АБВГ.468362.046Д33", "ДАННЫЕ ПРОЕКТИРОВАНИЯ", new TreeSet<>(Set.of("АБВГ.468362.046")))),
            Map.entry(new SpDocument("АБВГ.468362.046Д42", "ДАННЫЕ ПРОГРАММИРОВАНИЯ"), new Document("АБВГ.468362.046Д42", "ДАННЫЕ ПРОГРАММИРОВАНИЯ", new TreeSet<>(Set.of("АБВГ.468362.046")))),
            Map.entry(new SpDocument("ХБ6.487.004", "КЛИН"), new Document("ХБ6.487.004", "КЛИН", new TreeSet<>(Set.of("АБВГ.468362.046")))),
            Map.entry(new SpDocument("АБВГ.301412.834", "ПАНЕЛЬ"), new Document("АБВГ.301412.834", "ПАНЕЛЬ", new TreeSet<>(Set.of("АБВГ.468362.046")))),
            Map.entry(new SpDocument("АБВГ.301412.836", "ПАНЕЛЬ"), new Document("АБВГ.301412.836", "ПАНЕЛЬ", new TreeSet<>(Set.of("АБВГ.468362.046")))),
            Map.entry(new SpDocument("АБВГ.687282.086", "УСТРОЙСТВО СОПРЯЖЕНИЯ"), new Document("АБВГ.687282.086", "УСТРОЙСТВО СОПРЯЖЕНИЯ", new TreeSet<>(Set.of("АБВГ.468362.046")))),
            Map.entry(new SpDocument("ФЫВА.301231.034", "КАРКАС"), new Document("ФЫВА.301231.034", "КАРКАС", new TreeSet<>(Set.of("АБВГ.468362.046")))),
            Map.entry(new SpDocument("ФЫВА.304551.002", "РУЧКА"), new Document("ФЫВА.304551.002", "РУЧКА", new TreeSet<>(Set.of("АБВГ.468362.046")))),
            Map.entry(new SpDocument("ЧИПС.742161.007", "УПОР"), new Document("ЧИПС.742161.007", "УПОР", new TreeSet<>(Set.of("АБВГ.468362.046")))),
            Map.entry(new SpDocument("ЧИПС.742161.008", "УПОР"), new Document("ЧИПС.742161.008", "УПОР", new TreeSet<>(Set.of("АБВГ.468362.046")))),
            Map.entry(new SpDocument("ЧИПС.742244.001", "ШАССИ"), new Document("ЧИПС.742244.001", "ШАССИ", new TreeSet<>(Set.of("АБВГ.468362.046")))),
            Map.entry(new SpDocument("ЧИПС.745322.462", "ШВЕЛЛЕР"), new Document("ЧИПС.745322.462", "ШВЕЛЛЕР", new TreeSet<>(Set.of("АБВГ.468362.046")))),
            Map.entry(new SpDocument("ЧИПС.745371.017", "ПЛАНКА"), new Document("ЧИПС.745371.017", "ПЛАНКА", new TreeSet<>(Set.of("АБВГ.468362.046")))),
            Map.entry(new SpDocument("ФЫВА.741124.758", "ПЛАНКА"), new Document("ФЫВА.741124.758", "ПЛАНКА", new TreeSet<>(Set.of("АБВГ.468362.046")))),
            Map.entry(new SpDocument("ФЫВА.741136.088", "ТЯГА"), new Document("ФЫВА.741136.088", "ТЯГА", new TreeSet<>(Set.of("АБВГ.468362.046")))),
            Map.entry(new SpDocument("ФЫВА.741231.077", "ФИКСАТОР"), new Document("ФЫВА.741231.077", "ФИКСАТОР", new TreeSet<>(Set.of("АБВГ.468362.046")))),
            Map.entry(new SpDocument("ФЫВА.741612.018", "УХО"), new Document("ФЫВА.741612.018", "УХО", new TreeSet<>(Set.of("АБВГ.468362.046")))),
            Map.entry(new SpDocument("ФЫВА.753552.014", "ПРУЖИНА"), new Document("ФЫВА.753552.014", "ПРУЖИНА", new TreeSet<>(Set.of("АБВГ.468362.046"))))
    );

    public static List<Document> documents = aggregatedDocuments.values().stream()
            .sorted(Comparator.comparing(Document::decimalNumber))
            .toList();
}
