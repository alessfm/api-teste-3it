import { Component, OnInit } from '@angular/core';
import { FormService } from './form.service';
import { Pessoas } from './pessoa-fisica.module'

@Component({
  selector: 'app-pessoa-fisica',
  templateUrl: './pessoa-fisica.component.html'
})
export class PessoaFisicaComponent implements OnInit {
  pessoas: Pessoas[]
  
  constructor(private getAllPeopleService: FormService) { }

  ngOnInit() {
    this.getAllPeopleService.getPeople().subscribe(pessoas =>{
      this.pessoas = pessoas
    })
  } 

}
