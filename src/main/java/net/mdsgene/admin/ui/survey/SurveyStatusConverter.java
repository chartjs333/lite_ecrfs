package net.mdsgene.admin.ui.survey;

import javax.persistence.AttributeConverter;
import java.util.Objects;
import java.util.stream.Stream;

public class SurveyStatusConverter implements AttributeConverter<SurveyStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(SurveyStatus attribute) {
        if (attribute == null) {
            return null;
        }

        return attribute.getValue();
    }

    @Override
    public SurveyStatus convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }

        return Stream.of(SurveyStatus.values())
                .filter(c -> Objects.equals(c.getValue(), dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}