package Lab4;
enum Zona_mag {Expus,Achizitionat,Vandut;}
class Echipament{
    String nume;
    int nr_inv;
    int pret;
    Zona_mag zona_specifica;
    public Echipament(String nume, int nr_inv,int pret,Zona_mag zona) {
        this.nume = nume;
        this.nr_inv = nr_inv;
        this.zona_specifica = zona;
        this.pret = pret;
    }
}
