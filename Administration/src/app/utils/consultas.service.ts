import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
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
    return this.http.post<JSON>(this.url_base+"formsParent/getAll",null);
  }

  deleteQuestionFromForm(id_question: Number) {
    this.http.delete(this.url_base+"questions/delete/"+id_question).subscribe();
  }

  updateQuestions(active_formu: Formularios) {
    return this.http.post<Formularios>(this.url_base+"formsParent/update",active_formu);
  }

}
