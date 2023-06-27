class ProfileBean{
  id: string
  name: string;
  image: string;
  identification: string;
  second_name: string;
  credit_card: string;
  email: string;
  city: string;
  country: string;
  phone: string;
  address: string;
  postal_code: string;
  Users_id: string;
  Document_Types_Id: string;
  Card_Types_Id: string;
  users:string;
  user: string;
  /*psw: string; ,user:string, psw:string*/

  constructor(id:string, image:string, first_name:string, last_name:string, identification:string, credit_card:string, email:string, city:string, country:string, phone:string, address:string, postal_code:string, users_id:string, documentstype_id:string, cardtype_id:string, user:string, users:string){
    this.id=id;
    this.name=first_name;
    this.image=image;
    this.second_name=last_name;
    this.identification=identification;
    this.credit_card=credit_card;
    this.email=email;
    this.city=city;
    this.country=country;
    this.phone=phone;
    this.address=address;
    this.postal_code=postal_code;
    this.Users_id=users_id;
    this.Document_Types_Id=documentstype_id;
    this.Card_Types_Id=cardtype_id;
    this.user=user;
    this.users=users;
    /*this.psw=psw;*/
  }
}
export default ProfileBean;
