class SignupBean{
  id: string
  name: string;
  secondName: string;
  identification: string;
  creditCard: string;
  address: string;
  postalCode: string;
  image: string;
  country: string;
  email: string;
  city: string;
  phone: string;
  cardType: string;
  documentType: string;
  
  user:string;
  password: string;

    constructor(id:string, image:string, first_name:string, last_name:string, identification:string, creditCard:string, email:string, city:string, country:string, phone:string, address:string, postalCode:string, documentTypes:string, cardTypes:string, user:string, password:string){
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
      this.password=password;
    }
  }
  export default SignupBean;