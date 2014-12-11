package br.gov.fjrj.repositories;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.gov.fjrj.models.Product;

@Component
public class ProductRepositoryImpl extends Repository<Product, Long>  implements ProductRepository {

	ProductRepositoryImpl(Session session) {
		super(session);
	}
}
