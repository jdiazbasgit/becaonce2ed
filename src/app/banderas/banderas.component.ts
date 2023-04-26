import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-banderas',
  templateUrl: './banderas.component.html',
  styleUrls: ['./banderas.component.css']
})
export class BanderasComponent {
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
