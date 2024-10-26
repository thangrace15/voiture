public abstract class Vehicule {
    protected String immatriculation;
    protected String marque;
    protected String modele;
    protected int anneeMiseEnService;
    protected double kilometrage;
    protected boolean estLoue;

    public Vehicule(String immatriculation, String marque, String modele, int anneeMiseEnService, double kilometrage) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;
        this.anneeMiseEnService = anneeMiseEnService;
        this.kilometrage = kilometrage;
        this.estLoue = false;

    }



    public abstract double calculerPrixLocation();

    public boolean estDisponible()
    {
        return !estLoue;
    }

    public void louer() {
        if (estLoue) {
            throw new VehiculeIndisponibleException("Le véhicule est déjà loué !");
        }
        estLoue = true;
    }

    public void retourner() {
        estLoue = false;
    }

    @Override
    public String toString() {
        return marque + " " + modele + " (" + immatriculation + "), année : " + anneeMiseEnService + ", km : " + kilometrage + (estLoue ? " - Loué" : " - Disponible");
    }
}