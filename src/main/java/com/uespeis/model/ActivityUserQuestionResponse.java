package com.uespeis.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
