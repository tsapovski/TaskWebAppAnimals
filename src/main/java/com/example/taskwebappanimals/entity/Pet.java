package com.example.taskwebappanimals.entity;

import java.io.Serializable;
import java.util.Objects;

public class Pet implements Serializable {
    private int id;
    private String typePet;
    private String name;
    private int age;
    private String color;
    private boolean ownerStatus;

    public Pet() {
    }

    public Pet(String typePet, String name, int age, String color, boolean ownerStatus) {
        this.typePet = typePet;
        this.name = name;
        this.age = age;
        this.color = color;
        this.ownerStatus = ownerStatus;
    }

    public Pet(int id, String typePet, String name, int age, String color, boolean ownerStatus) {
        this.id = id;
        this.typePet = typePet;
        this.name = name;
        this.age = age;
        this.color = color;
        this.ownerStatus = ownerStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypePet() {
        return typePet;
    }

    public void setTypePet(String typePet) {
        this.typePet = typePet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isOwnerStatus() {
        return ownerStatus;
    }

    public void setOwnerStatus(boolean ownerStatus) {
        this.ownerStatus = ownerStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return getId() == pet.getId() && getAge() == pet.getAge() && isOwnerStatus() == pet.isOwnerStatus() && getTypePet().equals(pet.getTypePet()) && getName().equals(pet.getName()) && getColor().equals(pet.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTypePet(), getName(), getAge(), getColor(), isOwnerStatus());
    }
}