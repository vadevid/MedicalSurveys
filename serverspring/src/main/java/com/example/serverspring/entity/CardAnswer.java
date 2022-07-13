package com.example.serverspring.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "card_answer")
public class CardAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    public CardAnswer(Card card, String answer) {
        this.card = card;
        this.answer = answer;
    }

    public CardAnswer() {};

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    @Column(name = "answer", nullable = false, length = 150)
    private String answer;

    @Column(name = "answer_date", nullable = false)
    private LocalDate answerDate = LocalDate.now();
}