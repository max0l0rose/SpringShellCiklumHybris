package com.company;

import com.company.model.ProdStatus;
import com.company.model.Product;
import com.company.repo.ProdRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;


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
    public boolean demo(ProdRepository repository) {
		//return (args) ->
		//{
		log.info("demo: ");

			Product dep = new Product("Prod1", 10, ProdStatus.IN_STOCK, null);
            repository.save(dep);

//			dep.setDepName(dep.getDepName() + dep.getId());
//			depsRepo.save(dep);
//			//entityManager.merge(dep);
//
//			User user = new User("Jack", dep, Role.ADMIN);
//			repository.save(user);
//			// fetch all customers

//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (Customer customer : repository.findAll()) {
//				log.info(customer.toString());
//			}
//			log.info("");
//
//			// fetch an individual customer by ID
//			Customer customer = repository.findById(1L);
//			log.info("Customer found with findById(1L):");
//			log.info("--------------------------------");
//			log.info(customer.toString());
//			log.info("");
//
//			// fetch customers by last name
//			log.info("Customer found with findByLastName('Bauer'):");
//			log.info("--------------------------------------------");
//			repository.findByLastName("Bauer").forEach(bauer -> {
//				log.info(bauer.toString());
//			});
//			// for (Customer bauer : repository.findByLastName("Bauer")) {
//			//  log.info(bauer.toString());
//			// }
			log.info("demo: Ok");
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

