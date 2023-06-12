class ProfileBean{
  id:number
  name: string;
  photo: string;
  identification: any;
  lastname: any;
  creditcard: any;
  email: any;
  city: any;
  country: any;
  phone: any;
  address: any;
  postalcode: any;

  constructor(id:number, photo:string, name:string, lastname:string, identification:string, creditcard:string, email:string, city:string, country:string, phone:string, address:string, postalcode:string){
    this.id=id;
    this.name=name
    this.photo=photo
    this.lastname=lastname
    this.identification=identification
    this.creditcard=creditcard
    this.email=email
    this.city=city
    this.country=country
    this.phone=phone
    this.address=address
    this.postalcode=postalcode
  }
}
export default ProfileBean;
