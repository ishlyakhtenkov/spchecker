package ru.javaprojects.spchecker;

import ru.javaprojects.spchecker.sp.SpDocument;
import ru.javaprojects.spchecker.sp.SpLine;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SpReaderTestData {

    public static final Path ABVG_301412_847_SP_PATH = Path.of("src/test/resources/sp/АБВГ.301412.847.docx");
    public static final Path ABVG_301412_849_SP_PATH = Path.of("src/test/resources/sp/АБВГ.301412.849.docx");
    public static final Path ABVG_468362_046_SP_PATH = Path.of("src/test/resources/sp/АБВГ.468362.046.docx");
    public static final Path NO_DOCUMENTS_SP_PATH = Path.of("src/test/resources/sp/no_documents_sp.docx");

    public static final String ABVG_468362_046_SP_NAME = "ЕДИНЫЙ КОМПЛЕКС УЧЕБНО-ТРЕНИРОВОЧНЫХ СРЕДСТВ ДЛЯ АБГ 1-234 К4566";
    public static final String ABVG_468362_046_SP_DECIMAL_NUMBER = "АБВГ.468362.046";

        public static List<SpDocument> spDocuments = List.of(
            new SpDocument("АБВГ.468362.046СБ", "ЕДИНЫЙ КОМПЛЕКС УЧЕБНО-ТРЕНИРОВОЧНЫХ СРЕДСТВ ДЛЯ АБГ 1-234 К4566 СБОРОЧНЫЙ ЧЕРТЕЖ"),
            new SpDocument("АБВГ.468362.046Э3", "ЕДИНЫЙ КОМПЛЕКС УЧЕБНО-ТРЕНИРОВОЧНЫХ СРЕДСТВ ДЛЯ АБГ 1-234 К4566 СХЕМА ЭЛЕКТРИЧЕСКАЯ ПРИНЦИПИАЛЬНАЯ"),
            new SpDocument("АБВГ.468362.046ПЭ3", "ЕДИНЫЙ КОМПЛЕКС УЧЕБНО-ТРЕНИРОВОЧНЫХ СРЕДСТВ ДЛЯ АБГ 1-234 К4566 ПЕРЕЧЕНЬ ЭЛЕМЕНТОВ"),
            new SpDocument("АБВГ.468362.046ТУ", "ЕДИНЫЙ КОМПЛЕКС УЧЕБНО-ТРЕНИРОВОЧНЫХ СРЕДСТВ ДЛЯ АБГ 1-234 К4566 ТЕХНИЧЕСКИЕ УСЛОВИЯ"),
            new SpDocument("АБВГ.468362.046РР", "ЕДИНЫЙ КОМПЛЕКС УЧЕБНО-ТРЕНИРОВОЧНЫХ СРЕДСТВ ДЛЯ АБГ 1-234 К4566 РАСЧЕТ НАДЕЖНОСТИ"),
            new SpDocument("АБВГ.468362.046И33", "ЕДИНЫЙ КОМПЛЕКС УЧЕБНО-ТРЕНИРОВОЧНЫХ СРЕДСТВ ДЛЯ АБГ 1-234 К4566 ИНСТРУКЦИЯ ПО ПРОГРАММИРОВАНИЮ МИКРОСХЕМ"),
            new SpDocument("АБВГ.468362.046Д4", "ЕДИНЫЙ КОМПЛЕКС УЧЕБНО-ТРЕНИРОВОЧНЫХ СРЕДСТВ ДЛЯ АБГ 1-234 К4566 КОМПЛЕКТ КАРТ ДЛЯ ОЦЕНКИ ПРАВИЛЬНОСТИ ПРИМЕНЕНИЯ ЭРИ"),
            new SpDocument("АБВГ.468362.046Д33", "ЕДИНЫЙ КОМПЛЕКС УЧЕБНО-ТРЕНИРОВОЧНЫХ СРЕДСТВ ДЛЯ АБГ 1-234 К4566 ДАННЫЕ ПРОЕКТИРОВАНИЯ"),
            new SpDocument("АБВГ.468362.046Д42", "ЕДИНЫЙ КОМПЛЕКС УЧЕБНО-ТРЕНИРОВОЧНЫХ СРЕДСТВ ДЛЯ АБГ 1-234 К4566 ДАННЫЕ ПРОГРАММИРОВАНИЯ"),
            new SpDocument("ХБ6.487.004", "КЛИН"),
            new SpDocument("АБВГ.301412.834", "ПАНЕЛЬ"),
            new SpDocument("АБВГ.301412.836", "ПАНЕЛЬ"),
            new SpDocument("АБВГ.687282.086", "УСТРОЙСТВО СОПРЯЖЕНИЯ"),
            new SpDocument("ФЫВА.301231.034", "КАРКАС"),
            new SpDocument("ФЫВА.304551.002", "РУЧКА"),
            new SpDocument("АБВГ.711141.044", "КОЛЕСО"),
            new SpDocument("ЧИПС.723111.235", "ВТУЛКА"),
            new SpDocument("ЧИПС.742161.007", "УПОР"),
            new SpDocument("ЧИПС.742161.008", "УПОР"),
            new SpDocument("ЧИПС.742244.001", "ШАССИ"),
            new SpDocument("ЧИПС.745322.462", "ШВЕЛЛЕР"),
            new SpDocument("ЧИПС.745371.017", "ПЛАНКА"),
            new SpDocument("ФЫВА.741124.758", "ПЛАНКА"),
            new SpDocument("ФЫВА.741136.088", "ТЯГА"),
            new SpDocument("ФЫВА.741231.077", "ФИКСАТОР"),
            new SpDocument("ФЫВА.741612.018", "УХО"),
            new SpDocument("ФЫВА.753552.014", "ПРУЖИНА")
    );

    public static final SpLine EMPTY_LINE = new SpLine("", "", "", "", "", "", "");

    public static List<SpLine> spLines = new ArrayList<>();

    static {
        spLines.add(EMPTY_LINE);
        spLines.add(EMPTY_LINE);
        spLines.add(new SpLine("", "", "", "", "ДОКУМЕНТАЦИЯ", "", ""));
        spLines.add(EMPTY_LINE);
        spLines.add(new SpLine("А2", "", "", "АБВГ.301412.847СБ", "СБОРОЧНЫЙ ЧЕРТЕЖ", "", "ДЭ"));
        for (int i = 0; i < 20; i++) {
            spLines.add(EMPTY_LINE);
        }
        spLines.add(new SpLine("", "", "", "", "ДЕТАЛИ", "", ""));
        spLines.add(EMPTY_LINE);
        spLines.add(new SpLine("А2", "", "1", "АБВГ.741128.977", "ПАНЕЛЬ", "1", "ДЭ"));
        spLines.add(EMPTY_LINE);
        spLines.add(new SpLine("", "", "2", "АБВГ.711141.044", "КОЛЕСО", "2", ""));
        spLines.add(EMPTY_LINE);
        spLines.add(new SpLine("", "", "4", "ЧИПС.723111.235", "ВТУЛКА", "1", ""));
        spLines.add(EMPTY_LINE);
        spLines.add(EMPTY_LINE);
        spLines.add(EMPTY_LINE);
        spLines.add(new SpLine("", "", "", "", "СТАНДАРТНЫЕ ИЗДЕЛИЯ", "", ""));
        spLines.add(EMPTY_LINE);
        spLines.add(new SpLine("", "", "3", "СКИД.757471.010-01", "КОНТАКТ", "2", ""));
        spLines.add(new SpLine("", "", "", "", "В-1,8", "", ""));
        spLines.add(new SpLine("", "", "", "", "ОСТ 4.209.007-82", "", ""));
        spLines.add(EMPTY_LINE);
    }
}
