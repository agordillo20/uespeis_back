package com.uespeis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "forms")
@Data
public class Form {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
    private Integer idUser;
    private boolean loocked;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent")
    @JsonIgnore
    private FormParent parent;

    @Override
    public String toString(){
        return "id:"+id+",idUser:"+idUser+",locked:"+loocked+",parent:"+parent.getId();
    }
}
