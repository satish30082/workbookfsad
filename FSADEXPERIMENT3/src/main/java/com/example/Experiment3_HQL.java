package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.example.entity.Product;
import com.example.util.HibernateUtil;

public class Experiment3_HQL {

    public static void main(String[] args) {

        insertProducts();
        sortByPriceAsc();
        sortByPriceDesc();
        sortByQuantity();
        pagination();
        aggregates();
    }

    static void insertProducts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(new Product("Laptop", 60000, 5, "Electronics"));
        session.save(new Product("Mouse", 500, 20, "Electronics"));
        session.save(new Product("Keyboard", 1500, 15, "Electronics"));
        session.save(new Product("Chair", 3000, 10, "Furniture"));
        session.save(new Product("Table", 7000, 3, "Furniture"));
        session.save(new Product("Pen", 20, 100, "Stationery"));

        tx.commit();
        session.close();

        System.out.println("Products inserted");
    }

    static void sortByPriceAsc() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> q =
            session.createQuery("from Product order by price asc", Product.class);

        System.out.println("\nPrice Ascending:");
        for (Product p : q.list())
            System.out.println(p.getProductName() + " - " + p.getPrice());

        session.close();
    }

    static void sortByPriceDesc() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> q =
            session.createQuery("from Product order by price desc", Product.class);

        System.out.println("\nPrice Descending:");
        for (Product p : q.list())
            System.out.println(p.getProductName() + " - " + p.getPrice());

        session.close();
    }

    static void sortByQuantity() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> q =
            session.createQuery("from Product order by quantity desc", Product.class);

        System.out.println("\nQuantity Descending:");
        for (Product p : q.list())
            System.out.println(p.getProductName() + " - " + p.getQuantity());

        session.close();
    }

    static void pagination() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> q =
            session.createQuery("from Product", Product.class);

        q.setFirstResult(0);
        q.setMaxResults(3);
        System.out.println("\nFirst 3 Products:");
        for (Product p : q.list())
            System.out.println(p.getProductName());

        q.setFirstResult(3);
        q.setMaxResults(3);
        System.out.println("\nNext 3 Products:");
        for (Product p : q.list())
            System.out.println(p.getProductName());

        session.close();
    }

    static void aggregates() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Long count =
            (Long) session.createQuery("select count(*) from Product").uniqueResult();

        Object[] res =
            (Object[]) session.createQuery(
                "select min(price), max(price) from Product").uniqueResult();

        System.out.println("\nTotal Products: " + count);
        System.out.println("Minimum Price: " + res[0]);
        System.out.println("Maximum Price: " + res[1]);

        session.close();
    }
}
