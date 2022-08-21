package org.chenfeng.taling.business.entity.service;

import org.chenfeng.taling.business.entity.ProductDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testIndex(){
        ProductDemo productDemo = new ProductDemo();
        productDemo.setId(1L);
        productDemo.setGoodsName("中华牙膏");
        productDemo.setGoodsImage("/user/image/zhonghua.png");
        productDemo.setPrice(18.9);
        productRepository.save(productDemo);
    }

}
