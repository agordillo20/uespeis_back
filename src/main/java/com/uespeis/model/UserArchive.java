package com.uespeis.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users_archives")
@Data
public class UserArchive {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
    private Integer idUser;
    private Integer idArchive;
    private boolean seeFull;
}
