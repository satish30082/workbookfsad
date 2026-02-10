package com.fsad.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.fsad.model.Product;
import com.fsad.util.HibernateUtil;

public class HQLDemo {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(new Product("Laptop","Electronics",50000,10));
        session.save(new Product("Mobile","Electronics",20000,15));
        session.save(new Product("Chair","Furniture",2500,20));
        session.save(new Product("Table","Furniture",6000,8));
        session.save(new Product("Pen","Stationary",20,100));
        session.save(new Product("Book","Stationary",60,50));

        tx.commit();
        Query<Product> q1 =
            session.createQuery("from Product order by price asc",Product.class);

        System.out.println("Price Ascending:");
        for(Product p:q1.list()){
            System.out.println(p.getName()+" "+p.getPrice());
        }
        Query<Product> q2 =
            session.createQuery("from Product",Product.class);

        q2.setFirstResult(0);
        q2.setMaxResults(3);

        System.out.println("First 3:");
        for(Product p:q2.list()){
            System.out.println(p.getName());
        }

        Query<Long> q3 =
            session.createQuery("select count(*) from Product",Long.class);
        System.out.println("Total: "+q3.uniqueResult());
        session.close();
        HibernateUtil.getSessionFactory().close();
    }
}
