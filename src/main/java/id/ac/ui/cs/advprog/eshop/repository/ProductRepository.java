package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll(){
        return productData.iterator();
    }

    public Product findProduct(String productId) {
        for (Product product : productData) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public Product update(String productId, Product product) {
        for(int i=0; i<productData.size(); i++){
            if(productData.get(i).getProductId().equals(productId)){
                productData.set(i, product);
                return productData.get(i);
            }
        }
        return null;
    }

    public void delete(String productId) {
        for(int i=0; i<productData.size(); i++){
            if(productData.get(i).getProductId().equals(productId)){
                productData.remove(i);
            }
        }
    }

}
