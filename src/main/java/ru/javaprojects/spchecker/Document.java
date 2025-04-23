package ru.javaprojects.spchecker;

import java.util.Set;

public record Document(String decimalNumber, String name, Set<String> applicability) {
}
