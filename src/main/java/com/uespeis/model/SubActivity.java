package com.uespeis.model;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class SubActivity {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Integer id;
    @ManyToOne
    @JoinColumn(name="parent",nullable=false)
    @JsonIgnore
    private Activity parent;
    @Column(columnDefinition="TEXT")
    private String text;
    @Column(columnDefinition="TEXT")
    private String clave;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="resources",nullable=true)
    private Resources resources;
    @OneToMany(mappedBy = "parent")
    private List<ActivityUserQuestion> activitiesUserQuestions;
}
