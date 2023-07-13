class AwardsFinesConfiguration {
  id: number = 0;
  current: number = 0;
  description: string = "";

  constructor(id: number, current: number, description: string) {
    this.id = id;
    this.current = current;
    this.description = description;
  }
}
export default AwardsFinesConfiguration;