package com.uespeis.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

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
