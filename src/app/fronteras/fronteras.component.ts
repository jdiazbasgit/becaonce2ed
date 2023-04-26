
import { DoCheck, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-fronteras',
  templateUrl: './fronteras.component.html',
  styleUrls: ['./fronteras.component.css']
})
export class FronterasComponent implements DoCheck {

  //@Input() pais:string | undefined="";
  paisEnRuta:string=""

constructor(private rutaActiva:ActivatedRoute){
  
}
  ngDoCheck(): void {
    this.paisEnRuta=this.rutaActiva.snapshot.params['pais'];
  }
  
  

  

}
