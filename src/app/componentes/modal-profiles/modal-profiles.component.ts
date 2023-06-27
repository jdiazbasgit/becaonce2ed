import { Component, EventEmitter, Output } from '@angular/core';
import ProfileBean from '../../beans/ProfileBean';
import { ProfileService } from 'src/app/servicios/profile.service';


@Component({
  selector: 'app-modal-profiles',
  templateUrl: './modal-profiles.component.html',
  styleUrls: ['./modal-profiles.component.css']
})

export class ModalProfilesComponent {
  id: string = "";
  image: string = '';
  first_name: string = "";
  last_name: string = "";
  identification: string = "";
  credit_card: string = "";
  email: string = "";
  city: string = "";
  country: string = "";
  phone: string = "";
  address: string = "";
  postal_code: string = "";

  user_id: string = '';
  documentstype_id: string = '';
  cardtype_id: string = '';
  user: string = "";
  psw: string = "";

  users: any ='';

  message: string = "";

  imageContent: string = "";

  @Output() eventoProfile = new EventEmitter();


  constructor(private service: ProfileService) {}

  getImage(imageBytes: string | null): string {
    if (imageBytes) {
      this.image = imageBytes.toString()
      return 'data:image/jpeg;base64,' + imageBytes;
    }
    return 'assets/placeholder-image-profile.jpg';
  }

  selectImage() {
    const fileInput = document.querySelector('#file-input') as HTMLInputElement;
    if (fileInput) {
      fileInput.click();
    }
  }

  fileUpload(event: any) {
    const file = event.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onload = (e) => {
        this.imageContent = reader.result as string;
        const base64Match = this.imageContent.match(/^data:image\/[a-z]+;base64,([\s\S]+)/i);

        if (base64Match && base64Match.length > 1) {
          this.imageContent = base64Match[1];
          const imgElement = document.querySelector('#setImage') as HTMLImageElement;
          if (imgElement) {
            imgElement.src = this.getImage(this.imageContent);
          }
        }
      };
      reader.readAsDataURL(file);
      file.close;
    }
  }

  saveData() {
    if(this.identification.trim()==''){
      //this.message = 'Por favor, introduzca descripción.';
    } else {

      if (this.imageContent) {
        this.image = this.imageContent.toString();
      }

      const profile = new ProfileBean(this.id, this.image || '', this.first_name, this.last_name, this.identification, this.credit_card, this.email, this.city, this.country, this.phone, this.address, this.postal_code, this.user_id, this.documentstype_id, this.cardtype_id, this.user, this.users);

      this.service.saveOrUpdate('http://localhost:8080/once/profiles/', profile)
        .subscribe((dato: boolean) => {
          if (dato) {
            this.message = '¡El perfil ha sido guardado correctamente!';
            //this.eventoExistingProduct.emit({ salida: "OK" });
          } else {
            this.message = 'Error al guardar el perfil.';
          }
        });
      }
  }

  openModal(id: string, data: any) {
    if (data !== '') {
      this.id = id;
      this.image = data.image;
      this.identification = data.identification;
      this.first_name = data.name;
      this.last_name = data.second_name;
      this.address = data.address;
      this.postal_code = data.postal_code;
      this.credit_card = data.credit_card;
      this.email = data.email;
      this.city = data.city;
      this.country = data.country;
      this.phone = data.phone;
      this.user_id = data._links.user;
      this.documentstype_id = data._links.docomentTypes;
      this.cardtype_id = data._links.cardTypes;
      this.user = data._links.self;
      this.users = data.users;
    } else {
      this.id = '';
      this.image = '';
      this.identification = '';
      this.first_name = '';
      this.last_name = '';
      this.credit_card = '';
      this.address = '';
      this.postal_code = '';
      this.email = '';
      this.city = '';
      this.country = '';
      this.phone = '';
      this.user_id = '';
      this.documentstype_id = '';
      this.cardtype_id = '';
      this.user = '';
      this.users = '';
    }
  }

  closeModal(): void {
    this.eventoProfile.emit({ salida: "OK" });
  }
}
