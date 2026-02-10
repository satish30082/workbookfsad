package com.fsad.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fsad.model.Product;
import com.fsad.util.HibernateUtil;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // INSERT

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("Enter Product Name:");
        String name = sc.nextLine();

        System.out.println("Enter Description:");
        String desc = sc.nextLine();

        System.out.println("Enter Price:");
        double price = sc.nextDouble();

        System.out.println("Enter Quantity:");
        int qty = sc.nextInt();

        Product p = new Product(name, desc, price, qty);

        session.save(p);

        tx.commit();
        session.close();

        System.out.println("Inserted Successfully!");


        session = HibernateUtil.getSessionFactory().openSession();

        System.out.println("Enter ID to Fetch:");
        int id = sc.nextInt();

        Product prod = session.get(Product.class, id);

        if (prod != null) {

            System.out.println("Name: " + prod.getName());
            System.out.println("Price: " + prod.getPrice());

        } else {

            System.out.println("Not Found!");

        }

        session.close();

        sc.close();
        HibernateUtil.getSessionFactory().close();
    }
}
