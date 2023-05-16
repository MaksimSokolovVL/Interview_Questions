package com.example.sokolov.interviewquestions.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "questions")
public class Question {
    @Id
    @Column(name = "q_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question_txt", nullable = true, unique = true)
    private String text;

    @Column(name = "images", nullable = true)
    private byte[] image;

    @Column(name = "explanations", nullable = true)
    private String explanation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id", referencedColumnName = "s_id")
    private Section section;


    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Answer> answers = new ArrayList<>();


    @Override
    public String toString() {
        return "Question{" +
                "text='" + getText() + '\'' +
                '}';
    }
}
