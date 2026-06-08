import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldCheckSuccessRemoveId() {
        ShopRepository repository = new ShopRepository();
            Product bread = new Product(1, "Хлеб", 60);
            Product milk = new Product(2, "Молоко", 90);
            repository.add(bread);
            repository.add(milk);
            repository.removeById(1);
            Product[] expected = {milk};
            Product[] actual = repository.findAll();
            Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionByRemoveNotExistedId() {
        ShopRepository repository = new ShopRepository();
        Product bread = new Product(1, "Хлеб", 60);
        Product milk = new Product(2, "Молоко", 90);
        repository.add(bread);
        repository.add(milk);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(3);
        });
    }
}
