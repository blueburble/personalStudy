package com.collect.java8.generics.code;

import com.collect.java8.typeInfo.code.A;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;



class Product{
    private final int id;
    private String description;
    private double price;

    Product(int id, String desc, double price){
        this.id = id;
        this.description = desc;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public void priceChange(double change){
        price += change;
    }

    public static Supplier<Product> generator =  new Supplier<Product>() {
        private Random rand = new Random(47);
        @Override
        public Product get() {
            return new Product(rand.nextInt(1000), "Test", Math.round(rand.nextDouble() * 1000) + 0.99);
        }
    };
}

class Shelf extends ArrayList<Product> {
    Shelf(int nProducts){
        Suppliers.fill(this, Product.generator, nProducts);
    }
}

class Aisle extends ArrayList<Shelf>{
    Aisle(int nShelves, int nProducts){
        for(int i = 0; i < nShelves; i++){
            add(new Shelf(nProducts));
        }
    }
}

class CheckoutStand{

}

class Office{

}

public class Store extends ArrayList<Aisle>{
    private ArrayList<CheckoutStand> checkoutStands = new ArrayList<>();
    private Office office = new Office();

    public Store(int nAisles, int nShelves, int nProducts){
        for(int i = 0; i < nAisles; i++){
            add(new Aisle(nShelves, nProducts));
        }
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        for(Aisle a : this){
            str.append(a);
            str.append("\n");
            for(Shelf b : a){
                str.append(b);
                str.append("\n");
            }
        }
        return str.toString();
    }

    public static void main(String[] args){
        System.out.println(new Store(5, 4,3));
    }
}