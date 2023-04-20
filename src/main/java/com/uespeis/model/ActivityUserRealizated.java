package com.uespeis.model;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "activity_user_realizated")
@Data
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
