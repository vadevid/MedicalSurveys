package com.example.serverspring.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class CardAnswerModel {
    Integer id;
    String valueName;
    String answer;
    String answerDate;
    Double minValue;
    Double maxValue;
}
