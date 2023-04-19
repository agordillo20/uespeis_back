package com.uespeis.model;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

public class ActivityUserRealizated {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Integer id;
    
    @JoinColumn(name="parent_id",nullable=false)
    private ActivityParent parent;

    @JoinColumn(name="user_id",nullable=false)
    private User user;


}
