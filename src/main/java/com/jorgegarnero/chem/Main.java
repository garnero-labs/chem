package com.jorgegarnero.chem ;

import com.jorgegarnero.chem.pubchem.loader.PubChemLoader ;

import java.io.IOException ;
import java.io.InputStream ;
import java.nio.file.Files ;
import java.nio.file.Path ;

/**
 * Dummy main.
 *
 * @author Jorge Garnero
 * @version 1.0
 */

public class Main {

    public static void main_00 (String [] args) {
        System.out.println ("=== Proyecto Chem: Entorno Java 25 OK ===") ;
        System.out.println ("Iniciando infraestructura base para Hidrocarburos-02...") ;
    }

    public static void main (String[] args) {

        if (args.length == 0) {
            System.err.println ("Usage: java -jar <path-to-json>") ;
            return ;
        }

        Path jsonPath = Path.of (args[0]) ;
        PubChemLoader loader = new PubChemLoader () ;
        loader.set3d () ;

        try (InputStream in = Files.newInputStream (jsonPath)) {
            Molecule mol = loader.load (in) ;

            //System.out.printf ("Mol=%s\n", mol.toString ()) ;
            System.out.printf (
                    "ID=%d, Name=%s, 2D=%s, Atoms=%d, Bonds=%d%n",
                    mol.getId (),
                    mol.getName (),
                    mol.is2D (),
                    mol.getAtoms ().size (),
                    mol.getBonds ().size ()) ;

        } catch (IOException e) {
            System.err.println ("Error reading JSON from " + jsonPath + ": " + e.getMessage ()) ;
        }
    }


}
