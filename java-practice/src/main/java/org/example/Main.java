package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Child child = new Child();
        child.인사();

        Poketmon poketmon = new Poketmon("홍준",PoketmonType.FIRE);
        System.out.println(poketmon.getName());
        System.out.println(poketmon.getType());

        AquaPoketmon aquaPoketmon = new AquaPoketmon("hongjun");
        System.out.println(aquaPoketmon.getName());
        System.out.println(aquaPoketmon.getType());


        Monkey monkey = new Monkey();
        monkey.울다();
    }
}