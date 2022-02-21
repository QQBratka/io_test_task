import file.reader.writer.ReportReader;
import service.ReportCreator;
import validation.DateValidator;
import validation.MatchLineValidator;
import file.reader.writer.ReportWriter;

public class Main {
    private static final String FROM_FILE = "input.csv";
    private static final String TO_FILE = "output.csv";

    public static void main(String[] args) {
        ReportCreator reportCreator
                = new ReportCreator(new ReportReader(),
                new ReportWriter(),
                new MatchLineValidator(new DateValidator()));

        reportCreator.createReport(FROM_FILE, TO_FILE);
    }
}
