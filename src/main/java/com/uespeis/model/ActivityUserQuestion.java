package com.uespeis.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "activity_user")
@Data
public class ActivityUserQuestion {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Integer id;
    private String answers;
    private String response;
    private String question;
    @ManyToOne
    @JoinColumn(name="parent_id",nullable=false)
    private ActivityParent parent;
}