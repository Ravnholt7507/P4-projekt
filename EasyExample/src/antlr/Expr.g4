grammar Expr;

/* grammar name and file name must match */


@header {
package antlr;
}

//start variable
prog: (decl | expr | print | if_stat | while_stat | train)+ EOF            # Program
    ;

decl		
 : ID '=' expr ';'
 ;
 
 if_stat: 'if' condition_block ('else if' condition_block)* ('else' stat_block)?
 ;

condition_block
 : '(' expr ')' stat_block
 ;

stat_block
 : '{' (expr | decl | print | if_stat | while_stat)* '}'
 | (expr | decl | print | if_stat | while_stat)
 ;

while_stat: 'while' '(' expr ')' stat_block
 ;
 
train: TRAIN '(' trainParams ')'
;

trainParams: ACTFUNC ',' epochs ',' array
;

epochs: INT
;
 
 

array: ARRAY '[' ']' 
     | ARRAY '[' element ']'
     ;

element: value 
       | value ',' element
       ;

value: array 
     | INT
     ;


/* ANTLR resolves ambiguities by first alternative given */

expr: expr '*' expr                 		# Multiplication
    | expr '/' expr							# Division
    | expr '+' expr                 		# Addition
    | expr '-' expr							# Subtraction
    | expr op=(LTEQ | GTEQ | LT | GT) expr  # RelationalExpr
    | expr op=(EQ | NEQ) expr               # EqualityExpr
 	| expr AND expr                         # AndExpr
 	| expr OR expr                          # OrExpr
 	| BOOL									# Bool
    | ID                            		# Variable
    | DOUBLE 	                      		# Double
    | INT									# Int
    ;

print:
 'Print' '(' expr ')' ';'
 ;

/* Tokens */
TRAIN:'train';
ACTFUNC:'sigmoid';
ARRAY:'array';


 /* Boolean operators */
OR : '||';
AND : '&&';
EQ : '=='; 
NEQ : '!=';
GT : '>';
LT : '<';
GTEQ : '>=';
LTEQ : '<=';

/* Types */
BOOL 
: ('true' | 'false');

INT
: '0' | '-'?[1-9][0-9]*;

DOUBLE
 : [0-9]+ '.' [0-9]* 
 | '.' [0-9]+
 ;
 
 /* Basics */
 ID : [a-z][a-zA-Z0-9]*;

INT_TYPE : 'INT';
COMMENT : '--' ~[\r\n]* -> skip;
NEWLINE : [\r\n] ->  skip;
WS : [ \t\n]+ -> skip;