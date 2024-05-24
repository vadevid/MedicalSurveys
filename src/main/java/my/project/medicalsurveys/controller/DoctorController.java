package my.project.medicalsurveys.controller;

import my.project.medicalsurveys.entity.Card;
import my.project.medicalsurveys.entity.ContactingADoctor;
import my.project.medicalsurveys.entity.Doctor;
import my.project.medicalsurveys.model.request.DoctorSendMessageRequest;
import my.project.medicalsurveys.model.request.SendCardRequest;
import my.project.medicalsurveys.model.response.*;
import my.project.medicalsurveys.service.CardService;
import my.project.medicalsurveys.service.ContactingADoctorService;
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

    @Autowired
    ContactingADoctorService contactingADoctorService;

    @PostMapping(path = "/getAllCard", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DoctorGetAllCardResponse>> getAllCard(@RequestBody Doctor doctor) throws Exception {
        return ResponseEntity.ok(cardService.findByDoctorId(doctor.getId()));
    }

    @PostMapping(path = "/getCard", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetCardResponse> getCardById(@RequestBody Card card) throws Exception {
        return ResponseEntity.ok(cardService.findById(card.getId()));
    }

    @PostMapping(path = "/getCardAllAnswer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GetCardAllAnswerResponse>> getCardAllAnswer(@RequestBody Card card) throws Exception {
        return ResponseEntity.ok(cardService.getAllAnswer(card.getId()));
    }

    @PostMapping(path = "/sendCard", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> sendCard(@RequestBody SendCardRequest request) throws Exception {
        return ResponseEntity.ok(cardService.sendCard(request));
    }

    @PostMapping(path = "/getAllMessage", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DoctorGetAllMessageResponse>> getAllMessage(@RequestBody Doctor doctor) throws Exception {
        return ResponseEntity.ok(contactingADoctorService.findByDoctorId(doctor.getId()));
    }

    @PostMapping(path = "/getMessage", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DoctorGetMessageResponse> getMessage(@RequestBody ContactingADoctor contactingADoctor) throws Exception {
        return ResponseEntity.ok(contactingADoctorService.getMessageById(contactingADoctor.getId()));
    }

    @PostMapping(path = "/sendMessage", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> sendMessage(@RequestBody DoctorSendMessageRequest message) throws Exception {
        return ResponseEntity.ok(contactingADoctorService.sendMessage(message));
    }

}