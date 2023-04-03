package com.uespeis.model;


import java.sql.Blob;

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
    @Lob
    private Blob resource;
    private Integer requiredScore;
	
}
