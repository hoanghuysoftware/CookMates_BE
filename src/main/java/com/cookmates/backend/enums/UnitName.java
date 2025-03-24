package com.cookmates.backend.enums;

public enum UnitName {
    GRAM("g"),         // Gram - gam
    KILOGRAM("kg"),    // Kilogram - ký (kg)
    LITER("L"),        // Liter - lít
    MILLILITER("mL"),  // Milliliter - mililit
    TEASPOON("tsp"),   // Teaspoon - muỗng cà phê
    TABLESPOON("tbsp"),// Tablespoon - muỗng canh
    CUP("cup"),        // Cup - cốc
    PIECE("piece");    // Piece - cái, miếng

    private final String symbol;

    UnitName(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
