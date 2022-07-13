package com.example.serverspring.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class PatientInfoModel {

    private String fio;
    private String age;
    private String sex;
    private String growth;
    private String weight;
    private String mass_index;
}
