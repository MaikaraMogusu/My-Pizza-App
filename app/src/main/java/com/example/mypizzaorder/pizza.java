package com.example.mypizzaorder;

public class pizza {
  double pizza_size_price=0;
  double meat_price=0;
  double cheese_price=0;
  double veggies_price=0;


    public pizza() {
    }

    public double getPizza_size_price() {
        return pizza_size_price;
    }

    public void setPizza_size_price(double pizza_size_price) {
        this.pizza_size_price = pizza_size_price;
    }

    public double getMeat_price() {
        return meat_price;
    }

    public void setMeat_price(double meat_price) {
        this.meat_price = meat_price;
    }

    public double getCheese_price() {
        return cheese_price;
    }

    public void setCheese_price(double cheese_price) {
        this.cheese_price = cheese_price;
    }

    public double getVeggies_price() {
        return veggies_price;
    }

    public void setVeggies_price(double veggies_price) {
        this.veggies_price = veggies_price;
    }

}
