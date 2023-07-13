class CurrentAccountBean {
    number: number = 0;
    calendar: any;
    fee: any;
    typeAccount: any;
    user: any;

    constructor(number: number, calendar: any, fee: any, typeAccount: any, user: any) {
        this.number = number
        this.calendar = calendar
        this.fee = fee
        this.typeAccount = typeAccount
        this.user = user
    }
}
export default CurrentAccountBean;