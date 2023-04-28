import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-geograficos',
  templateUrl: './geograficos.component.html',
  styleUrls: ['./geograficos.component.css']
})
export class GeograficosComponent {
  paisEnRuta:string=""

  constructor(private rutaActiva:ActivatedRoute){
    
  }
    
    
    ngOnInit(): void {
      this.paisEnRuta=this.rutaActiva.snapshot.params['pais'];
    }
  
}
