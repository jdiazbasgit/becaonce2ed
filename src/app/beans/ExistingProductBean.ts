class ExistingProductBean {
  description: string;
  price: string;
  stock: string;
  image: string | null = null;
  subcategory: string;

  constructor(image: string, description: string, price: string, stock: string, subcategory: string ) {
    this.description = description;
    this.price = price;
    this.stock = stock;
    this.image = image;
    this.subcategory = subcategory;
  }
}

export default ExistingProductBean;

