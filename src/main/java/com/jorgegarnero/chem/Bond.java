package com.jorgegarnero.chem ;

import java.util.Objects ;

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

    public void setCardinal (int cardinal) {
        this.cardinal = cardinal ;
    }
    public void setFromAtom (int fromAtom) {
        this.fromAtom = fromAtom ;
    }
    public void setToAtom   (int toAtom  ) {
        this.toAtom   = toAtom   ;
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