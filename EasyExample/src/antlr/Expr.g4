grammar Expr;

/* grammar name and file name must match */


@header {
package antlr;
}

//start variable
prog: (decl | expr | print | if_stat | while_stat | train | read | neural_network | read_image_data | setup | train | dataset | add_data | read_data | predict | arraydecl)+ EOF            # Program
    ;
    
decl		
 : ID '=' expr ';'
 ;
 
if_stat: 'if' condition_block ('else if' condition_block)* ('else' stat_block)?
 ;

neural_network
 : NEURALNETWORK ID '(' INT ',' INT ',' INT ')'
 ;

setup
 : ID '.' SETUP '(' DATASET ID (',' ACTFUNC)? (',' DOUBLE)? ')' ';'
 ;
 
dataset
 : DATASET ID ';'
 ;
 
add_data
 : ID '.' ADDDATA '(' (array ',' array ( ';' array ',' array)* )?  ')' ';'
 ;
 
read_data
 : ID '.' READDATA '(' ID ',' ID  ',' STRING ',' STRING ')' ';'
 ;
 
read_image_data
 : ID '.' READIMAGE '(' ID ',' ID ',' STRING ',' STRING ')' ';'
 ;
 
predict
 : ID '.' PREDICT '(' ID (',' ID)? ')' ';'
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

/* TRAIN */
train: ID '.' TRAIN '(' epochs ')'
 ;

epochs: INT
 ; 
 
/* ARRAYS */

arraydecl
 : ID '[' (INT | DOUBLE)? ']' ('=' array)? ';'
 ;

array: '{' value (',' value)* '}'
     ;

value: INT | DOUBLE
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
    | STRING								# String
    ;

print:
 'Print' '(' (expr | ID) ')' ';'
 ;
 
read:
 'read' '(' STRING ',' STRING  ',' STRING ')' ';'
 ;

/* Tokens */

TRAIN:'train';
ACTFUNC:'sigmoid' | 'Sigmoid' | 'Softmax' | 'SoftMax' | 'relu' | 'Relu' | 'ReLu';
ARRAY:'array' | 'Array';
NEURALNETWORK:'NeuralNetwork';
SETUP:'Setup' | 'setup';
DATASET: 'Dataset' | 'dataset';
ADDDATA: 'AddData' | 'addData';
READDATA: 'ReadData' | 'Readdata' | 'readdata';
PREDICT: 'predict' | 'Predict';
READIMAGE: 'Readimage' | 'readimage';

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
 ID : [a-zA-Z0-9]*;

STRING
 : '"' (~["\r\n] | '""')* '"'
 ;

INT_TYPE : 'INT';
COMMENT : '--' ~[\r\n]* -> skip;
NEWLINE : [\r\n] ->  skip;
WS : [ \t\n]+ -> skip;