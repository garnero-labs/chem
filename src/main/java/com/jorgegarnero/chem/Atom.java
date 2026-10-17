package com.jorgegarnero.chem ;

import java.util.ArrayList ;
import java.util.List ;
import java.util.Objects ;


public class Atom {

    private int        id       ;
    private Element    element  ;
    private Point      position ;
    private List<Bond> bonds    ;

    public Atom (int id, Element element) {

        this.id      = id                 ;
        this.element = element            ;
        this.bonds   = new ArrayList<> () ;

    }

    public Atom copy () {

        Atom atom = new Atom (id, element) ;

        if (this.position != null) {
            atom.setPosition (this.position.copy ()) ;
        }

        atom.setBonds (this.getBonds ().stream ().map (Bond::copy).toList ()) ;

        return atom ;
    }

    public int        getId       () { return id       ; }
    public Element    getElement  () { return element  ; }
    public Point      getPosition () { return position ; }
    public List<Bond> getBonds    () { return bonds    ; }

    public void setId       (int id)           { this.id       = id       ; }
    public void setElement  (Element element)  { this.element  = element  ; }
    public void setPosition (Point position)   { this.position = position ; }
    public void setBonds    (List<Bond> bonds) { this.bonds    = bonds    ; }

    public String toString () {

        return String.format ("[id=%d,%s]", id, element.getName ()) ;

    }


    @Override

    public boolean equals (Object o) {

        if (this == o) return true ;

        if (o == null || getClass () != o.getClass ()) return false ;

        Atom atom = (Atom) o ;

        return id == atom.id && element == atom.element && Objects.equals (position, atom.position) && Objects.equals (bonds, atom.bonds) ;

    }

    @Override
    public int hashCode () {

        return Objects.hash (id, element, position, bonds) ;

    }

}