package dev.wcs.tutoring.persistenceshootout.nosql.neo4j.entity;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node(primaryLabel = "Person")
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer born;

    @Relationship("DIRECTED")
    List<Movie> directedMovies;

    @Relationship("ACTED_IN")
    List<Movie> actedInMovies;

    @Relationship("REVIEWED")
    List<ReviewRelationship> reviewedMovies;

    @Relationship("PRODUCED")
    List<Movie> producedMovies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBorn() {
        return born;
    }

    public void setBorn(Integer born) {
        this.born = born;
    }

    public List<Movie> getDirectedMovies() {
        return directedMovies;
    }

    public void setDirectedMovies(List<Movie> directedMovies) {
        this.directedMovies = directedMovies;
    }

    public List<Movie> getActedInMovies() {
        return actedInMovies;
    }

    public void setActedInMovies(List<Movie> actedInMovies) {
        this.actedInMovies = actedInMovies;
    }

    public List<ReviewRelationship> getReviewedMovies() {
        return reviewedMovies;
    }

    public void setReviewedMovies(List<ReviewRelationship> reviewedMovies) {
        this.reviewedMovies = reviewedMovies;
    }

    public List<Movie> getProducedMovies() {
        return producedMovies;
    }

    public void setProducedMovies(List<Movie> producedMovies) {
        this.producedMovies = producedMovies;
    }
}