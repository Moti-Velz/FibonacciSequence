import utils.FibonacciRunner;

import java.util.Scanner;
import java.util.InputMismatchException;

import java.util.InputMismatchException;
import java.util.Scanner;

//OverFlow à partir du 93e index
public class Main {
    /**
     * Méthode principale qui s'exécute lors du lancement du programme.
     *
     * @param args les arguments de ligne de commande (non utilisés dans ce programme)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (option != 2) {
            // Affichage du menu
            System.out.println("\nMenu:");
            System.out.println("1. Exécutez Fibonacci.");
            System.out.println("2. Quitter.");
            System.out.print("Choisissez une option: ");

            try {
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        boolean invalidInput = false;  // Indicateur d'entrées invalides
                        do {
                            System.out.println("Entrez l'indice n-ième voulu de la suite de Fibonacci \n" +
                                    "La suite est affichée de 0 à 92\n" +
                                    "Le temps d'exécution est affiché de 0 à 7500");
                            try {
                                int n = scanner.nextInt();
                                if (n < 0) {
                                    System.out.println("Veuillez entrer un nombre entier positif.");
                                    invalidInput = true;
                                } else if (n > 7500) {
                                    System.out.println("Veuillez entrer un nombre inférieur ou égal à 7500");
                                    invalidInput = true;
                                } else {
                                    invalidInput = false;
                                    // Création et exécution du runner Fibonacci
                                    FibonacciRunner gameEngine = new FibonacciRunner();
                                    gameEngine.run(n);
                                }
                            } catch (InputMismatchException ime) {
                                System.out.println("Veuillez entrer un nombre entier valide.");
                                scanner.next();
                                invalidInput = true;
                            }
                        } while (invalidInput);  // Loop jusqu'a une entrée valide
                        break;
                    case 2:
                        // Sortie du programme
                        System.out.println("Sortie du programme.");
                        break;
                    default:
                        // Gestion des options invalides
                        System.out.println("Option invalide. Veuillez réessayer.");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Veuillez entrer un nombre entier valide.");
                scanner.next();
            }
        }

        // Fermeture du scanner après utilisation
        scanner.close();
    }

}
