package Lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
enum Mod_tiparire {color, alb_negru;}
enum Format {A3,A4;}
enum Operare {Windows, Linux;}
class Imprimante extends Echipament{
    int ppm,p_car;
    String rezolutie;
    Mod_tiparire mod;
    public Imprimante(String nume, int nr_inv,int pret,Zona_mag zona,int ppm,String rez,int nrpg,Mod_tiparire mod) {
        super(nume, nr_inv,pret,zona);
        this.ppm = ppm;
        this.rezolutie = rez;
        this.p_car = nrpg;
        this.mod = mod;

    }
}
class Copiatoare extends Echipament{
    int p_ton;
    Format f;
    public Copiatoare(String nume, int nr_inv,int pret,Zona_mag zona,int p_ton,Format f){
        super(nume, nr_inv,pret,zona);
        this.p_ton = p_ton;
        this.f = f;
    }
}
class Sisteme extends Echipament{
    String tip_mon;
    int  capacitate;
    double vit_proc;
    Operare sis;
    public Sisteme(String nume, int nr_inv,int pret,Zona_mag zona,String tip_mon,double vit,int c,Operare sis){
        super(nume, nr_inv,pret,zona);
        this.tip_mon = tip_mon;
        this.capacitate=c;
        this.vit_proc=vit;
        this.sis=sis;

    }
}
public class p1 {
    public static void main(String[] args) throws FileNotFoundException {
        int opt = 0;
        String form,si,cop;
        Scanner scann = new Scanner(System.in);
        List<Echipament> listaE = new ArrayList<Echipament>();
        Scanner sc = new Scanner(new File("C:\\Users\\Aquiris\\IdeaProjects\\Laborator4\\src\\Lab4\\Echipament.javagit "));
        String[] s;
        String n,st;
        while (sc.hasNextLine()) {
            s = sc.nextLine().split(";");
            if (s[5].compareTo("imprimanta") == 0) {
                if (s[3].compareTo("A") == 0)
                    listaE.add(new Imprimante(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), Zona_mag.Achizitionat, Integer.parseInt(s[6]), s[7], Integer.parseInt(s[8]), Mod_tiparire.color));
                if (s[3].compareTo("B") == 0)
                    listaE.add(new Imprimante(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), Zona_mag.Expus, Integer.parseInt(s[6]), s[7], Integer.parseInt(s[8]), Mod_tiparire.color));
                if (s[3].compareTo("C") == 0)
                    listaE.add(new Imprimante(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), Zona_mag.Vandut, Integer.parseInt(s[6]), s[7], Integer.parseInt(s[8]), Mod_tiparire.color));

            } else {
                if (s[5].compareTo("copiator") == 0) {
                    if (s[3].compareTo("A") == 0)
                        if (s[7].compareTo("A4") == 0)
                            listaE.add(new Copiatoare(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), Zona_mag.Achizitionat, Integer.parseInt(s[6]), Format.A4));
                        else
                            listaE.add(new Copiatoare(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), Zona_mag.Achizitionat, Integer.parseInt(s[6]), Format.A3));
                    if (s[3].compareTo("B") == 0)
                        if (s[7].compareTo("A4") == 0)
                            listaE.add(new Copiatoare(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), Zona_mag.Expus, Integer.parseInt(s[6]), Format.A4));
                        else
                            listaE.add(new Copiatoare(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), Zona_mag.Expus, Integer.parseInt(s[6]), Format.A3));
                    if (s[3].compareTo("C") == 0)
                        if (s[7].compareTo("A4") == 0)
                            listaE.add(new Copiatoare(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), Zona_mag.Vandut, Integer.parseInt(s[6]), Format.A4));
                        else
                            listaE.add(new Copiatoare(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), Zona_mag.Vandut, Integer.parseInt(s[6]), Format.A3));
                }
            }
            if (s[5].compareTo("sistem de calcul") == 0) {
                if (s[3].compareTo("A") == 0)
                    if (s[9].compareTo("linux") == 0)
                        listaE.add(new Sisteme(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), Zona_mag.Achizitionat, s[6], Double.parseDouble(s[7]), Integer.parseInt(s[8]), Operare.Linux));
                    else
                        listaE.add(new Sisteme(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), Zona_mag.Achizitionat, s[6], Double.parseDouble(s[7]), Integer.parseInt(s[8]), Operare.Windows));

                if (s[3].compareTo("B") == 0)
                    if (s[9].compareTo("linux") == 0)
                        listaE.add(new Sisteme(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), Zona_mag.Expus, s[6], Double.parseDouble(s[7]), Integer.parseInt(s[8]), Operare.Linux));
                    else
                        listaE.add(new Sisteme(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), Zona_mag.Expus, s[6], Double.parseDouble(s[7]), Integer.parseInt(s[8]), Operare.Windows));

                if (s[3].compareTo("C") == 0)
                    if (s[9].compareTo("linux") == 0)
                        listaE.add(new Sisteme(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), Zona_mag.Vandut, s[6], Double.parseDouble(s[7]), Integer.parseInt(s[8]), Operare.Linux));
                    else
                        listaE.add(new Sisteme(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), Zona_mag.Vandut, s[6], Double.parseDouble(s[7]), Integer.parseInt(s[8]), Operare.Windows));
            }
        }
        do {
            System.out.println("1.Afişarea tuturor echipamentelor");
            System.out.println("2.Afişarea tuturor imprimantelor");
            System.out.println("3.Afişarea tuturor copiatoarelor");
            System.out.println("4.Afişarea tuturor sistemelor de calcul");
            System.out.println("5.Modificarea stării în care se află un echipament ");
            System.out.println("6.Setarea unui anumit mod de scriere pentru o imprimantă ");
            System.out.println("7.Setarea unui format de copiere pentru copiatoare");
            System.out.println("8.Instalarea unui anumit sistem de operare pe un sistem de calcul ");
            System.out.println("9.Afişarea echipamentelor vândute");
            System.out.println("Da-ti optiunea ");
            opt = scann.nextInt();
            switch (opt) {
                case 1:
                    for (Echipament echipament : listaE) {
                        if (echipament instanceof Imprimante) {
                            Imprimante imprimanta = (Imprimante) echipament;
                            System.out.println("Imprimanta: nume=" + imprimanta.nume +
                                    ", nr inventar=" + imprimanta.nr_inv +
                                    ", pret=" + imprimanta.pret +
                                    ", zona=" + imprimanta.zona_specifica +
                                    ", ppm=" + imprimanta.ppm +
                                    ", rezolutie=" + imprimanta.rezolutie +
                                    ", p_car=" + imprimanta.p_car +
                                    ", mod=" + imprimanta.mod);
                        } else if (echipament instanceof Copiatoare) {
                            Copiatoare copiator = (Copiatoare) echipament;
                            System.out.println("Copiator: nume=" + copiator.nume +
                                    ", nr_inv=" + copiator.nr_inv +
                                    ", pret=" + copiator.pret +
                                    ", zona=" + copiator.zona_specifica +
                                    ", p_ton=" + copiator.p_ton +
                                    ", format=" + copiator.f);
                        } else if (echipament instanceof Sisteme) {
                            Sisteme sistem = (Sisteme) echipament;
                            System.out.println("Sistem: nume=" + sistem.nume +
                                    ", nr_inv=" + sistem.nr_inv +
                                    ", pret=" + sistem.pret +
                                    ", zona=" + sistem.zona_specifica +
                                    ", tip monitor=" + sistem.tip_mon +
                                    ", viteza procesor=" + sistem.vit_proc +
                                    ", capacitate=" + sistem.capacitate +
                                    ", sis=" + sistem.sis);
                        }
                    }
                    break;
                case 2:
                    for (Echipament echipament : listaE) {
                        if (echipament instanceof Imprimante) {
                            Imprimante imprimanta = (Imprimante) echipament;
                            System.out.println("Imprimanta: nume=" + imprimanta.nume +
                                    ", nr inventar=" + imprimanta.nr_inv +
                                    ", pret=" + imprimanta.pret +
                                    ", zona=" + imprimanta.zona_specifica +
                                    ", ppm=" + imprimanta.ppm +
                                    ", rezolutie=" + imprimanta.rezolutie +
                                    ", p_car=" + imprimanta.p_car +
                                    ", mod=" + imprimanta.mod);
                        }

                    }
                    break;
                case 3:
                    for (Echipament echipament : listaE){
                        if (echipament instanceof Copiatoare){
                            Copiatoare copiator = (Copiatoare) echipament;
                            System.out.println("Copiator: nume=" + copiator.nume +
                                    ", nr_inv=" + copiator.nr_inv +
                                    ", pret=" + copiator.pret +
                                    ", zona=" + copiator.zona_specifica +
                                    ", p_ton=" + copiator.p_ton +
                                    ", format=" + copiator.f);
                        }
                    }
                    break;
                  case 4:
                      for (Echipament echipament : listaE){
                          if(echipament instanceof Sisteme){
                              Sisteme sistem = (Sisteme) echipament;
                              System.out.println("Sistem: nume=" + sistem.nume +
                                      ", nr_inv=" + sistem.nr_inv +
                                      ", pret=" + sistem.pret +
                                      ", zona=" + sistem.zona_specifica +
                                      ", tip monitor=" + sistem.tip_mon +
                                      ", viteza procesor=" + sistem.vit_proc +
                                      ", capacitate=" + sistem.capacitate +
                                      ", sis=" + sistem.sis);
                          }
                      }
                      break;
                case 5:
                    System.out.println("Da-ti numele echipamentului");
                    n=scann.nextLine();
                    System.out.println("Da-ti starea dorita:");
                    st=scann.nextLine();
                    for(Echipament echipament : listaE){
                        if(echipament.nume.compareTo(n)==0){
                            if(st.compareTo("Expus")==0)
                                echipament.zona_specifica=Zona_mag.Expus;
                            if(st.compareTo("Vandut")==0)
                                echipament.zona_specifica=Zona_mag.Vandut;
                            if(st.compareTo("Achizitionat")==0)
                                echipament.zona_specifica=Zona_mag.Achizitionat;
                        }
                    }
                    break;
                    case 6:
                        System.out.println("Da-ti modul de scriere pentru imprimante:");
                        st=scann.nextLine();
                        for(Echipament echipament : listaE){
                            if(echipament instanceof Imprimante){
                                Imprimante imprimanta = (Imprimante) echipament;
                                if(st.compareTo("color")==0)
                                    imprimanta.mod=Mod_tiparire.color;
                                else
                                    imprimanta.mod=Mod_tiparire.alb_negru;
                            }
                        }
                        break;
                        case 7:
                            System.out.println("Da-ti formatul de copiere:");
                            form=scann.nextLine();
                            for(Echipament echipament : listaE){
                                if(echipament instanceof Copiatoare){
                                    Copiatoare copiator = (Copiatoare) echipament;
                                    if(form.compareTo("A3")==0)
                                        copiator.f=Format.A3;
                                    else
                                        copiator.f=Format.A4;
                                }
                            }
                            break;
                            case 8:
                                    System.out.println("Da-ti sistemul de calcul:");
                                    cop=scann.nextLine();
                                    System.out.println("Da-ti sistemul de operare:");
                                    si=scann.nextLine();
                                    for(Echipament echipament : listaE){
                                        if(echipament instanceof Sisteme){
                                            Sisteme sisteme = (Sisteme) echipament;
                                            if(cop.compareTo(sisteme.nume)==0){
                                                if(si.compareTo("Linux")==0)
                                                    sisteme.sis=Operare.Linux;
                                                else
                                                    sisteme.sis=Operare.Windows;
                                            }

                                        }
                                    }
                                break;
                                    case 9:
                                        for(Echipament echipament : listaE){
                                            if(echipament.zona_specifica.compareTo(Zona_mag.Vandut)==0){
                                                if (echipament instanceof Imprimante) {
                                                    Imprimante imprimanta = (Imprimante) echipament;
                                                    System.out.println("Imprimanta: nume=" + imprimanta.nume +
                                                            ", nr inventar=" + imprimanta.nr_inv +
                                                            ", pret=" + imprimanta.pret +
                                                            ", zona=" + imprimanta.zona_specifica +
                                                            ", ppm=" + imprimanta.ppm +
                                                            ", rezolutie=" + imprimanta.rezolutie +
                                                            ", p_car=" + imprimanta.p_car +
                                                            ", mod=" + imprimanta.mod);
                                                } else if (echipament instanceof Copiatoare) {
                                                    Copiatoare copiator = (Copiatoare) echipament;
                                                    System.out.println("Copiator: nume=" + copiator.nume +
                                                            ", nr_inv=" + copiator.nr_inv +
                                                            ", pret=" + copiator.pret +
                                                            ", zona=" + copiator.zona_specifica +
                                                            ", p_ton=" + copiator.p_ton +
                                                            ", format=" + copiator.f);
                                                } else if (echipament instanceof Sisteme) {
                                                    Sisteme sistem = (Sisteme) echipament;
                                                    System.out.println("Sistem: nume=" + sistem.nume +
                                                            ", nr_inv=" + sistem.nr_inv +
                                                            ", pret=" + sistem.pret +
                                                            ", zona=" + sistem.zona_specifica +
                                                            ", tip monitor=" + sistem.tip_mon +
                                                            ", viteza procesor=" + sistem.vit_proc +
                                                            ", capacitate=" + sistem.capacitate +
                                                            ", sis=" + sistem.sis);
                                                }
                                            }


                                        }
                                        break;

            }
        } while (opt != 0);
        scann.close();
    }
}
