package com.uespeis.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users_questions")
@Data
public class UserQuestions {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
    private Integer idUser;
    private Integer idQuestion;
    private Integer answer;
}
