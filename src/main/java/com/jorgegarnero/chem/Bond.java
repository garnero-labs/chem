package com.jorgegarnero.chem ;

import java.util.Objects ;

/**
 * A chemical bond between atoms.
 *
 * @author Jorge Garnero
 * @version 1.0
 */

public class Bond {

    private int cardinal ;
    private int fromAtom ;
    private int toAtom   ;

    public Bond (int cardinal, int fromAtom, int toAtom) {

        this.cardinal = cardinal ;
        this.fromAtom = fromAtom ;
        this.toAtom   = toAtom   ;

    }

    public Bond copy () {
        return new Bond (cardinal, fromAtom, toAtom) ;
    }

    public int getCardinal  () {
        return cardinal ;
    }
    public int getFromAtom  () {
        return fromAtom ;
    }
    public int getToAtom    () {
        return toAtom   ;
    }

    @Override
    public String toString () {
        return "Bond{"        +
                "cardinal="   + cardinal +
                ", fromAtom=" + fromAtom +
                ", toAtom="   + toAtom   +
                '}' ;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true ;
        if (o == null || getClass () != o.getClass ()) return false ;
        Bond bond =(Bond) o ;
        return cardinal == bond.cardinal && fromAtom == bond.fromAtom && toAtom == bond.toAtom ;
    }

    @Override
    public int hashCode () {
        return Objects.hash (cardinal, fromAtom, toAtom) ;
    }
}