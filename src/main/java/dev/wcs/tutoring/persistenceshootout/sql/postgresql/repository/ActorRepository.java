package dev.wcs.tutoring.persistenceshootout.sql.postgresql.repository;

import dev.wcs.tutoring.persistenceshootout.sql.postgresql.entity.ActorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends CrudRepository<ActorEntity, Integer> {

    List<ActorEntity> findAllByFirstName(String firstName);
    List<ActorEntity> findActorEntitiesByFirstNameContaining(String firstName);

}
