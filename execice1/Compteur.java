package com.company.execice1;

public class Compteur extends Thread {
    protected String nom;
    protected int max;

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
        System.out.println("*** " + nom + " a fini de compter jusqu'à " + max);
    }

    public static void main(String[] args) {
        Compteur[] compteurs = {
                new Compteur("Toto"),
                new Compteur("Bibi"),
                new Compteur("Robert"),
                new Compteur("Pierre")
        };
        for (int i = 0; i < compteurs.length; i++) {
            compteurs[i].start();
        }
    }

}