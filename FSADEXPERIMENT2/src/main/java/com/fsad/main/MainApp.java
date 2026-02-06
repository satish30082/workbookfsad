package com.fsad.main;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.fsad.model.Product;
import com.fsad.util.HibernateUtil;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("Enter Product Name:");
        String name = sc.nextLine();

        System.out.println("Enter Product Description:");
        String description = sc.nextLine();

        System.out.println("Enter Product Price:");
        double price = sc.nextDouble();

        System.out.println("Enter Product Quantity:");
        int quantity = sc.nextInt();

        Product p = new Product();
        p.setName(name);
        p.setDescription(description);
        p.setPrice(price);
        p.setQuantity(quantity);

        session.save(p);
        System.out.println("Product saved successfully!");

        System.out.println("Enter Product ID to fetch:");
        int id = sc.nextInt();

        Product prod = session.get(Product.class, id);
        if (prod != null) {
            System.out.println("Product Name: " + prod.getName());
            System.out.println("Price: " + prod.getPrice());
        } else {
            System.out.println("Product not found!");
        }

        if (prod != null) {
            System.out.println("Enter new price:");
            double newPrice = sc.nextDouble();
            prod.setPrice(newPrice);
            session.update(prod);
            System.out.println("Product updated!");
        }

        if (prod != null) {
            System.out.println("Do you want to delete this product? (yes/no)");
            sc.nextLine();
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                session.delete(prod);
                System.out.println("Product deleted!");
            }
        }

        tx.commit();
        session.close();
        sc.close();
    }
}
