grammar Expr;

/* grammar name and file name must match */


@header {
package antlr;
}

//start variable
prog: (decl | expr)+ EOF            # Program
    ;
 
decl: ID ':' INT_TYPE '=' NUM       #Declaration
    ;

/* ANTLR resolves ambigouities by first alternative given */

expr: expr '*' expr                 # Multiplication
    | expr '+' expr                 # Addition
    | ID                            # Variable
    | NUM                           # Number
    ;


/* Tokens */
ID : [a-z][a-zA-Z0-9]*;
NUM : '0' | '-'?[1-9][0-9]*;
INT_TYPE : 'INT';
COMMENT : '--' ~[\r\n]* -> skip;
NEWLINE : [\r\n] ->  skip;
WS : [ \t\n]+ -> skip;