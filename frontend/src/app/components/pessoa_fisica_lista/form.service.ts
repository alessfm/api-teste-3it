import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pessoas } from '../pessoa-fisica.module'
import { Cidades } from '../cidade.module'
import { Estados } from '../estado.module'

@Injectable({
  providedIn: 'root'
})
export class FormService {

  constructor(private http: HttpClient){}

  getPeople():Observable<Pessoas[]>{
    return this.http.get<Pessoas[]>('http://localhost:8080/pessoas')
  }

  getCities():Observable<Cidades[]>{
    return this.http.get<Cidades[]>('http://localhost:8080/municipios')
  }

  getStates():Observable<Estados[]>{
    return this.http.get<Estados[]>('http://localhost:8080/estados')
  }
}
