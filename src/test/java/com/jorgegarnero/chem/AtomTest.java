package com.jorgegarnero.chem ;

import org.junit.jupiter.api.Test ;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame ;
import static org.junit.jupiter.api.Assertions.assertEquals  ;
import static org.junit.jupiter.api.Assertions.assertNotNull ;
import static org.junit.jupiter.api.Assertions.assertNull    ;
import static org.junit.jupiter.api.Assertions.assertNotEquals ;
import static org.junit.jupiter.api.Assertions.assertTrue    ;

class AtomTest {

    @Test
    void testAtomCreationAndGetters () {
        Atom atom = new Atom (1, Element.CARBON) ;

        assertEquals (1, atom.getId (), "Atom ID must be 1") ;
        assertEquals (Element.CARBON, atom.getElement (), "Atom element must be CARBON") ;
        assertNull (atom.getPosition (), "Position must be null upon initial creation") ;
        assertNotNull (atom.getBonds (), "Bonds list must be initialized and not null") ;
        assertTrue (atom.getBonds ().isEmpty (), "Bonds list must be empty initially") ;
    }

    @Test
    void testAtomSetters () {

        //--- set
        Atom atom   = new Atom  (1, Element.HYDROGEN) ;
        Point point = new Point (1.0, 2.0, 3.0) ;
        Bond b1     = new Bond  (1, 1, 2) ;

        atom.setPosition (point) ;
        atom.addBond (b1) ;

        //--- check
        assertEquals (point.getX (), atom.getPosition ().getX (), "Atom position.x must match") ;
        assertEquals (point.getY (), atom.getPosition ().getY (), "Atom position.y must match") ;
        assertEquals (point.getZ (), atom.getPosition ().getZ (), "Atom position.z must match") ;
        assertFalse  (atom.getBonds ().isEmpty ()) ;

        Bond b2 = atom.getBonds ().getFirst () ;
        assertEquals (1, b2.getCardinal ()) ;
        assertEquals (1, b2.getFromAtom ()) ;
        assertEquals (2, b2.getToAtom   ()) ;

        //--- do not repeat.
        assertEquals (1, atom.getBonds ().size ()) ;
        atom.addBond (b2.copy ()) ;
        assertEquals (1, atom.getBonds ().size ()) ;

        //--- do not null.
        assertEquals (1, atom.getBonds ().size ()) ;
        atom.addBond (null) ;
        assertEquals (1, atom.getBonds ().size ()) ;

    }

    @Test
    void testAtomCopy () {
        Atom original = new Atom (1, Element.CARBON) ;
        original.setPosition (new Point (1.1, 2.2, 3.3)) ;
        original.addBond (new Bond (1, 1, 6));

        Atom copy = original.copy () ;

        assertNotSame (original, copy, "Copy must be a different instance in memory") ;
        assertEquals (original.getId (), copy.getId (), "Copy ID must match original") ;
        assertEquals (original.getElement (), copy.getElement (), "Copy element must match original") ;
        assertEquals (original.getPosition ().getX (), copy.getPosition ().getX (), "Copy position coordinate x should be equal.") ;
        assertEquals (original.getPosition ().getY (), copy.getPosition ().getY (), "Copy position coordinate y should be equal.") ;
        assertEquals (original.getPosition ().getZ (), copy.getPosition ().getZ (), "Copy position coordinate z should be equal.") ;

    }

    @Test
    void testToString () {
        Atom atom = new Atom (1, Element.CARBON) ;
        String str = atom.toString () ;

        assertNotNull (str, "toString result must not be null") ;
        assertTrue (str.contains ("id=1"), "toString must contain atom id") ;
        assertTrue (str.contains ("Carbon"), "toString must contain element name") ;
    }

    @Test
    void testEqualsAndHashCode () {
        Atom atom1 = new Atom (1, Element.CARBON) ;
        Atom atom2 = new Atom (1, Element.CARBON) ;
        Atom atomDifferentId = new Atom (2, Element.CARBON) ;
        Atom atomDifferentElement = new Atom (1, Element.OXYGEN) ;

        assertEquals (atom1, atom1, "Atom must be equal to itself") ;
        assertEquals (atom1, atom2, "Atoms with same ID and element must be equal") ;
        assertEquals (atom1.hashCode (), atom2.hashCode (), "Equal atoms must have identical hash codes") ;

        assertNotEquals (atom1, atomDifferentId, "Atoms with different IDs must not be equal") ;
        assertNotEquals (atom1, atomDifferentElement, "Atoms with different elements must not be equal") ;
        assertNotEquals (atom1, null, "Atom must not be equal to null") ;
        assertNotEquals (atom1, "NotAnAtom", "Atom must not be equal to an unrelated object") ;

    }
}