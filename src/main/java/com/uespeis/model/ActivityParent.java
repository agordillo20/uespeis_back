package com.uespeis.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "activity_parent")
@Data
public class ActivityParent {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Integer id;

    @OneToMany(mappedBy = "parent")
    private List<Activity> activities;

    @OneToMany(mappedBy = "parent")
    private List<ActivityUserQuestion> activitiesUserQuestions;

    private String name;
    private Integer totalForComplete;
}
