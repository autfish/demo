package com.autfish._designPatterns.lesson19.mediator;

public class MeituanMediator extends Mediator {

    private Colleague customer;
    private Colleague restaurant;
    private Colleague deliveryMan;

    @Override
    public void send(String message, String from) {
        switch (from) {
            case "Customer":
                restaurant.receive(message, from);
                break;
            case "Restaurant":
                deliveryMan.receive(message, from);
                break;
            case "DeliveryMan":
                customer.receive(message, from);
                break;
        }
    }

    public void setCustomer(Colleague customer) {
        this.customer = customer;
    }

    public void setRestaurant(Colleague restaurant) {
        this.restaurant = restaurant;
    }

    public void setDeliveryMan(Colleague deliveryMan) {
        this.deliveryMan = deliveryMan;
    }
}
