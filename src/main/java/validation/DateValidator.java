package validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateValidator {
    private static final DateTimeFormatter DATE_FORMATTER
            = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final int FIRST_DATE_INDEX = 0;
    private static final int SECOND_DATE_INDEX = 1;

    public boolean dateValidation(String[] firstDate, String[] secondDate) {
        return firstDate.length == 1
                ?
                LocalDate.parse(firstDate[FIRST_DATE_INDEX], DATE_FORMATTER)
                .equals(LocalDate.parse(secondDate[FIRST_DATE_INDEX], DATE_FORMATTER))
                :
                LocalDate.parse(firstDate[FIRST_DATE_INDEX], DATE_FORMATTER)
                .equals(LocalDate.parse(secondDate[FIRST_DATE_INDEX], DATE_FORMATTER))
                || LocalDate.parse(firstDate[SECOND_DATE_INDEX], DATE_FORMATTER)
                .equals(LocalDate.parse(secondDate[FIRST_DATE_INDEX], DATE_FORMATTER))
                || (LocalDate.parse(firstDate[FIRST_DATE_INDEX], DATE_FORMATTER)
                .isBefore(LocalDate.parse(secondDate[FIRST_DATE_INDEX], DATE_FORMATTER))
                && LocalDate.parse(firstDate[SECOND_DATE_INDEX], DATE_FORMATTER)
                .isAfter(LocalDate.parse(secondDate[FIRST_DATE_INDEX], DATE_FORMATTER)));
    }
}
