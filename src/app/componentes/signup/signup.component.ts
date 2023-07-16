import { Component } from '@angular/core';
import { SignupService } from 'src/app/servicios/signup.service';
import SignupBean from '../../beans/SignupBean';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})

export class SignupComponent {
  signupForm!: FormGroup;
  submittedSignup: boolean = false;

  id: string = "";
  image: string = '';
  firstname: string = "";
  lastname: string = "";
  identification: string = "";
  creditcard: string = "";
  email: string = "";
  city: string = "";
  country: string = "";
  phone: string = "";
  address: string = "";
  postalcode: string = "";

  documenttype: string = '';
  cardtype: string = '';

  /* CREAR LOGIN */
  username: string = '';
  password: string = '';
  showPassword: boolean = false;

  imageContent: string = "";

  responseAlert: string | null = null;

  constructor(private service: SignupService, private fb: FormBuilder) { }

  getImageSignup(imageBytes: string | null): string {
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

  fileUploadSignup(event: any) {
    const file = event.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onload = (e) => {
        this.imageContent = reader.result as string;
        const base64Match = this.imageContent.match(/^data:image\/[a-z]+;base64,([\s\S]+)/i);

        if (base64Match && base64Match.length > 1) {
          this.imageContent = base64Match[1];
          const imgElement = document.querySelector('#setImageProfile') as HTMLImageElement;
          if (imgElement) {
            imgElement.src = this.getImageSignup(this.imageContent);
          }
        }
      };
      reader.readAsDataURL(file);
      file.close;
    }
  }

  saveData() {
    this.submittedSignup = true;
    if (this.signupForm.invalid) {
      return;
    }

    if (this.imageContent) {
      this.image = this.imageContent.toString();
    }
    
    this.documenttype = '613';
    this.cardtype = '374';

    const formValue = this.signupForm.value;
    const signup = new SignupBean(this.id, this.image || '', formValue.firstname, formValue.lastname, formValue.identification, formValue.creditcard, formValue.email, formValue.city, formValue.country, formValue.phone, formValue.address, formValue.postalcode, this.documenttype, this.cardtype, formValue.username, formValue.password);

    this.service.patchSinHeader('http://localhost:8080/once/profiles/save', signup)
      .subscribe((dato: boolean) => {
        if (dato) {
          this.responseAlert = "correcto";
        } else {
          this.responseAlert = "incorrecto";
        }
      });

    this.signupForm.reset();
    this.submittedSignup = false;
  }

  ngOnInit() {
    this.initForm();
  }

  initForm() {
    /* Obligatorio todos los campos */
    this.signupForm = this.fb.group({
      firstname: ['', Validators.required],
      lastname: ['', Validators.required],
      identification: ['', Validators.required],
      address: ['', Validators.required],
      postalcode: ['', Validators.required],
      city: ['', Validators.required],
      country: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', Validators.required],
      creditcard: ['', Validators.required],
      username: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(16)]]
    });
  }

  passwordVisibility() {
    this.showPassword = !this.showPassword;
  }

  clearAll() {
    Object.assign(this, {
      id: '',
      image: '',
      identification: '',
      firstname: '',
      lastname: '',
      creditcard: '',
      address: '',
      postalcode: '',
      email: '',
      city: '',
      country: '',
      phone: '',
      user: '',
      documenttype: '',
      cardtype: '',
      username: '',
      password: ''
    });
  }
}
