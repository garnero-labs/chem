package com.jorgegarnero.chem ;

import org.junit.jupiter.api.Test ;
import static org.junit.jupiter.api.Assertions.* ;

import java.util.List ;
import java.util.Set ;

class MoleculeTest {

    @Test
    void testDefaultConstructor () {
        Molecule mol = new Molecule () ;

        assertEquals ("unnamed", mol.getName (), "Default name must be 'unnamed'") ;
        assertEquals (-1, mol.getId (), "Default ID must be -1") ;
        assertFalse (mol.is2D (), "Default dimension must not be 2D (must be 3D)") ;
        assertTrue (mol.is3D (), "Default dimension must be 3D") ;
        assertNotNull (mol.getAtoms (), "Atoms list must not be null") ;
        assertTrue (mol.getAtoms ().isEmpty (), "Atoms list must be empty") ;
        assertNotNull (mol.getBonds (), "Bonds list must not be null") ;
        assertTrue (mol.getBonds ().isEmpty (), "Bonds list must be empty") ;
    }

    @Test
    void testMethaneMoleculeAndHydrocarbon () {

        //--- set
        Atom cc = new Atom (1, Element.CARBON  ) ;
        Atom h2 = new Atom (2, Element.HYDROGEN) ;
        Atom h3 = new Atom (3, Element.HYDROGEN) ;
        Atom h4 = new Atom (4, Element.HYDROGEN) ;
        Atom h5 = new Atom (5, Element.HYDROGEN) ;
        List<Atom> atoms = List.of (cc, h2, h3, h4, h5) ;

        Bond b2 = new Bond (1, 1, 2) ;
        Bond b3 = new Bond (1, 1, 3) ;
        Bond b4 = new Bond (1, 1, 4) ;
        Bond b5 = new Bond (1, 1, 5) ;
        List<Bond> bonds = List.of (b2, b3, b4, b5) ;

        Molecule mol = new Molecule ("metano", 1, false, atoms, bonds) ;

        //--- check
        assertEquals ("metano", mol.getName (), "Name must be metano") ;
        assertEquals (1, mol.getId (), "ID must be 1") ;
        assertFalse (mol.is2D (), "Methane should be 3D") ;
        assertTrue (mol.is3D (), "Methane should be 3D") ;
        assertEquals (5, mol.getAtoms ().size (), "Must have 5 atoms") ;
        assertEquals (4, mol.getBonds ().size (), "Must have 4 bonds") ;

        assertTrue (mol.isHydroCarbon (), "Methane must be identified as a hydrocarbon") ;
        Set<Element> expectedElements = Set.of (Element.CARBON, Element.HYDROGEN) ;
        assertEquals (expectedElements, mol.getMadeOf (), "MadeOf must contain only Carbon and Hydrogen") ;

        Bond intrusiveBond = new Bond (1, 100, 200) ;
        assertNull (mol.getFromAtom (intrusiveBond), "No 'from' atom from unrelated bond.") ;
        assertNull (mol.getToAtom   (intrusiveBond), "No 'to'   atom from unrelated bond.") ;

    }

    @Test
    void testNonHydroCarbonMolecule () {
        Atom oxygen = new Atom (1, Element.OXYGEN) ;
        Atom h1     = new Atom (2, Element.HYDROGEN) ;
        Atom h2     = new Atom (3, Element.HYDROGEN) ;

        Molecule water = new Molecule ("agua", 2, true, List.of (oxygen, h1, h2), List.of ()) ;
        water.set2D () ;

        assertTrue (water.is2D (), "Water molecule should be 2D after set2D") ;
        assertFalse (water.is3D (), "Water molecule should not be 3D") ;
        assertFalse (water.isHydroCarbon (), "Water is not a hydrocarbon") ;
        assertEquals (Set.of (Element.OXYGEN, Element.HYDROGEN), water.getMadeOf ()) ;

        //--- for testing purposes ...
        water.set3D () ;
        assertTrue (water.is3D (), "Ok, now should be 3D") ;

    }

