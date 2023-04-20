package com.uespeis.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "activity")
@Data
public class Activity {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Integer id;
    @ManyToOne
    @JoinColumn(name="parent",nullable=false)
    private ActivityParent parent;
    private String text;
    @Lob
    private byte[] resource;
/*check if its necessary
    public void setResource(Blob blob){
        try {
            this.resource = blob.getBinaryStream().readAllBytes();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }*/


	
}
