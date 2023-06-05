import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  logado:boolean = false

  ngDoCheck(){
    if (sessionStorage['token'] != null && this.logado == false)
    this.logado = true
    if (sessionStorage['token'] == null && this.logado == true)
    this.logado = false
  }

}
