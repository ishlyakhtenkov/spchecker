package ru.javaprojects.spchecker;

import java.util.TreeSet;

public record Document(String decimalNumber, String name, TreeSet<String> applicability) {
}
