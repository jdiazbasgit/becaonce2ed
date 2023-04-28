import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OnInit } from '@angular/core';
import { PaisesService } from '../paises.service';

@Component({
  selector: 'app-generales',
  templateUrl: './generales.component.html',
  styleUrls: ['./generales.component.css']
})
export class GeneralesComponent implements OnInit {
  paisEnRuta:string=""
  datos: any;
  nofficial: string = "";
  population: string = "";
  region: string = "";
  subregion: string = "";
  capital: string = "";
  area: string = "";
  flags: any = "";

  constructor(private rutaActiva:ActivatedRoute, private service: PaisesService){
    this.paisEnRuta = this.rutaActiva.snapshot.params['pais'];
  }

    ngOnInit(): void {
      console.log("entro en on init")

      this.paisEnRuta = this.rutaActiva.snapshot.params['pais'];
      console.log("pais:" + this.paisEnRuta)
      this.service.dameDatos("https://restcountries.com/v3.1/name/" + this.paisEnRuta)
        .then((datos: any) => {
          console.log(datos)
          this.datos = datos[0];
          //this.flags = this.datos.flags;
          this.nofficial = this.datos.nofficial;
          this.population = this.datos.population;
          this.region =  this.datos.region;
          this.subregion =  this.datos.subregion;
          this.capital =  this.datos.capital;
          this.area =  this.datos.area;
          //this. = this.obtenerMonedas();
          //this. = "+ this.obtenerSimbolo();
        })


        /*obtenerMonedas():string {
          let monedaArray: string[] = Object.keys(this.datos.currencies)
          let monedasAImprimir: string = ""
          monedaArray.forEach(moneda => {
              monedasAImprimir = (this.datos.currencies[moneda].name +" ")
          })
          return monedasAImprimir
        }
        obtenerSimbolo():string {
          let simbolo: string[] = Object.keys(this.datos.currencies)
          let simbolos: string = ""
          simbolo.forEach(simbolo => {
              simbolos = (this.datos.currencies[simbolo].symbol +" ")
          })
          return simbolos
        }*/
    }
}


//countryData.name['nativeName'][nNative].official
