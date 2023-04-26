import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-generales',
  templateUrl: './generales.component.html',
  styleUrls: ['./generales.component.css']
})
export class GeneralesComponent {
  paisEnRuta:string=""

  constructor(private rutaActiva:ActivatedRoute){
    
  }
    ngDoCheck(): void {
      this.paisEnRuta=this.rutaActiva.snapshot.params['pais'];
    }
    
    ngOnInit(): void {
      this.paisEnRuta=this.rutaActiva.snapshot.params['pais'];
    }
  
}
