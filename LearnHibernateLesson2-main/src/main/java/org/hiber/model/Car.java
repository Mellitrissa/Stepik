package org.hiber.model;

import jakarta.persistence.*;

@Entity
@Table (name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    @ManyToOne()
    @JoinColumn(name= "userId")
    private User owner;
    public Car (){
    }
    public Car(String model){
        this.model=model;
    }
    public String getModel(String model){
        return model;
    }
    public void setModel(String model){
        this.model=model;
    }
    public User getOwner(User owner){
        return owner;
    }
    public void setOwner(User owner){
        this.owner=owner;
    }
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", owner='" + owner + '}';
    }
}
