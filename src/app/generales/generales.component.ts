import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PaisesService } from '../paises.service';

@Component({
  selector: 'app-generales',
  templateUrl: './generales.component.html',
  styleUrls: ['./generales.component.css']
})
export class GeneralesComponent {
  paisEnRuta:string=""
  capital: boolean = true
  poblacion: string = ""
  area: string = ""
  dominio: string = ""
  moneda: boolean = true
  datos:any

  constructor(private rutaActiva:ActivatedRoute, private service: PaisesService){
    this.paisEnRuta = this.rutaActiva.snapshot.params['pais']
  }
   
    ngOnInit(): void {
      this.paisEnRuta=this.rutaActiva.snapshot.params['pais'];

      /*this.paisEnRuta = this.rutaActiva.snapshot.params['pais'];
      console.log("pais:" + this.paisEnRuta)*/
      this.service.dameDatos("https://restcountries.com/v3.1/name/" + this.paisEnRuta)

      .subscribe((datos: any) => {

        console.log(datos)
        this.datos = datos [0];
        this.capital = datos.boolean;
        this.poblacion = datos.borders;
        this.area = datos.borders;
        this.dominio = datos.borders;
        this.moneda = datos.boolean;
      })
    }
  
}
