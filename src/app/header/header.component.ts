import { Component } from '@angular/core';
import { ElRevisorService } from '../el-revisor.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  logado:boolean
  cuentaElegida:boolean=false

  constructor(private elRevisor:ElRevisorService, private router:Router){
    this.logado=this.elRevisor.logado
    this.cuentaElegida=this.elRevisor.cuentaElegida
  }

  logarse(){
    this.elRevisor.logado=true
    this.router.navigateByUrl("cuentas")
  }
  deslogarse(){
    this.elRevisor.logado=false
    this.elRevisor.cuentaElegida=false
    this.router.navigateByUrl("landing")
  }

  ngDoCheck(){
    this.logado=this.elRevisor.logado
    this.cuentaElegida=this.elRevisor.cuentaElegida 
  } 
}