package com.jorgegarnero.chem.pubchem.loader ;

/*
 * Copyright (C) 2026 Jorge Julio Garnero
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 */

import com.jorgegarnero.chem.Molecule ;
import org.junit.jupiter.api.Test ;

import java.io.ByteArrayInputStream ;
import java.io.IOException ;
import java.io.InputStream ;
import java.nio.charset.StandardCharsets ;

import static org.junit.jupiter.api.Assertions.assertEquals ;
import static org.junit.jupiter.api.Assertions.assertFalse ;
import static org.junit.jupiter.api.Assertions.assertThrows ;

class PubChemLoaderTest {

    @Test
    void loadsMultiAtomMoleculeIn3DMode () throws IOException {
        String json = """
            {
              "metadata": {
                "cid": 99887766,
                "molecularFormula": "C2H",
                "iupacName": "dummy"
              },
              "dimension": "3D",
              "atoms": [
                { "aid": 1, "element": "C", "x": 0.6381, "y": 0.4162, "z": -0.1202 },
                { "aid": 2, "element": "C", "x": 1.9840, "y": -0.2510, "z": 0.1450 },
                { "aid": 3, "element": "H", "x": 0.4120, "y": 0.5100, "z": -1.1920 }
              ]
            }
            """ ;

        PubChemLoader loader = new PubChemLoader () ;
        loader.set3d () ;

        Molecule mol ;
        try (InputStream in = new ByteArrayInputStream (json.getBytes (StandardCharsets.UTF_8))) {
            mol = loader.load (in) ;
        }

        assertEquals (99887766, mol.getId ()) ;
        assertEquals ("dummy", mol.getName ()) ;
        assertFalse (mol.is2D ()) ;
        assertEquals (3, mol.getAtoms ().size ()) ;
    }

    @Test
    void failsWhen3DRequestedOn2DJson () {
        String json2d = """
            {
              "metadata": {
                "cid": 998877,
                "molecularFormula": "doesnt-matter",
                "iupacName": "dummy"
              },
              "dimension": "2D",
              "atoms": [
                { "aid": 1, "element": "C", "x": 0.0, "y": 0.0 },
                { "aid": 2, "element": "C", "x": 1.34, "y": 0.0 }
              ]
            }
            """ ;

        PubChemLoader loader = new PubChemLoader () ;
        loader.set3d () ;

        assertThrows (IOException.class, () -> {
            try (InputStream in = new ByteArrayInputStream (json2d.getBytes (StandardCharsets.UTF_8))) {
                loader.load (in) ;
            }
        }) ;
    }
}
