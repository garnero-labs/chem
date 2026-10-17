package com.jorgegarnero.chem ;

import org.junit.jupiter.api.Test ;
import static org.junit.jupiter.api.Assertions.assertNotSame ;
import static org.junit.jupiter.api.Assertions.assertEquals  ;
import static org.junit.jupiter.api.Assertions.assertNotNull ;
import static org.junit.jupiter.api.Assertions.assertNull    ;
import static org.junit.jupiter.api.Assertions.assertNotEquals ;
import static org.junit.jupiter.api.Assertions.assertTrue    ;

import java.util.List ;
import java.util.ArrayList ;

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
        Atom atom = new Atom (1, Element.HYDROGEN) ;
        Point point = new Point (1.0, 2.0, 3.0) ;
        List<Bond> bonds = new ArrayList<> () ;
        bonds.add (new Bond (1, 1, 2)) ;

        atom.setId (2) ;
        atom.setElement (Element.OXYGEN) ;
        atom.setPosition (point) ;
        atom.setBonds (bonds) ;

        assertEquals (2, atom.getId (), "Atom ID must be updated to 2") ;
        assertEquals (Element.OXYGEN, atom.getElement (), "Atom element must be updated to OXYGEN") ;
        assertEquals (point, atom.getPosition (), "Atom position must match the assigned point") ;
        assertEquals (1, atom.getBonds ().size (), "Atom bonds size must be 1") ;
    }

    @Test
    void testAtomCopy () {
        Atom original = new Atom (1, Element.CARBON) ;
        original.setPosition (new Point (1.1, 2.2, 3.3)) ;
        List<Bond> bonds = new ArrayList<> () ;
        bonds.add (new Bond (1, 1, 6)) ;
        original.setBonds (bonds) ;

        Atom copy = original.copy () ;

        assertNotSame (original, copy, "Copy must be a different instance in memory") ;
        assertEquals (original.getId (), copy.getId (), "Copy ID must match original") ;
        assertEquals (original.getElement (), copy.getElement (), "Copy element must match original") ;
        assertEquals (original.getPosition (), copy.getPosition (), "Copy position must match original") ;
        assertNotSame (original.getPosition (), copy.getPosition (), "Copy position must be a deep clone") ;
        assertEquals (original, copy, "Copy must be equal to original") ;
    }

    @Test
    void testAtomCopyNullPosition () {
        Atom original = new Atom (5, Element.NITROGEN) ;
        // Position is left as null intentionally

        Atom copy = original.copy () ;

        assertNotSame (original, copy, "Copy must be a different instance") ;
        assertEquals (original.getId (), copy.getId (), "Copy ID must match original") ;
        assertEquals (original.getElement (), copy.getElement (), "Copy element must match original") ;
        assertNull (copy.getPosition (), "Copy position must remain null if original position is null") ;
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

        List<Bond> bonds = new ArrayList<> () ;
        bonds.add (new Bond (1, atom2.getId (), 1000)) ;
        atom2.setBonds (bonds) ;

        assertNotEquals (atom1, atom2, "Atom must not equal if bonds are different") ;

        Atom atom3 = new Atom (1, Element.CARBON) ;
        atom3.setPosition (new Point (1,2,3)) ;
        assertNotEquals (atom1, atom3, "Atom must not equal if positions are different") ;

    }
}