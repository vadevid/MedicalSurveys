package my.project.medicalsurveys.controller;

import my.project.medicalsurveys.model.response.patient.PatientInfoModel;
import my.project.medicalsurveys.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;


    @GetMapping("/hello/{id}")
    public String hello(@PathVariable Long id) {
        return "hello " + id;
    }

    @GetMapping(path = "/info/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PatientInfoModel getPatientInfo(@PathVariable Long id) throws Exception {
        return patientService.getPatientInfo(id);
    }
}
