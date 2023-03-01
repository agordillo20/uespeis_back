package com.uespeis.model;

import java.util.List;
import jakarta.persistence.*;

import lombok.Data;

@Entity
@Table(name = "forms")
@Data
public class Form {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String type;
    private Integer idUser;
    private boolean loocked;
    @OneToMany(mappedBy = "form")
    private List<Questions> questions;

    public Form(Enum<?> type){
        this.type = type.name();
    }
}
