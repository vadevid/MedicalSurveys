package com.example.entity;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "card_answer")
public class CardAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    @Column(name = "answer")
    private String answer;
    
    @Column(name = "answer_date")
    private LocalDate answerDate = LocalDate.now();

    public CardAnswer() {
    }

    public CardAnswer(Card card, String answer) {
        this.card = card;
        this.answer = answer;
    }

    public String  getAnswer() {
        return answer;
    }

    public void setAnswer(String  answer) {
        this.answer = answer;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(LocalDate answerDate) {
        this.answerDate = answerDate;
    }
}