import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { Formularios } from 'src/app/models/Formularios';
import { ConsultasService } from 'src/app/utils/consultas.service';

@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent {
  profileForm = new FormGroup({
    genero: new FormControl(''),
    edad: new FormControl(''),
    estadoCivil: new FormControl(''),
    altura: new FormControl(''),
    peso: new FormControl(''),
    estudios: new FormControl(''),
    estadoLaboral: new FormControl(''),
  });

  questionForm = new FormGroup({
    parent:new FormControl(''),
    question_id:new FormControl(''),
    answer:new FormControl('')
  });

  active_form!:Formularios
  desactivate_form!:Formularios

  formularios$: Observable<Formularios[]>
  genero = []
  estadoCivil = []
  estudios = []
  estadoLaboral = []



  constructor(private consultasService: ConsultasService) {
    this.formularios$ = this.consultasService.getAllForms();
    this.consultasService.getAllValuesToFilter().subscribe(res => {
      let resultado = JSON.parse(JSON.stringify(res))
      this.estudios = resultado.result_st
      this.estadoCivil = resultado.result_cs
      this.estadoLaboral = resultado.result_ls
      this.genero = resultado.result_gen
    })
  }

  filtrarFormulario(formularios:Formularios[],event:Event){
    let found = false
    let select = event.target as HTMLSelectElement
    formularios.forEach(f=>{
      if(f.id==select.value as unknown as number){
        this.active_form = f;
        found=true
      }
    })
    if(!found){
      this.active_form = this.desactivate_form
    }
    
  }

  filtrarUser() {
    this.consultasService.filterByUser(this.profileForm.value).subscribe(res => {
      this.renderizeResponse(res)
    })
  }

  filtrarQuestion() {
    this.consultasService.filterByQuestion(this.questionForm.value).subscribe(res => {
      this.renderizeResponse(res)
    })
  }

  renderizeResponse(res: JSON) {
    let arrayResultado:JSON[] = JSON.parse(JSON.stringify(res)).result
    if (arrayResultado.length > 0) {
      let fields = this.getFields(JSON.stringify(arrayResultado[0]))
      this.renderizeHead(fields);
      for (let fila of arrayResultado) {
        let values = this.getValues(JSON.stringify(fila));
        this.renderizeBody(values);
      }
    }

  }

  getFields(linea: string) {
    let sp = linea.replaceAll("{","").replaceAll("}","").split(",")
    let keys:string[] = []
    for(let iter of sp){
      keys.push(iter.split(":")[0].replaceAll('"','').replaceAll("'",""))
    }
    return keys;
  }

  getValues(linea:string){
    let sp = linea.replaceAll("{","").replaceAll("}","").split(",")
    let values:string[] = []
    for(let iter of sp){
      values.push(iter.split(":")[1].replaceAll('"','').replaceAll("'",""))
    }
    return values;
  }

  renderizeHead(fields:string[]){
    let parent = document.getElementById("th");
    parent?.childNodes.forEach(ch=>{
      parent?.removeChild(ch)
    })
    let subparent = document.createElement("tr")
    for(let field of fields){
      let item:HTMLElement = document.createElement("th")
      item.innerHTML = field
      subparent.appendChild(item)
    }
    parent?.appendChild(subparent)
  }

  renderizeBody(values:string[]){
    let parent = document.getElementById("tb");
    parent?.childNodes.forEach(ch=>{
      parent?.removeChild(ch)
    })
    let subparent = document.createElement("tr")
    for(let field of values){
      let item:HTMLElement = document.createElement("td")
      item.innerHTML = field
      subparent.appendChild(item)
    }
    parent?.appendChild(subparent)
  }

}
