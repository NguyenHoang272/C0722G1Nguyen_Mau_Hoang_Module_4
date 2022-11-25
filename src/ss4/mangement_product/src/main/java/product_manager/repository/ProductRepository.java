package product_manager.repository;

import org.springframework.stereotype.Repository;
import product_manager.model.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Ban phim", 10000, "mo ta", "A1"));
        products.add(new Product(2, "Camera", 50000, "mo ta", "B2"));
        products.add(new Product(3, "Chuot", 25000, "mo ta", "D6"));
        products.add(new Product(4, "Dien thoai", 9000, "mo ta", "C2"));
        products.add(new Product(5, "Man Hinh", 110000, "mo ta", "A5"));
        products.add(new Product(8, "Vinh Oc", 110000, "mo ta", "A5"));
        products.add(new Product(10, "Sieu Nhan", 40000, "mo ta", "A5"));
    }

    @Override
    public List<Product> finAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product finById(int id) {
        for (Product product : products) {
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        int index = findIndex(id);
        products.remove(index);
        products.add(index, product);
    }
    public int findIndex(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public void remove(int id) {
        int index = findIndex(id);
        products.remove(index);
    }

    @Override
    public List<Product> findByName(String nameSearch) {
        List<Product> searchList = new ArrayList<>();
        for (Product item : finAll()){
            if (item.getName().contains(nameSearch)){
                searchList.add(item);
            }
        }
        return searchList;
    }

    @Override
    public List<Product> findByProducer(String producer) {
        List<Product> productsFound = new ArrayList<>();

        for (Product product : products
        ) {
            if (product.getProducer().contains(producer)) {
                productsFound.add(product);
            }
        }
        return productsFound;
    }

    @Override
    public List<Product> findByPrice(double min, double max) {
        return null;
    }
}

