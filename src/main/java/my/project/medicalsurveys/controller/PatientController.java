package my.project.medicalsurveys.controller;

import my.project.medicalsurveys.entity.Patient;
import my.project.medicalsurveys.model.request.ContactingADoctorModel;
import my.project.medicalsurveys.model.response.DoctorModel;
import my.project.medicalsurveys.model.response.PatientCardModel;
import my.project.medicalsurveys.model.response.PatientInfoModel;
import my.project.medicalsurveys.model.response.PatientModulesModel;
import my.project.medicalsurveys.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@CrossOrigin
public class PatientController {

    @Autowired
    PatientService patientService;

    @Autowired
    CardService cardService;

    @Autowired
    ContactingADoctorService contactingADoctorService;

    @Autowired
    DoctorService doctorService;

    @PostMapping(path = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public PatientInfoModel getPatientInfo(@RequestBody Patient patient) throws Exception {
        return patientService.getPatientInfo(patient.getId());
    }
    @PostMapping(path = "/getModules")
    public ResponseEntity<List<PatientModulesModel>> getModules(@RequestBody Patient patient) throws Exception {
        return ResponseEntity.ok(patientService.getModules(patient.getId()));
    }

    @PostMapping(path = "/getAllCard", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PatientCardModel>> getAllCard(@RequestBody Patient patient) throws Exception {
        return ResponseEntity.ok(cardService.findByPatientId(patient.getId()));
    }

    @PostMapping(path = "/sendMessage", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> sendMessage(@RequestBody ContactingADoctorModel contactingADoctorModel) {
        return ResponseEntity.ok(contactingADoctorService.save(contactingADoctorModel));
    }

    @PostMapping(path = "/findAllDoctor", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DoctorModel>> findAllDoctor() throws Exception {
        return ResponseEntity.ok(doctorService.findAll());
    }
}
