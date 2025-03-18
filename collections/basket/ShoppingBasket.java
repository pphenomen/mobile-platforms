package basket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class ShoppingBasket implements Basket {
    private Map<String, Integer> products = new HashMap<>();

    @Override
    public void addProduct(String product, int quantity) {
        products.put(product, products.getOrDefault(product, 0) + quantity);
    }

    @Override
    public void removeProduct(String product) {
        products.remove(product);
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        if (products.containsKey(product)) {
            products.put(product, quantity);
        }
    }

    @Override
    public void clear() {
        products.clear();
    }

    @Override
    public List<String> getProducts() {
        return new ArrayList<>(products.keySet());
    }

    @Override
    public int getProductQuantity(String product) {
        return products.getOrDefault(product, 0);
    }
}
