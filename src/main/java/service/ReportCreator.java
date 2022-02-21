package service;

import validation.MatchLineValidator;
import file.reader.writer.ReportReader;
import file.reader.writer.ReportWriter;
import java.util.ArrayList;
import java.util.List;

public class ReportCreator {
    private static final String D_TYPE = "D";
    private static final String C_TYPE = "C";
    private static final int QUANTITY_INDEX = 5;
    private final ReportReader reportReader;
    private final ReportWriter reportWriter;
    private final MatchLineValidator matchValidator;

    public ReportCreator(ReportReader reportReader,
                         ReportWriter reportWriter,
                         MatchLineValidator matchValidator) {
        this.reportReader = reportReader;
        this.reportWriter = reportWriter;
        this.matchValidator = matchValidator;
    }

    public void createReport(String fromFileName, String toFileName) {
        StringBuilder output = new StringBuilder();
        String[] input = reportReader.readReport(fromFileName);
        List<String> typeD = getLinesByType(input, D_TYPE);
        List<String> typeC = getLinesByType(input, C_TYPE);
        for (String typeDLines : typeD) {
            int result = 0;
            int count = 0;
            for (String typeCLines : typeC) {
                if (matchValidator.isValid(typeDLines.split(" "), typeCLines.split(" "))) {
                    String[] splattedLine = typeCLines.split(" ");
                    result += Integer.parseInt(splattedLine[QUANTITY_INDEX]);
                    count++;
                }
            }
            if (result == 0) {
                output.append("-").append(System.lineSeparator());
            } else {
                output.append(result/count).append(System.lineSeparator());
            }
        }
        reportWriter.writeReport(toFileName, output.toString());
    }

    private List<String> getLinesByType(String[] inputLines, String firstLetter) {
        List<String> list = new ArrayList<>();
        for (String line : inputLines) {
            if (line.startsWith(firstLetter)) {
                list.add(line);
            }
        }
        return list;
    }
}
