class UserBean{
    id: number;
    user: string;
    password: string;
    enabled: string;
    rol: string

    constructor(id: number, user: string, password: string, enabled: string, rol:string){
        this.id=id;
        this.user=user;
        this.password= password;
        this.enabled= enabled;
        this.rol=rol;
    }
}
export default UserBean;