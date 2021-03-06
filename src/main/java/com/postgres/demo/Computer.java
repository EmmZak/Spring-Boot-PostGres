package com.postgres.demo;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.*;

@Entity(name="computer")
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private double price;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name="player_id", referencedColumnName="id")
    private Player player;

    public Computer() {}

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Computer(String brand, double price) {
        this.brand=brand;
        this.price=price;
    }

    public Player getPlayer() {
        return player;
    }

    public Long getId() {return id; }
    public void setId(Long id) {this.id=id; }

    public String getBrand() {return brand; }
    public void setBrand(String brand) {this.brand=brand; }

    public double getPrice() {return price; }
    public void setPrice(double price) {this.price=price; }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", player=" + player.getName() +
                '}';
    }
}
