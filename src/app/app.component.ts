import { Component } from '@angular/core';
import { PaisesService } from './paises.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title:string ;
  flag:boolean;
  fecha:Date=new Date();

  constructor(private service:PaisesService){
    this.title="estamos en un curso de angular empezando"
    this.flag=false
  }

  cambiar():void{
    this.flag=!this.flag;
    this.service.dameDatos("https://restcountries.com/v3.1/region/europe")
    .subscribe((datos:any)=>{
      datos.forEach((pais:any) => {
        console.log(pais.capital)
      });
    })
  }


}
