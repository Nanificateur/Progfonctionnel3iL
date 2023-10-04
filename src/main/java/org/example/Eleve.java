package org.example;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Eleve {
    private String nom;
    private double note;

    public double getNote() {
        return note;
    }

    public String getNom() {
        return nom;
    }

    // Getter pour l'âge (à partir de la note pour cet exemple)
    public int getAge() {
        return (int) note; // Conversion de la note en int pour cet exemple
    }
}
