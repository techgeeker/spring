package org.michaelliu.spring.mybatis.test;

import com.alibaba.fastjson.JSON;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.spring.beans.dto.Product;
import org.michaelliu.spring.beans.vo.ProductVo;
import org.michaelliu.spring.mybatis.mapper.ProductMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Michael on 7/28/16.
 */
public class TestProductMapper {

    private static final Log log = LogFactory.getLog(TestProductMapper.class);

    public static void testSelectByPrimaryKey(Long id) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/mapper-config.xml");
        ProductMapper productMapper = context.getBean("productMapper", ProductMapper.class);
        ProductVo productVo = productMapper.selectByPrimaryKey(id);
        log.info(JSON.toJSONString(productVo));
    }

    public static void testSelectAllWithOrder() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/mapper-config.xml");
        ProductMapper productMapper = context.getBean("productMapper", ProductMapper.class);
        List<ProductVo> productList = productMapper.selectAllWithOrder();
        log.info(JSON.toJSONString(productList));
    }

    public static void testInsertSelective(Product product) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/mapper-config.xml");
        ProductMapper productMapper = context.getBean("productMapper", ProductMapper.class);
        System.out.println("insert data: " + JSON.toJSONString(product));
        int result = productMapper.insertSelective(product);
        System.out.println("insert result: " + result);
        System.out.println("insert result: " + JSON.toJSONString(product));
    }

    public static void testUpdateByPrimaryKeySelective(Product product) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/mapper-config.xml");
        ProductMapper productMapper = context.getBean("productMapper", ProductMapper.class);
        System.out.println("update data: " + JSON.toJSONString(product));
        int result = productMapper.updateByPrimaryKeySelective(product);
        System.out.println("update result: " + result);
    }

    public static void main(String[] args) {
        testSelectByPrimaryKey(1l);
        Product product = new Product.Builder()
                .setName("Michael Liu")
                .setBalance(13)
                .setPrice(378)
                .setStatus((byte) 1)
                .build();
        testInsertSelective(product);
        testUpdateByPrimaryKeySelective(product);
        testSelectAllWithOrder();
    }

}
