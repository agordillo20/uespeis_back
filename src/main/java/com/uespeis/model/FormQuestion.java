
package com.uespeis.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "form_questions")
@Data
public class FormQuestion {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
    private Integer idForm;
    private Integer idQuestion;
}
