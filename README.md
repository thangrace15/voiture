# Projet de Gestion de Parc Automobile

## Description
Ce projet est une application console permettant à une entreprise de location de gérer son parc automobile. L'application inclut des fonctionnalités pour gérer les véhicules, les clients, et les locations. Le projet met en œuvre les concepts de Programmation Orientée Objet (POO) tels que l'héritage, le polymorphisme, l'encapsulation, et la gestion des exceptions.

## Fonctionnalités
- **Ajouter un véhicule** : Permet d'ajouter un véhicule (voiture ou camion) avec les informations nécessaires (immatriculation, marque, modèle, etc.).
- **Ajouter un client** : Ajoute un client avec des informations personnelles telles que le nom, prénom, numéro de permis, etc.
- **Louer un véhicule** : Permet à un client de louer un véhicule disponible.
- **Retourner un véhicule** : Permet de marquer un véhicule loué comme disponible.
- **Lister les véhicules disponibles** : Affiche tous les véhicules actuellement disponibles.
- **Lister les véhicules loués** : Affiche tous les véhicules actuellement en location.

## Structure du Projet

### Classes Principales

1. **Classe `Vehicule`** : Classe abstraite définissant les attributs de base pour tous les véhicules, incluant la méthode abstraite `calculerPrixLocation()`.

2. **Sous-classes `Voiture` et `Camion`** :
   - `Voiture` : Représente les voitures avec des attributs supplémentaires comme le nombre de places et le type de carburant.
   - `Camion` : Représente les camions avec des attributs spécifiques comme la capacité de chargement et le nombre d'essieux.
   - Ces classes implémentent l'interface `Louable`.

3. **Interface `Louable`** :
   - Définit les méthodes `louer()` et `retourner()` pour gérer le statut des véhicules.
   - Implémentée par les classes `Voiture` et `Camion`.

4. **Classe `Client`** :
   - Contient les informations des clients et gère les véhicules actuellement loués par chaque client.

5. **Classe `ParcAutomobile`** :
   - Contient les collections de véhicules et de clients, et fournit des méthodes pour ajouter des véhicules et des clients ainsi que pour rechercher des véhicules et des clients.

6. **Exceptions Personnalisées** :
   - `VehiculeIndisponibleException` : Levée lorsqu'un véhicule indisponible est demandé pour location.
   - `ClientNonAutoriseException` : Peut être utilisée pour restreindre la location de certains véhicules selon le permis du client.

7. **Classe `Application`** :
   - Contient le point d'entrée `main()` de l'application.
   - Affiche un menu interactif pour naviguer entre les fonctionnalités de gestion du parc automobile.

## Concepts de POO Utilisés

- **Encapsulation** : Les données des classes sont protégées et accessibles uniquement via des méthodes définies.
- **Héritage** : Les classes `Voiture` et `Camion` héritent de la classe `Vehicule` pour éviter la duplication de code.
- **Polymorphisme** : La méthode `calculerPrixLocation()` est définie de manière polymorphe dans `Vehicule`, avec des implémentations spécifiques dans `Voiture` et `Camion`.
- **Gestion des Exceptions** : Utilisation d'exceptions personnalisées pour gérer les erreurs spécifiques liées à la location et au retour de véhicules.

## Utilisation de l'Application

1. Clonez le dépôt et assurez-vous que toutes les classes sont bien compilées.
2. Lancez la classe `Application`.
3. Suivez les instructions du menu pour ajouter des véhicules, ajouter des clients, gérer les locations, et lister les véhicules.

## Exemple d'Exécution

- **Ajout d'un véhicule** :
   - Choisissez d'ajouter une voiture ou un camion, entrez les informations nécessaires, et le véhicule sera ajouté au parc.

- **Location d'un véhicule** :
   - Sélectionnez un client existant, choisissez un véhicule disponible, et la location sera enregistrée. Si le véhicule est déjà loué, une exception sera levée.

- **Retour d'un véhicule** :
   - Choisissez un véhicule loué pour le marquer comme retourné et disponible pour de nouvelles locations.

## Structure des Fichiers

- **src/** : Contient tous les fichiers source Java.
- **README.md** : Ce fichier, expliquant le fonctionnement et la structure du projet.
- **lib/** : Contient des bibliothèques supplémentaires si nécessaire.

## Prérequis

- **Java 8** ou une version ultérieure
- **Git** pour cloner le dépôt

## Installation

1. Clonez le dépôt :
   ```bash
   git clone https://github.com/Univers10/projetHotelAkylium.git
