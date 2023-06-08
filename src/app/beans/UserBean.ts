class UserBean{
    id: number;
    user: string;
    password: string;
    enabled: boolean;

    constructor(id: number, user: string, password: string, enabled: boolean){
        this.id=id;
        this.user=user;
        this.password=password;
        this.enabled=enabled;
    }
}
export default UserBean;