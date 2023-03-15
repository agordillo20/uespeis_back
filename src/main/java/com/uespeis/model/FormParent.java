package com.uespeis.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "form_parent")
@Data
public class FormParent {

    public FormParent(){

    }

    public FormParent(Enum<?> type){
        this.type = type.name();
    }
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String type;
    @OneToMany(mappedBy = "parent",cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    private List<Form> forms;
    
    @OneToMany(mappedBy = "formId",cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    private List<Questions> questions;

    @Override
    public String toString(){
        return "id:"+id+",type:"+type+",forms:"+forms.toString()+",questions:"+questions.toString();
    }
    
}
