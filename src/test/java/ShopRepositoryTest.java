import ProductManager.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void testRemoveWhenProductExist() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "телефон", 30_000);
        Product product2 = new Product(2, "книга", 300);
        Product product3 = new Product(3, "машина", 3_000_000);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.remove(2);

        Product[] actual = repository.findAll();
        Product[] expected = {product1, product3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWhenProductNotExist() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "телефон", 30_000);
        Product product2 = new Product(2, "книга", 300);
        Product product3 = new Product(3, "машина", 3_000_000);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repository.remove(123123)
        );
    }
}
