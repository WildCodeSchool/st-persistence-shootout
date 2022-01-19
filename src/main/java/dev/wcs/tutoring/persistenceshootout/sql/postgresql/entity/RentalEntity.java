package dev.wcs.tutoring.persistenceshootout.sql.postgresql.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "rental", schema = "public", catalog = "dvdrental")
public class RentalEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "rental_id")
    private int rentalId;
    @Basic
    @Column(name = "rental_date")
    private Timestamp rentalDate;
    @Basic
    @Column(name = "inventory_id")
    private int inventoryId;
    @Basic
    @Column(name = "customer_id")
    private short customerId;
    @Basic
    @Column(name = "return_date")
    private Timestamp returnDate;
    @Basic
    @Column(name = "staff_id")
    private short staffId;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false, insertable=false, updatable=false)
    private CustomerEntity customerByCustomerId;

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public Timestamp getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Timestamp rentalDate) {
        this.rentalDate = rentalDate;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public short getCustomerId() {
        return customerId;
    }

    public void setCustomerId(short customerId) {
        this.customerId = customerId;
    }

    public Timestamp getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Timestamp returnDate) {
        this.returnDate = returnDate;
    }

    public short getStaffId() {
        return staffId;
    }

    public void setStaffId(short staffId) {
        this.staffId = staffId;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentalEntity that = (RentalEntity) o;
        return rentalId == that.rentalId && inventoryId == that.inventoryId && customerId == that.customerId && staffId == that.staffId && Objects.equals(rentalDate, that.rentalDate) && Objects.equals(returnDate, that.returnDate) && Objects.equals(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rentalId, rentalDate, inventoryId, customerId, returnDate, staffId, lastUpdate);
    }

    public CustomerEntity getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(CustomerEntity customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }

}
