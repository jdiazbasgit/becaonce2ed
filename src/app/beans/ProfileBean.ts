class ProfileBean{
  id: string
  name: string;
  image: string;
  identification: string;
  secondName: string;
  creditCard: string;
  email: string;
  city: string;
  country: string;
  phone: string;
  address: string;
  postalCode: string;
  user: string;
  documentType: string;
  cardType: string;

  /*users:string;
  psw: string; ,user:string, psw:string*/

  constructor(id:string, image:string, first_name:string, last_name:string, identification:string, creditCard:string, email:string, city:string, country:string, phone:string, address:string, postalCode:string, user:string, documentTypes:string, cardTypes:string){
    this.id=id;
    this.name=first_name;
    this.image=image;
    this.secondName=last_name;
    this.identification=identification;
    this.creditCard=creditCard;
    this.email=email;
    this.city=city;
    this.country=country;
    this.phone=phone;
    this.address=address;
    this.postalCode=postalCode;
    this.user=user;
    this.documentType=documentTypes;
    this.cardType=cardTypes;
    /*this.users=users;
    this.psw=psw;*/
  }
}
export default ProfileBean;
