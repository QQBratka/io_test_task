package validation;

public class MatchValidator {
    private final DateValidator dateValidator;
    private static final String DASH_SPLITTER = "-";
    private static final String ALL_TYPE = "*";
    private static final int SERVICE_INDEX = 1;
    private static final int QUESTION_INDEX = 2;
    private static final int TYPE_INDEX = 3;
    private static final int DATE_INDEX = 4;

    public MatchValidator(DateValidator dateValidator) {
        this.dateValidator = dateValidator;
    }

    public boolean isMatching(String[] firstLine, String[] secondLine) {
        return ((firstLine[SERVICE_INDEX].equals(ALL_TYPE)
                || secondLine[SERVICE_INDEX].contains(firstLine[SERVICE_INDEX]))
                && (firstLine[QUESTION_INDEX].equals(ALL_TYPE)
                || secondLine[QUESTION_INDEX].contains(firstLine[QUESTION_INDEX]))
                && firstLine[TYPE_INDEX].equals(secondLine[TYPE_INDEX])
                && dateValidator.dateValidation(firstLine[DATE_INDEX].split(DASH_SPLITTER),
                secondLine[DATE_INDEX].split(DASH_SPLITTER)));
    }
}
