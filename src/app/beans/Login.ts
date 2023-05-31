class Login {
    usuario: string = ""
    clave: string = ""

    constructor(user: string, pwd: string) {
        this.usuario = user;
        this.clave = pwd;
    }
}
export default Login;