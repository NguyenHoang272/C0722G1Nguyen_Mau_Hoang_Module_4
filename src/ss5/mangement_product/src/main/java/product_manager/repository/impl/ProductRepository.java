package product_manager.repository.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import product_manager.model.Product;
import product_manager.repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> products = new ArrayList<>();

//    static {
//        products.add(new Product(1, "Ban phim", 10000, "mo ta", "A1"));
//        products.add(new Product(2, "Camera", 50000, "mo ta", "B2"));
//        products.add(new Product(3, "Chuot", 25000, "mo ta", "D6"));
//        products.add(new Product(4, "Dien thoai", 9000, "mo ta", "C2"));
//        products.add(new Product(5, "Man Hinh", 110000, "mo ta", "A5"));
//        products.add(new Product(8, "Vinh Oc", 110000, "mo ta", "A5"));
//        products.add(new Product(10, "Sieu Nhan", 40000, "mo ta", "A5"));
//    }

    @Override
    public List<Product> finAll() {
        Session session = null;
        List<Product> products = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            products = session.createQuery("FROM Product").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return products;
    }

    @Override
    public List<Product> findByName(String nameSearch) {
        Session session = null;
        List<Product> products= null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            products =  session.createQuery("from Product where name like :name").setParameter("name","%"+nameSearch+"%").getResultList();
        }finally {
            if (session != null){
                session.close();
            }
        }
        return products;
    }

    @Override
    public void save(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(product);

        } finally {
            if (session != null) {
                session.close();
            }

        }
    }

    @Override
    public Product finById(int id) {
        Session session = null;
        Product product = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            product = (Product) session.createQuery("FROM Product where  id= :idx").setParameter("idx", id).getSingleResult();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return product;
    }




    @Override
    public void update( Product product) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.merge(product);
            transaction.commit();
        }finally {
            if (session != null) {
                session.close();
            }
        }
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
        Session session = null;
        Product product = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            product = session.load(Product.class, id);
            session.remove(product);
            transaction.commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
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

