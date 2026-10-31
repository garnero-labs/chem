# Chem

Base module for **Hydrocarbons-02**, a modular project designed to process molecular data, handle chemical nomenclature, and render 3D structures.

## Tech Stack
- **Java 25 (LTS)**
- **Maven 3.9.9**

## Getting Started

### Prerequisites
Ensure you have Java 25 and Maven installed.

Build: Run `mvn clean package`

Run: Run `java -jar target/chem-1.0-SNAPSHOT.jar`

## Architecture & Domain Model

```mermaid
classDiagram
    class Element {
        <<enumeration>>
        HYDROGEN
        CARBON
        OXYGEN
        ...
        -int atomicNumber
        +int getAtomicNumber()
    }

    class Point {
        -double x
        -double y
        -double z
        +Point copy()
    }

    class Bond {
        -int id
        -int fromAtom
        -int toAtom
        +Bond copy()
    }

    class Atom {
        -int id
        -Element element
        -Point position
        -List~Bond~ bonds
        +Atom copy()
    }

    class Molecule {
        -String name
        -int id
        -boolean is2D
        -List~Atom~ atoms
        -List~Bond~ bonds
        +Molecule copy()
        +Set~Element~ getMadeOf()
        +boolean isHydroCarbon()
        +Atom getFromAtom(Bond bond)
        +Atom getToAtom(Bond bond)
    }

    Molecule "1" *-- "*" Atom : contains
    Molecule "1" *-- "*" Bond : contains
    Atom "1" --> "1" Element : has type
    Atom "0..1" --> "0..1" Point : located at
    Atom "1" o-- "*" Bond : connected via