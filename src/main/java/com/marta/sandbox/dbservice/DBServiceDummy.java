package com.marta.sandbox.dbservice;

import com.marta.sandbox.entity.Product;
import com.marta.sandbox.entity.ProductDummy;

import java.util.*;
import java.util.stream.Collectors;

public class DBServiceDummy {

    private HashMap<String, Product> products;

    private static DBServiceDummy thisInstance = new DBServiceDummy();
    public static DBServiceDummy getInstance () {return thisInstance;}

    public List<Product> getRandomProducts(int quantity) {
        return products.entrySet().stream()
                .filter(e -> !e.getKey().equals("99"))
                .limit(quantity)
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public Product getProductByID(String id) {
        return products.get(id);
    }

    private DBServiceDummy() {
        products = new HashMap<>();

        products.put(
                "11",
                new ProductDummy(
                        "11",
                        "Fishnet Something",
                        14.99f,
                        "img/product-11.jpg",
                        "<p>The majesty of Mountains - Ugmonk style.</p>" +
                                "<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>" +
                                "<p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident. sunt in culpa qui officia deserunt mollit anim id est laborum. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>")
        );
        products.put(
                "21",
                new ProductDummy(
                        "21",
                        "Fishnet Armchair",
                        29.99f,
                        "img/product-21.jpg",
                        "<p>The majesty of Mountains - Ugmonk style.</p>" +
                                "<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>" +
                                "<p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident. sunt in culpa qui officia deserunt mollit anim id est laborum. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>")
        );
        products.put(
                "31",
                new ProductDummy(
                        "31",
                        "Fishnet Lamp",
                        27.99f,
                        "img/product-31.jpg",
                        "<p>The majesty of Mountains - Ugmonk style.</p>" +
                                "<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>" +
                                "<p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident. sunt in culpa qui officia deserunt mollit anim id est laborum. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>")
        );
        products.put(
                "41",
                new ProductDummy(
                        "41",
                        "Fishnet Bra",
                        23.99f,
                        "img/product-41.jpg",
                        "<p>The majesty of Mountains - Ugmonk style.</p>" +
                                "<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>" +
                                "<p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident. sunt in culpa qui officia deserunt mollit anim id est laborum. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>")
        );
        products.put(
                "5",
                new ProductDummy(
                        "5",
                        "Fishnet Bowl",
                        9.99f,
                        "img/product-5.jpg",
                        "<p>The majesty of Mountains - Ugmonk style.</p>" +
                                "<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>" +
                                "<p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident. sunt in culpa qui officia deserunt mollit anim id est laborum. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>")
        );
        products.put(
                "6",
                new ProductDummy(
                        "6",
                        "Fishnet Vase",
                        19.99f,
                        "img/product-6.jpg",
                        "<p>The majesty of Mountains - Ugmonk style.</p>" +
                                "<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>" +
                                "<p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident. sunt in culpa qui officia deserunt mollit anim id est laborum. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>")
        );
        products.put(
                "99",
                new ProductDummy(
                        "99",
                        "Fishnet Chair",
                        36.7f,
                        "img/product-99-1-big.jpg",
                        "<p>The majesty of Mountains - Ugmonk style.</p>" +
                                "<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>" +
                                "<p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident. sunt in culpa qui officia deserunt mollit anim id est laborum. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>")
        );
    }
}
