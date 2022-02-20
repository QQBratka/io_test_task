package file.reader.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReportWriter {
    public void writeReport(String fileName, String report) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't create file!", e);
        }
    }
}
