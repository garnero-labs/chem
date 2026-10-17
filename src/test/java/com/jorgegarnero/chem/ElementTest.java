package com.jorgegarnero.chem ;

import org.junit.jupiter.api.Test ;
import static org.junit.jupiter.api.Assertions.assertNotSame ;
import static org.junit.jupiter.api.Assertions.assertEquals  ;
import static org.junit.jupiter.api.Assertions.assertSame    ;
import static org.junit.jupiter.api.Assertions.assertThrows  ;

class ElementTest {

    @Test

    public void testBond () {

        Bond b1 = new Bond (1, 100, 200) ;
        Bond b2 = new Bond (1, 100, 200) ;

        assertNotSame (b1, b2, "not same") ;
        assertEquals  (b1, b2, "equals"  ) ;

        Bond b3 = b1 ;

        assertEquals (b1, b3, "equals") ;
        assertSame   (b1, b3, "same"  ) ;

        Bond b4 = b1.copy () ;

        assertEquals  (b1, b4, "equals") ;
        assertNotSame (b1, b4, "same"  ) ;

    }


    @Test
    void testElementByAtomicNumber () {

        // Full 118 sequential elements validation order

        assertEquals (Element.HYDROGEN            , Element.elementByAtomicNumber (  1), "Element with atomic number   1 must be HYDROGEN            ") ;
        assertEquals (Element.HELIUM              , Element.elementByAtomicNumber (  2), "Element with atomic number   2 must be HELIUM              ") ;
        assertEquals (Element.LITHIUM             , Element.elementByAtomicNumber (  3), "Element with atomic number   3 must be LITHIUM             ") ;
        assertEquals (Element.BERYLLIUM           , Element.elementByAtomicNumber (  4), "Element with atomic number   4 must be BERYLLIUM           ") ;
        assertEquals (Element.BORON               , Element.elementByAtomicNumber (  5), "Element with atomic number   5 must be BORON               ") ;
        assertEquals (Element.CARBON              , Element.elementByAtomicNumber (  6), "Element with atomic number   6 must be CARBON              ") ;
        assertEquals (Element.NITROGEN            , Element.elementByAtomicNumber (  7), "Element with atomic number   7 must be NITROGEN            ") ;
        assertEquals (Element.OXYGEN              , Element.elementByAtomicNumber (  8), "Element with atomic number   8 must be OXYGEN              ") ;
        assertEquals (Element.FLUORINE            , Element.elementByAtomicNumber (  9), "Element with atomic number   9 must be FLUORINE            ") ;
        assertEquals (Element.NEON                , Element.elementByAtomicNumber ( 10), "Element with atomic number  10 must be NEON                ") ;
        assertEquals (Element.SODIUM              , Element.elementByAtomicNumber ( 11), "Element with atomic number  11 must be SODIUM              ") ;
        assertEquals (Element.MAGNESIUM           , Element.elementByAtomicNumber ( 12), "Element with atomic number  12 must be MAGNESIUM           ") ;
        assertEquals (Element.ALUMINIUM           , Element.elementByAtomicNumber ( 13), "Element with atomic number  13 must be ALUMINIUM           ") ;
        assertEquals (Element.SILICON             , Element.elementByAtomicNumber ( 14), "Element with atomic number  14 must be SILICON             ") ;
        assertEquals (Element.PHOSPHORUS          , Element.elementByAtomicNumber ( 15), "Element with atomic number  15 must be PHOSPHORUS          ") ;
        assertEquals (Element.SULFUR              , Element.elementByAtomicNumber ( 16), "Element with atomic number  16 must be SULFUR              ") ;
        assertEquals (Element.CHLORINE            , Element.elementByAtomicNumber ( 17), "Element with atomic number  17 must be CHLORINE            ") ;
        assertEquals (Element.ARGON               , Element.elementByAtomicNumber ( 18), "Element with atomic number  18 must be ARGON               ") ;
        assertEquals (Element.POTASSIUM           , Element.elementByAtomicNumber ( 19), "Element with atomic number  19 must be POTASSIUM           ") ;
        assertEquals (Element.CALCIUM             , Element.elementByAtomicNumber ( 20), "Element with atomic number  20 must be CALCIUM             ") ;
        assertEquals (Element.SCANDIUM            , Element.elementByAtomicNumber ( 21), "Element with atomic number  21 must be SCANDIUM            ") ;
        assertEquals (Element.TITANIUM            , Element.elementByAtomicNumber ( 22), "Element with atomic number  22 must be TITANIUM            ") ;
        assertEquals (Element.VANADIUM            , Element.elementByAtomicNumber ( 23), "Element with atomic number  23 must be VANADIUM            ") ;
        assertEquals (Element.CHROMIUM            , Element.elementByAtomicNumber ( 24), "Element with atomic number  24 must be CHROMIUM            ") ;
        assertEquals (Element.MANGANESE           , Element.elementByAtomicNumber ( 25), "Element with atomic number  25 must be MANGANESE           ") ;
        assertEquals (Element.IRON                , Element.elementByAtomicNumber ( 26), "Element with atomic number  26 must be IRON                ") ;
        assertEquals (Element.COBALT              , Element.elementByAtomicNumber ( 27), "Element with atomic number  27 must be COBALT              ") ;
        assertEquals (Element.NICKEL              , Element.elementByAtomicNumber ( 28), "Element with atomic number  28 must be NICKEL              ") ;
        assertEquals (Element.COPPER              , Element.elementByAtomicNumber ( 29), "Element with atomic number  29 must be COPPER              ") ;
        assertEquals (Element.ZINC                , Element.elementByAtomicNumber ( 30), "Element with atomic number  30 must be ZINC                ") ;
        assertEquals (Element.GALLIUM             , Element.elementByAtomicNumber ( 31), "Element with atomic number  31 must be GALLIUM             ") ;
        assertEquals (Element.GERMANIUM           , Element.elementByAtomicNumber ( 32), "Element with atomic number  32 must be GERMANIUM           ") ;
        assertEquals (Element.ARSENIC             , Element.elementByAtomicNumber ( 33), "Element with atomic number  33 must be ARSENIC             ") ;
        assertEquals (Element.SELENIUM            , Element.elementByAtomicNumber ( 34), "Element with atomic number  34 must be SELENIUM            ") ;
        assertEquals (Element.BROMINE             , Element.elementByAtomicNumber ( 35), "Element with atomic number  35 must be BROMINE             ") ;
        assertEquals (Element.KRYPTON             , Element.elementByAtomicNumber ( 36), "Element with atomic number  36 must be KRYPTON             ") ;
        assertEquals (Element.RUBIDIUM            , Element.elementByAtomicNumber ( 37), "Element with atomic number  37 must be RUBIDIUM            ") ;
        assertEquals (Element.STRONTIUM           , Element.elementByAtomicNumber ( 38), "Element with atomic number  38 must be STRONTIUM           ") ;
        assertEquals (Element.YTTRIUM             , Element.elementByAtomicNumber ( 39), "Element with atomic number  39 must be YTTRIUM             ") ;
        assertEquals (Element.ZIRCONIUM           , Element.elementByAtomicNumber ( 40), "Element with atomic number  40 must be ZIRCONIUM           ") ;
        assertEquals (Element.NIOBIUM             , Element.elementByAtomicNumber ( 41), "Element with atomic number  41 must be NIOBIUM             ") ;
        assertEquals (Element.MOLYBDENUM          , Element.elementByAtomicNumber ( 42), "Element with atomic number  42 must be MOLYBDENUM          ") ;
        assertEquals (Element.TECHNETIUM          , Element.elementByAtomicNumber ( 43), "Element with atomic number  43 must be TECHNETIUM          ") ;
        assertEquals (Element.RUTHENIUM           , Element.elementByAtomicNumber ( 44), "Element with atomic number  44 must be RUTHENIUM           ") ;
        assertEquals (Element.RHODIUM             , Element.elementByAtomicNumber ( 45), "Element with atomic number  45 must be RHODIUM             ") ;
        assertEquals (Element.PALLADIUM           , Element.elementByAtomicNumber ( 46), "Element with atomic number  46 must be PALLADIUM           ") ;
        assertEquals (Element.SILVER              , Element.elementByAtomicNumber ( 47), "Element with atomic number  47 must be SILVER              ") ;
        assertEquals (Element.CADMIUM             , Element.elementByAtomicNumber ( 48), "Element with atomic number  48 must be CADMIUM             ") ;
        assertEquals (Element.INDIUM              , Element.elementByAtomicNumber ( 49), "Element with atomic number  49 must be INDIUM              ") ;
        assertEquals (Element.TIN                 , Element.elementByAtomicNumber ( 50), "Element with atomic number  50 must be TIN                 ") ;
        assertEquals (Element.ANTIMONY            , Element.elementByAtomicNumber ( 51), "Element with atomic number  51 must be ANTIMONY            ") ;
        assertEquals (Element.TELLURIUM           , Element.elementByAtomicNumber ( 52), "Element with atomic number  52 must be TELLURIUM           ") ;
        assertEquals (Element.IODINE              , Element.elementByAtomicNumber ( 53), "Element with atomic number  53 must be IODINE              ") ;
        assertEquals (Element.XENON               , Element.elementByAtomicNumber ( 54), "Element with atomic number  54 must be XENON               ") ;
        assertEquals (Element.CAESIUM             , Element.elementByAtomicNumber ( 55), "Element with atomic number  55 must be CAESIUM             ") ;
        assertEquals (Element.BARIUM              , Element.elementByAtomicNumber ( 56), "Element with atomic number  56 must be BARIUM              ") ;
        assertEquals (Element.LANTHANUM           , Element.elementByAtomicNumber ( 57), "Element with atomic number  57 must be LANTHANUM           ") ;
        assertEquals (Element.CERIUM              , Element.elementByAtomicNumber ( 58), "Element with atomic number  58 must be CERIUM              ") ;
        assertEquals (Element.PRASEODYMIUM        , Element.elementByAtomicNumber ( 59), "Element with atomic number  59 must be PRASEODYMIUM        ") ;
        assertEquals (Element.NEODYMIUM           , Element.elementByAtomicNumber ( 60), "Element with atomic number  60 must be NEODYMIUM           ") ;
        assertEquals (Element.PROMETHIUM          , Element.elementByAtomicNumber ( 61), "Element with atomic number  61 must be PROMETHIUM          ") ;
        assertEquals (Element.SAMARIUM            , Element.elementByAtomicNumber ( 62), "Element with atomic number  62 must be SAMARIUM            ") ;
        assertEquals (Element.EUROPIUM            , Element.elementByAtomicNumber ( 63), "Element with atomic number  63 must be EUROPIUM            ") ;
        assertEquals (Element.GADOLINIUM          , Element.elementByAtomicNumber ( 64), "Element with atomic number  64 must be GADOLINIUM          ") ;
        assertEquals (Element.TERBIUM             , Element.elementByAtomicNumber ( 65), "Element with atomic number  65 must be TERBIUM             ") ;
        assertEquals (Element.DYSPROSIUM          , Element.elementByAtomicNumber ( 66), "Element with atomic number  66 must be DYSPROSIUM          ") ;
        assertEquals (Element.HOLMIUM             , Element.elementByAtomicNumber ( 67), "Element with atomic number  67 must be HOLMIUM             ") ;
        assertEquals (Element.ERBIUM              , Element.elementByAtomicNumber ( 68), "Element with atomic number  68 must be ERBIUM              ") ;
        assertEquals (Element.THULIUM             , Element.elementByAtomicNumber ( 69), "Element with atomic number  69 must be THULIUM             ") ;
        assertEquals (Element.YTTERBIUM           , Element.elementByAtomicNumber ( 70), "Element with atomic number  70 must be YTTERBIUM           ") ;
        assertEquals (Element.LUTETIUM            , Element.elementByAtomicNumber ( 71), "Element with atomic number  71 must be LUTETIUM            ") ;
        assertEquals (Element.HAFNIUM             , Element.elementByAtomicNumber ( 72), "Element with atomic number  72 must be HAFNIUM             ") ;
        assertEquals (Element.TANTALUM            , Element.elementByAtomicNumber ( 73), "Element with atomic number  73 must be TANTALUM            ") ;
        assertEquals (Element.TUNGSTEN            , Element.elementByAtomicNumber ( 74), "Element with atomic number  74 must be TUNGSTEN            ") ;
        assertEquals (Element.RHENIUM             , Element.elementByAtomicNumber ( 75), "Element with atomic number  75 must be RHENIUM             ") ;
        assertEquals (Element.OSMIUM              , Element.elementByAtomicNumber ( 76), "Element with atomic number  76 must be OSMIUM              ") ;
        assertEquals (Element.IRIDIUM             , Element.elementByAtomicNumber ( 77), "Element with atomic number  77 must be IRIDIUM             ") ;
        assertEquals (Element.PLATINUM            , Element.elementByAtomicNumber ( 78), "Element with atomic number  78 must be PLATINUM            ") ;
        assertEquals (Element.GOLD                , Element.elementByAtomicNumber ( 79), "Element with atomic number  79 must be GOLD                ") ;
        assertEquals (Element.MERCURY             , Element.elementByAtomicNumber ( 80), "Element with atomic number  80 must be MERCURY             ") ;
        assertEquals (Element.THALLIUM            , Element.elementByAtomicNumber ( 81), "Element with atomic number  81 must be THALLIUM            ") ;
        assertEquals (Element.LEAD                , Element.elementByAtomicNumber ( 82), "Element with atomic number  82 must be LEAD                ") ;
        assertEquals (Element.BISMUTH             , Element.elementByAtomicNumber ( 83), "Element with atomic number  83 must be BISMUTH             ") ;
        assertEquals (Element.POLONIUM            , Element.elementByAtomicNumber ( 84), "Element with atomic number  84 must be POLONIUM            ") ;
        assertEquals (Element.ASTATINE            , Element.elementByAtomicNumber ( 85), "Element with atomic number  85 must be ASTATINE            ") ;
        assertEquals (Element.RADON               , Element.elementByAtomicNumber ( 86), "Element with atomic number  86 must be RADON               ") ;
        assertEquals (Element.FRANCIUM            , Element.elementByAtomicNumber ( 87), "Element with atomic number  87 must be FRANCIUM            ") ;
        assertEquals (Element.RADIUM              , Element.elementByAtomicNumber ( 88), "Element with atomic number  88 must be RADIUM              ") ;
        assertEquals (Element.ACTINIUM            , Element.elementByAtomicNumber ( 89), "Element with atomic number  89 must be ACTINIUM            ") ;
        assertEquals (Element.THORIUM             , Element.elementByAtomicNumber ( 90), "Element with atomic number  90 must be THORIUM             ") ;
        assertEquals (Element.PROTACTINIUM        , Element.elementByAtomicNumber ( 91), "Element with atomic number  91 must be PROTACTINIUM        ") ;
        assertEquals (Element.URANIUM             , Element.elementByAtomicNumber ( 92), "Element with atomic number  92 must be URANIUM             ") ;
        assertEquals (Element.NEPTUNIUM           , Element.elementByAtomicNumber ( 93), "Element with atomic number  93 must be NEPTUNIUM           ") ;
        assertEquals (Element.PLUTONIUM           , Element.elementByAtomicNumber ( 94), "Element with atomic number  94 must be PLUTONIUM           ") ;
        assertEquals (Element.AMERICIUM           , Element.elementByAtomicNumber ( 95), "Element with atomic number  95 must be AMERICIUM           ") ;
        assertEquals (Element.CURIUM              , Element.elementByAtomicNumber ( 96), "Element with atomic number  96 must be CURIUM              ") ;
        assertEquals (Element.BERKELIUM           , Element.elementByAtomicNumber ( 97), "Element with atomic number  97 must be BERKELIUM           ") ;
        assertEquals (Element.CALIFORNIUM         , Element.elementByAtomicNumber ( 98), "Element with atomic number  98 must be CALIFORNIUM         ") ;
        assertEquals (Element.EINSTEINIUM         , Element.elementByAtomicNumber ( 99), "Element with atomic number  99 must be EINSTEINIUM         ") ;
        assertEquals (Element.FERMIUM             , Element.elementByAtomicNumber (100), "Element with atomic number 100 must be FERMIUM             ") ;
        assertEquals (Element.MENDELEVIUM         , Element.elementByAtomicNumber (101), "Element with atomic number 101 must be MENDELEVIUM         ") ;
        assertEquals (Element.NOBELIUM            , Element.elementByAtomicNumber (102), "Element with atomic number 102 must be NOBELIUM            ") ;
        assertEquals (Element.LAWRENCIUM          , Element.elementByAtomicNumber (103), "Element with atomic number 103 must be LAWRENCIUM          ") ;
        assertEquals (Element.RUTHERFORDIUM       , Element.elementByAtomicNumber (104), "Element with atomic number 104 must be RUTHERFORDIUM       ") ;
        assertEquals (Element.DUBNIUM             , Element.elementByAtomicNumber (105), "Element with atomic number 105 must be DUBNIUM             ") ;
        assertEquals (Element.SEABORGIUM          , Element.elementByAtomicNumber (106), "Element with atomic number 106 must be SEABORGIUM          ") ;
        assertEquals (Element.BOHRIUM             , Element.elementByAtomicNumber (107), "Element with atomic number 107 must be BOHRIUM             ") ;
        assertEquals (Element.HASSIUM             , Element.elementByAtomicNumber (108), "Element with atomic number 108 must be HASSIUM             ") ;
        assertEquals (Element.MEITNERIUM          , Element.elementByAtomicNumber (109), "Element with atomic number 109 must be MEITNERIUM          ") ;
        assertEquals (Element.DARMSTADTIUM        , Element.elementByAtomicNumber (110), "Element with atomic number 110 must be DARMSTADTIUM        ") ;
        assertEquals (Element.ROENTGENIUM         , Element.elementByAtomicNumber (111), "Element with atomic number 111 must be ROENTGENIUM         ") ;
        assertEquals (Element.COPERNICIUM         , Element.elementByAtomicNumber (112), "Element with atomic number 112 must be COPERNICIUM         ") ;
        assertEquals (Element.NIHONIUM            , Element.elementByAtomicNumber (113), "Element with atomic number 113 must be NIHONIUM            ") ;
        assertEquals (Element.FLEROVIUM           , Element.elementByAtomicNumber (114), "Element with atomic number 114 must be FLEROVIUM           ") ;
        assertEquals (Element.MOSCOVIUM           , Element.elementByAtomicNumber (115), "Element with atomic number 115 must be MOSCOVIUM           ") ;
        assertEquals (Element.LIVERMORIUM         , Element.elementByAtomicNumber (116), "Element with atomic number 116 must be LIVERMORIUM         ") ;
        assertEquals (Element.TENNESSINE          , Element.elementByAtomicNumber (117), "Element with atomic number 117 must be TENNESSINE          ") ;
        assertEquals (Element.OGANESSON           , Element.elementByAtomicNumber (118), "Element with atomic number 118 must be OGANESSON           ") ;


        Element[] allElements = Element.values () ;
        assertEquals (118, allElements.length, "Must have 118 elements") ;
        for (int i = 0 ; i < allElements.length ; i++) {
            final int index = i ;
            assertEquals (i + 1, allElements[i].getAtomicNumber (), () -> "ordinal vs atomic number invalid:" + index) ;
        }

        // Test invalid range when search by atomic number.
        assertThrows (IllegalArgumentException.class, () -> Element.elementByAtomicNumber (0), "IllegalArgumentException when searching < 1") ;
        assertThrows (IllegalArgumentException.class, () -> Element.elementByAtomicNumber (119), "IllegalArgumentException when searching > 118") ;
    }

