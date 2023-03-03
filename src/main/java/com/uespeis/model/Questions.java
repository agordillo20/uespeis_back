package com.uespeis.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "archives")
@Data
public class Questions {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
    private String title;
    private String type;
    private String question;
    private String answer;
    private Integer score;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formId",nullable = false)
    private Form form;


}
