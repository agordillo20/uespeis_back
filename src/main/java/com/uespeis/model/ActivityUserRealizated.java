package com.uespeis.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class ActivityUserRealizated {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Integer id;
    @ManyToOne
    @JoinColumn(name="parent_id",nullable=false)
    private Activity parent;
    @ManyToOne
    @JoinColumn(name="user_id",nullable=false)
    private User user;
    private Date date;

}
