package com.uespeis.model;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

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
    private byte[] resource;
    private Integer requiredScore;

    public void setResource(Blob blob){
        try {
            this.resource = blob.getBinaryStream().readAllBytes();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }


	
}
