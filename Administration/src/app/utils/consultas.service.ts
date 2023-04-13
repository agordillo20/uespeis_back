import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Fichero } from '../models/Ficheros';
import { Formularios } from '../models/Formularios';
import { Questions } from '../models/Questions';

@Injectable({
  providedIn: 'root'
})
export class ConsultasService {
  

  private url_base = "http://localhost:8080/"
  constructor(private http:HttpClient) { }

  authenticateUser(value: any) {
    return this.http.post<JSON>(this.url_base+"users/authenticate",value);
  }

  checkUserIsValid(user:String){
    return this.http.post<JSON>(this.url_base+"users/getRol",user);
  }

  getAllForms() {
    return this.http.post<Formularios[]>(this.url_base+"formsParent/getAll",null);
  }

  deleteQuestionFromForm(id_question: Number) {
    this.http.delete(this.url_base+"questions/delete/"+id_question).subscribe();
  }

  updateQuestions(active_formu: Formularios) {
    return this.http.post<Formularios>(this.url_base+"formsParent/update",active_formu);
  }

  jwtValid(jwt:string){
    return this.http.post<boolean>(this.url_base+"users/checkJWT",jwt);
  }

  getAllValuesToFilter(){
    return this.http.post<JSON>(this.url_base+"mixed/getFieldValue",null);
  }

  filterByUser(datos:any){
    return this.http.post<JSON>(this.url_base+"mixed/filter/byUser",JSON.stringify(datos));
  }

  filterByQuestion(datos:any){
    return this.http.post<JSON>(this.url_base+"mixed/filter/byQuestion",JSON.stringify(datos));
  }

  saveFile(file:any){
    this.http.post(this.url_base+"archives/save",file).subscribe();
  }

  getAllFiles(){
    return this.http.post<Fichero[]>(this.url_base+"archives/getAll",null);
  }

}
