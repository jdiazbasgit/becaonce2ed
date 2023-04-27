import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PaisesService } from '../paises.service';

@Component({
  selector: 'app-geograficos',
  templateUrl: './geograficos.component.html',
  styleUrls: ['./geograficos.component.css']
})

export class GeograficosComponent implements OnInit {
  paisEnRuta: string = "";
  datos: any;
  
  constructor(private rutaActiva: ActivatedRoute, private service: PaisesService) {
    this.paisEnRuta = this.rutaActiva.snapshot.params['pais'];
  }
  
  ngOnInit(): void {
    this.paisEnRuta = this.rutaActiva.snapshot.params['pais'];
    
    this.service.dameDatos("https://restcountries.com/v3.1/name/" + this.paisEnRuta)
      .subscribe((datos: any) => {
        this.datos = datos[0];
      });
  }
}
