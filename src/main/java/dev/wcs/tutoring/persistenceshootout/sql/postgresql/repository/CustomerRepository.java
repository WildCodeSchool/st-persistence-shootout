package dev.wcs.tutoring.persistenceshootout.sql.postgresql.repository;

import dev.wcs.tutoring.persistenceshootout.sql.postgresql.entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {

    List<CustomerEntity> findByAddress_City_Name(String city);

    @Query(value = "select cust from CustomerEntity cust inner join cust.address a inner join a.city c where c.name=:city")
    List<CustomerEntity> findAllCustomersByCity(String city);

}