    @Test
    void testCopyDeep () {
        Atom cc = new Atom (1, Element.CARBON) ;
        Bond b1 = new Bond (1, 1, 1) ;
        Molecule original = new Molecule ("original", 10, false, List.of (cc), List.of (b1)) ;

        Molecule copy = original.copy () ;

        assertNotSame (original, copy, "Copy must be a different instance") ;
        assertEquals (original.getName (), copy.getName ()) ;
        assertEquals (original.getId (), copy.getId ()) ;
        assertEquals (original.is2D (), copy.is2D ()) ;

        assertNotSame (original.getAtoms (), copy.getAtoms (), "Atoms list must be deep copied") ;
        assertNotSame (original.getBonds (), copy.getBonds (), "Bonds list must be deep copied") ;
    }

    @Test
    void testAtomNavigationByBond () {
        Atom carbon = new Atom (10, Element.CARBON) ;
        Atom oxygen = new Atom (20, Element.OXYGEN) ;
        Bond bond   = new Bond (1, 10, 20) ;

        Molecule mol = new Molecule ("CO", 99, false, List.of (carbon, oxygen), List.of (bond)) ;

        Atom from = mol.getFromAtom (bond) ;
        Atom to   = mol.getToAtom (bond) ;

        assertNotNull (from, "From atom must be found") ;
        assertEquals (10, from.getId (), "From atom ID must match carbon") ;
        assertEquals (carbon, from, "From atom instance must match") ;

        assertNotNull (to, "To atom must be found") ;
        assertEquals (20, to.getId (), "To atom ID must match oxygen") ;
        assertEquals (oxygen, to, "To atom instance must match") ;
    }

    @Test
    void testSettersAndNullGuards () {
        Molecule mol = new Molecule () ;

        mol.setName (null) ; // Dependiendo de tu implementacion, o puedes probar cambiarlo
        mol.setName ("propano") ;
        assertEquals ("propano", mol.getName ()) ;

        mol.setId (55) ;
        assertEquals (55, mol.getId ()) ;

        mol.setAtoms (null) ;
        assertNotNull (mol.getAtoms (), "Setting null atoms should result in empty list") ;
        assertTrue (mol.getAtoms ().isEmpty ()) ;

        mol.setBonds (null) ;
        assertNotNull (mol.getBonds (), "Setting null bonds should result in empty list") ;
        assertTrue (mol.getBonds ().isEmpty ()) ;
    }

    @Test
    void testNull_Empty () {

        //--- set
        Molecule mol = new Molecule (null, 100, false, null, null) ;
        assertEquals ("unnamed", mol.getName (), "Default name must be 'unnamed'") ;
        assertTrue (mol.getMadeOf ().isEmpty ()) ;

        mol.setAtoms (null) ;
        mol.setBonds (null) ;

        //--- check
        assertNotNull (mol.getAtoms (), "Empty atoms, not null") ;
        assertTrue (mol.getAtoms ().isEmpty (), "Atoms should be empty") ;

        assertNotNull (mol.getBonds (), "Empty bonds, not null") ;
        assertTrue (mol.getBonds ().isEmpty (), "Bonds should be empty") ;

    }

    @Test
    void testNull_Set_Null_Empty () {
        //--- set
        Molecule mol = new Molecule () ;
        mol.setAtoms (List.of (new Atom (1, Element.CARBON))) ;
        mol.setBonds (List.of (new Bond (1, 100, 200))) ;

        assertNotNull (mol.getAtoms (), "Atoms not null") ;
        assertFalse (mol.getAtoms ().isEmpty (), "Atoms not empty") ;

        assertNotNull (mol.getBonds (), "Bonds not null") ;
        assertFalse (mol.getBonds ().isEmpty (), "Bonds not empty") ;

    }

    @Test
    void testToString () {
        Molecule mol = new Molecule () ;
        String str = mol.toString () ;

        assertNotNull (str) ;
        assertTrue (str.contains ("Molecule"), "toString must contain class name description") ;
    }
}