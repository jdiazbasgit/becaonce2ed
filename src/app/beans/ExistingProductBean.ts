class ExistingProductBean {
  id: number;
  description: string;
  price: string;
  stock: string;
  image: string;

  constructor(id: number, image: string, description: string, price: string, stock: string ) {
    this.id = id;
    this.description = description;
    this.price = price;
    this.stock = stock;
    this.image = image;
  }
}

export default ExistingProductBean;

