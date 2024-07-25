package com.falah.test;

public enum SpecialChar {
    A(30, 'A'),
    B(48, 'B'),
    C(46, 'C'),
    D(32, 'D'),
    E(18, 'E'),
    F(33, 'F'),
    G(34, 'G'),
    H(35, 'H'),
    I(23, 'I'),
    J(36, 'J'),
    K(37, 'K'),
    L(38, 'L'),
    M(50, 'M'),
    N(49, 'N'),
    O(24, 'O'),
    P(25, 'P'),
    Q(16, 'Q'),
    R(19, 'R'),
    S(31, 'S'),
    T(20, 'T'),
    U(17, 'U'),
    V(47, 'V'),
    W(17, 'W'),
    X(45, 'X'),
    Y(21, 'Y'),
    Z(44, 'Z'),

    EXCLAMATION(2, '!'),
    AT(3, '@'),
    HASH(4, '#'),
    DOLLAR(5, '$'),
    PERCENT(6, '%'),
    CARET(7, '^'),
    AMPERSAND(8, '&'),
    ASTERISK(9, '*'),
    OPEN_PARENTHESIS(10, '('),
    CLOSE_PARENTHESIS(11, ')'),
    UNDERSCORE(12, '_'),
    PLUS(13, '+'),
    OPEN_BRACE(26, '{'),
    CLOSE_BRACE(27, '}'),
    COLON(39, ':'),
    DOUBLE_QUOTE(40, '\"');


    private final int code;
    private final char value;

    SpecialChar(int code, char value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public char getValue() {
        return value;
    }

    public static SpecialChar get(int code) {
        for (SpecialChar specialChar : SpecialChar.values())
            if (specialChar.getCode() == code) return specialChar;
        return null;
    }
}
