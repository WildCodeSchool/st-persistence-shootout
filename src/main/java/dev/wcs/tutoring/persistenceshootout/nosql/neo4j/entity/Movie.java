package dev.wcs.tutoring.persistenceshootout.nosql.neo4j.entity;

import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node("Movie")
public class Movie {

  @Id
  private String title;

  private String tagline;

  @Property("released")
  private Integer yearOfRelease;

  @Version
  private Long version;

  @Relationship(value = "ACTED_IN", direction = Relationship.Direction.INCOMING)
  List<Person> actedInMovies;

  public Movie() {}

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getTagline() {
    return tagline;
  }

  public void setTagline(String tagline) {
    this.tagline = tagline;
  }

  public Integer getYearOfRelease() {
    return yearOfRelease;
  }

  public void setYearOfRelease(Integer yearOfRelease) {
    this.yearOfRelease = yearOfRelease;
  }

  public List<Person> getActedInMovies() {
    return actedInMovies;
  }

  public void setActedInMovies(List<Person> actedInMovies) {
    this.actedInMovies = actedInMovies;
  }

  @Override
  public String toString() {
    return "Movie{" +
            "title='" + title + '\'' +
            ", tagline='" + tagline + '\'' +
            ", yearOfRelease=" + yearOfRelease +
            '}';
  }
}