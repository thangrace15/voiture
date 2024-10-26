import java.util.ArrayList;
import java.util.List;

public class Client {
     public String nom;
     public String prenom;
    private String numeroPermis;
    private String telephone;
    private List<Vehicule> locationsEnCours;

    public Client(String nom, String prenom, String numeroPermis, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroPermis = numeroPermis;
        this.telephone = telephone;
        this.locationsEnCours = new ArrayList<>();
    }

    public void louerVehicule(Vehicule vehicule) {
        vehicule.louer();
        locationsEnCours.add(vehicule);
    }

    public void retournerVehicule(Vehicule vehicule) {
        vehicule.retourner();
        locationsEnCours.remove(vehicule);
    }
}