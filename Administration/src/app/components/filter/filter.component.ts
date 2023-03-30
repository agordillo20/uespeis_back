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
export class FilterComponent{
  profileForm = new FormGroup({
    genero: new FormControl(''),
    edad: new FormControl(''),
    estadoCivil: new FormControl(''),
    altura: new FormControl(''),
    peso: new FormControl(''),
    estudios: new FormControl(''),
    estadoLaboral: new FormControl(''),
  });
  formularios$:Observable<Formularios[]>
  genero=[]
  estadoCivil=[]
  estudios=[]
  estadoLaboral=[]
  
  

  constructor(private consultasService:ConsultasService){
    this.formularios$ = this.consultasService.getAllForms();
    this.consultasService.getAllValuesToFilter().subscribe(res=>{
      let resultado = JSON.parse(JSON.stringify(res))
      this.estudios = resultado.result_st
      this.estadoCivil = resultado.result_cs
      this.estadoLaboral = resultado.result_ls
      this.genero = resultado.result_gen
    })
    
  }

  filtrar() {
    this.consultasService.filterByUser(this.profileForm.value).subscribe(res=>{
      console.log(res)
    })
}

}
