import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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
  
  constructor(private getAllPeopleService: FormService, private router:Router) { }
  // estadoID = null

  ngOnInit(){
    this.getAllPeopleService.getPeople().subscribe(pessoas =>{
      this.pessoas = pessoas
    })
    this.getAllPeopleService.getStates().subscribe(estados =>{
      this.estados = estados
      // this.estadoID = this.estados[1]['id']
      // console.log(this.estadoID )
      this.getAllPeopleService.getCities().subscribe(cidades =>{
        this.cidades = cidades
      })
    })
  } 

  delPeople(){
    this.getAllPeopleService.removePeople(this.pessoas[0]['id']).subscribe(_ =>{
    alert('Pessoa excluída');
    window.location.reload();
    })

  // addPeople(){
  //   this.getAllPeopleService.adicionePeople(this.pessoas).subscribe(_ =>{
  //   alert('Pessoa adicionada');
  //   window.location.reload();
  //   })
  }

}
