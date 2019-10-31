package com.autfish._designPatterns.lesson19.mediator;

public class Client {
    public static void main(String[] args) {

        MeituanMediator meituanMediator = new MeituanMediator();

        Colleague customer = new Customer(meituanMediator);
        Colleague restaurant = new Restaurant(meituanMediator);
        Colleague deliveryMan = new DeliveryMan(meituanMediator);

        meituanMediator.setCustomer(customer);
        meituanMediator.setRestaurant(restaurant);
        meituanMediator.setDeliveryMan(deliveryMan);

        customer.send("订一份披萨");
        restaurant.send("披萨打包完毕");
        deliveryMan.send("30分钟后送到");
    }
}
