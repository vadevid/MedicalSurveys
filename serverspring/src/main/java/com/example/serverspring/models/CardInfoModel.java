package com.example.serverspring.models;

import com.example.serverspring.entity.Doctor;
import com.example.serverspring.entity.Patient;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class CardInfoModel {
    Integer id;
    String name;
    Doctor doctor;
    Patient patient;
    String cardType;
}
