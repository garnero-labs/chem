package com.jorgegarnero.chem ;

import org.junit.jupiter.api.Test ;

import static org.junit.jupiter.api.Assertions.assertNotSame ;
import static org.junit.jupiter.api.Assertions.assertEquals  ;
import static org.junit.jupiter.api.Assertions.assertNotNull ;

class PointTest {

    @Test
    void testPointCreationAndGetters () {
        Point point = new Point (1.5, 2.0, -3.2) ;

        assertEquals (1.5,  point.getX (), 1e-9, "X coordinate must be 1.5") ;
        assertEquals (2.0,  point.getY (), 1e-9, "Y coordinate must be 2.0") ;
        assertEquals (-3.2, point.getZ (), 1e-9, "Z coordinate must be -3.2") ;
    }

    @Test
    void testPointSetters () {
        Point point = new Point (0.0, 0.0, 0.0) ;

        point.setX (4.1) ;
        point.setY (5.2) ;
        point.setZ (6.3) ;

        assertEquals (4.1, point.getX (), 1e-9, "X coordinate must be updated to 4.1") ;
        assertEquals (5.2, point.getY (), 1e-9, "Y coordinate must be updated to 5.2") ;
        assertEquals (6.3, point.getZ (), 1e-9, "Z coordinate must be updated to 6.3") ;
    }

    @Test
    void testPointCopy () {
        Point original = new Point (1.1, 2.2, 3.3) ;
        Point copy     = original.copy () ;

        assertNotSame (original, copy, "Copy must be a different instance in memory") ;
        assertEquals  (original.getX (), copy.getX (), 1e-9, "X coordinate of copy must match original") ;
        assertEquals  (original.getY (), copy.getY (), 1e-9, "Y coordinate of copy must match original") ;
        assertEquals  (original.getZ (), copy.getZ (), 1e-9, "Z coordinate of copy must match original") ;

    }

    @Test
    void testSprintf () {
        Point point = new Point (1.234, 5.678, 9.012) ;
        String formatted = point.sprintf ("%.2f") ;

        assertNotNull (formatted, "Formatted string must not be null") ;
        assertEquals  ("(1.23,5.68,9.01)", formatted, "Formatted string must match expected pattern") ;
    }

}