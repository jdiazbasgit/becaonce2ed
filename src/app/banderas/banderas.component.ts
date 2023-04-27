import { DoCheck, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Component } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { PaisesService } from '../paises.service';


@Component({
  selector: 'app-banderas',
  templateUrl: './banderas.component.html',
  styleUrls: ['./banderas.component.css']
})
export class BanderasComponent implements OnInit {

  
  paisEnRuta: string = ""
  datos: any;
  flag: boolean = true;
  fronteras: Array<string> = []
  banderas: string = '';
  
  constructor(private rutaActiva: ActivatedRoute, private service: PaisesService) {
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
        this.fronteras = datos.borders;
        this.banderas = this.datos.flags.png;
      })
   

   
  }

}
