package product_manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product_manager.model.Product;
import product_manager.repository.IProductRepository;

import java.util.List;
@Service
public class ProductService implements IPrductService {
    @Autowired
private IProductRepository iProductRepository;
    @Override
    public List<Product> finAll() {
        return iProductRepository.finAll();
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);

    }

    @Override
    public Product finById(int id) {
        return iProductRepository.finById(id);
    }

    @Override
    public void update(int id, Product product) {
        iProductRepository.update(id,product);

    }

    @Override
    public void remove(int id) {
        iProductRepository.remove(id);

    }

    @Override
    public List<Product> findByName(String nameSearch) {
        return iProductRepository.findByName(nameSearch);
    }

    @Override
    public List<Product> findByProducer(String producer) {
        return findByProducer(producer);
    }

    @Override
    public List<Product> findByPrice(double min, double max) {
        return null;
    }
}
