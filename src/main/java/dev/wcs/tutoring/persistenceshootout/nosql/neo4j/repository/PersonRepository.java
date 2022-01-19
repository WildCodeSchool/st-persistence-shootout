package dev.wcs.tutoring.persistenceshootout.nosql.neo4j.repository;

import java.util.List;

import dev.wcs.tutoring.persistenceshootout.nosql.neo4j.entity.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

public interface PersonRepository extends Neo4jRepository<Person, Long> {

  List<Person> findByActedInMoviesTitle(String actedInMovieTitle);

  @Query("MATCH (m:Movie {title: $title1})<-[r1:ACTED_IN]-(p:Person)-[r2:ACTED_IN]->(n:Movie {title: $title2}) RETURN p")
  List<Person> findByActedInBothMovies(String title1, String title2);

}