    @Test
    void testElementGettersWithSampleElements () {
        // Test Hydrogen
        Element h = Element.HYDROGEN ;
        assertEquals (1, h.getAtomicNumber (), "AtomicNumber de Hydrogen must be 1") ;
        assertEquals ("H", h.getSymbol (), "Symbol de Hydrogen must be H") ;
        assertEquals ("Hydrogen", h.getName (), "Name de Hydrogen must be Hydrogen") ;
        assertEquals (1, h.getGroup (), "Group de Hydrogen must be 1") ;
        assertEquals (1, h.getPeriod (), "Period de Hydrogen must be 1") ;
        assertEquals ("s", h.getBlock (), "Block de Hydrogen must be s") ;
        assertEquals (1.008, h.getStandardAtomicWeight (), "StandardAtomicWeight de Hydrogen must be 1.008") ;

        // Test Carbon
        Element c = Element.CARBON ;
        assertEquals (6, c.getAtomicNumber (), "AtomicNumber de Carbon must be 6") ;
        assertEquals ("C", c.getSymbol (), "Symbol de Carbon must be C") ;
        assertEquals ("Carbon", c.getName (), "Name de Carbon must be Carbon") ;
        assertEquals (14, c.getGroup (), "Group de Carbon must be 14") ;
        assertEquals (2, c.getPeriod (), "Period de Carbon must be 2") ;
        assertEquals ("p", c.getBlock (), "Block de Carbon must be p") ;
        assertEquals (12.011, c.getStandardAtomicWeight (), "StandardAtomicWeight de Carbon must be 12.011") ;

        // Test Iron
        Element fe = Element.IRON ;
        assertEquals (26, fe.getAtomicNumber (), "AtomicNumber de Iron must be 26") ;
        assertEquals ("Fe", fe.getSymbol (), "Symbol de Iron must be Fe") ;
        assertEquals ("Iron", fe.getName (), "Name de Iron must be Iron") ;
        assertEquals (8, fe.getGroup (), "Group de Iron must be 8") ;
        assertEquals (4, fe.getPeriod (), "Period de Iron must be 4") ;
        assertEquals ("d", fe.getBlock (), "Block de Iron must be d") ;
        assertEquals (55.845, fe.getStandardAtomicWeight (), "StandardAtomicWeight de Iron must be 55.845") ;

        // Test Gold
        Element au = Element.GOLD ;
        assertEquals (79, au.getAtomicNumber (), "AtomicNumber de Gold must be 79") ;
        assertEquals ("Au", au.getSymbol (), "Symbol de Gold must be Au") ;
        assertEquals ("Gold", au.getName (), "Name de Gold must be Gold") ;
        assertEquals (11, au.getGroup (), "Group de Gold must be 11") ;
        assertEquals (6, au.getPeriod (), "Period de Gold must be 6") ;
        assertEquals ("d", au.getBlock (), "Block de Gold must be d") ;
        assertEquals (196.97, au.getStandardAtomicWeight (), "StandardAtomicWeight de Gold must be 196.97") ;

        // Test Oganesson
        Element og = Element.OGANESSON ;
        assertEquals (118, og.getAtomicNumber (), "AtomicNumber de Oganesson must be 118") ;
        assertEquals ("Og", og.getSymbol (), "Symbol de Oganesson must be Og") ;
        assertEquals ("Oganesson", og.getName (), "Name de Oganesson must be Oganesson") ;
        assertEquals (18, og.getGroup (), "Group de Oganesson must be 18") ;
        assertEquals (7, og.getPeriod (), "Period de Oganesson must be 7") ;
        assertEquals ("p", og.getBlock (), "Block de Oganesson must be p") ;
        assertEquals (294.00, og.getStandardAtomicWeight (), "StandardAtomicWeight de Oganesson must be 294.00") ;
    }
}