package net.mdsgene.admin.ui.survey;

import java.util.Arrays;

public enum SurveyStatus {

    ALL(0, "All"),
    NEW(1, "New"),
    IN_PROGRESS(2, "In Progress"),
    SUBMITTED(3, "Submitted"),
    SENT(4, "Sent"),
    IN_ANTICIPATION(5, "In Anticipation");

    private final String name;
    private final int value;

    SurveyStatus(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }

    /**
     * @return the Enum representation for the given string.
     * @throws IllegalArgumentException if unknown string.
     */
    public static SurveyStatus fromString(int value) throws IllegalArgumentException {
        return Arrays.stream(SurveyStatus.values())
                .filter(v -> v.value == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("unknown value: " + value));
    }
}