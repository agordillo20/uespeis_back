package com.uespeis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "questions")
@Data
public class Questions {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Integer id;
    private String title;
    private String type;
    private String question;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formId")
    @JsonIgnore
    private FormParent formId;

    @Override
    public String toString(){
        return "id:"+id+",title:"+title+",type:"+type+",question:"+question+",parent:"+formId.getId();
    }


}
