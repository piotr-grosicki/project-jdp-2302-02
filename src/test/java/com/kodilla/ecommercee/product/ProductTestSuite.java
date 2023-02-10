package com.kodilla.ecommercee.product;

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
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTestSuite {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private GroupRepository groupRepository;

    @Test
    public void testFindAllProducts() {
        //Given
        Group gaming = new Group("Gaming CPU");
        Group work = new Group("Work CPU");
        Product asus_tuf = new Product("Asus TUF", new BigDecimal(2000), gaming);
        Product dell_precision = new Product("Dell Precision", new BigDecimal(3000), work);

        List<Product> productListBeforeSave = productRepository.findAll();
        groupRepository.save(gaming);
        groupRepository.save(work);
        productRepository.save(asus_tuf);
        productRepository.save(dell_precision);

        //When
        List<Product> productList = productRepository.findAll();
        int startSize = productListBeforeSave.size();
        int finishSize = productList.size();

        // Then
        Assert.assertEquals(startSize, finishSize - 2);

        //CleanUp
        productRepository.deleteById(asus_tuf.getId());
        productRepository.deleteById(dell_precision.getId());
        groupRepository.deleteById(gaming.getId());
        groupRepository.deleteById(work.getId());
    }

    @Test
    public void testFindProductById() {
        //Given
        Group gaming = new Group("Gaming CPU");
        Group work = new Group("Work CPU");
        Product asus_tuf = new Product("Asus TUF", new BigDecimal(2000), gaming);
        Product dell_precision = new Product("Dell Precision", new BigDecimal(3000), work);

        groupRepository.save(gaming);
        groupRepository.save(work);
        productRepository.save(asus_tuf);
        productRepository.save(dell_precision);

        //When
        Optional<Product> testAsus = productRepository.findById(asus_tuf.getId());
        Optional<Product> testDell = productRepository.findById(dell_precision.getId());

        // Then
        Assert.assertEquals(asus_tuf.getId(), testAsus.get().getId());
        Assert.assertEquals(dell_precision.getId(), testDell.get().getId());

        //CleanUp
        productRepository.deleteById(asus_tuf.getId());
        productRepository.deleteById(dell_precision.getId());
        groupRepository.deleteById(gaming.getId());
        groupRepository.deleteById(work.getId());
    }

    @Test
    public void testDeleteProductById() {
        //Given
        Group gaming = new Group("Gaming CPU");
        Group work = new Group("Work CPU");
        Product asus_tuf = new Product("Asus TUF", new BigDecimal(2000), gaming);
        Product dell_precision = new Product("Dell Precision", new BigDecimal(3000), work);

        groupRepository.save(gaming);
        groupRepository.save(work);
        productRepository.save(asus_tuf);
        productRepository.save(dell_precision);

        //When
        int startSize = productRepository.findAll().size();
        productRepository.deleteById(asus_tuf.getId());
        int finishSize = productRepository.findAll().size();

        // Then
        Assert.assertEquals(Optional.empty(), productRepository.findById(asus_tuf.getId()));
        Assert.assertEquals(startSize, finishSize + 1);

        //CleanUp
        productRepository.deleteById(dell_precision.getId());
        groupRepository.deleteById(gaming.getId());
        groupRepository.deleteById(work.getId());
    }

    @Test
    public void testProductCascadeWhenRemoveProduct() {
        //Given
        Group gaming = new Group("Gaming CPU");
        Group work = new Group("Work CPU");
        Product asus_tuf = new Product("Asus TUF", new BigDecimal(2000), gaming);
        Product dell_precision = new Product("Dell Precision", new BigDecimal(3000), work);

        groupRepository.save(gaming);
        groupRepository.save(work);
        productRepository.save(asus_tuf);
        productRepository.save(dell_precision);

        //When
        int groupBeforeDelete = groupRepository.findAll().size();
        productRepository.deleteById(asus_tuf.getId());
        productRepository.deleteById(dell_precision.getId());
        int groupAfterDelete = groupRepository.findAll().size();

        // Then
        Assert.assertEquals(groupBeforeDelete, groupAfterDelete);

        //CleanUp
        groupRepository.deleteById(gaming.getId());
        groupRepository.deleteById(work.getId());
    }

    @Test
    public void testProductCascadeWhenRemoveGroup() {
        //Given
        Group gaming = new Group("Gaming CPU");
        Group work = new Group("Work CPU");
        Product asus_tuf = new Product("Asus TUF", new BigDecimal(2000), gaming);
        Product dell_precision = new Product("Dell Precision", new BigDecimal(3000), work);

        groupRepository.save(gaming);
        groupRepository.save(work);
        productRepository.save(asus_tuf);
        productRepository.save(dell_precision);

        //When
        int productBeforeDelete = productRepository.findAll().size();
        int groupBeforeDelete = groupRepository.findAll().size();

        groupRepository.deleteById(gaming.getId());
        groupRepository.deleteById(work.getId());

        int productAfterDelete = groupRepository.findAll().size();
        int groupAfterDelete = groupRepository.findAll().size();

        // Then
        Assert.assertEquals(groupBeforeDelete, groupAfterDelete + 2);
        Assert.assertEquals(productBeforeDelete, productAfterDelete + 2 );
    }
}