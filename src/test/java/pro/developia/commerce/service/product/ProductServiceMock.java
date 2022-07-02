package pro.developia.commerce.service.product;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.developia.commerce.repository.CategoryRepository;
import pro.developia.commerce.repository.ProductRepository;
import pro.developia.commerce.service.product.Impl.ProductServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ProductServiceMock {

    @InjectMocks
    protected ProductServiceImpl productService;

    @Mock
    protected ProductRepository productRepository;

    @Mock
    protected CategoryRepository categoryRepository;


}
