import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ElRevisorService } from './el-revisor.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'pruebasBanco'
  logado:boolean=false
  cuentaElegida:boolean=false

  constructor(private router:Router, private elRevisor:ElRevisorService){

  }

  ngOnInit(){
    console.log("router-->landing")
    this.router.navigateByUrl("landing")
    this.logado=this.elRevisor.logado
    this.cuentaElegida=this.elRevisor.cuentaElegida
  }

  ngDoCheck(){
    this.logado=this.elRevisor.logado
    this.cuentaElegida=this.elRevisor.cuentaElegida
  }

}
