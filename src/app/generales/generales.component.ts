import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PaisesService } from '../paises.service';

@Component({
  selector: 'app-generales',
  templateUrl: './generales.component.html',
  styleUrls: ['./generales.component.css']
})
export class GeneralesComponent {
  paisEnRuta:string="";
  datos: any;
  monedas: Array<any> = [];

  constructor(private rutaActiva:ActivatedRoute, private service: PaisesService){
    
  }
   
    ngOnInit(): void {
      this.paisEnRuta=this.rutaActiva.snapshot.params['pais'];
      this.service.dameDatos("https://restcountries.com/v3.1/name/name/" + this.paisEnRuta)
      .suscribe((datos: any) =>{
        
        this.datos = datos[0];
        Object.keys(this.datos.currencies).forEach(moneda=>this.monedas.push(this.datos.currencies[moneda]))
      })
    }
  
}
