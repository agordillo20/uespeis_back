
package com.uespeis.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "form_questions")
@Data
public class FormQuestion {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Integer id;
    private Integer idForm;
    private Integer idQuestion;
}
