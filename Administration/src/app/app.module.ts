import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule,ReactiveFormsModule }   from '@angular/forms';
import { AppRoutingModule } from './utils/app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { HttpClientModule } from  '@angular/common/http';
import { FormulariosComponent } from './components/formularios/formularios.component';
import { FilterComponent } from './components/filter/filter.component';
import { RelationsComponent } from './components/relations/relations.component';
import { FicherosComponent } from './components/ficheros/ficheros.component';
import { SafePipeModule } from 'safe-pipe';
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    HomeComponent,
    FormulariosComponent,
    FilterComponent,
    RelationsComponent,
    FicherosComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    SafePipeModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
