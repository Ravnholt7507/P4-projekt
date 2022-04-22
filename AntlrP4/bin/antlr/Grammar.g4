grammar Grammar;

/* grammar name and file name must match */

@header {
package antlr;
}

//start variable
prog: (stat)+ EOF                 	#Program
    ;

dcl
   : type ID ASSIGN expr SCOL 		        #Declaration
   ;

type: (INT_TYPE | FLOAT_TYPE | BOOL_TYPE)   #TypeDen
    ;
    
    
stat
  : dcl 
  | if_stat
  | while_stat
  | expr
  ;
  
if_stat
 : IF condition_block (ELSE IF condition_block)* (ELSE stat_block)?
 ;

condition_block
 : OPAR expr CPAR stat_block
 ;

stat_block
 : OBRACE stat* CBRACE
 | stat
 ;
 
 while_stat
 : WHILE OPAR expr CPAR stat_block
 ;

/* ANTLR resolves ambigouities by first alternative given */

expr
 : expr POW expr                        #pow
 | MINUS expr                           #unaryMinus
 | NOT expr                             #notExpr
 | expr op=('*' | '/') expr             #multiplication
 | expr op=('+' | '-') expr             #additive
 | expr op=(LTEQ | GTEQ | LT | GT) expr #relationalExpr
 | expr op=(EQ | NEQ) expr              #equalityExpr
 | expr AND expr                        #andExpr
 | expr OR expr                         #orExpr
 | atom                                 #atomExpr
 ;
 

atom
 : OPAR expr CPAR 			#par
 | INT  				    #Int
 | FLOAT				    #Float
 | ID             			#Id
 | BOOL					    #Bool
 ;

/* Tokens */

INT_TYPE
 : 'int'
 ;

FLOAT_TYPE
 : 'float'
 ;
 
BOOL_TYPE
 : 'bool'
 ;
 
 /* Boolean operators */
OR : '||';
AND : '&&';
EQ : '=='; 
NEQ : '!=';
GT : '>';
LT : '<';
GTEQ : '>=';
LTEQ : '<=';

 /* Arithmetic operators */
PLUS : '+';
MINUS : '-';
MULT : '*';
DIV : '/';
MOD : '%';
POW : '^';
NOT : '!';
ASSIGN : '=';

/* BOOLS */
BOOL: ('TRUE' | 'FALSE');

/* Other */
SCOL : ';';
OPAR : '(';
CPAR : ')';
OBRACE : '{';
CBRACE : '}';

INT
 : [0-9]+
 ;

FLOAT
 : [0-9]+ '.' [0-9]* 
 | '.' [0-9]+
 ;

IF : 'if';
ELSE : 'else';
WHILE : 'while';

ID
 : [a-zA-Z_] [a-zA-Z_0-9]*
 ;

COMMENT : '--' ~[\r\n]* -> skip;
NEWLINE : [\r\n] ->  skip;
WS : [ \t\n]+ -> skip;

