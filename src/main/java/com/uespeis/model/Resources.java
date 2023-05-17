package com.uespeis.model;

import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Resources {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer id;
    @Lob
    @Column(columnDefinition="mediumblob")
    private byte[] resource;
    private float width;
    private float height;
    @Column(columnDefinition="TEXT")
    private String relatedText;
}
