import { Component, DoCheck, EventEmitter, Output } from '@angular/core';
import ProfileBean from '../../beans/ProfileBean';
import { ProfileService } from 'src/app/servicios/profile.service';


@Component({
  selector: 'app-modal-profiles',
  templateUrl: './modal-profiles.component.html',
  styleUrls: ['./modal-profiles.component.css']
})
export class ModalProfilesComponent implements DoCheck {
  id: number = 0
  mensaje: string = ""
  fin: boolean = false

  name: string = ""
  photo: string = ""
  lastname: string = ""
  identification: string = ""
  creditcard: string = ""
  email: string = ""
  city: string = ""
  country: string = ""
  phone: string = ""
  address: string = ""
  postalcode: string = ""

  @Output() eventoAComunicar=new EventEmitter()

  constructor(private service: ProfileService) {

  }

  ngDoCheck(): void {
    if (this.id !== 0 && !this.fin) {
      console.log("id entrada:" + this.id)
      this.service.getDatos("http://localhost:8080/once/profiles/" + this.id)
        .subscribe((datos: any) => {
          this.fin = true
          this.photo = datos.image;
          this.identification = datos.identification;
          this.name = datos.name;
          this.lastname = datos.second_name;
          this.address = datos.address;
          this.postalcode = datos.postal_code;
          this.creditcard = datos.credit_card;
          this.email = datos.email;
          this.city = datos.city;
          this.country = datos.country;
          this.phone = datos.phone;
        })
    }
  }

  realizarComunicacion(){
    this.id=0;
    this.eventoAComunicar.emit({salida:"OK"})
    this.fin = false;

    this.name=""
    this.photo=""
    this.lastname=""
    this.identification=""
    this.creditcard=""
    this.email=""
    this.city=""
    this.country=""
    this.phone=""
    this.address=""
    this.postalcode=""
  }

  grabar() {
    this.fin = false;
    if (this.name.trim() !== "" || this.photo.trim() !== "" || this.lastname.trim() !== "" || this.identification.trim() !== "" || this.creditcard.trim() !== "" || this.email.trim() !== "" || this.city.trim() !== "" || this.country.trim() !== "" || this.phone.trim() !== "" || this.address.trim() !== "" || this.postalcode.trim() !== "" ) {
      this.service.saveOrUpdate("http://localhost:8080/once/profiles", new ProfileBean(this.id, this.name, this.photo, this.lastname, this.identification, this.creditcard, this.email, this.city, this.country, this.phone, this.address, this.postalcode))
      .subscribe((dato: boolean) => {
        if (dato) {
          this.mensaje = "Grabacion realizada correctamente"
        }
        else
          this.mensaje = "La grabación no se ha realizado"
      })
    }

    this.name=""
    this.photo=""
    this.lastname=""
    this.identification=""
    this.creditcard=""
    this.email=""
    this.city=""
    this.country=""
    this.phone=""
    this.address=""
    this.postalcode=""
  }

  resetFields() {
    this.fin = false;
    this.name = "";
    this.photo = "";
    this.lastname = "";
    this.identification = "";
    this.creditcard = "";
    this.email = "";
    this.city = "";
    this.country = "";
    this.phone = "";
    this.address = "";
    this.postalcode = "";
  }
}
