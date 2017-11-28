package com.model2.mvc.service.user.product;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;




@RunWith(SpringJUnit4ClassRunner.class)

//==> Meta-Data �� �پ��ϰ� Wiring ����...
//@ContextConfiguration(locations = { "classpath:config/context-*.xml" })
@ContextConfiguration	(locations = {	"classpath:config/context-common.xml",
																			"classpath:config/context-aspect.xml",
																			"classpath:config/context-mybatis.xml",
																			"classpath:config/context-transaction.xml" })
public class ProductServiceTest {
	
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	
	
//	@Test
	public void testaddProduct() throws IOException {
		
		SqlSession sqlSession = SqlSessionFactoryBean.getSqlSession();
		System.out.println("\n");
			
		Product product = new Product( );
		product.setProdName("������");
		product.setProdDetail("���� �߱����̶� ����......");
		
		System.out.println(":: 1. addProduct(INSERT)  ? ");
		System.out.println(":: "+ sqlSession.insert("ProductMapper.addProduct",product));
		System.out.println("\n");
	}
		
//	@Test
		public void testgetProduct() throws IOException {
			
			SqlSession sqlSession = SqlSessionFactoryBean.getSqlSession();
			System.out.println("\n");
			
			Product product = new Product( );

			product.setProdName("���̱���");
			
			String name = "���̱���";
			
		System.out.println(":: 2.getProduct(SELECT)  ? ");
		System.out.println(":: "+ sqlSession.selectOne("ProductMapper.getProduct",name));
		System.out.println("\n");
		
		}
		
		@Test
		public void testupdateProduct() throws IOException {
			
			SqlSession sqlSession = SqlSessionFactoryBean.getSqlSession();
			System.out.println("\n");
			Product product = new Product( );
			
			product.setProdName("���̱���7777");
			product.setProdDetail("���� ���ֽ��ϴ�!");
			product.setProdNo(10072);
			
		System.out.println(":: 3. update(UPDATE)  ? ");
		sqlSession.update("ProductMapper.updateProduct",product);
		System.out.println("===========");
		
	
//		product.setProdName("���̱���2");
//		product.setProdDetail("���� ���ֽ��ϴ�!");
	
	
	
	}
}
