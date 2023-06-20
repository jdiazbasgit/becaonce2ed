class AwardsFine {
  id: number = 0;
  time: number = 0;
  awardFineType: any;
  awardFineConfiguration: any;

  constructor(id: number, time: number, awardFineType: any, awardFineConfiguration: any) {
    this.id = id;
    this.awardFineType = awardFineType;
    this.awardFineConfiguration = awardFineConfiguration;
  }
}
export default AwardsFine;