class UserBeans {
    id: number ;
	user: String;
	password:String;
    enabled: boolean;
    rol:number

	

    constructor(id:number,user: String,password:String , enabled: boolean,rol:number){
        this.id=id
        this.user=user
        this.password=password
        this.enabled=enabled
        this.rol=rol

    }
}export default UserBeans;