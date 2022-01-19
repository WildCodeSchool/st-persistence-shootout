package dev.wcs.tutoring.persistenceshootout.sql.postgresql.repository;

import dev.wcs.tutoring.persistenceshootout.sql.postgresql.entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {

    List<CustomerEntity> findCustomerEntitiesByAddressByAddressId_CityByCityId_City(String city);

    @Query(value = "select cust from CustomerEntity cust inner join cust.addressByAddressId a inner join a.cityByCityId c where c.city=:city")
    List<CustomerEntity> findAllCustomersByCity(String city);

}
