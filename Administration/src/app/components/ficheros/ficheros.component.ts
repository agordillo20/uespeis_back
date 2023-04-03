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

  uploadResources(event:any){
    console.log(event)
    let files = event.target.files
    console.log(files)
    for(let file of files){
      let formdata: FormData = new FormData();
      formdata.append('archive', file);
      this.service.saveFile(formdata);
    }
    let ficheros = (document.getElementById("fileUploader") as HTMLInputElement)
    ficheros.value = ficheros.defaultValue
    alert("Archivos guardados")
  }

}
