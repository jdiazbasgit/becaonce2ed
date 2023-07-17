import { Component, ViewChild, OnInit } from '@angular/core';
import { ModalProfilesComponent } from '../modal-profiles/modal-profiles.component';
import { ProfileService } from '../../servicios/profile.service';
import { MatPaginator } from '@angular/material/paginator';
import { ModalLoginComponent } from '../modal-login/modal-login.component';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})

export class ProfileComponent implements OnInit {
  @ViewChild(ModalProfilesComponent, { static: false })
  modal: ModalProfilesComponent | undefined
  @ViewChild(ModalLoginComponent, { static: false })
  modalLogin: ModalLoginComponent | undefined

  title = "Lista de perfiles";
  columns: string[] = ['name', 'secondName', 'identification', 'creditCard', 'address', 'postalCode', 'country', 'email', 'city', 'phone', 'image'];
  elements: any[] = [];
  message: string = "";

  @ViewChild(MatPaginator)
  paginator!: MatPaginator

  constructor(private service: ProfileService) {}

  ngOnInit() {
    this.getData();
  }

  getData() {
    this.service.getDatos("http://localhost:8080/once/profiles")
      .subscribe({
        next: (response: any) => {
          if (response._embedded) {
            this.elements = response._embedded.profiles;
          } else {
            console.error('La propiedad _embedded no existe en el JSON.');
          }
        },
        error: (error: any) => {
          console.error('Error al obtener los datos: ', error);
        }
      })
  }

  getImage(imageBytes: string): string {
    if (imageBytes) {
      return 'data:image/jpeg;base64,' + imageBytes;
    }
    return 'assets/placeholder-image-profile.jpg';
  }

  openModal(id: string, element?: any, action?: string) {
    if (this.modal) {
      this.modal.image = '';
      this.modal.identification = '';
      this.modal.firstname = '';
      this.modal.lastname = '';
      this.modal.creditcard = '';
      this.modal.address = '';
      this.modal.postalcode = '';
      this.modal.country = '';
      this.modal.email = '';
      this.modal.city = '';
      this.modal.phone = '';
      this.modal.image = '';
      this.modal.message = '';

      if (action === 'edit') {
        if (element !== undefined && element !== null && element !== '') {
          this.modal.openModal(id, element, 'edit');
        }
      } else {
        this.modal.openModal('', '', 'add');
      }
    }
  }

  handlerRegisterClick(): void{
    this.openModal('','','add');
  }

  delProfile(id: string) {
    if (confirm("¿Esta seguro de eliminar el perfil?")) {
      this.service.delete("http://localhost:8080/once/profiles/" + id)
      .subscribe((dato: boolean) => {
        if (dato) {
          this.message = 'Perfil eliminado correctamente.';
          this.getData();
        } else {
          this.message ='Perfil no se ha eliminado';
        }
      });
    }
  }

  handleEventoProfile(event: any) {
    if (event.actualizar === "OK") {
      this.getData();
    }
  }
}
