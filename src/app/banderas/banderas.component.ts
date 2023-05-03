// banderas.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PaisesService } from '../paises.service';

@Component({
  selector: 'app-banderas',
  templateUrl: './banderas.component.html',
  styleUrls: ['./banderas.component.css']
})
export class BanderasComponent implements OnInit {
  paisSeleccionado: string = '';
  banderaUrl: string = '';
  escudoUrl: string = '';

  constructor(private rutaActiva: ActivatedRoute, private service: PaisesService) {
    this.paisSeleccionado = this.rutaActiva.snapshot.params['pais'];
  }

  ngOnInit(): void {
    this.service.dameDatos("https://restcountries.com/v3.1/name/" + this.paisSeleccionado)
      .subscribe((datos: any) => {
        const banderaUrl = datos[0]?.flags?.svg || '';
        this.banderaUrl = banderaUrl;
      });
  }
}
