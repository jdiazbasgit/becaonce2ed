class UserBeans {
    id: number ;
	user: String;
	password:String;
    enabled: boolean;
    rol:string

	

    constructor(id:number,user: String,password:String , enabled: boolean,rol:string){
        this.id=id
        this.user=user
        this.password=password
        this.enabled=enabled
        this.rol=rol

    }
}export default UserBeans;