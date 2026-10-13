package com.jorgegarnero.chem;

public enum Element {

    HYDROGEN       (    "H"    ,"Hydrogen"     ,1       ,1  , "s", 1.008)    ,
    HELIUM         (    "He"   ,"Helium"       ,18      ,1  , "s", 4.0026)   ,
    LITHIUM        (    "Li"   ,"Lithium"      ,1       ,2  , "s", 6.94)     ,
    BERYLLIUM      (    "Be"   ,"Beryllium"    ,2       ,2  , "s", 9.0122)   ,
    BORON          (    "B"    ,"Boron"        ,13      ,2  , "p", 10.81)    ,
    CARBON         (    "C"    ,"Carbon"       ,14      ,2  , "p", 12.011)   ,
    NITROGEN       (    "N"    ,"Nitrogen"     ,15      ,2  , "p", 14.007)   ,
    OXYGEN         (    "O"    ,"Oxygen"       ,16      ,2  , "p", 15.999)   ,
    FLUORINE       (    "F"    ,"Fluorine"     ,17      ,2  , "p", 18.998)   ,
    NEON           (    "Ne"   ,"Neon"         ,18      ,2  , "p", 20.18)    ,
    SODIUM         (    "Na"   ,"Sodium"       ,1       ,3  , "s", 22.99)    ,
    MAGNESIUM      (    "Mg"   ,"Magnesium"    ,2       ,3  , "s", 24.305)   ,
    ALUMINIUM      (    "Al"   ,"Aluminium"    ,13      ,3  , "p", 26.982)   ,
    SILICON        (    "Si"   ,"Silicon"      ,14      ,3  , "p", 28.085)   ,
    PHOSPHORUS     (    "P"    ,"Phosphorus"   ,15      ,3  , "p", 30.974)   ,
    SULFUR         (    "S"    ,"Sulfur"       ,16      ,3  , "p", 32.06)    ,
    CHLORINE       (    "Cl"   ,"Chlorine"     ,17      ,3  , "p", 35.45)    ,
    ARGON          (    "Ar"   ,"Argon"        ,18      ,3  , "p", 39.95)    ,
    POTASSIUM      (    "K"    ,"Potassium"    ,1       ,4  , "s", 39.098)   ,
    CALCIUM        (    "Ca"   ,"Calcium"      ,2       ,4  , "s", 40.078)   ,
    SCANDIUM       (    "Sc"   ,"Scandium"     ,3       ,4  , "d", 44.956)   ,
    TITANIUM       (    "Ti"   ,"Titanium"     ,4       ,4  , "d", 47.867)   ,
    VANADIUM       (    "V"    ,"Vanadium"     ,5       ,4  , "d", 50.942)   ,
    CHROMIUM       (    "Cr"   ,"Chromium"     ,6       ,4  , "d", 51.996)   ,
    MANGANESE      (    "Mn"   ,"Manganese"    ,7       ,4  , "d", 54.938)   ,
    IRON           (    "Fe"   ,"Iron"         ,8       ,4  , "d", 55.845)   ,
    COBALT         (    "Co"   ,"Cobalt"       ,9       ,4  , "d", 58.933)   ,
    NICKEL         (    "Ni"   ,"Nickel"       ,10      ,4  , "d", 58.693)   ,
    COPPER         (    "Cu"   ,"Copper"       ,11      ,4  , "d", 63.546)   ,
    ZINC           (    "Zn"   ,"Zinc"         ,12      ,4  , "d", 65.38)    ,
    GALLIUM        (    "Ga"   ,"Gallium"      ,13      ,4  , "p", 69.723)   ,
    GERMANIUM      (    "Ge"   ,"Germanium"    ,14      ,4  , "p", 72.63)    ,
    ARSENIC        (    "As"   ,"Arsenic"      ,15      ,4  , "p", 74.922)   ,
    SELENIUM       (    "Se"   ,"Selenium"     ,16      ,4  , "p", 78.971)   ,
    BROMINE        (    "Br"   ,"Bromine"      ,17      ,4  , "p", 79.904)   ,
    KRYPTON        (    "Kr"   ,"Krypton"      ,18      ,4  , "p", 83.798)   ,
    RUBIDIUM       (    "Rb"   ,"Rubidium"     ,1       ,5  , "s", 85.468)   ,
    STRONTIUM      (    "Sr"   ,"Strontium"    ,2       ,5  , "s", 87.62)    ,
    YTTRIUM        (    "Y"    ,"Yttrium"      ,3       ,5  , "d", 88.906)   ,
    ZIRCONIUM      (    "Zr"   ,"Zirconium"    ,4       ,5  , "d", 91.224)   ,
    NIOBIUM        (    "Nb"   ,"Niobium"      ,5       ,5  , "d", 92.906)   ,
    MOLYBDENUM     (    "Mo"   ,"Molybdenum"   ,6       ,5  , "d", 95.95)    ,
    TECHNETIUM     (    "Tc"   ,"Technetium"   ,7       ,5  , "d", 97.00)    ,
    RUTHENIUM      (    "Ru"   ,"Ruthenium"    ,8       ,5  , "d", 101.07)   ,
    RHODIUM        (    "Rh"   ,"Rhodium"      ,9       ,5  , "d", 102.91)   ,
    PALLADIUM      (    "Pd"   ,"Palladium"    ,10      ,5  , "d", 106.42)   ,
    SILVER         (    "Ag"   ,"Silver"       ,11      ,5  , "d", 107.87)   ,
    CADMIUM        (    "Cd"   ,"Cadmium"      ,12      ,5  , "d", 112.41)   ,
    INDIUM         (    "In"   ,"Indium"       ,13      ,5  , "p", 114.82)   ,
    TIN            (    "Sn"   ,"Tin"          ,14      ,5  , "p", 118.71)   ,
    ANTIMONY       (    "Sb"   ,"Antimony"     ,15      ,5  , "p", 121.76)   ,
    TELLURIUM      (    "Te"   ,"Tellurium"    ,16      ,5  , "p", 127.6)    ,
    IODINE         (    "I"    ,"Iodine"       ,17      ,5  , "p", 126.9)    ,
    XENON          (    "Xe"   ,"Xenon"        ,18      ,5  , "p", 131.29)   ,
    CAESIUM        (    "Cs"   ,"Caesium"      ,1       ,6  , "s", 132.91)   ,
    BARIUM         (    "Ba"   ,"Barium"       ,2       ,6  , "s", 137.33)   ,
    LANTHANUM      (    "La"   ,"Lanthanum"    ,999     ,6  , "f", 138.91)   ,
    CERIUM         (    "Ce"   ,"Cerium"       ,999     ,6  , "f", 140.12)   ,
    PRASEODYMIUM   (    "Pr"   ,"Praseodymium" ,999     ,6  , "f", 140.91)   ,
    NEODYMIUM      (    "Nd"   ,"Neodymium"    ,999     ,6  , "f", 144.24)   ,
    PROMETHIUM     (    "Pm"   ,"Promethium"   ,999     ,6  , "f", 145.00)   ,
    SAMARIUM       (    "Sm"   ,"Samarium"     ,999     ,6  , "f", 150.36)   ,
    EUROPIUM       (    "Eu"   ,"Europium"     ,999     ,6  , "f", 151.96)   ,
    GADOLINIUM     (    "Gd"   ,"Gadolinium"   ,999     ,6  , "f", 157.25)   ,
    TERBIUM        (    "Tb"   ,"Terbium"      ,999     ,6  , "f", 158.93)   ,
    DYSPROSIUM     (    "Dy"   ,"Dysprosium"   ,999     ,6  , "f", 162.50)   ,
    HOLMIUM        (    "Ho"   ,"Holmium"      ,999     ,6  , "f", 164.93)   ,
    ERBIUM         (    "Er"   ,"Erbium"       ,999     ,6  , "f", 167.26)   ,
    THULIUM        (    "Tm"   ,"Thulium"      ,999     ,6  , "f", 168.93)   ,
    YTTERBIUM      (    "Yb"   ,"Ytterbium"    ,999     ,6  , "f", 173.05)   ,
    LUTETIUM       (    "Lu"   ,"Lutetium"     ,3       ,6  , "d", 174.97)   ,
    HAFNIUM        (    "Hf"   ,"Hafnium"      ,4       ,6  , "d", 178.49)   ,
    TANTALUM       (    "Ta"   ,"Tantalum"     ,5       ,6  , "d", 180.95)   ,
    TUNGSTEN       (    "W"    ,"Tungsten"     ,6       ,6  , "d", 183.84)   ,
    RHENIUM        (    "Re"   ,"Rhenium"      ,7       ,6  , "d", 186.21)   ,
    OSMIUM         (    "Os"   ,"Osmium"       ,8       ,6  , "d", 190.23)   ,
    IRIDIUM        (    "Ir"   ,"Iridium"      ,9       ,6  , "d", 192.22)   ,
    PLATINUM       (    "Pt"   ,"Platinum"     ,10      ,6  , "d", 195.08)   ,
    GOLD           (    "Au"   ,"Gold"         ,11      ,6  , "d", 196.97)   ,
    MERCURY        (    "Hg"   ,"Mercury"      ,12      ,6  , "d", 200.59)   ,
    THALLIUM       (    "Tl"   ,"Thallium"     ,13      ,6  , "p", 204.38)   ,
    LEAD           (    "Pb"   ,"Lead"         ,14      ,6  , "p", 207.20)   ,
    BISMUTH        (    "Bi"   ,"Bismuth"      ,15      ,6  , "p", 208.98)   ,
    POLONIUM       (    "Po"   ,"Polonium"     ,16      ,6  , "p", 209.00)   ,
    ASTATINE       (    "At"   ,"Astatine"     ,17      ,6  , "p", 210.00)   ,
    RADON          (    "Rn"   ,"Radon"        ,18      ,6  , "p", 222.00)   ,
    FRANCIUM       (    "Fr"   ,"Francium"     ,1       ,7  , "s", 223.00)   ,
    RADIUM         (    "Ra"   ,"Radium"       ,2       ,7  , "s", 226.00)   ,
    ACTINIUM       (    "Ac"   ,"Actinium"     ,999     ,7  , "f", 227.00)   ,
    THORIUM        (    "Th"   ,"Thorium"      ,999     ,7  , "f", 232.04)   ,
    PROTACTINIUM   (    "Pa"   ,"Protactinium" ,999     ,7  , "f", 231.04)   ,
    URANIUM        (    "U"    ,"Uranium"      ,999     ,7  , "f", 238.03)   ,
    NEPTUNIUM      (    "Np"   ,"Neptunium"    ,999     ,7  , "f", 237.00)   ,
    PLUTONIUM      (    "Pu"   ,"Plutonium"    ,999     ,7  , "f", 244.00)   ,
    AMERICIUM      (    "Am"   ,"Americium"    ,999     ,7  , "f", 243.00)   ,
    CURIUM         (    "Cm"   ,"Curium"       ,999     ,7  , "f", 247.00)   ,
    BERKELIUM      (    "Bk"   ,"Berkelium"    ,999     ,7  , "f", 247.00)   ,
    CALIFORNIUM    (    "Cf"   ,"Californium"  ,999     ,7  , "f", 251.00)   ,
    EINSTEINIUM    (    "Es"   ,"Einsteinium"  ,999     ,7  , "f", 252.00)   ,
    FERMIUM        (    "Fm"   ,"Fermium"      ,999     ,7  , "f", 257.00)   ,
    MENDELEVIUM    (    "Md"   ,"Mendelevium"  ,999     ,7  , "f", 258.00)   ,
    NOBELIUM       (    "No"   ,"Nobelium"     ,999     ,7  , "f", 259.00)   ,
    LAWRENCIUM     (    "Lr"   ,"Lawrencium"   ,3       ,7  , "d", 266.00)   ,
    RUTHERFORDIUM  (    "Rf"   ,"Rutherfordium",4       ,7  , "d", 267.00)   ,
    DUBNIUM        (    "Db"   ,"Dubnium"      ,5       ,7  , "d", 268.00)   ,
    SEABORGIUM     (    "Sg"   ,"Seaborgium"   ,6       ,7  , "d", 267.00)   ,
    BOHRIUM        (    "Bh"   ,"Bohrium"      ,7       ,7  , "d", 270.00)   ,
    HASSIUM        (    "Hs"   ,"Hassium"      ,8       ,7  , "d", 271.00)   ,
    MEITNERIUM     (    "Mt"   ,"Meitnerium"   ,9       ,7  , "d", 278.00)   ,
    DARMSTADTIUM   (    "Ds"   ,"Darmstadtium" ,10      ,7  , "d", 281.00)   ,
    ROENTGENIUM    (    "Rg"   ,"Roentgenium"  ,11      ,7  , "d", 282.00)   ,
    COPERNICIUM    (    "Cn"   ,"Copernicium"  ,12      ,7  , "d", 285.00)   ,
    NIHONIUM       (    "Nh"   ,"Nihonium"     ,13      ,7  , "p", 286.00)   ,
    FLEROVIUM      (    "Fl"   ,"Flerovium"    ,14      ,7  , "p", 289.00)   ,
    MOSCOVIUM      (    "Mc"   ,"Moscovium"    ,15      ,7  , "p", 290.00)   ,
    LIVERMORIUM    (    "Lv"   ,"Livermorium"  ,16      ,7  , "p", 293.00)   ,
    TENNESSINE     (    "Ts"   ,"Tennessine"   ,17      ,7  , "p", 294.00)   ,
    OGANESSON      (    "Og"   ,"Oganesson"    ,18      ,7  , "p", 294.00)

