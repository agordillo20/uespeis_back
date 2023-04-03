import { Component } from '@angular/core';
import { ConsultasService } from 'src/app/utils/consultas.service';

@Component({
  selector: 'app-ficheros',
  templateUrl: './ficheros.component.html',
  styleUrls: ['./ficheros.component.css']
})
export class FicherosComponent {

  constructor(private service:ConsultasService){

  }

  ficheros!:[]

  uploadResources(event:any){//solo se ha guardado uno
    let files:File[] = event.target.files
    for(let file of files){
      let formdata: FormData = new FormData();
      formdata.append('archive', file);
      this.service.saveFile(formdata);
      let ficheros = (document.getElementById("fileUploader") as HTMLInputElement)
      ficheros.value = ficheros.defaultValue
      alert("Archivos guardados")
    }
  }

}
