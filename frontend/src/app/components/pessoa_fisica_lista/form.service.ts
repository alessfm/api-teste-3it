import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pessoas } from '../pessoa-fisica.module'

@Injectable({
  providedIn: 'root'
})
export class FormService {

  constructor(private http: HttpClient){}

  getPeople():Observable<Pessoas[]>{
    return this.http.get<Pessoas[]>('http://localhost:8080/pessoas')
  }
}
