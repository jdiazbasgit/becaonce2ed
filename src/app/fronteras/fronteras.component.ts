// fronteras.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PaisesService } from '../paises.service';

@Component({
  selector: 'app-fronteras',
  templateUrl: './fronteras.component.html',
  styleUrls: ['./fronteras.component.css']
})
export class FronterasComponent implements OnInit {
  paisEnRuta: string = "";
  datos: any;
  flag: boolean = true;
  fronteras: Array<string> = [];
  fronterasCompletas: Array<string> = [];

  constructor(private rutaActiva: ActivatedRoute, private service: PaisesService) {
    this.paisEnRuta = this.rutaActiva.snapshot.params['pais'];
  }

  ngOnInit(): void {
    console.log("entro en on init");

    this.paisEnRuta = this.rutaActiva.snapshot.params['pais'];
    console.log("pais:" + this.paisEnRuta);
    this.service.dameDatos("https://restcountries.com/v3.1/name/" + this.paisEnRuta)
      .subscribe((datos: any) => {
        console.log(datos);
        this.datos = datos[0];
        this.fronteras = datos[0]?.borders || [];
        this.obtenerNombresFronterasCompletos();
      });
  }

  obtenerNombresFronterasCompletos(): void {
    this.fronterasCompletas = [];
    this.fronteras.forEach((frontera: string) => {
      this.service.dameDatos("https://restcountries.com/v3.1/alpha/" + frontera)
        .subscribe((datos: any) => {
          this.fronterasCompletas.push(datos[0]?.name?.common || frontera);
        });
    });
  }
}
