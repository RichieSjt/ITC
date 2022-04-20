public class ProductSizeDecorator implements Product {
    String size;
    Product product;

    public ProductSizeDecorator(Product decoratedProduct, String size) {
        this.product = decoratedProduct;
        this.size = size; 
    }

    @Override
    public String getName() {
        return size + " " + product.getName() ;
    }
}
