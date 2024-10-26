import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        ParcAutomobile parc = new ParcAutomobile();
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;

        while (continuer) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Ajouter un véhicule");
            System.out.println("2. Ajouter un client");
            System.out.println("3. Louer un véhicule");
            System.out.println("4. Retourner un véhicule");
            System.out.println("5. Lister les véhicules disponibles");
            System.out.println("6. Lister les véhicules loués");
            System.out.println("7. Quitter");
            System.out.print("Choisissez une option: ");

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    ajouterVehicule(parc, scanner);
                    break;
                case 2:
                    ajouterClient(parc, scanner);
                    break;
                case 3:
                    louerVehicule(parc, scanner);
                    break;
                case 4:
                    retournerVehicule(parc, scanner);
                    break;
                case 5:
                    listerVehiculesDisponibles(parc);
                    break;
                case 6:
                    listerVehiculesLoues(parc);
                    break;
                case 7:
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide.");
                    break;
            }
        }

        scanner.close();
    }

    private static void ajouterVehicule(ParcAutomobile parc, Scanner scanner) {
        System.out.println("Quel type de véhicule souhaitez-vous ajouter ?");
        System.out.println("1. Voiture");
        System.out.println("2. Camion");
        int type = scanner.nextInt();
        scanner.nextLine();  // Consommer la ligne restante

        System.out.print("Immatriculation: ");
        String immatriculation = scanner.nextLine();
        System.out.print("Marque: ");
        String marque = scanner.nextLine();
        System.out.print("Modèle: ");
        String modele = scanner.nextLine();
        System.out.print("Année de mise en service: ");
        int annee = scanner.nextInt();
        System.out.print("Kilométrage: ");
        double kilometrage = scanner.nextDouble();
        scanner.nextLine();  // Consommer la ligne restante

        if (type == 1) {
            System.out.print("Nombre de places: ");
            int nombrePlaces = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Type de carburant (essence, diesel, électrique): ");
            String typeCarburant = scanner.nextLine();
            parc.ajouterVehicule(new Voiture(immatriculation, marque, modele, annee, kilometrage, nombrePlaces, typeCarburant));
            System.out.println("Voiture ajoutée avec succès.");
        } else if (type == 2) {
            System.out.print("Capacité de chargement (en tonnes): ");
            double capacite = scanner.nextDouble();
            System.out.print("Nombre d'essieux: ");
            int essieux = scanner.nextInt();
            parc.ajouterVehicule(new Camion(immatriculation, marque, modele, annee, kilometrage, capacite, essieux));
            System.out.println("Camion ajouté avec succès.");
        } else {
            System.out.println("Type de véhicule non valide.");
        }
    }

    private static void ajouterClient(ParcAutomobile parc, Scanner scanner) {
        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Prénom: ");
        String prenom = scanner.nextLine();
        System.out.print("Numéro de permis: ");
        String numeroPermis = scanner.nextLine();
        System.out.print("Numéro de téléphone: ");
        String telephone = scanner.nextLine();
        parc.ajouterClient(new Client(nom, prenom, numeroPermis, telephone));
        System.out.println("Client ajouté avec succès.");
    }

    private static void louerVehicule(ParcAutomobile parc, Scanner scanner) {
        System.out.print("Entrez le nom du client: ");
        String nomClient = scanner.nextLine();
        Client client = parc.trouverClient(nomClient);

        if (client == null) {
            System.out.println("Client non trouvé.");
            return;
        }

        System.out.println("Liste des véhicules disponibles : ");
        listerVehiculesDisponibles(parc);

        System.out.print("Immatriculation du véhicule à louer: ");
        String immatriculation = scanner.nextLine();
        Vehicule vehicule = parc.trouverVehicule(immatriculation);

        if (vehicule == null || !vehicule.estDisponible()) {
            System.out.println("Véhicule non disponible.");
            return;
        }

        try {
            client.louerVehicule(vehicule);
            System.out.println("Véhicule loué avec succès.");
        } catch (VehiculeIndisponibleException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void retournerVehicule(ParcAutomobile parc, Scanner scanner) {
        System.out.print("Entrez l'immatriculation du véhicule à retourner: ");
        String immatriculation = scanner.nextLine();
        Vehicule vehicule = parc.trouverVehicule(immatriculation);

        if (vehicule == null || vehicule.estDisponible()) {
            System.out.println("Ce véhicule n'est pas actuellement loué.");
            return;
        }

        vehicule.retourner();
        System.out.println("Véhicule retourné avec succès.");
    }

    private static void listerVehiculesDisponibles(ParcAutomobile parc) {
        System.out.println("Véhicules disponibles :");
        for (Vehicule vehicule : parc.getVehiculesDisponibles()) {
            System.out.println(vehicule);
        }
    }

    private static void listerVehiculesLoues(ParcAutomobile parc) {
        System.out.println("Véhicules loués :");
        for (Vehicule vehicule : parc.getVehiculesLoue()) {
            System.out.println(vehicule);
        }
    }
}