import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PessoaFisicaComponent } from './components/pessoa_fisica/pessoa-fisica.component';

const routes: Routes = [
  { path: 'pessoas', component: PessoaFisicaComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
