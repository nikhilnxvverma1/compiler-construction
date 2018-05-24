package com.nikhil;

/**
 * Different types of token types in the language
 * Created by nikhilverma on 2/13/18.
 */
public enum TokenType {
    EOF,// <end of file>
    ID, // <x>
    INT,// int
    LPAREN,// {
    RPAREN,// }
    SEMICOLON,// ;
    WHILE,// while
    ASSIGN_EQ,// =
    COMPARE_EQ,// ==
    MUL,// *
    DIV,// /
    PLUS,//+
    MINUS,// -
    LESS_THAN_EQUAL_TO,// <=
    GREATER_THAN_EQUAL_TO,// >=
    LESS_THAN,// <
    GREATER_THAN,// >
    DOT,// .
    IF,// if
    ELSE,// else
    INTERFACE,// interface
    VOID,// void
    THIS,// this
    NEW,// new
    BOOLEAN,// boolean
    SIDEF// sidef
}
