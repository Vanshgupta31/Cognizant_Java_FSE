import java.util.*;

class Product {
    int id;
    String name, category;

    Product(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public String toString() {
        return "Product ID : " + id + ", Name : " + name + ", Category : " + category;
    }
}

public class EcommerceSearch {

    static Product linearSearch(Product[] p, int id) {
        for (Product x : p)
            if (x.id == id)
                return x;
        return null;
    }

    static Product binarySearch(Product[] p, int id) {
        int l = 0, r = p.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (p[m].id == id)
                return p[m];
            if (p[m].id < id)
                l = m + 1;
            else
                r = m - 1;
        }
        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(105, "Laptop", "Electronics"),
                new Product(102, "Shoes", "Fashion"),
                new Product(101, "Phone", "Electronics"),
                new Product(104, "Watch", "Accessories"),
                new Product(103, "Headphones", "Electronics")
        };

        System.out.println("Linear Search Result:");
        System.out.println(linearSearch(products, 104));

        Arrays.sort(products, Comparator.comparingInt(p -> p.id));

        System.out.println("\nBinary Search Result:");
        System.out.println(binarySearch(products, 103));
    }
}
