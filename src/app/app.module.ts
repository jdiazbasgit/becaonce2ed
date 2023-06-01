import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
<<<<<<< HEAD
import { NavComponent } from './nav/nav.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
=======
import { FooterComponent } from './footer/footer.component';
>>>>>>> feature/front/proyectos-tienda-jccb

@NgModule({
  declarations: [
    AppComponent,
<<<<<<< HEAD
    NavComponent
    AppComponent,
    HeaderComponent,
    LoginComponent
=======
    FooterComponent
>>>>>>> feature/front/proyectos-tienda-jccb
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
