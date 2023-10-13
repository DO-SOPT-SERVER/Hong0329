package org.example;

public class Poketmon {
    private String name;
    private PoketmonType type;

    public Poketmon() {
    }

    // 생성자 추가
    public Poketmon(String name, PoketmonType type) {
        this.name = name;
        this.type = type;
    }

    public Poketmon(PoketmonType type) {
        this.type = type;
    }

    public String getName(){
        return name;
    }

    public PoketmonType getType() {
        return type;
    }
}