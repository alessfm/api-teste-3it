import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

interface myData{
  obj: Object
}

@Injectable({
  providedIn: 'root'
})
export class FormService {
  records = {}

  constructor(private http: HttpClient){}

  getPeople(){
    return this.http.get<myData>('http://localhost:8080/pessoas').subscribe(data =>{
      data.obj;
      this.records = data
      console.log(this.records)
    })
  }
}
