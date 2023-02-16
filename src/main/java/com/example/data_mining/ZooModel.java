package com.example.data_mining;

public class ZooModel {
    private String animal;
    private double[] attributes;

    public ZooModel(String animal, double[] attributes) {
        this.animal = animal;
        this.attributes = attributes;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public double[] getAttributes() {
        return attributes;
    }

    public void setAttributes(double[] attributes) {
        this.attributes = attributes;
    }
}
