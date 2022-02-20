import file.reader.writer.ReportReader;
import service.ReportCreator;
import validation.DateValidator;
import validation.MatchValidator;
import file.reader.writer.ReportWriter;

public class RunApp {
    private static final String fromFile = "input.csv";
    private static final String toFile = "output.csv";

    public static void main(String[] args) {
        ReportCreator reportCreator
                = new ReportCreator(new ReportReader(),
                new ReportWriter(),
                new MatchValidator(new DateValidator()));

        reportCreator.createReport(fromFile, toFile);
    }
}
