class ProfileBeans {
  name: string;
  secondName: string;
  identification: string;
  phone: string;
  image:Array<number>
  email: string;
  identificationType:number;
  user: string;
  password:string
  


  constructor(name: string, secondName: string, identification: string, email: string, phone: string, image:Array<number>, identificationType: number, user: string,password:string) {
  this.name=name
  this.secondName=secondName
  this.identification=identification
  this.email=email
  this.phone=phone
  this.image=image
  this.identificationType=identificationType
  this.user=user
  this.password=password

  }
}
export default ProfileBeans;