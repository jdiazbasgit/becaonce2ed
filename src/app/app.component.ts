import { Component } from '@angular/core';
import { PaisesService } from './paises.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title:string ;
  continente:string="0";
  paises:Array<string>=[]
  paisSeleccionado:string="0"

  constructor(private service:PaisesService, private router:Router){
    this.title="estamos en un curso de angular empezando"
  }

  cambiarPais(){    
    this.router.navigate(['generales/', this.paisSeleccionado])    
  }

  cargarPaises():void{
    this.service.dameDatos("https://restcountries.com/v3.1/region/"+this.continente)
    .then((datos:any)=>{
      this.paises=[];
      datos.forEach((pais:any) => {
        this.paises.push(pais.name.common)
      });
    })
  }


}
