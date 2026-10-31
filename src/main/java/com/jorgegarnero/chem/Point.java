package com.jorgegarnero.chem ;

/**
 * A 3D cartesian coordinate.
 *
 * @author Jorge Garnero
 * @version 1.0
 */

public class Point {

    private double x ;
    private double y ;
    private double z ;

    public Point (double x, double y, double z) {

        this.x = x ;
        this.y = y ;
        this.z = z ;

    }


    public Point copy () {

        return new Point (x, y, z) ;

    }

    public double getX () { return x ; }
    public double getY () { return y ; }
    public double getZ () { return z ; }

    public void setX (double x) { this.x = x ; }
    public void setY (double y) { this.y = y ; }
    public void setZ (double z) { this.z = z ; }


    public String sprintf (String format) {

        String format2 = String.format ("(%s,%s,%s)", format, format, format) ;

        return String.format (format2, x, y, z) ;

    }

    /*
     * We do not have "equals" neither "hash".
     * Because:
     *      - we do want to have setters.
     *      - we do not have orphan hashes.
     *      - if we need to compare, we can do it "by hand", and with tolerance. (epsilons).
     */

}