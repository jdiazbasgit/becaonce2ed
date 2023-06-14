import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { ModalProfilesComponent } from '../modal-profiles/modal-profiles.component';
import { ProfileService } from '../../servicios/profile.service';
import { Modal } from 'bootstrap';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})

export class ProfileComponent implements OnInit {
  @ViewChild(ModalProfilesComponent) modal: any

  id: number = 0
  titulo: string
  mensaje: string = ""

  elements: any[]

  @Input() eventoDelHijo: string = ""

  constructor(private service: ProfileService) {
    this.titulo = "Lista de perfiles"
    this.elements = []
  }

  ngOnInit(): void {
    this.elements = []
    this.service.getDatos("http://localhost:8080/once/profiles")
      .subscribe((datos: any) => {
        this.elements = datos._embedded.profiles
      })
  }

  ngAfterViewInit() {
    if (this.modal) {
      const modalElement = this.modal.nativeElement;
      if (modalElement) {
        const myModal = new Modal(modalElement);
        myModal.show();
      }
    }
  }

  eliminar(id: any) {
    if (confirm("¿Esta seguro de borrar el perfil?")) {
      this.service.delete("http://localhost:8080/once/profiles/"+id)
      .subscribe((dato: boolean) => {
        if (!dato) {
          this.mensaje = "Se ha borrado correctamente"
          this.ngOnInit();
        }
        else
          this.mensaje = "El registro no se ha borrado"
      })
    }
  }

  realizarComunicacion(event: any) {
    //this.eventoDelHijo=event.salida
    this.mensaje = ""
    /*if (event.salida === "OK")
      this.ngOnInit();*/
  }

  modificar(element: any) {
    this.mensaje = ""
    let ruta = element._links.self.href
    this.modal.id = parseInt(ruta.substring(ruta.lastIndexOf("/") + 1))
    // console.log(this.id )
  }

  abrirModal() {
    const modalElement = this.modal?.nativeElement;
    if (modalElement) {
      const myModal = new Modal(modalElement);
      myModal.show();
    }
  }
}


//https://plnkr.co/edit/?open=app%2Fapp.component.ts&preview
