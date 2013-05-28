package org.springframework.springapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.springapp.domain.Product;

public class ProductDaoImpl implements ProductDao {
	
	private HibernateTransactionManager txManager;
	private SessionFactory sessionFactory;
	
	/** Logger for this class and subclasses */
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    
    public void setTxManagerFactory(HibernateTransactionManager txManager) {
		this.txManager = txManager;		
		this.sessionFactory = this.txManager.getSessionFactory();
	}


    public List<Product> getProductList() {
        logger.info("Getting products!");
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("from Product").list();
        session.getTransaction().commit();
        
        //List<Product> products = getSimpleJdbcTemplate().query("select id, description, price from products",new ProductMapper());
        
        return products;
    }

    public void saveProduct(Product prod) {
        logger.info("Saving product: " + prod.getDescription());
        Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		session.update(prod);
		
		session.getTransaction().commit();
        
        /*int count = getSimpleJdbcTemplate().update(
            "update products set description = :description, price = :price where id = :id",
            new MapSqlParameterSource().addValue("description", prod.getDescription())
                .addValue("price", prod.getPrice())
                .addValue("id", prod.getId()));*/
        logger.info("updated product : " + prod);
    }
    
    
}
