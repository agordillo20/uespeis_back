package com.uespeis.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
public class Activity {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Integer id;
    @ManyToOne
    @JoinColumn(name="parent",nullable=false)
    @JsonIgnore
    private ActivityParent parent;
    @Column(columnDefinition="TEXT")
    private String text;
    @ManyToOne
    @JoinColumn(name="resources",nullable=true)
    private Resources resources;
}
