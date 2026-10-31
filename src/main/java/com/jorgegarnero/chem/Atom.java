package com.jorgegarnero.chem ;

import java.util.ArrayList ;
import java.util.List ;
import java.util.Objects ;

/**
 * An Atom.
 *
 * @author Jorge Garnero
 * @version 1.0
 */

public class Atom {

    private final int        id       ;
    private final Element    element  ;
    private final List<Bond> bonds    ;
    private       Point      position ;

    public Atom (int id, Element element) {

        this.id      = id                 ;
        this.element = element            ;
        this.bonds   = new ArrayList<> () ;

    }

    public Atom copy () {

        Atom atom = new Atom (id, element) ;

        this.getBonds ().stream ().map (Bond::copy).forEach (atom::addBond) ;

        if (this.position == null)
            return atom ;

        atom.setPosition (this.position.copy ()) ;
        return atom ;

    }

    public int        getId       () { return id       ; }
    public Element    getElement  () { return element  ; }
    public Point      getPosition () { return position ; }
    public List<Bond> getBonds    () { return bonds    ; }

    public void setPosition (Point position)   { this.position = position ; }

    public void addBond (Bond bond) {
        if (bond != null && !bonds.contains (bond)) {
            bonds.add (bond) ;
        }
    }

    public String toString () {

        return String.format ("[id=%d,%s]", id, element.getName ()) ;

    }


    @Override

    public boolean equals (Object o) {

        if (this == o) return true ;

        if (o == null || getClass () != o.getClass ()) return false ;

        Atom atom = (Atom) o ;

        return id == atom.id && element == atom.element  ;

    }

    @Override
    public int hashCode () {

        return Objects.hash (id, element) ;

    }

}