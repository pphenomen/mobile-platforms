package basket;

public class Main {
    public static void main(String[] args) {
        Basket basket = new ShoppingBasket();

        basket.addProduct("Яблоко", 3);
        basket.addProduct("Банан", 2);
        basket.addProduct("Апельсин", 5);

        System.out.println("Товары в корзине: " + basket.getProducts());
        System.out.println("Количество яблок: " + basket.getProductQuantity("Яблоко"));

        basket.updateProductQuantity("Банан", 10);
        System.out.println("Обновленное количество бананов: " + basket.getProductQuantity("Банан"));

        basket.removeProduct("Апельсин");
        System.out.println("Товары после удаления апельсина: " + basket.getProducts());

        basket.clear();
        System.out.println("Товары после очистки корзины: " + basket.getProducts());
    }
}
