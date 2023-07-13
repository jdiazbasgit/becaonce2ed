class SoldProductBean {
    id: number;
    quantity: number;
    existingProduct: string;
    price: number;
    date: Date;
    profile: string;
    basket: boolean;
  
    constructor(id: number, quantity: number, existingProduct: string, price: number, date: Date, profile: string, basket: boolean
  ) {
      this.id = id;
      this.quantity = quantity;
      this.existingProduct = existingProduct;
      this.price = price;
      this.date = date;
      this.profile = profile;
      this.basket = basket;
      }
  }
  
  export default SoldProductBean