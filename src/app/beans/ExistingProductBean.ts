class ExistingProductBean {
  id: string;
  description: string;
  price: string;
  stock: string;
  image: string;
  subcategory: string;

  constructor(id: string, image: string, description: string, price: string, stock: string, subcategory: string) {
    this.id = id;
    this.image = image;
    this.description = description;
    this.price = price;
    this.stock = stock;
    this.subcategory = subcategory;
  }
}

export default ExistingProductBean

