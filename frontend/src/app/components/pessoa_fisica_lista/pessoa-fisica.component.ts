import { Component, OnInit } from '@angular/core';
import { FormService } from './form.service';
import { Pessoas } from '../pessoa-fisica.module'
import { Cidades } from '../cidade.module'
import { Estados } from '../estado.module'

@Component({
  selector: 'app-pessoa-fisica',
  templateUrl: './pessoa-fisica.component.html'
})
export class PessoaFisicaComponent implements OnInit {
  pessoas: Pessoas[]
  cidades: Cidades[]
  estados: Estados[]
  
  constructor(private getAllPeopleService: FormService) { }

  ngOnInit() {
    this.getAllPeopleService.getPeople().subscribe(pessoas =>{
      this.pessoas = pessoas
    })
    this.getAllPeopleService.getCities().subscribe(cidades =>{
      this.cidades = cidades
      console.log(this.cidades)
    })
    this.getAllPeopleService.getStates().subscribe(estados =>{
      this.estados = estados
    })
  } 

}
