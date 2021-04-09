
package apple.cloneApple;

import apple.cloneApple.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTests {
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void inspect(){
        Class<?> clz = productRepository.getClass();

        System.out.println(clz.getName());

        Class<?>[] interfaces = clz.getInterfaces();
        Stream.of(interfaces).forEach(inter -> System.out.println(inter.getName()));

        Class<?> superClasses = clz.getSuperclass();
        System.out.println(superClasses.getName());
    }
}