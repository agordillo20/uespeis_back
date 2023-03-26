import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { ConsultasService } from './consultas.service';


@Injectable({
  providedIn: 'root'
})


export class AuthPersistenceService {

  constructor(private service:ConsultasService) { }

  public isAuthenticated(): Observable<boolean> {
    let jwt = sessionStorage.getItem('jwt');
    if(jwt){
      return this.service.jwtValid(jwt);
    }else{
      return new BehaviorSubject<boolean>(false);
    }
  }

  public authenticate(jwt:string){
    sessionStorage.setItem('jwt',jwt);
  }

  public logOut(){
    sessionStorage.removeItem('jwt');
  }

}
