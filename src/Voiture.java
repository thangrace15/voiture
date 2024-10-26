public class Voiture extends Vehicule implements Louable {
    private int nombrePlaces;
    private String typeCarburant;

    public Voiture(String immatriculation, String marque, String modele, int anneeMiseEnService, double kilometrage, int nombrePlaces, String typeCarburant) {
        super(immatriculation, marque, modele, anneeMiseEnService, kilometrage);
        this.nombrePlaces = nombrePlaces;
        this.typeCarburant = typeCarburant;
    }

    @Override
    public double calculerPrixLocation() {
        return 50.0;
    }
}

