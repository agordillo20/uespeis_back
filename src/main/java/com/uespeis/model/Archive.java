package com.uespeis.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "archives")
@Data
public class Archive {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
    private String type;
    private String resource;//change by byte[]??
    private Integer requiredScore;
	
}
