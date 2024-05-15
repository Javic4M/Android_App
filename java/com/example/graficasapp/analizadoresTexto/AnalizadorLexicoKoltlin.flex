package com.example.graficasapp.analizadores;

import java_cup.runtime.*;

%% // Separador de Area

%class LexicoKoltlin
%public
%cup
%line
%column
%eofval{
    return symbol(sym.EOF);
%eofval}

%{
    private Symbol symbol(int type) {
        return new Symbol(type, yyline+1, yycolumn+1);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline+1, yycolumn+1, value);
    }
%}

Saltos = [\r|\n|\r\n]
Espacios = {Saltos} | [ \t\f]
Numero = [0-9]+
Pixel = \"[0-9]+[pP][xX]\"
Color = \"[#][[a-z]|[0-9]]+\"
Tipo = \"[A-Z]\"
Palabra = \"[^\"]*\"
Identificador = [iI][dD][a-zA-Z]*

%% // Separador de Area

<YYINITIAL> {

    "\"title\""             { return symbol(sym.TITULO, yytext()); }

    "\"description\""       { return symbol(sym.DESCRIPCION, yytext()); }

    "\"keywords\""          { return symbol(sym.PALABRA_CLAVE, yytext()); }

    "\"header\""            { return symbol(sym.ENCABEZADO, yytext()); }

    "\"footer\""            { return symbol(sym.PIE, yytext()); }

    "\"copyright\""         { return symbol(sym.COPYRIGHT, yytext()); }

    "\"backgroundColor\""   { return symbol(sym.FONDO, yytext()); }

    "\"fontFamily\""        { return symbol(sym.FUENTE, yytext()); }

    "\"fontSize\""          { return symbol(sym.TAMANIO_FUENTE, yytext()); }

    "\"data\""              { return symbol(sym.DATA, yytext()); }

    "\"category\""          { return symbol(sym.CATEGORIA, yytext()); }

    "\"value\""             { return symbol(sym.VALOR, yytext()); }

    "\"color\""             { return symbol(sym.COLOR, yytext()); }

    "\"chart\""             { return symbol(sym.CHART, yytext()); }

    "\"xAxisLabel\""        { return symbol(sym.X_BARRA, yytext()); }

    "\"yAxisLabel\""        { return symbol(sym.Y_BARRA, yytext()); }

    "\"label\""             { return symbol(sym.LABEL, yytext()); }

    "\"legendPosition\""    { return symbol(sym.POSICION, yytext()); }

    "\"x\""                 { return symbol(sym.X, yytext()); }

    "\"y\""                 { return symbol(sym.Y, yytext()); }

    "\"size\""              { return symbol(sym.TAMANIO, yytext()); }

    "\"name\""              { return symbol(sym.NOMBRE, yytext()); }

    "\"points\""            { return symbol(sym.PUNTOS, yytext()); }

    "\"lineStyle\""         { return symbol(sym.LINEA_ESTILO, yytext()); }

    "{"                     { return symbol(sym.LLAVE_I, yytext()); }

    "}"                     { return symbol(sym.LLAVE_D, yytext()); }

    "["                     { return symbol(sym.CORCHETE_I, yytext()); }

    "]"                     { return symbol(sym.CORCHETE_D, yytext()); }

    ":"                     { return symbol(sym.DOS_PUNTOS, yytext()); }

    ";"                     { return symbol(sym.PUNTO_Y_COMA, yytext()); }

    ","                     { return symbol(sym.COMA, yytext()); }

    "+"                     { return symbol(sym.MAS, yytext()); }

    "if"                    { return symbol(sym.IF, yytext()); }

    "else"                  { return symbol(sym.ELSE, yytext()); }

    "for"                   { return symbol(sym.FOR, yytext()); }

    "while"                 { return symbol(sym.WHILE, yytext()); }

    "="                     { return symbol(sym.IGUAL, yytext()); }

    "=="                    { return symbol(sym.DOBLE_IGUAL, yytext()); }

    "!="                    { return symbol(sym.NO_IGUAL, yytext()); }

    ">"                     { return symbol(sym.MAYOR, yytext()); }

    ">="                    { return symbol(sym.MAYOR_IGUAL, yytext()); }

    "<"                     { return symbol(sym.MENOR, yytext()); }

    "<="                    { return symbol(sym.MENOR_IGUAL, yytext()); }

    "("                     { return symbol(sym.PARENTESIS_I, yytext()); }

    ")"                     { return symbol(sym.PARENTESIS_D, yytext()); }

    {Numero}                { return symbol(sym.NUMERO, yytext()); }

    {Pixel}                 { return symbol(sym.PIXEL, yytext()); }

    {Color}                 { return symbol(sym.NUMERO_COLOR, yytext()); }

    {Tipo}                  { return symbol(sym.TIPO, yytext()); }

    {Identificador}         { return symbol(sym.IDENTIFICADOR, yytext()); }

    {Palabra}               { return symbol(sym.PALABRA, yytext()); }

    {Espacios}              {/* ignoramos */}

}

[^]                         { throw new Error("Error Léxico caracter Invalido en la linea " + (yyline+1) + ", columna " + (yycolumn+1) + ": " + yytext()); }