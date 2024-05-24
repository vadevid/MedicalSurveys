package my.project.medicalsurveys.controller;

import my.project.medicalsurveys.entity.Card;
import my.project.medicalsurveys.entity.Message;
import my.project.medicalsurveys.entity.Patient;
import my.project.medicalsurveys.model.request.PatientSendMessageRequest;
import my.project.medicalsurveys.model.request.SetValueRequest;
import my.project.medicalsurveys.model.request.NewCardValueRequest;
import my.project.medicalsurveys.model.response.*;
import my.project.medicalsurveys.repository.PatientLearnRepository;
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

    @Autowired
    PatientLearnRepository patientLearnRepository;

    @Autowired
    PatientLearnService patientLearnService;

    @PostMapping(path = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public PatientInfoResponse getPatientInfo(@RequestBody Patient patient) throws Exception {
        return patientService.getPatientInfo(patient.getId());
    }

    @PostMapping(path = "/setValue", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean setValue(@RequestBody SetValueRequest setValueRequest) throws Exception {
        return patientService.setValue(setValueRequest);
    }

//    @PostMapping(path = "/checkLearn", produces = MediaType.APPLICATION_JSON_VALUE)
//    public void checkLearn(@RequestBody CheckLearnModel checkLearnModel) throws Exception {
//        patientLearnService.checkPatientLearn(checkLearnModel.getPatientId(), checkLearnModel.getLearnId());
//    }
//
//    @PostMapping(path = "/getModules")
//    public ResponseEntity<List<PatientModulesModel>> getModules(@RequestBody Patient patient) throws Exception {
//        return ResponseEntity.ok(patientService.getModules(patient.getId()));
//    }

    @PostMapping(path = "/findAllDoctor", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FindAllDoctorResponse>> findAllDoctor() throws Exception {
        return ResponseEntity.ok(doctorService.findAll());
    }

    @PostMapping(path = "/getAllCard", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PatientGetAllCardResponse>> getAllCard(@RequestBody Patient patient) throws Exception {
        return ResponseEntity.ok(cardService.findByPatientId(patient.getId()));
    }

    @PostMapping(path = "/getCard", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetCardResponse> getCardById(@RequestBody Card card) throws Exception {
        return ResponseEntity.ok(cardService.findById(card.getId()));
    }

    @PostMapping(path = "/newCardValue", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> newCardValue(@RequestBody NewCardValueRequest newCardValueRequest) throws Exception {
        return ResponseEntity.ok(cardService.newCardValue(newCardValueRequest));
    }

    @PostMapping(path = "/checkNewCard", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> checkNewCard(@RequestBody Patient patient) throws Exception {
        return ResponseEntity.ok(patientService.checkNewCard(patient.getId()));
    }

    @PostMapping(path = "/getCardAllAnswer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GetCardAllAnswerResponse>> getCardAllAnswer(@RequestBody Card card) throws Exception {
        return ResponseEntity.ok(cardService.getAllAnswer(card.getId()));
    }

    @PostMapping(path = "/sendMessage", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> sendMessage(@RequestBody PatientSendMessageRequest patientSendMessageRequest) {
        return ResponseEntity.ok(contactingADoctorService.save(patientSendMessageRequest));
    }

    @PostMapping(path = "/getAllMessage", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PatientGetAllMessageResponse>> getAllMessage(@RequestBody Patient patient) throws Exception {
        return ResponseEntity.ok(patientService.getAllMessage(patient.getId()));
    }

    @PostMapping(path = "/getMessage", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetMessageResponse> getMessage(@RequestBody Message message) throws Exception {
        return ResponseEntity.ok(patientService.getMessage(message.getId()));
    }

    @PostMapping(path = "/deleteMessage", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteMessage(@RequestBody Message message) throws Exception {
        return ResponseEntity.ok(patientService.deleteMessage(message.getId()));
    }

    @PostMapping(path = "/checkNewMessages", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> checkNewMessage(@RequestBody Patient patient) throws Exception {
        return ResponseEntity.ok(patientService.checkNewMessage(patient.getId()));
    }

}
