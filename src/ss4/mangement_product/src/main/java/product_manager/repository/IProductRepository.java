package product_manager.repository;



import product_manager.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> finAll();
    void save(Product product);
    Product finById(int id);
    void update (int id, Product product);
    void remove(int id);
    public List<Product> findByName(String name);

    List<Product> findByProducer(String producer);

    List<Product> findByPrice(double min, double max);
}
