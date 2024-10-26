public class Camion extends Vehicule implements Louable {
    private double capaciteChargement;
    private int nombreEssieux;

    public Camion(String immatriculation, String marque, String modele, int anneeMiseEnService, double kilometrage, double capaciteChargement, int nombreEssieux) {
        super(immatriculation, marque, modele, anneeMiseEnService, kilometrage);
        this.capaciteChargement = capaciteChargement;
        this.nombreEssieux = nombreEssieux;
    }

    @Override
    public double calculerPrixLocation() {
        return 100.0;
    }


}