package com.jorgegarnero.chem.pubchem.loader ;

/*
 * Copyright (C) 2026 Jorge Julio Garnero
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 */

import com.fasterxml.jackson.databind.JsonNode ;
import com.fasterxml.jackson.databind.ObjectMapper ;
import com.jorgegarnero.chem.Atom ;
import com.jorgegarnero.chem.Bond ;
import com.jorgegarnero.chem.Element ;
import com.jorgegarnero.chem.Molecule ;
import com.jorgegarnero.chem.Point ;

import java.io.IOException ;
import java.io.InputStream ;
import java.util.ArrayList ;
import java.util.HashSet ;
import java.util.List ;
import java.util.Set ;

public class PubChemLoader {

    private final ObjectMapper mapper = new ObjectMapper () ;
    private       boolean      flag3D = false ;

    public boolean is3d  () { return flag3D  ; }
    public boolean is2d  () { return !flag3D ; }
    public void    set3d () { this.flag3D = true  ; }
    public void    set2d () { this.flag3D = false ; }

    public Molecule load (InputStream inputStream) throws IOException {

        JsonNode root     = mapper.readTree (inputStream) ;
        JsonNode metadata = root.path ("metadata") ;

        int    cid              = metadata.path ("cid").asInt (-1) ;
        String molecularFormula = metadata.path ("molecularFormula").asText ("") ;
        String iupacName        = metadata.path ("iupacName").asText ("") ;

        if (cid <= 0)
            throw new IOException ("Unable to get cid from inputstream.") ;
        if (molecularFormula.isBlank ())
            throw new IOException ("Unable to get molecular formula from inputstream.") ;
        if (iupacName.isBlank ())
            throw new IOException ("Unable to get iupacName from inputstream.") ;

        Molecule molecule = new Molecule () ;
        molecule.setId   (cid) ;
        molecule.setName (iupacName) ;

        if (flag3D) molecule.set3D () ;
        else        molecule.set2D () ;

        List<Atom> atoms = parseAtoms (root, flag3D) ;
        molecule.setAtoms (atoms) ;

        List<Bond> bonds = parseBonds (root, molecule) ;
        molecule.setBonds (bonds) ;

        return molecule ;

    }

    private List<Bond> parseBonds (JsonNode root, Molecule molecule) throws IOException {

        List<Atom> atoms = molecule.getAtoms () ;
        JsonNode bondsNode = root.path ("bonds") ;

        if (bondsNode.isMissingNode () || bondsNode.isNull ()) {
            return List.of () ;
        }
        if (! bondsNode.isArray ()) {
            throw new IOException ("Invalid bonds field in inputstream: expected array.") ;
        }

        Set<Integer> validAtomIds = new HashSet<> (atoms.size ()) ;
        for (Atom atom : atoms) {
            validAtomIds.add (atom.getId ()) ;
        }

        List<Bond> bonds = new ArrayList<> (bondsNode.size ()) ;
        for (int i = 0 ; i < bondsNode.size () ; i++) {
            JsonNode bondNode = bondsNode.get (i) ;

            int aid1  = bondNode.path ("aid1").asInt (-1) ;
            int aid2  = bondNode.path ("aid2").asInt (-1) ;
            int order = bondNode.path ("order").asInt (-1) ;

            if (aid1 <= 0 || aid2 <= 0) {
                throw new IOException ("Invalid atom ids in bond at index " + i + ".") ;
            }
            if (aid1 == aid2) {
                throw new IOException ("Self-loop bond at index " + i + " for atom id " + aid1 + ".") ;
            }
            if (! validAtomIds.contains (aid1) || ! validAtomIds.contains (aid2)) {
                throw new IOException (
                        "Bond at index " + i + " references unknown atom id (" + aid1 + ", " + aid2 + ")."
                ) ;
            }
            if (order <= 0) {
                throw new IOException ("Invalid bond order at index " + i + " (" + order + ").") ;
            }

            Bond theNewBond = new Bond (order, aid1, aid2) ;
            bonds.add (theNewBond) ;

            Atom atom1 = molecule.getAtomById (aid1) ;
            atom1.addBond (theNewBond) ;

            Atom atom2 = molecule.getAtomById (aid2) ;
            atom2.addBond (theNewBond) ;

        }

        return bonds ;
    }
    private List<Atom> parseAtoms (JsonNode root, boolean require3D) throws IOException {
        String expectedDimension = require3D ? "3D" : "2D" ;
        String dimension         = root.path ("dimension").asText ("") ;

        if (! expectedDimension.equalsIgnoreCase (dimension)) {
            throw new IOException (
                    "Expected dimension " + expectedDimension + " in inputstream, but found '" + dimension + "'."
            ) ;
        }

        JsonNode atomsNode = root.path ("atoms") ;
        if (! atomsNode.isArray () || atomsNode.isEmpty ()) {
            throw new IOException ("Missing or empty atoms array in inputstream.") ;
        }

        List<Atom> atoms = new ArrayList<> (atomsNode.size ()) ;
        for (int i = 0 ; i < atomsNode.size () ; i++) {
            JsonNode atomNode = atomsNode.get (i) ;

            int    aid           = atomNode.path ("aid").asInt (-1) ;
            String elementSymbol = atomNode.path ("element").asText ("") ;

            if (aid <= 0) {
                throw new IOException ("Invalid aid at index " + i + ".") ;
            }
            if (elementSymbol.isBlank ()) {
                throw new IOException ("Missing element at index " + i + ".") ;
            }

            Element element  = resolveElement (elementSymbol, i) ;
            Point   position = parseAtomPosition (atomNode, i, require3D) ;

            Atom atom = new Atom (aid, element) ;
            atom.setPosition (position) ;
            atoms.add (atom) ;
        }

        return atoms ;
    }

    private Point parseAtomPosition (JsonNode atomNode, int index, boolean require3D) throws IOException {
        JsonNode xNode = atomNode.path ("x") ;
        JsonNode yNode = atomNode.path ("y") ;

        if (! xNode.isNumber () || ! yNode.isNumber ()) {
            throw new IOException ("Missing or non-numeric x/y coordinates for atom at index " + index + ".") ;
        }

        double x = xNode.asDouble () ;
        double y = yNode.asDouble () ;

        if (require3D) {
            JsonNode zNode = atomNode.path ("z") ;
            if (! zNode.isNumber ()) {
                throw new IOException ("Missing or non-numeric z coordinate for 3D atom at index " + index + ".") ;
            }
            return new Point (x, y, zNode.asDouble ()) ;
        }

        return new Point (x, y, 0) ;
    }

    private Element resolveElement (String symbol, int index) throws IOException {
        return Element.fromSymbol (symbol)
                      .orElseThrow (() -> new IOException (
                              "Unsupported element '" + symbol + "' at atom index " + index + "."
                      )) ;
    }
}
