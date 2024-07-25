package com.falah.test;

public enum Letter {

    A(30, 'a'),
    B(48, 'b'),
    C(46, 'c'),
    D(32, 'd'),
    E(18, 'e'),
    F(33, 'f'),
    G(34, 'g'),
    H(35, 'h'),
    I(23, 'i'),
    J(36, 'j'),
    K(37, 'k'),
    L(38, 'l'),
    M(50, 'm'),
    N(49, 'n'),
    O(24, 'o'),
    P(25, 'p'),
    Q(16, 'q'),
    R(19, 'r'),
    S(31, 's'),
    T(20, 't'),
    U(17, 'u'),
    V(47, 'v'),
    W(17, 'w'),
    X(45, 'x'),
    Y(21, 'y'),
    Z(44, 'z'),
    ONE(79, '1'),
    TWO(80, '2'),
    THREE(81, '3'),
    FOUR(75, '4'),
    FIVE(76, '5'),
    SIX(77, '6'),
    SEVEN(71, '7'),
    EIGHT(72, '8'),
    NINE(73, '9'),
    ZERO(82, '0'),
    SPECIAL_ONE(2, '1'),
    SPECIAL_TWO(3, '2'),
    SPECIAL_THREE(4, '3'),
    SPECIAL_FOUR(5, '4'),
    SPECIAL_FIVE(6, '5'),
    SPECIAL_SIX(7, '6'),
    SPECIAL_SEVEN(8, '7'),
    SPECIAL_EIGHT(9, '8'),
    SPECIAL_NINE(10, '9'),
    SPECIAL_ZERO(11, '0'),
    MINUS(12, '-'),
    EQUAL(13, '='),
    SEMICOLON(39, ';'),
    APOSTROPHE(40, '\''),
    GRAVE(41, '`'),
    LEFT_BRACKET(26, '['),
    RIGHT_BRACKET(27, ']'),
    BACKSLASH(43, '\\'),
    COMMA(51, ','),
    DOT(52, '.'),
    SLASH(53, '/'),
    SPACE(57, ' '),
    TAB(15, '\t');


    private final int code;
    private final char value;

    Letter(int code, char value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public char getValue() {
        return value;
    }

    public static Letter get(int code) {
        for (Letter letter : Letter.values()) {
            if (letter.getCode() == code) {
                return letter;
            }
        }
        return null;
    }


}
