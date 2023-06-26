class ProfileBean{
  id: string
  first_name: string;
  image: string;
  identification: string;
  last_name: string;
  credit_card: string;
  email: string;
  city: string;
  country: string;
  phone: string;
  address: string;
  postal_code: string;
  users_id: string;
  documentstype_id: string;
  cardtype_id: string;

  constructor(id:string, image:string, first_name:string, last_name:string, identification:string, credit_card:string, email:string, city:string, country:string, phone:string, address:string, postal_code:string, users_id:string, documentstype_id:string, cardtype_id:string ){
    this.id=id;
    this.first_name=first_name;
    this.image=image;
    this.last_name=last_name;
    this.identification=identification;
    this.credit_card=credit_card;
    this.email=email;
    this.city=city;
    this.country=country;
    this.phone=phone;
    this.address=address;
    this.postal_code=postal_code;
    this.users_id=users_id;
    this.documentstype_id=documentstype_id;
    this.cardtype_id=cardtype_id;
  }
}
export default ProfileBean;
