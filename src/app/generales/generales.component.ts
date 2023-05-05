import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PaisesService } from '../paises.service';
import { subscribeOn } from 'rxjs';

@Component({
  selector: 'app-generales',
  templateUrl: './generales.component.html',
  styleUrls: ['./generales.component.css']
})
export class GeneralesComponent implements OnInit{
  paisEnRuta:string=""
  datos:any;
  monedas:Array <any>=[];

  constructor(private rutaActiva:ActivatedRoute, private service: PaisesService){
    this.paisEnRuta = this.rutaActiva.snapshot.params['pais'];
    
  }
   
    ngOnInit(): void {
      this.paisEnRuta=this.rutaActiva.snapshot.params['pais'];
      this.service.dameDatos("https://restcountries.com/v3.1/name/" +this.paisEnRuta)
      .subscribe((datos: any)=>{
        this.datos = datos[0];
        Object.keys(datos.currencies).forEach(m=>this.monedas.push(this.datos.currencies[m]))
        
      }
      )
    }
  
}
