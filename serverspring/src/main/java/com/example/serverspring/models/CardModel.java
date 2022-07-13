package com.example.serverspring.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class CardModel {
    Integer id;
    String name;
    String doctorName;
    String doctorType;
    String cardType;
}
