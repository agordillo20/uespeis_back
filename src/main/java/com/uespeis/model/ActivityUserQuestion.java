package com.uespeis.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
public class ActivityUserQuestion {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Integer id;
    @Column(columnDefinition = "TEXT")
    private String answers;
    @Column(columnDefinition = "TEXT")
    private String question;
    private String type;
    private boolean uniqueResponse;
    @ManyToOne
    @JoinColumn(name="parent",nullable=false)
    @JsonIgnore
    private SubActivity parent;
    @ManyToOne
    @JoinColumn(name = "resources")
    private Resources resources;
    @Column(columnDefinition = "TEXT")
    private String title;
}