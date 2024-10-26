import java.util.ArrayList;
import java.util.List;

public class ParcAutomobile {
    private List<Vehicule> vehicules;
    private List<Client> clients;

    public ParcAutomobile() {
        vehicules = new ArrayList<>();
        clients = new ArrayList<>();
    }



    public void ajouterVehicule(Vehicule vehicule) {
        vehicules.add(vehicule);
    }



    public void ajouterClient(Client client) {
        clients.add(client);
    }



    public List<Vehicule> getVehiculesDisponibles() {
        List<Vehicule> disponibles = new ArrayList<>();
        for (Vehicule v : vehicules) {
            if (v.estDisponible()) {
                disponibles.add(v);
            }
        }
        return disponibles;
    }



    public List<Vehicule> getVehiculesLoue() {
        List<Vehicule> loues = new ArrayList<>();
        for (Vehicule v : vehicules) {
            if (!v.estDisponible()) {
                loues.add(v);
            }
        }
        return loues;
    }



    public Vehicule trouverVehicule(String immatriculation) {
        for (Vehicule vehicule : vehicules) {
            if (vehicule.immatriculation.equals(immatriculation)) {
                return vehicule;
            }
        }
        return null;

    }



    public Client trouverClient(String nom
    ) {
        for (Client client : clients) {
            if (client.nom.equals(nom)) {
                return client;
            }
        }
        return null;

    }
}