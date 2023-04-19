package com.uespeis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@NoArgsConstructor
public class Profile {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Integer id;
    private String gender;
	private Integer age;
    private Integer height;
    private Double weight;
    private String civilStatus;
    private String study;
    private String employmentStatus;
    private boolean sickLeave;//baja laboral
    private Integer sickLeaveTime;//tiempo de baja
	private String profession;
	private String position;
    private boolean smoker;//fuma?
    private Integer smokeYear;//desde cuando fuma
    private Integer smokeAmount;//cantidad que fuma habitualmente
    private boolean smokeEver;//ha fumado alguna vez
    private Integer smokeEverYear;//cuanto tiempo ha fumado
    private Integer smokeEverLeave;//tiempo que hace que no fuma
    private boolean physicalIllness;//enfermedad fisica?
    private String physical;//la enfermedad/enfermedades separadas por ,
    private boolean mentalIllness;//enfermedad mental?
    private String mental;//la enfermedad/enfermedades separadas por ,

    public Profile(Enum<?> gender, Enum<?> civilStatus,Enum<?> study,Enum<?> employmentStatus){
        this.gender = gender.name();
		this.civilStatus = civilStatus.name();
        this.study = study.name();
        this.employmentStatus = employmentStatus.name();
    }
}
