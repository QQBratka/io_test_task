package validation;

public class MatchLineValidator {
    private final DateValidator dateValidator;
    private static final String ALL_TYPES = "*";
    private static final int SERVICE_INDEX = 1;
    private static final int QUESTION_INDEX = 2;
    private static final int TYPE_INDEX = 3;
    private static final int DATE_INDEX = 4;

    public MatchLineValidator(DateValidator dateValidator) {
        this.dateValidator = dateValidator;
    }

    public boolean isValid(String[] lineD, String[] lineC) {
        return ((lineD[SERVICE_INDEX].equals(ALL_TYPES)
                || lineC[SERVICE_INDEX].startsWith(lineD[SERVICE_INDEX]))
                && (lineD[QUESTION_INDEX].equals(ALL_TYPES)
                || lineC[QUESTION_INDEX].startsWith(lineD[QUESTION_INDEX]))
                && lineD[TYPE_INDEX].equals(lineC[TYPE_INDEX])
                && dateValidator.dateValidation(lineD[DATE_INDEX].split("-"),
                lineC[DATE_INDEX].split("-")));
    }
}
