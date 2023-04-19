package com.uespeis.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Integer id;
	private String email;
	private String password;
	private String rol;
	private LocalDateTime lastAccess;
	private boolean locked;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="profile_id",referencedColumnName = "id")
	private Profile profile;

	public User(Enum<?> rol) {
		this.rol = rol.name();
	}

}
