package com.company;

import com.company.model.Order;
import com.company.model.OrderItems;
import com.company.model.ProdStatus;
import com.company.model.Product;
import com.company.repo.OrdersRepo;
import com.company.repo.ProdRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication(
//		exclude={DataSourceAutoConfiguration.class}
)
@PropertySource("classpath:local.properties")
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);


//    @Autowired
//    private EntityManager entityManager;
//
//    @PersistenceUnit
//    EntityManagerFactory entityManFactory;



    	//CommandLineRunner
	@Bean
	//@Transactional
    public boolean demo(ProdRepo prodRepo, OrdersRepo ordersRepo) {
		//return (args) ->
		//{
		log.info("demo: ");

		Product prod1 = new Product("Prod1", 10, ProdStatus.IN_STOCK);
        prodRepo.save(prod1);
		Product prod2 = new Product("Prod2", 20, ProdStatus.IN_STOCK);
		prodRepo.save(prod2);

//		ArrayList<OrderItems> orderItems = new ArrayList<>() {{
//			add(new OrderItems())
//		}};
//
//		Order order1 = new Order(0, ProdStatus.IN_STOCK, new ArrayList<Product>() {{
//			add(prod1); add(prod2);
//		}});
//		ordersRepo.save(order1);
//
//		Order order2 = new Order(0, ProdStatus.IN_STOCK, new ArrayList<Product>() {{
//			add(prod2);
//		}});
//		ordersRepo.save(order2);
//
//		log.info("demo: Ok");
		//};
		return  true;
	}


    public static void main(String[] args) {
        log.info("main: ----------------------------");
//        try {
            SpringApplication.run(Main.class, args);
//        } catch (IllegalStateException ex)
//        {
//            System.out.println(ex.getMessage());
//        }
        log.info("main: ===========================!");
    }
}

