package service;

import validation.MatchValidator;
import file.reader.writer.ReportReader;
import file.reader.writer.ReportWriter;
import java.util.ArrayList;
import java.util.List;

public class ReportCreator {
    private static final String D_TYPE = "D";
    private static final String C_TYPE = "C";
    private static final String EMPTY_SPLITTER = " ";
    private static final int QUANTITY_INDEX = 5;
    private final ReportReader reportReader;
    private final ReportWriter reportWriter;
    private final MatchValidator matchValidator;

    public ReportCreator(ReportReader reportReader, ReportWriter reportWriter, MatchValidator matchValidator) {
        this.reportReader = reportReader;
        this.reportWriter = reportWriter;
        this.matchValidator = matchValidator;
    }

    public void createReport(String fromFileName, String toFileName) {
        int result;
        int count;
        StringBuilder output = new StringBuilder();
        String[] input = reportReader.readReport(fromFileName);
        List<String> typeD = getType(input, D_TYPE);
        List<String> typeC = getType(input, C_TYPE);
        for (String lineD : typeD) {
            result = 0;
            count = 0;
            for (String lineC : typeC) {
                if (matchValidator.isMatching(lineD.split(EMPTY_SPLITTER), lineC.split(EMPTY_SPLITTER))) {
                    String[] splattedLine = lineC.split(EMPTY_SPLITTER);
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

    private List<String> getType(String[] inputLines, String firstLetter) {
        List<String> list = new ArrayList<>();
        for (String line : inputLines) {
            if (line.startsWith(firstLetter)) {
                list.add(line);
            }
        }
        return list;
    }
}
