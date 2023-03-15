import { Component,Output,EventEmitter,Input } from '@angular/core';
import {NgForm} from '@angular/forms';
import {ConsultasService} from '../../utils/consultas.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  @Output() loggin:EventEmitter<string> = new EventEmitter();
  @Input() isloggin:boolean=false;
  constructor(private service:ConsultasService){}

  login(f:NgForm){
    if(f.valid){
      this.service.authenticateUser(f.value).subscribe(res=>{
        if(JSON.parse(JSON.stringify(res)).resultado){
          this.service.checkUserIsValid(f.value.user).subscribe((rol=>{
            let ob_rol=JSON.parse(JSON.stringify(rol)).resultado
            if(ob_rol!=null && ob_rol!="DEFAULT"){
              this.loggin.emit("OK");
            }else{
              this.loggin.emit("El usuario no tiene el rol correcto.")
            }
          }))
        }else{
          this.loggin.emit("Datos introducidos incorrectos.")
        }
      })
    }
  }

}
