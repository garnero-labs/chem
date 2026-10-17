package com.jorgegarnero.chem ;

import java.util.Objects ;

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


    @Override
    public boolean equals (Object o) {

        if (this == o) return true ;

        if (o == null || getClass () != o.getClass ()) return false ;

        Point point = (Point) o ;

        return Double.compare (x, point.x) == 0 && Double.compare (y, point.y) == 0 && Double.compare (z, point.z) == 0 ;

    }


    @Override
    public int hashCode () {

        return Objects.hash (x, y, z) ;

    }

}