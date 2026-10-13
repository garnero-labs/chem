package com.jorgegarnero.chem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ElementTest {

    @Test
    void testElementByAtomicNumber () {
        // Full test. Order in the enum matters. This prevents any change altering the order.
        assertEquals (Element.HYDROGEN, Element.elementByAtomicNumber (1));
        assertEquals (Element.HELIUM, Element.elementByAtomicNumber (2));
        assertEquals (Element.LITHIUM, Element.elementByAtomicNumber (3));
        assertEquals (Element.BERYLLIUM, Element.elementByAtomicNumber (4));
        assertEquals (Element.BORON, Element.elementByAtomicNumber (5));
        assertEquals (Element.CARBON, Element.elementByAtomicNumber (6));
        assertEquals (Element.NITROGEN, Element.elementByAtomicNumber (7));
        assertEquals (Element.OXYGEN, Element.elementByAtomicNumber (8));
        assertEquals (Element.FLUORINE, Element.elementByAtomicNumber (9));
        assertEquals (Element.NEON, Element.elementByAtomicNumber (10));
        assertEquals (Element.SODIUM, Element.elementByAtomicNumber (11));
        assertEquals (Element.MAGNESIUM, Element.elementByAtomicNumber (12));
        assertEquals (Element.ALUMINIUM, Element.elementByAtomicNumber (13));
        assertEquals (Element.SILICON, Element.elementByAtomicNumber (14));
        assertEquals (Element.PHOSPHORUS, Element.elementByAtomicNumber (15));
        assertEquals (Element.SULFUR, Element.elementByAtomicNumber (16));
        assertEquals (Element.CHLORINE, Element.elementByAtomicNumber (17));
        assertEquals (Element.ARGON, Element.elementByAtomicNumber (18));
        assertEquals (Element.POTASSIUM, Element.elementByAtomicNumber (19));
        assertEquals (Element.CALCIUM, Element.elementByAtomicNumber (20));
        assertEquals (Element.SCANDIUM, Element.elementByAtomicNumber (21));
        assertEquals (Element.TITANIUM, Element.elementByAtomicNumber (22));
        assertEquals (Element.VANADIUM, Element.elementByAtomicNumber (23));
        assertEquals (Element.CHROMIUM, Element.elementByAtomicNumber (24));
        assertEquals (Element.MANGANESE, Element.elementByAtomicNumber (25));
        assertEquals (Element.IRON, Element.elementByAtomicNumber (26));
        assertEquals (Element.COBALT, Element.elementByAtomicNumber (27));
        assertEquals (Element.NICKEL, Element.elementByAtomicNumber (28));
        assertEquals (Element.COPPER, Element.elementByAtomicNumber (29));
        assertEquals (Element.ZINC, Element.elementByAtomicNumber (30));
        assertEquals (Element.GALLIUM, Element.elementByAtomicNumber (31));
        assertEquals (Element.GERMANIUM, Element.elementByAtomicNumber (32));
        assertEquals (Element.ARSENIC, Element.elementByAtomicNumber (33));
        assertEquals (Element.SELENIUM, Element.elementByAtomicNumber (34));
        assertEquals (Element.BROMINE, Element.elementByAtomicNumber (35));
        assertEquals (Element.KRYPTON, Element.elementByAtomicNumber (36));
        assertEquals (Element.RUBIDIUM, Element.elementByAtomicNumber (37));
        assertEquals (Element.STRONTIUM, Element.elementByAtomicNumber (38));
        assertEquals (Element.YTTRIUM, Element.elementByAtomicNumber (39));
        assertEquals (Element.ZIRCONIUM, Element.elementByAtomicNumber (40));
        assertEquals (Element.NIOBIUM, Element.elementByAtomicNumber (41));
        assertEquals (Element.MOLYBDENUM, Element.elementByAtomicNumber (42));
        assertEquals (Element.TECHNETIUM, Element.elementByAtomicNumber (43));
        assertEquals (Element.RUTHENIUM, Element.elementByAtomicNumber (44));
        assertEquals (Element.RHODIUM, Element.elementByAtomicNumber (45));
        assertEquals (Element.PALLADIUM, Element.elementByAtomicNumber (46));
        assertEquals (Element.SILVER, Element.elementByAtomicNumber (47));
        assertEquals (Element.CADMIUM, Element.elementByAtomicNumber (48));
        assertEquals (Element.INDIUM, Element.elementByAtomicNumber (49));
        assertEquals (Element.TIN, Element.elementByAtomicNumber (50));
        assertEquals (Element.ANTIMONY, Element.elementByAtomicNumber (51));
        assertEquals (Element.TELLURIUM, Element.elementByAtomicNumber (52));
        assertEquals (Element.IODINE, Element.elementByAtomicNumber (53));
        assertEquals (Element.XENON, Element.elementByAtomicNumber (54));
        assertEquals (Element.CAESIUM, Element.elementByAtomicNumber (55));
        assertEquals (Element.BARIUM, Element.elementByAtomicNumber (56));
        assertEquals (Element.LANTHANUM, Element.elementByAtomicNumber (57));
        assertEquals (Element.CERIUM, Element.elementByAtomicNumber (58));
        assertEquals (Element.PRASEODYMIUM, Element.elementByAtomicNumber (59));
        assertEquals (Element.NEODYMIUM, Element.elementByAtomicNumber (60));
        assertEquals (Element.PROMETHIUM, Element.elementByAtomicNumber (61));
        assertEquals (Element.SAMARIUM, Element.elementByAtomicNumber (62));
        assertEquals (Element.EUROPIUM, Element.elementByAtomicNumber (63));
        assertEquals (Element.GADOLINIUM, Element.elementByAtomicNumber (64));
        assertEquals (Element.TERBIUM, Element.elementByAtomicNumber (65));
        assertEquals (Element.DYSPROSIUM, Element.elementByAtomicNumber (66));
        assertEquals (Element.HOLMIUM, Element.elementByAtomicNumber (67));
        assertEquals (Element.ERBIUM, Element.elementByAtomicNumber (68));
        assertEquals (Element.THULIUM, Element.elementByAtomicNumber (69));
        assertEquals (Element.YTTERBIUM, Element.elementByAtomicNumber (70));
        assertEquals (Element.LUTETIUM, Element.elementByAtomicNumber (71));
        assertEquals (Element.HAFNIUM, Element.elementByAtomicNumber (72));
        assertEquals (Element.TANTALUM, Element.elementByAtomicNumber (73));
        assertEquals (Element.TUNGSTEN, Element.elementByAtomicNumber (74));
        assertEquals (Element.RHENIUM, Element.elementByAtomicNumber (75));
        assertEquals (Element.OSMIUM, Element.elementByAtomicNumber (76));
        assertEquals (Element.IRIDIUM, Element.elementByAtomicNumber (77));
        assertEquals (Element.PLATINUM, Element.elementByAtomicNumber (78));
        assertEquals (Element.GOLD, Element.elementByAtomicNumber (79));
        assertEquals (Element.MERCURY, Element.elementByAtomicNumber (80));
        assertEquals (Element.THALLIUM, Element.elementByAtomicNumber (81));
        assertEquals (Element.LEAD, Element.elementByAtomicNumber (82));
        assertEquals (Element.BISMUTH, Element.elementByAtomicNumber (83));
        assertEquals (Element.POLONIUM, Element.elementByAtomicNumber (84));
        assertEquals (Element.ASTATINE, Element.elementByAtomicNumber (85));
        assertEquals (Element.RADON, Element.elementByAtomicNumber (86));
        assertEquals (Element.FRANCIUM, Element.elementByAtomicNumber (87));
        assertEquals (Element.RADIUM, Element.elementByAtomicNumber (88));
        assertEquals (Element.ACTINIUM, Element.elementByAtomicNumber (89));
        assertEquals (Element.THORIUM, Element.elementByAtomicNumber (90));
        assertEquals (Element.PROTACTINIUM, Element.elementByAtomicNumber (91));
        assertEquals (Element.URANIUM, Element.elementByAtomicNumber (92));
        assertEquals (Element.NEPTUNIUM, Element.elementByAtomicNumber (93));
        assertEquals (Element.PLUTONIUM, Element.elementByAtomicNumber (94));
        assertEquals (Element.AMERICIUM, Element.elementByAtomicNumber (95));
        assertEquals (Element.CURIUM, Element.elementByAtomicNumber (96));
        assertEquals (Element.BERKELIUM, Element.elementByAtomicNumber (97));
        assertEquals (Element.CALIFORNIUM, Element.elementByAtomicNumber (98));
        assertEquals (Element.EINSTEINIUM, Element.elementByAtomicNumber (99));
        assertEquals (Element.FERMIUM, Element.elementByAtomicNumber (100));
        assertEquals (Element.MENDELEVIUM, Element.elementByAtomicNumber (101));
        assertEquals (Element.NOBELIUM, Element.elementByAtomicNumber (102));
        assertEquals (Element.LAWRENCIUM, Element.elementByAtomicNumber (103));
        assertEquals (Element.RUTHERFORDIUM, Element.elementByAtomicNumber (104));
        assertEquals (Element.DUBNIUM, Element.elementByAtomicNumber (105));
        assertEquals (Element.SEABORGIUM, Element.elementByAtomicNumber (106));
        assertEquals (Element.BOHRIUM, Element.elementByAtomicNumber (107));
        assertEquals (Element.HASSIUM, Element.elementByAtomicNumber (108));
        assertEquals (Element.MEITNERIUM, Element.elementByAtomicNumber (109));
        assertEquals (Element.DARMSTADTIUM, Element.elementByAtomicNumber (110));
        assertEquals (Element.ROENTGENIUM, Element.elementByAtomicNumber (111));
        assertEquals (Element.COPERNICIUM, Element.elementByAtomicNumber (112));
        assertEquals (Element.NIHONIUM, Element.elementByAtomicNumber (113));
        assertEquals (Element.FLEROVIUM, Element.elementByAtomicNumber (114));
        assertEquals (Element.MOSCOVIUM, Element.elementByAtomicNumber (115));
        assertEquals (Element.LIVERMORIUM, Element.elementByAtomicNumber (116));
        assertEquals (Element.TENNESSINE, Element.elementByAtomicNumber (117));
        assertEquals (Element.OGANESSON, Element.elementByAtomicNumber (118));

        // Validate exceptions for out of range.
        assertThrows (IllegalArgumentException.class, () -> Element.elementByAtomicNumber (0));
        assertThrows (IllegalArgumentException.class, () -> Element.elementByAtomicNumber (119));
    }

    @Test
    void testElementGettersWithSampleElements () {
        // 1. Test Hydrogen (s-block, period 1, group 1)
        Element h = Element.HYDROGEN;
        assertEquals (1, h.getAtomicNumber ());
        assertEquals ("H", h.getSymbol ());
        assertEquals ("Hydrogen", h.getName ());
        assertEquals (1, h.getGroup ());
        assertEquals (1, h.getPeriod ());
        assertEquals ("s", h.getBlock ());
        assertEquals (1.008, h.getStandardAtomicWeight ());

        // 2. Test Carbon (p-block, period 2, group 14)
        Element c = Element.CARBON;
        assertEquals (6, c.getAtomicNumber ());
        assertEquals ("C", c.getSymbol ());
        assertEquals ("Carbon", c.getName ());
        assertEquals (14, c.getGroup ());
        assertEquals (2, c.getPeriod ());
        assertEquals ("p", c.getBlock ());
        assertEquals (12.011, c.getStandardAtomicWeight ());

        // 3. Test Iron (d-block, period 4, group 8)
        Element fe = Element.IRON;
        assertEquals (26, fe.getAtomicNumber ());
        assertEquals ("Fe", fe.getSymbol ());
        assertEquals ("Iron", fe.getName ());
        assertEquals (8, fe.getGroup ());
        assertEquals (4, fe.getPeriod ());
        assertEquals ("d", fe.getBlock ());
        assertEquals (55.845, fe.getStandardAtomicWeight ());

        // 4. Test Gold (d-block, period 6, group 11)
        Element au = Element.GOLD;
        assertEquals (79, au.getAtomicNumber ());
        assertEquals ("Au", au.getSymbol ());
        assertEquals ("Gold", au.getName ());
        assertEquals (11, au.getGroup ());
        assertEquals (6, au.getPeriod ());
        assertEquals ("d", au.getBlock ());
        assertEquals (196.97, au.getStandardAtomicWeight ());

        // 5. Test Oganesson (p-block, period 7, group 18)
        Element og = Element.OGANESSON;
        assertEquals (118, og.getAtomicNumber ());
        assertEquals ("Og", og.getSymbol ());
        assertEquals ("Oganesson", og.getName ());
        assertEquals (18, og.getGroup ());
        assertEquals (7, og.getPeriod ());
        assertEquals ("p", og.getBlock ());
        assertEquals (294.00, og.getStandardAtomicWeight ());
    }
}