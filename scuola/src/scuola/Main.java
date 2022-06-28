import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /** UTILITIES **/

       // File fileStud = new File(" ");
        DecimalFormat df = new DecimalFormat("0.00");
        Logger logger = LoggerFactory.getLogger(Scuola.class);

        /** SCUOLA 1 **/

        //STUDENTI
        Studente mario = new Studente(1,"Mario","Balotelli",'M');
        Studente luigi = new Studente(2,"Luigi","Dimaio",'M');
        Studente rosa = new Studente(3,"Rosa","Splendente",'F');
        Studente michela = new Studente(4,"Michela","Giannino",'F');
        Studente maria = new Studente(5,"Maria","Salvador",'F');

        //LISTE STUDENTI
        List<Studente> listaScuola1 = new ArrayList<>();
        listaScuola1.add(mario);
        listaScuola1.add(luigi);
        listaScuola1.add(rosa);
        listaScuola1.add(michela);
        listaScuola1.add(maria);


        /** SCUOLA 2 **/

        //STUDENTI
        Studente luca = new Studente(1,"Luca","Carboni",'M');
        Studente gianni = new Studente(2,"Gianni","Celesti",'M');
        Studente marina = new Studente(3,"Marina","Militare",'F');
        Studente chiara = new Studente(4,"Chiara","Salvato",'F');
        Studente matteo = new Studente(5,"Matteo","Renzi",'M');

        //LISTE STUDENTI
        List<Studente> listaScuola2 = new ArrayList<>();
        listaScuola2.add(luca);
        listaScuola2.add(gianni);
        listaScuola2.add(marina);
        listaScuola2.add(chiara);
        listaScuola2.add(matteo);



        /** EXECUTE **/

        //SCUOLE
        Scuola scuola1 = new Scuola(listaScuola1);
        Scuola scuola2 = new Scuola(listaScuola2);


        //SCUOLA 1
        System.out.println("\n*****************SCUOLA 1**********************");
        System.out.println(scuola1.getPromossi());
        System.out.println("\nLa lista completa degli studenti della scuola e': " + scuola1.getStudenti());
        System.out.println("\nIl voto migliore di Matematica di " + michela.getNome() + " e' " + df.format(michela.votoMiglioreMateria("Matematica")));
        System.out.println("\nLo studente migliore e': " + scuola1.getStudenteMigliore() + " con una media di " + df.format(scuola1.getStudenteMigliore().mediaTotale()));
        scuola1.salvaStudenti(fileStud); logger.info("I dati degli studenti sono stati salvati nel file: " + fileStud);


        //SCUOLA 2
        System.out.println("\n*****************SCUOLA 2**********************");
        System.out.println(scuola2.getPromossi());
        System.out.println("\nLa lista completa degli studenti della scuola e': " + scuola2.getStudenti());
        System.out.println("\nIl voto migliore in Scienze di " + gianni.getNome() + " e' " + df.format(gianni.votoMiglioreMateria("Matematica")));
        System.out.println("\nLo studente migliore e': " + scuola2.getStudenteMigliore() + " con una media di " + df.format(scuola2.getStudenteMigliore().mediaTotale()));


        //THREAD
        System.out.println("\n*****************THREAD**********************\n");
        Thread thread1 = new Thread(scuola1, "Scuola1");
        Thread thread2 = new Thread(scuola2, "Scuola2");
        thread1.start();
        thread2.start();

    }

}