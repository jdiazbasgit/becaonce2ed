class TransactionProgramerBean{
    id:number;
    dateStart: any;
    current: number;
    currentAccount:any;
    description:string;
    timmingType:any;

    constructor(id:number, dateStart:any, current:number,currentAccount:any,description:string,timingType:any){
        this.id=id;
        this.current=current;
        this.dateStart=dateStart;
        this.currentAccount=currentAccount;
        this.description=description;
        this.timmingType=timingType;
    }
}
export default TransactionProgramerBean;