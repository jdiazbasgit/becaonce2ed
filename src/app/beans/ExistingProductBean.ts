class ExistingProductBean {
  description: string;
  price: string;
  stock: string;
  image: string;

  constructor(image: string, description: string, price: string, stock: string ) {
    this.description = description;
    this.price = price;
    this.stock = stock;
    this.image = image;
  }
}

export default ExistingProductBean;

