package com.example.demo;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Table("items")
public class Item {
    @PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
    private UUID id = UUID.randomUUID();
    private String name;
    private double price;

    @CreatedBy
    private String purchaser;
    @CreatedDate
    private LocalDateTime boughtOn;

    public Item() {
    }

    public Item(UUID id, String name, double price, String purchaser, LocalDateTime boughtOn) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.purchaser = purchaser;
        this.boughtOn = boughtOn;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(String purchaser) {
        this.purchaser = purchaser;
    }

    public LocalDateTime getBoughtOn() {
        return boughtOn;
    }

    public void setBoughtOn(LocalDateTime boughtOn) {
        this.boughtOn = boughtOn;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", purchaser='" + purchaser + '\'' +
                ", boughtOn=" + boughtOn +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.price, price) == 0 && Objects.equals(id, item.id) && Objects.equals(name, item.name) && Objects.equals(purchaser, item.purchaser) && Objects.equals(boughtOn, item.boughtOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, purchaser, boughtOn);
    }
}
