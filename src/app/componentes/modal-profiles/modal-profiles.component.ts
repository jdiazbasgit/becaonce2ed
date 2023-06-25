import { Component, DoCheck, EventEmitter, Output } from '@angular/core';
import ProfileBean from '../../beans/ProfileBean';
import { ProfileService } from 'src/app/servicios/profile.service';


@Component({
  selector: 'app-modal-profiles',
  templateUrl: './modal-profiles.component.html',
  styleUrls: ['./modal-profiles.component.css']
})
export class ModalProfilesComponent {
  id: string = "";
  name: string = ""
  image: string = '';
  lastname: string = ""
  identification: string = ""
  creditcard: string = ""
  email: string = ""
  city: string = ""
  country: string = ""
  phone: string = ""
  address: string = ""
  postalcode: string = ""

  mensaje: string = ""

  imageContent: string = "";

  @Output() eventoAComunicar=new EventEmitter()

  constructor(private service: ProfileService) {}

  getImage(imageBytes: string | null): string {
    if (imageBytes) {
      this.image = imageBytes.toString()
      return 'data:image/jpeg;base64,' + imageBytes;
    }
    return 'assets/placeholder-image.jpg';
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
      
      const profile = new ProfileBean(this.id, this.image, this.name, this.lastname, this.identification, this.creditcard, this.email, this.city, this.country, this.phone, this.address, this.postalcode);//, this.subcategory || 'http://localhost:8080/once/xxxx/6');

      this.service.saveOrUpdate('http://localhost:8080/once/profiles/', profile)
        .subscribe((dato: boolean) => {
          if (dato) {
            //this.message = '¡El producto ha sido guardado correctamente!';
            //this.eventoExistingProduct.emit({ salida: "OK" });
          } else {
            //this.message = 'Error al guardar el producto.';
          }
        });
      }
  }

  openModal(id: string, data: any) {
    if (data !== '') {
      this.id = id;
      this.image = data.image;
      this.identification = data.identification;
      this.name = data.name;
      this.lastname = data.second_name;
      this.address = data.address;
      this.postalcode = data.postal_code;
      this.creditcard = data.credit_card;
      this.email = data.email;
      this.city = data.city;
      this.country = data.country;
      this.phone = data.phone;
    } else {
      this.id = '';
      this.image = '';
      this.name='';
      this.lastname='';
      this.identification='';
      this.creditcard='';
      this.email='';
      this.city='';
      this.country='';
      this.phone='';
      this.address='';
      this.postalcode='';
    }
  }
}
