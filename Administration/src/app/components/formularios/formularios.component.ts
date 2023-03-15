import { Component } from '@angular/core';
import { ConsultasService } from '../../utils/consultas.service';
import { Formularios } from '../../models/Formularios';
import { Questions } from '../../models/Questions';

@Component({
  selector: 'app-formularios',
  templateUrl: './formularios.component.html',
  styleUrls: ['./formularios.component.css']
})
export class FormulariosComponent {

  editFormu:boolean=false;
  seeFormu:boolean=false;
  formus!:Formularios[];
  active_formu!:Formularios;
  active_questions!:Questions[];


  constructor(private service:ConsultasService){
    service.getAllForms().subscribe(forms=>{
      this.formus = JSON.parse(JSON.stringify(forms))
    });
  }

  editForm(id:number)
  {
    this.active_formu = this.formus[id];
    this.active_questions = this.active_formu.questions;
    this.editFormu=true;
  }

  seeForm(id:number)
  {
    this.active_formu = this.formus[id];
    this.active_questions = this.active_formu.questions;
    this.seeFormu=true;
  }

  deleteQuestion(id:Number|null,j:number){
    this.active_questions.splice(j,1)
    this.active_formu.questions= this.active_questions;
    if(id!=null){
      this.service.deleteQuestionFromForm(id);
    }
  }

  newQuestion(){
    this.active_questions.push({id:null,question:"",title:"",type:""})
    this.active_formu.questions = this.active_questions;
  }

  closePopUp(){
    this.editFormu=false;
  }

  updateQuestions(){
    for(let i=0;i<this.active_formu.questions.length;i++){
      this.active_formu.questions[i].title = (<HTMLInputElement>document.getElementById("title_"+i)).value;
      this.active_formu.questions[i].question = (<HTMLInputElement>document.getElementById("qt_"+i)).value;
      this.active_formu.questions[i].type = (<HTMLInputElement>document.getElementById("type_"+i)).value;
    }
    this.service.updateQuestions(this.active_formu).subscribe((res)=>{
      this.active_formu = res;
      this.active_questions = this.active_formu.questions
      console.log("actualizados",this.active_formu)
    })
  }

}
