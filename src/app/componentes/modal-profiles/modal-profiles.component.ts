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
  name: string;
  photo: string;
  lastname: string;
  identification: string;
  creditcard: string;
  email: string;
  city: string;
  country: string;
  phone: string;
  address: string;
  postalcode: string;

  mensaje: string = ""
  fin: boolean = false
  namePlaceHolder: string =""
  photoPlaceHolder: string =""
  lastnamePlaceHolder: string=""
  identificationPlaceHolder: string=""
  creditcardPlaceHolder: string=""
  emailPlaceHolder: string=""
  cityPlaceHolder: string=""
  countryPlaceHolder: string=""
  phonePlaceHolder: string=""
  addressPlaceHolder: string=""
  postalcodePlaceHolder: string=""

  @Output() eventoAComunicar=new EventEmitter()

  constructor(private service: ProfileService) {
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
    this.postalcode =""
  }

  ngDoCheck(): void {
    if (this.id !== 0 && !this.fin) {
      console.log("id entrada:" + this.id)
      this.service.getDatos("http://localhost:8080/once/profiles/" + this.id)
        .subscribe((datos: any) => {
          this.fin = true
          //  if (this.descripcion !== datos.description)
            //this.descripcionPlaceHolder= datos.description;
            this.photoPlaceHolder = datos.image;
            this.identificationPlaceHolder = datos.identification;
            this.namePlaceHolder = datos.name;
            this.lastnamePlaceHolder = datos.second_name;
            this.addressPlaceHolder = datos.address;
            this.postalcodePlaceHolder = datos.postal_code;
            this.creditcardPlaceHolder = datos.credit_card;
            this.emailPlaceHolder = datos.email;
            this.cityPlaceHolder = datos.city;
            this.countryPlaceHolder = datos.country;
            this.phonePlaceHolder = datos.phone;

        })
    }
  }

  realizarComunicacion(){
    this.id=0;
    this.eventoAComunicar.emit({salida:"OK"})
  }

  grabar() {
    this.fin = false;
    if (this.name.trim() !== "" || this.photo.trim() !== "" || this.lastname.trim() !== "" || this.identification.trim() !== "" || this.creditcard.trim() !== "" || this.email.trim() !== "" || this.city.trim() !== "" || this.country.trim() !== "" || this.phone.trim() !== "" || this.address.trim() !== "" || this.postalcode.trim() !== "" ) {
      this.service.saveOrUpdate("http://localhost:8080/once/profiles", new ProfileBean(this.id, this.name))
      .subscribe((dato: boolean) => {
        if (dato) {
          this.mensaje = "Grabacion realizada correctamente"
          this.name = ""
        }
        else
          this.mensaje = "La grabación no se ha realizado"
      })
    }
  }
}
