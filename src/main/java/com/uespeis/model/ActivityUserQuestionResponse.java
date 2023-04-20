package com.uespeis.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "activity_user_question_response")
@Data
public class ActivityUserQuestionResponse {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Integer id;

    @ManyToOne
    @JoinColumn(name="activity_user_question_id",nullable=false)
    private ActivityUserQuestion activityUserQuestion;
    private String response;
    @ManyToOne
    @JoinColumn(name="user_id",nullable=false)
    private User user;
}
