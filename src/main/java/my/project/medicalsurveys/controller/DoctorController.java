package my.project.medicalsurveys.controller;

import my.project.medicalsurveys.entity.Patient;
import my.project.medicalsurveys.model.response.DoctorCardModel;
import my.project.medicalsurveys.model.response.PatientCardModel;
import my.project.medicalsurveys.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    CardService cardService;

    @PostMapping(path = "/getAllCard", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DoctorCardModel>> getAllCard(@RequestBody Patient patient) throws Exception {
        return ResponseEntity.ok(cardService.findByDoctorId(patient.getId()));
    }
}