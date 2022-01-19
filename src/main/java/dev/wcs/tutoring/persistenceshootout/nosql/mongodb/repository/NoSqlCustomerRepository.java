package dev.wcs.tutoring.persistenceshootout.nosql.mongodb.repository;

import java.util.List;

import dev.wcs.tutoring.persistenceshootout.nosql.mongodb.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoSqlCustomerRepository extends MongoRepository<Customer, String> {

  Customer findByFirstName(String firstName);
  List<Customer> findByLastName(String lastName);

}