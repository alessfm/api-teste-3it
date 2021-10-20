import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';

import { PessoaFisicaComponent } from './components/pessoa_fisica_lista/pessoa-fisica.component';
import { FormService } from './components/pessoa_fisica_lista/form.service';

@NgModule({
  declarations: [
    AppComponent,
    PessoaFisicaComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [FormService],
  bootstrap: [AppComponent]
})
export class AppModule { }
