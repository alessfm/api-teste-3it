import { Component, OnInit } from '@angular/core';
import { FormService } from './form.service';

@Component({
  selector: 'app-pessoa-fisica',
  templateUrl: './pessoa-fisica.component.html',
  styleUrls: ['./pessoa-fisica.component.css']
})
export class PessoaFisicaComponent implements OnInit {

  constructor(private getAllPeopleService: FormService) { }

  ngOnInit() {
    this.getAllPeopleService.getPeople()
  }

}
