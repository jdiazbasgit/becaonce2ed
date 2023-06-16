class ProfileBeans {
  name: string;
  secondName: string;
  identification!: string;
  phone: string;
  image:Array<number>
  email: string;
  identificationType: string;
  user: string;
  password:string
  


  constructor(name: string, secondName: string, identification: string, phone: string, email: string, identificationType: string, user: string,image:Array<number>,password:string) {
    this.name=name;
    this.secondName=secondName
    this.identification=identification
    this.phone=phone
    this.email=email
    this.identificationType=identificationType
    this.user=user
    this.image=image
    this.password=password

  }
}
export default ProfileBeans;