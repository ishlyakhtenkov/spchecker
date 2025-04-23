package ru.javaprojects.spchecker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AppMain {
    public static void main(String[] args) throws IOException {
        args = new String[] {"C:/test/sps"};
        if (args.length == 0) {
            throw new AppException("Specifications directory has not been specified");
        }
        Path specDir = Paths.get(args[0]);
        if (!Files.isDirectory(specDir)) {
            throw new AppException("Specifications directory has not been found");
        }
        var aggregator = new ApplicabilityAggregator();
        aggregator.addSpecifications(specDir);
        aggregator.printReport(specDir.resolve("report.txt"));
    }
}
