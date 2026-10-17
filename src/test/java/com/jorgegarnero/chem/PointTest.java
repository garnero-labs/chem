package com.jorgegarnero.chem ;

import org.junit.jupiter.api.Test ;

import static org.junit.jupiter.api.Assertions.assertNotSame ;
import static org.junit.jupiter.api.Assertions.assertEquals  ;
import static org.junit.jupiter.api.Assertions.assertNotNull ;
import static org.junit.jupiter.api.Assertions.assertNotEquals ;
import static org.junit.jupiter.api.Assertions.assertSame ;

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
        assertEquals  (original, copy, "Copy must be equal to original") ;
    }

    @Test
    void testSprintf () {
        Point point = new Point (1.234, 5.678, 9.012) ;
        String formatted = point.sprintf ("%.2f") ;

        assertNotNull (formatted, "Formatted string must not be null") ;
        assertEquals  ("(1.23,5.68,9.01)", formatted, "Formatted string must match expected pattern") ;
    }

    @Test
    void testEqualsAndHashCode () {
        Point p1             = new Point (1.0, 2.0, 3.0) ;
        Point pSame1         = p1 ;
        Point p2             = new Point (1.0, 2.0, 3.0) ;
        Point pDifferentX    = new Point (9.0, 2.0, 3.0) ;
        Point pDifferentY    = new Point (1.0, 9.0, 3.0) ;
        Point pDifferentZ    = new Point (1.0, 2.0, 9.0) ;

        assertSame   (p1, pSame1, "Points should be same") ;
        assertNotSame (p1, p2, "Points should not be same") ;
        assertEquals (p1, pSame1, "Points should be equal") ;
        assertEquals (p1, p1, "Point must be equal to itself") ;
        assertEquals (p1, p2, "Points with identical coordinates must be equal") ;
        assertEquals (p1.hashCode (), p2.hashCode (), "Equal points must have identical hash codes") ;

        assertNotEquals (p1, pDifferentX, "Points with different X must not be equal") ;
        assertNotEquals (p1, pDifferentY, "Points with different Y must not be equal") ;
        assertNotEquals (p1, pDifferentZ, "Points with different Z must not be equal") ;
        assertNotEquals (p1, null       , "Point must not be equal to null") ;
        assertNotEquals (p1, "NotAPoint", "Point must not be equal to an unrelated object") ;
    }
}