class ConfigurationBean{
    id:number
    stockAlarm:string
    constructor(id:number, stockAlarm:string){
        this.id=id;
        this.stockAlarm=stockAlarm; 
    }
}
export default ConfigurationBean;