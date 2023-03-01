package com.uespeis.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String email;
	private String password;
	private String gender;
	private String rol;
	private String civilStatus;
	private String profession;
	private String position;
	private LocalDateTime lastAccess;
	private boolean locked;
	private LocalDateTime birthdayDate;

	public User(Enum<?> gender, Enum<?> civilStatus, Enum<?> rol) {
		this.gender = gender.name();
		this.civilStatus = civilStatus.name();
		this.rol = rol.name();
	}

}
