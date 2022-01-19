package dev.wcs.tutoring.persistenceshootout.nosql.neo4j.entity;

import org.springframework.data.neo4j.core.schema.*;

@RelationshipProperties
public class ReviewRelationship {
    @Id
    @GeneratedValue
    private final Long neoId;

    private String summary;
    private Integer rating;

    @TargetNode
    private Movie movieEntity;

    public ReviewRelationship(Long neoId, String summary, Integer rating) {
        this.neoId = neoId;
        this.summary = summary;
        this.rating = rating;
    }

    public Long getNeoId() {
        return neoId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Movie getMovieEntity() {
        return movieEntity;
    }

    public void setMovieEntity(Movie movieEntity) {
        this.movieEntity = movieEntity;
    }
}