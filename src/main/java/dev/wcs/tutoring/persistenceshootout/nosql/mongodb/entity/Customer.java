package dev.wcs.tutoring.persistenceshootout.nosql.mongodb.entity;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Customer {

  @Id
  private String id;

  private String firstName;
  private String lastName;
  private List<Purchase> lastPurchases;

  public Customer() {}

  public Customer(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public List<Purchase> getLastPurchases() {
    return lastPurchases;
  }

  public void setLastPurchases(List<Purchase> lastPurchases) {
    this.lastPurchases = lastPurchases;
  }

  @Override
  public String toString() {
    return String.format(
        "Customer[id=%s, firstName='%s', lastName='%s']",
        id, firstName, lastName);
  }

}