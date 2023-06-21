import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html'
  
})
export class HeaderComponent {
  logado: boolean = false;

  ngDoCheck(){
    if(sessionStorage.getItem('token') && !this.logado){
      this.logado = true;
    }
    if(!sessionStorage.getItem('token') && this.logado){
      this.logado = false;
    }
  }
}
