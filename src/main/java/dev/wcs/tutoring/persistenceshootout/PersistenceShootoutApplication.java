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
	public void run(String... args) {
		List<CustomerEntity> inErlangen = customerRepository.findByAddress_City_Name("Erlangen");
		List<CustomerEntity> inErlangenNative = customerRepository.findAllCustomersByCity("Erlangen");

		System.out.println("\n-----------");
		System.out.println("RDBMS / SQL");
		System.out.println("-----------");

		System.out.println("\nAll Customers in Erlangen with Spring Data method signature resolution:");
		System.out.println("-----------------------------------------------------------------------");
		for (CustomerEntity cust : inErlangen) {
			System.out.println(cust.getFirstName() + " " + cust.getLastName());
		}
		System.out.println("\nAll Customers in Erlangen with Spring Data JPQL:");
		System.out.println("------------------------------------------------");
		for (CustomerEntity cust : inErlangenNative) {
			System.out.println(cust.getFirstName() + " " + cust.getLastName());
		}

		System.out.println("\n---------------");
		System.out.println("MongoDB / NoSQL");
		System.out.println("---------------");

		noSqlCustomerRepository.deleteAll();

		noSqlCustomerRepository.save(new Customer("Alice", "Smith"));
		noSqlCustomerRepository.save(new Customer("Bob", "Smith"));

		System.out.println("\nCustomers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : noSqlCustomerRepository.findAll()) {
			System.out.println(customer);
		}

		// fetch an individual customer
		System.out.println("\nCustomer found with findByFirstName('Alice'):");
		System.out.println("---------------------------------------------");
		Customer alice = noSqlCustomerRepository.findByFirstName("Alice");
		addPurchases(alice);
		System.out.println(alice);

		System.out.println("\nCustomers found with findByLastName('Smith'):");
		System.out.println("---------------------------------------------");
		for (Customer customer : noSqlCustomerRepository.findByLastName("Smith")) {
			System.out.println(customer);
		}

		List<Person> matrixers = personRepository.findByActedInMoviesTitle("The Matrix");
		List<Person> bothMovies = personRepository.findByActedInBothMovies("The Matrix", "The Matrix Reloaded");

		System.out.println("\n-------------");
		System.out.println("Neo4j / NoSQL");
		System.out.println("-------------");

		System.out.println("\nAll Actors in The Matrix:");
		System.out.println("-------------------------");
		for (Person matrixer : matrixers) {
			System.out.println(matrixer.getName());
		}

		System.out.println("\nAll Actors in The Matrix AND The Matrix Reloaded:");
		System.out.println("-------------------------------------------------");
		for (Person matrixer : bothMovies) {
			System.out.println(matrixer.getName());
		}

	}

	private void addPurchases(Customer customer) {
		Purchase purchase1 = new Purchase("The Matrix", LocalDate.now().minusDays(100), BigDecimal.valueOf(5.99));
		Purchase purchase2 = new Purchase("Matrix Reloaded", LocalDate.now().minusDays(50), BigDecimal.valueOf(3.49));
		Purchase purchase3 = new Purchase("Matrix Resurrections", LocalDate.now().minusDays(1), BigDecimal.valueOf(1.45));
		customer.setLastPurchases(List.of(purchase1, purchase2, purchase3));
		noSqlCustomerRepository.save(customer);
	}
}
