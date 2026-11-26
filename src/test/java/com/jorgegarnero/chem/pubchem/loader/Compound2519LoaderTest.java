package com.jorgegarnero.chem.pubchem.loader ;

/*
 * Copyright (C) 2026 Jorge Julio Garnero
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 */

import com.jorgegarnero.chem.Atom ;
import com.jorgegarnero.chem.Bond ;
import com.jorgegarnero.chem.Element ;
import com.jorgegarnero.chem.Molecule ;
import org.junit.jupiter.api.Test ;

import java.io.IOException ;
import java.io.InputStream ;
import java.util.List ;

import static org.junit.jupiter.api.Assertions.* ;

class Compound2519LoaderTest {

    private static final String RESOURCE_3D = "/MolDepot/3d.2519.json" ;
    private static final String RESOURCE_2D = "/MolDepot/2d.2519.json" ;

    private InputStream openResource (String path) {
        InputStream in = Compound2519LoaderTest.class.getResourceAsStream (path) ;
        assertNotNull (in, "Test resource not found on classpath: " + path) ;
        return in ;
    }

    @Test
    void loadsMetadataModeAndAtomElementsFrom3dJson () throws IOException {
        PubChemLoader loader = new PubChemLoader () ;
        loader.set3d () ;

        Molecule molecule ;
        try (InputStream in = openResource (RESOURCE_3D)) {
            molecule = loader.load (in) ;
        }

        // Metadata
        assertEquals (2519, molecule.getId ()) ;
        assertEquals ("1,3,7-trimethylpurine-2,6-dione", molecule.getName ()) ;
        assertFalse  (molecule.is2D ()) ;

        //--- Atoms -- first round.
        List<Atom> atoms = molecule.getAtoms () ;
        assertNotNull (atoms) ;
        assertEquals (24, atoms.size ()) ;
        long nCarbons   = atoms.stream ().filter (a -> a.getElement ()==Element.CARBON)   .count () ;
        long nHydrogen  = atoms.stream ().filter (a -> a.getElement ()==Element.HYDROGEN) .count () ;
        long nNitrogen  = atoms.stream ().filter (a -> a.getElement ()==Element.NITROGEN) .count () ;
        long nOxygen    = atoms.stream ().filter (a -> a.getElement ()==Element.OXYGEN)   .count () ;
        //--- C8H10N4O2
        assertEquals (8 , nCarbons)  ;
        assertEquals (10, nHydrogen) ;
        assertEquals (4 , nNitrogen) ;
        assertEquals (2 , nOxygen)   ;

        //--- Bonds -- first round.
        List<Bond> bonds = molecule.getBonds () ;
        assertNotNull (bonds) ;
        assertEquals (25, bonds.size ()) ;

        //--- Atoms -- second round
        Atom atom4 = molecule.getAtomById (4) ;
        assertNotNull (atom4) ;
        assertEquals (4, atom4.getId ()) ;
        assertNotNull (atom4.getElement ()) ;

        assertNotNull (atom4.getPosition ()) ;
        assertEquals ( 2.2182, atom4.getPosition ().getX (), 1e-4) ;
        assertEquals ( 0.1412, atom4.getPosition ().getY (), 1e-4) ;
        assertEquals (-0.0003, atom4.getPosition ().getZ (), 1e-4) ;

        assertNull (molecule.getAtomById (999)) ;

        //--- Atom-Bond consistency
        for (Atom atom : atoms) {
            List<Bond> atomBonds = atom.getBonds () ;
            assertNotNull (atomBonds) ;
            assertFalse (atomBonds.isEmpty (), "Expected at least one bond on atom " + atom.getId ()) ;

            for (Bond bond : atomBonds) {
                boolean touchesAtom = bond.getFromAtom () == atom.getId () || bond.getToAtom () == atom.getId () ;
                assertTrue (touchesAtom, "Bond " + bond + " does not reference atom " + atom.getId ()) ;
            }
        }
    }

    @Test
    void loadsMetadataModeAndAtomElementsFrom2dJson () throws IOException {
        PubChemLoader loader = new PubChemLoader () ;
        loader.set2d () ;

        Molecule molecule ;
        try (InputStream in = openResource (RESOURCE_2D)) {
            molecule = loader.load (in) ;
        }

        // Metadata
        assertEquals (2519, molecule.getId ()) ;
        assertEquals ("1,3,7-trimethylpurine-2,6-dione", molecule.getName ()) ;
        assertTrue   (molecule.is2D ()) ;

        //--- Atoms -- first round.
        List<Atom> atoms = molecule.getAtoms () ;
        assertNotNull (atoms) ;
        assertEquals (24, atoms.size ()) ;
        long nCarbons   = atoms.stream ().filter (a -> a.getElement ()==Element.CARBON)   .count () ;
        long nHydrogen  = atoms.stream ().filter (a -> a.getElement ()==Element.HYDROGEN) .count () ;
        long nNitrogen  = atoms.stream ().filter (a -> a.getElement ()==Element.NITROGEN) .count () ;
        long nOxygen    = atoms.stream ().filter (a -> a.getElement ()==Element.OXYGEN)   .count () ;
        //--- C8H10N4O2
        assertEquals (8 , nCarbons)  ;
        assertEquals (10, nHydrogen) ;
        assertEquals (4 , nNitrogen) ;
        assertEquals (2 , nOxygen)   ;

        //--- Bonds -- first round.
        List<Bond> bonds = molecule.getBonds () ;
        assertNotNull (bonds) ;
        assertEquals (25, bonds.size ()) ;

        //--- Atoms -- second round
        Atom atom4 = molecule.getAtomById (4) ;
        assertNotNull (atom4) ;
        assertEquals (4, atom4.getId ()) ;
        assertNotNull (atom4.getElement ()) ;

        assertNotNull (atom4.getPosition ()) ;
        assertEquals (5.5443, atom4.getPosition ().getX (), 1e-4) ;
        assertEquals (0.8047, atom4.getPosition ().getY (), 1e-4) ;
        assertEquals (0.0   , atom4.getPosition ().getZ (), 1e-4) ;

        //--- for all of them.
        for (Atom atom : atoms) {
            assertNotNull (atom.getPosition ()) ;
            assertEquals (0.0, atom.getPosition ().getZ (), 1e-4) ;
        }

        assertNull (molecule.getAtomById (999)) ;

        //--- Atom-Bond consistency
        for (Atom atom : atoms) {
            List<Bond> atomBonds = atom.getBonds () ;
            assertNotNull (atomBonds) ;
            assertFalse (atomBonds.isEmpty (), "Expected at least one bond on atom " + atom.getId ()) ;

            for (Bond bond : atomBonds) {
                boolean touchesAtom = bond.getFromAtom () == atom.getId () || bond.getToAtom () == atom.getId () ;
                assertTrue (touchesAtom, "Bond " + bond + " does not reference atom " + atom.getId ()) ;
            }
        }
    }

}