    ;

    private final String    symbol                  ;
    private final String    name                    ;
    private final int       group                   ;
    private final int       period                  ;
    private final String    block                   ;
    private final double    standardAtomicWeight    ;

    private static final Element[] VALUES = values();

    Element (String symbol, String name, int group, int period, String block, double standardAtomicWeight) {
        this.symbol       = symbol       ;
        this.name         = name         ;
        this.group        = group        ;
        this.period       = period       ;
        this.block        = block        ;
        this.standardAtomicWeight = standardAtomicWeight ;
    }

    public int      getAtomicNumber         () { return this.ordinal() + 1;             }
    public String   getSymbol               () { return symbol                          ; }
    public String   getName                 () { return name                            ; }
    public int      getGroup                () { return group                           ; }
    public int      getPeriod               () { return period                          ; }
    public String   getBlock                () { return block                           ; }
    public double   getStandardAtomicWeight () { return standardAtomicWeight            ; }

    public static int getTotalElements      () { return VALUES.length;                  }

    public static Element elementByAtomicNumber (int atomicNumber) {
        if (atomicNumber < 1 || atomicNumber > VALUES.length) {
            throw new IllegalArgumentException("Element with atomic number " + atomicNumber + " is out of valid range (1-" + VALUES.length + ").");
        }
        return VALUES[atomicNumber - 1];
    }
}