package dev.wcs.tutoring.persistenceshootout;

import dev.wcs.tutoring.persistenceshootout.nosql.mongodb.entity.Customer;
import dev.wcs.tutoring.persistenceshootout.nosql.mongodb.entity.Purchase;
import dev.wcs.tutoring.persistenceshootout.nosql.mongodb.repository.NoSqlCustomerRepository;
import dev.wcs.tutoring.persistenceshootout.nosql.neo4j.entity.Person;
import dev.wcs.tutoring.persistenceshootout.nosql.neo4j.repository.PersonRepository;
import dev.wcs.tutoring.persistenceshootout.sql.postgresql.entity.CustomerEntity;
import dev.wcs.tutoring.persistenceshootout.sql.postgresql.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class PersistenceShootoutApplication implements CommandLineRunner {

	public final CustomerRepository customerRepository;
	public final NoSqlCustomerRepository noSqlCustomerRepository;
	public final PersonRepository personRepository;

	public PersistenceShootoutApplication(CustomerRepository customerRepository, NoSqlCustomerRepository noSqlCustomerRepository, PersonRepository personRepository) {
		this.customerRepository = customerRepository;
		this.noSqlCustomerRepository = noSqlCustomerRepository;
		this.personRepository = personRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(PersistenceShootoutApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		List<CustomerEntity> inErlangen = customerRepository.findCustomerEntitiesByAddressByAddressId_CityByCityId_City("Erlangen");
		List<CustomerEntity> inErlangenNativ = customerRepository.findAllCustomersByCity("Erlangen");
		System.out.println(inErlangen);


		noSqlCustomerRepository.deleteAll();

		// save a couple of customers
		noSqlCustomerRepository.save(new Customer("Alice", "Smith"));
		noSqlCustomerRepository.save(new Customer("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : noSqlCustomerRepository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(noSqlCustomerRepository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : noSqlCustomerRepository.findByLastName("Smith")) {
			addPurchases(customer);
			System.out.println(customer);
		}

		List<Person> matrixers = personRepository.findByActedInMoviesTitle("The Matrix");
		List<Person> bothMovies = personRepository.findByActedInBothMovies("The Matrix", "The Matrix Reloaded");

		System.out.println(matrixers);
		System.out.println(bothMovies);

	}

	private void addPurchases(Customer customer) {
		Purchase purchase1 = new Purchase("banana", LocalDate.now().minusDays(10), BigDecimal.valueOf(5.99));
		Purchase purchase2 = new Purchase("apple", LocalDate.now().minusDays(11), BigDecimal.valueOf(3.49));
		Purchase purchase3 = new Purchase("pear", LocalDate.now().minusDays(12), BigDecimal.valueOf(1.45));
		customer.setLastPurchases(List.of(purchase1, purchase2, purchase3));
		noSqlCustomerRepository.save(customer);
	}
}
