import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Formularios } from 'src/app/models/Formularios';
import { ConsultasService } from 'src/app/utils/consultas.service';

@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent{

  formularios$:Observable<Formularios[]>

  constructor(private consultasService:ConsultasService){
    this.formularios$ = this.consultasService.getAllForms();
    this.formularios$.subscribe(res=>{
      console.log(res)
    })
  }

}
