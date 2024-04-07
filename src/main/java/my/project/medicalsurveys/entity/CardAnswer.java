package my.project.medicalsurveys.entity;


import jakarta.persistence.*;

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

    @Column(name = "answer", nullable = false, length = 150)
    private String answer;

    @Column(name = "answer_date", nullable = false)
    private LocalDate answerDate = LocalDate.now();

    public CardAnswer() {
    }

    public CardAnswer(Integer id, Card card, String answer, LocalDate answerDate) {
        this.id = id;
        this.card = card;
        this.answer = answer;
        this.answerDate = answerDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public LocalDate getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(LocalDate answerDate) {
        this.answerDate = answerDate;
    }
}