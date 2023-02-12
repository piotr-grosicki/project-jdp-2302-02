package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private GroupRepository groupRepository;

    @Test
    public void testProductRepositoryPost() {
        //Given
        Group nabial = new Group("nabial");
        Group mieso = new Group("mieso");
        Product product1 = new Product(nabial, "Maslo", new BigDecimal(4));
        Product product2 = new Product(nabial, "ser", new BigDecimal(32));
        Product product3 = new Product(mieso, "kurczak", new BigDecimal(22));
        Product product4 = new Product(mieso, "wolowina", new BigDecimal(52));

        //When
        groupRepository.save(nabial);
        groupRepository.save(mieso);
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);

        //  Then
        Assert.assertEquals(4, productRepository.count());
        Assert.assertEquals(2, groupRepository.count());
        //CleanUp
        groupRepository.deleteAll();
        productRepository.deleteAll();
    }

    @Test
    public void testProductRepositoryGet() {
        //Given
        Group nabial = new Group("nabial");
        Group mieso = new Group("mieso");
        final Product product1 = new Product(nabial, "Maslo", new BigDecimal(4));
        final Product product2 = new Product(nabial, "ser", new BigDecimal(32));
        final Product product3 = new Product(mieso, "kurczak", new BigDecimal(22));

        //When
        groupRepository.save(nabial);
        groupRepository.save(mieso);
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        List<Product> testProduct = productRepository.findAll();

        //Then
        Assert.assertEquals(3, testProduct.size());

        //CleanUp
        groupRepository.deleteAll();
        productRepository.deleteAll();
    }

    @Test
    public void testProductRepositoryPut() {
        //Given
        Group nabial = new Group("nabial");
        Product product1 = new Product(nabial, "Maslo", new BigDecimal(4));
        Product product2 = new Product(nabial, "ser", new BigDecimal(32));

        //When
        groupRepository.save(nabial);
        productRepository.save(product1);
        productRepository.save(product2);
        Product editedProduct = productRepository.findById(product1.getId()).get();
        editedProduct.setName("kefir");
        productRepository.save(editedProduct);

        //Then
        Assert.assertEquals(productRepository.findById(product1.getId()).get().getName(), "kefir");

        //CleanUp
        groupRepository.deleteAll();
        productRepository.deleteAll();
    }

    @Test
    public void testProductRepositoryPutGroup() {
        //Given
        Group nabial = new Group("nabial");
        Product product1 = new Product(nabial, "Maslo", new BigDecimal(4));
        Product product2 = new Product(nabial, "ser", new BigDecimal(32));

        //When
        groupRepository.save(nabial);
        productRepository.save(product1);
        productRepository.save(product2);

        Group editGroup = productRepository.findById(product1.getId()).get().getGroup();
        editGroup.setName("zepsutynabial");
        groupRepository.save(editGroup);
        String productGroupAfterEdit = productRepository.findById(product2.getId()).get().getGroup().getName();

        //Then
        Assert.assertEquals(productGroupAfterEdit, "zepsutynabial");

        //CleanUp
        groupRepository.deleteAll();
        productRepository.deleteAll();
    }

    @Test
    public void testProductRepositoryDeleteOnlyProductRepository() {
        //Given
        Group nabial = new Group("nabial");
        Group mieso = new Group("mieso");
        final Product product1 = new Product(nabial, "Maslo", new BigDecimal(4));
        final Product product2 = new Product(nabial, "ser", new BigDecimal(32));
        final Product product3 = new Product(mieso, "kurczak", new BigDecimal(22));

        //When
        groupRepository.save(nabial);
        groupRepository.save(mieso);
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.deleteAll();

        //Then
        Assert.assertEquals(0, productRepository.count());
        Assert.assertEquals(2, groupRepository.count());

        //CleanUp
        groupRepository.deleteAll();
        productRepository.deleteAll();
    }

    @Test
    public void testProductRepositoryDeleteGroupRepository() {
        //Given
        Group nabial = new Group("nabial");
        Group mieso = new Group("mieso");
        final Product product1 = new Product(nabial, "Maslo", new BigDecimal(4));
        final Product product2 = new Product(nabial, "ser", new BigDecimal(32));
        final Product product3 = new Product(mieso, "kurczak", new BigDecimal(22));

        //When
        groupRepository.save(nabial);
        groupRepository.save(mieso);
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        groupRepository.deleteAll();

        //Then
        Assert.assertEquals(0, productRepository.count());
        Assert.assertEquals(0, groupRepository.count());

        //CleanUp
        groupRepository.deleteAll();
        productRepository.deleteAll();
    }
}