grammar Grammar;

/* grammar name and file name must match */


@header {
package antlr;
}

//start variable
prog: (dcl | expr)+ EOF                 #Program
    ;

dcl: type ID '=' expr 		        #Declaration
    ; 

type: (INT_TYPE | FLOAT_TYPE)		#TypeDen
    ;

/* ANTLR resolves ambigouities by first alternative given */

expr
 : expr POW expr                        #pow
 | MINUS expr                           #unaryMinus
 | expr op=('*' | '/') expr             #multiplication
 | expr op=('+' | '-') expr             #additive
 | atom                                 #atomExpr
 ;

atom
 : OPAR expr CPAR 			#par
 | INT  				#Int
 | FLOAT				#Float
 | ID             			#Id
 ;

PLUS : '+';
MINUS : '-';
MULT : '*';
DIV : '/';
MOD : '%';
POW : '^';
NOT : '!';

SCOL : ';';
ASSIGN : '=';
OPAR : '(';
CPAR : ')';
OBRACE : '{';
CBRACE : '}';

/* Tokens */
ID
 : [a-zA-Z_] [a-zA-Z_0-9]*
 ;

INT_TYPE
 : 'INT'
 ;

FLOAT_TYPE
 : 'FLOAT'
 ;

INT
 : [0-9]+
 ;

FLOAT
 : [0-9]+ '.' [0-9]* 
 | '.' [0-9]+
 ;

COMMENT : '--' ~[\r\n]* -> skip;
NEWLINE : [\r\n] ->  skip;
WS : [ \t\n]+ -> skip;