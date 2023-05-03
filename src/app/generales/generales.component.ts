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
  paisEnRuta: string = ""
  datos: any
  datosGenerales: Array<string> = []

  constructor(private rutaActiva: ActivatedRoute, private service: PaisesService) {
    //this.paisEnRuta = this.rutaActiva.snapshot.params['pais'];
  }

  ngOnInit(): void {
    console.log("entro en on init generales")
    this.paisEnRuta = this.rutaActiva.snapshot.params['pais'];
    console.log("pais:" + this.paisEnRuta)
    this.service.dameDatos("https://restcountries.com/v3.1/name/" + this.paisEnRuta)
      .then((datos: any) => {
        console.log(datos)
        this.datos = datos[0];
        this.datosGenerales.push("Capital: " + this.datos.capital)
        this.datosGenerales.push("Dominio: " + this.datos.tld);
        this.datosGenerales.push("Monedas: "+ this.obtenerMonedas())
        this.datosGenerales.push("Simbolo: "+ this.obtenerSimbolo())
        console.log(this.datosGenerales)
      })
  }

  recarga(): void {
    this.ngOnInit()
  }

  obtenerMonedas():string {
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
  }


}
