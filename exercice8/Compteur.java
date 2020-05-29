package com.company.exercice8;

public class Compteur extends Thread {
    private String nom;
    private int max;
    private static int ordre = 1;

    public Compteur(String nom, int max) {
        this.nom = nom;
        this.max = max;
    }

    public Compteur(String nom) {
        this(nom, 10);
    }

    public void run() {
        for (int i = 1; i <= max; i++) {
            try {
                sleep((int)(Math.random() * 5000));
            }
            catch(InterruptedException e) {
                System.err.println(nom + " a ete interrompu.");
            }
            System.out.println(nom + " : " + i);
        }
        System.out.println("*** " + nom + " a termine en position " + ordre++);
    }

    public static void main(String[] args) {
        com.company.execice1.Compteur[] compteurs = {
                new com.company.execice1.Compteur("Toto"),
                new com.company.execice1.Compteur("Bibi"),
                new com.company.execice1.Compteur("Robert"),
                new com.company.execice1.Compteur("Pierre")
        };
        for (int i = 0; i < compteurs.length; i++) {
            compteurs[i].start();
        }
    }
}
