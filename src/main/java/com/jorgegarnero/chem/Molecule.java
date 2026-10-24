package com.jorgegarnero.chem ;

import java.util.ArrayList ;
import java.util.List ;
import java.util.Objects ;
import java.util.Set ;
import java.util.stream.Collectors ;

public class Molecule {

    private static final Set<Element> hydroCarbonElementSet = Set.of (Element.CARBON,
                                                                  Element.HYDROGEN) ;

    private String      name    ;
    private int         id      ;
    private List<Atom>  atoms   ;
    private List<Bond>  bonds   ;
    private boolean     is2D    ;

    //-------------------------------------------------------------------------------------------------------

    public void    set2D () {  this.is2D = true  ; }
    public void    set3D () {  this.is2D = false ; }

    public boolean is3D  () { return ! is2D ; }
    public boolean is2D  () { return   is2D ; }

    //-------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------

    public Molecule (String name, int id, boolean is2D, List<Atom> atoms, List<Bond> bonds) {

        this.id     =    id ;
        this.is2D   = is2D  ;
        this.name   = name  == null ? "unnamed"         : name                   ;
        this.atoms  = atoms == null ? new ArrayList<>() : new ArrayList<>(atoms) ;
        this.bonds  = bonds == null ? new ArrayList<>() : new ArrayList<>(bonds) ;

    }

    public Molecule () {

        this ("unnamed", -1, false, null, null) ;

    }

    public Molecule copy () {

        List<Atom> cpAtoms = this.getAtoms ().stream ().map (Atom::copy).toList () ;
        List<Bond> cpBonds = this.getBonds ().stream ().map (Bond::copy).toList () ;

        Molecule cpMolecule = new Molecule (this.name, this.id, this.is2D, cpAtoms, cpBonds) ;

        return cpMolecule ;

    }

    //-------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------

    public String     getName  () {  return name   ;   }
    public int        getId    () {  return id     ;   }
    public List<Atom> getAtoms () {  return atoms  ;   }
    public List<Bond> getBonds () {  return bonds  ;   }

    public void setName (String     name )   { this.name = name ;    }
    public void setId   (int        id   )   { this.id   = id   ;    }

    public void setAtoms (List<Atom> atoms)   {
        this.atoms = atoms == null ? new ArrayList<>() : new ArrayList<>(atoms) ;
    }
    public void setBonds (List<Bond> bonds) {
        this.bonds = bonds == null ? new ArrayList<>() : new ArrayList<>(bonds) ;
    }

    //-------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------


    public Set<Element> getMadeOf () {

        return atoms.stream  ()
                    .map     (Atom::getElement)
                    .filter  (Objects::nonNull)
                    .collect (Collectors.toSet ()) ;
    }

    public boolean isHydroCarbon () {

        Set<Element> madeOfSet = getMadeOf () ;

        return hydroCarbonElementSet.equals (madeOfSet) ;

    }

    //-------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------

    public Atom getFromAtom (Bond bond) {
        int atomId = bond.getFromAtom () ;
        for (Atom atom : atoms) {
            if (atom.getId () == atomId)
                return atom ;
        }
        return null ;
    }

    public Atom getToAtom (Bond bond) {
        int atomId = bond.getToAtom () ;
        for (Atom atom : atoms) {
            if (atom.getId () == atomId)
                return atom ;
        }
        return null ;
    }


    //-------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------


    @Override
    public String toString () {
        return "Molecule{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", atoms=" + atoms +
                ", bonds=" + bonds +
                ", is2D=" + is2D +
                '}' ;
    }

}