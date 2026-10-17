package com.jorgegarnero.chem ;

import org.junit.jupiter.api.Test ;

import static org.junit.jupiter.api.Assertions.assertEquals ;
import static org.junit.jupiter.api.Assertions.assertNotEquals ;
import static org.junit.jupiter.api.Assertions.assertNotNull ;
import static org.junit.jupiter.api.Assertions.assertNotSame ;
import static org.junit.jupiter.api.Assertions.assertSame ;
import static org.junit.jupiter.api.Assertions.assertTrue ;

class BondTest {

    @Test
    public void testBond () {

        Bond b1 = new Bond (1, 100, 200) ;
        Bond b2 = new Bond (1, 100, 200) ;

        assertNotSame (b1, b2, "not same") ;
        assertEquals  (b1, b2, "equals"  ) ;

        Bond b3 = b1 ;

        assertEquals (b1, b3, "equals") ;
        assertSame   (b1, b3, "same"  ) ;

        Bond b4 = b1.copy () ;

        assertEquals  (b1, b4, "equals") ;
        assertNotSame (b1, b4, "same"  ) ;

    }

    @Test
    void testBondCreationAndGetters () {
        Bond bond = new Bond (1, 0, 1) ;

        assertEquals (1, bond.getCardinal ()) ;
        assertEquals (0, bond.getFromAtom ()) ;
        assertEquals (1, bond.getToAtom   ()) ;
    }

    @Test
    void testBondSetters () {
        Bond bond = new Bond (1, 0, 1) ;

        bond.setCardinal (2) ;
        bond.setFromAtom (2) ;
        bond.setToAtom   (3) ;

        assertEquals (2, bond.getCardinal ()) ;
        assertEquals (2, bond.getFromAtom ()) ;
        assertEquals (3, bond.getToAtom   ()) ;
    }

    @Test
    void testBondCopy () {
        Bond original = new Bond (3, 1, 4) ;
        Bond copy = original.copy () ;

        assertNotSame (original, copy) ;
        assertEquals  (original.getCardinal (), copy.getCardinal ()) ;
        assertEquals  (original.getFromAtom (), copy.getFromAtom ()) ;
        assertEquals  (original.getToAtom   (), copy.getToAtom   ()) ;
        assertEquals  (original, copy) ;
    }

    @Test
    void testEqualsAndHashCode () {
        Bond bond1 = new Bond (1, 0, 1) ;
        Bond bond2 = new Bond (1, 0, 1) ;
        Bond bondDifferentCardinal = new Bond (2, 0, 1) ;
        Bond bondDifferentFrom     = new Bond (1, 5, 1) ;
        Bond bondDifferentTo       = new Bond (1, 0, 5) ;

        assertEquals (bond1, bond1) ;
        assertEquals (bond1, bond2) ;
        assertEquals (bond1.hashCode (), bond2.hashCode ()) ;

        assertNotEquals (bond1, bondDifferentCardinal) ;
        assertNotEquals (bond1, bondDifferentFrom    ) ;
        assertNotEquals (bond1, bondDifferentTo      ) ;
        assertNotEquals (bond1, null          ) ;
        assertNotEquals (bond1, "NotABond"    ) ;

    }

    @Test
    void testToString () {
        Bond bond = new Bond (1, 0, 1) ;
        String str = bond.toString () ;

        assertNotNull (str) ;
        assertTrue    (str.contains ("cardinal=1")) ;
        assertTrue    (str.contains ("fromAtom=0")) ;
        assertTrue    (str.contains ("toAtom=1"  )) ;
    }
}