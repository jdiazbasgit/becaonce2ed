class ProfileBean{
  id: string
  name: string;
  image: string;
  identification: string;
  lastname: string;
  creditcard: string;
  email: string;
  city: string;
  country: string;
  phone: string;
  address: string;
  postalcode: string;

  constructor(id:string, image:string, name:string, lastname:string, identification:string, creditcard:string, email:string, city:string, country:string, phone:string, address:string, postalcode:string){
    this.id=id;
    this.name=name;
    this.image=image;
    this.lastname=lastname;
    this.identification=identification;
    this.creditcard=creditcard;
    this.email=email;
    this.city=city;
    this.country=country;
    this.phone=phone;
    this.address=address;
    this.postalcode=postalcode;
  }
}
export default ProfileBean;
