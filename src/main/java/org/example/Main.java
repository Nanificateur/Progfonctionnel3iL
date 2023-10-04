package org.example;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/personnes.csv"; // Chemin du fichier CSV

        try {
            List<Eleve> eleves = Files.lines(Paths.get(filePath))
                    .skip(1)  // Ignorer la première ligne
                    .map(line -> {
                        String[] parts = line.split(",");
                        String nom = parts[0];
                        double note = Double.parseDouble(parts[1].trim());
                        return new Eleve(nom, note);
                    })
                    .sorted(Comparator
                            .<Eleve>comparingDouble(Eleve::getAge)
                            .reversed()  // Tri par âge décroissant
                            .thenComparing(eleve -> eleve.getNom().toLowerCase()) // Tri par prénom croissant
                    )
                    .collect(Collectors.toList());

            // Afficher les élèves triés
            eleves.forEach(eleve -> log.info("Élève : {}", eleve));
        } catch (IOException e) {
            log.error("Une erreur est survenue lors de la lecture du fichier : {}", e.getMessage());
        }
    }
}
