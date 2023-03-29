import { Component,Output,EventEmitter,Input } from '@angular/core';
import {NgForm} from '@angular/forms';
import { Router } from '@angular/router';
import { AuthPersistenceService } from 'src/app/utils/auth-persistence.service';
import {ConsultasService} from '../../utils/consultas.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent{

  constructor(private service:ConsultasService,private authPersistence:AuthPersistenceService,private router:Router){
    authPersistence.isAuthenticated().subscribe(res=>{
      if(res){
        router.navigateByUrl("/home")
      }
    })
  }

  login(f:NgForm){
    if(f.valid){
      this.service.authenticateUser(f.value).subscribe(res=>{
        let response = JSON.parse(JSON.stringify(res))
        if(response.resultado){
          this.service.checkUserIsValid(f.value.user).subscribe((rol=>{
            let ob_rol=JSON.parse(JSON.stringify(rol)).resultado
            if(ob_rol!=null && ob_rol!="DEFAULT"){
              this.authPersistence.authenticate(response.jwt);
              this.router.navigateByUrl("/home")
              window.location.reload();
            }else{
              alert("El usuario no tiene el rol correcto.")
            }
          }))
        }else{
          alert("Datos introducidos incorrectos.")
        }
      })
    }else{
      alert("formulario no valido")
    }
  }

}
