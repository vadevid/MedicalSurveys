package com.example.serverspring.service;

import com.example.serverspring.entity.Card;
import com.example.serverspring.entity.CardAnswer;
import com.example.serverspring.entity.ContactingADoctor;
import com.example.serverspring.models.*;
import com.example.serverspring.repository.CardAnswerRepository;
import com.example.serverspring.repository.CardRepository;
import com.example.serverspring.repository.ContactingADoctorRepository;
import com.example.serverspring.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    CardAnswerRepository cardAnswerRepository;
    @Autowired
    ContactingADoctorRepository contactingADoctorRepository;

    public List<CardModel> findAllByPatientId(Integer id) {
        List<Card> listCards = cardRepository.findAllByPatientId(id);
        List<CardModel> listCardModels = new ArrayList<>();
        for (Card card: listCards) {
            listCardModels.add(CardModel.builder().id(card.getId()).name(card.getName())
                    .doctorName(card.getDoctor().getFIO())
                    .doctorType(card.getDoctor().getType())
                    .cardType(card.getType()).build());
        }
        return listCardModels;
    }
    public List<DoctorCardModel> findAllByDoctorId(Integer id) {
        List<Card> listCards = cardRepository.findAllByDoctorId(id);
        List<DoctorCardModel> listCardModels = new ArrayList<>();
        for (Card card: listCards) {
            listCardModels.add(new DoctorCardModel(card.getId(), card.getName(),
                    card.getPatient().getFIO(), card.getType()));
        }
        return listCardModels;
    }

    public CardInfoModel getById(Integer id) {
        Card card = cardRepository.getById(id);
        CardInfoModel returnedCard = CardInfoModel.builder().id(card.getId())
                .name(card.getName())
                .doctor(card.getDoctor())
                .patient(card.getPatient())
                .cardType(card.getType()).build();
        return returnedCard;
    }

    public List<CardAnswerModel> getAllAnswer(Integer id) {
        List<CardAnswer> cardAnswers = cardAnswerRepository.findAllByCardIdOrderByAnswerDate(id);
        List<CardAnswerModel> cardAnswerModels = new ArrayList<>();
        cardAnswers.forEach((CardAnswer cardAnswer) -> cardAnswerModels.add(CardAnswerModel.builder().id(cardAnswer.getId())
                .valueName(cardAnswer.getCard().getName())
                .answer(cardAnswer.getAnswer())
                .answerDate(cardAnswer.getAnswerDate().toString())
                .minValue(cardAnswer.getCard().getMinValue())
                .maxValue(cardAnswer.getCard().getMaxValue()).build()));
        return cardAnswerModels;
    }
    public boolean newValue(NewCardAnswerModel newCardAnswerModel) {
        try {
            CardAnswer cardAnswer = new CardAnswer(cardRepository.getById(newCardAnswerModel.getCardId()), newCardAnswerModel.getValue());
            cardAnswerRepository.save(cardAnswer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean save(NewCardModel newCardModel) {
        ContactingADoctor contactingADoctor = contactingADoctorRepository.getById(newCardModel.getContactingId());
        try {
            cardRepository.save(Card.builder().name(newCardModel.getName())
                    .patient(contactingADoctor.getPatient())
                    .doctor(contactingADoctor.getDoctor())
                    .type(newCardModel.getType())
                    .minValue(newCardModel.getMin())
                    .maxValue(newCardModel.getMax()).build());
            contactingADoctorRepository.delete(contactingADoctor);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
