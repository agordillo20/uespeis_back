import { Component } from '@angular/core';
import { Fichero } from 'src/app/models/Ficheros';
import { ConsultasService } from 'src/app/utils/consultas.service';

@Component({
  selector: 'app-ficheros',
  templateUrl: './ficheros.component.html',
  styleUrls: ['./ficheros.component.css']
})
export class FicherosComponent {

  ficheros:Fichero[] = []

  constructor(private service:ConsultasService){
    service.getAllFiles().subscribe(res=>this.ficheros = res);
  }

  

  uploadResources(event:any){
    console.log(event)
    let files:[] = event.target.files
    console.log(files)
    for(let file of files){
      let formdata: FormData = new FormData();
      formdata.append('archive', file);
      this.service.saveFile(formdata);
      this.ficheros.push(file);
    }
    let ficheros = (document.getElementById("fileUploader") as HTMLInputElement)
    ficheros.value = ficheros.defaultValue
    alert("Archivos guardados")
  }

}
