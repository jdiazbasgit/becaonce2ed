import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PaisesService } from '../paises.service';

@Component({
  selector: 'app-banderas',
  templateUrl: './banderas.component.html',
  styleUrls: ['./banderas.component.css']
})
export class BanderasComponent {
  paisEnRuta: string = ""
  banderas: Array<any> = []
  datos: any

  constructor(private rutaActiva: ActivatedRoute) {
    this.paisEnRuta = this.rutaActiva.snapshot.params['pais']
  }


  ngOnInit(): void {
    this.paisEnRuta = this.rutaActiva.snapshot.params['pais'];



    console.log("pais:" + this.paisEnRuta)
    this.datos.dameDatos("https://restcountries.com/v3.1/all/" + this.paisEnRuta)

      .subscribe((datos: any) => {
        console.log(datos)
        this.datos = datos[0];

        Object.keys(this.datos.currencies).forEach(moneda => this.banderas.push(this.datos.currencies[moneda]))

      });
  }

}
