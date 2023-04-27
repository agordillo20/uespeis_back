package com.uespeis.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class QuestionResponse {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Integer id;
    @ManyToOne
    @JoinColumn(name="question_id")
    private Question question;
    private Integer answer;
    @ManyToOne
    @JoinColumn(name="form_id",nullable=false)
    private Form form;
}
