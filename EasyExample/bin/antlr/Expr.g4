grammar Expr;

/* grammar name and file name must match */


@header {
package antlr;
}

//start variable
prog: (stat_block | stat_block_NN)+ EOF            # Program
 ;
 
decl		
 : ID '=' expr ';'
 ;
 
if_stat: 'if' condition_block ('else' (stat_block | stat_block_NN))?
 ;
 
condition_block
 : '(' expr ')' (stat_block | stat_block_NN)
 ;
 
stat_block
 : '{' (expr | decl | print | if_stat | while_stat)* '}'
 | (expr | decl | print | if_stat | while_stat)
 ;
 
stat_block_NN
 : '{' (train | neural_network| read_image_data | setup | dataset | add_data | read_data | predict)* '}'
 | (train | neural_network| read_image_data | setup | dataset | add_data | read_data | predict)
 ;

while_stat: 'while' '(' expr ')' stat_block
 ;

neural_network
 : NEURALNETWORK ID '(' expr ',' expr ',' expr ')' ';'
 ;

setup
 : ID '.' SETUP '(' ID (',' ACTFUNC)? (',' expr)? ')' ';'
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
 : ID '.' PREDICT '(' ID ')' ';'
 ;

/* TRAIN */
train: ID '.' TRAIN '(' (ID ',')? expr ')' ';'
 ;

epochs: INT								
 ; 
 
/* ARRAYS */

arraydecl
 : ID '[' expr ']' ('=' array)? ';'
 ;

array: '{' value (',' value)* '}'
     ;

value: INT | DOUBLE
     ;
   
/* ANTLR resolves ambiguities by first alternative given */

expr: expr op=(MULT | DIV) expr				# MultiOp
    | expr op=(ADD | SUB) expr              # AdditiveOp
    
    | expr op=(LTEQ | GTEQ | LT | GT) expr  # RelationalExpr
    | expr op=(EQ | NEQ) expr               # EqualityExpr
 	| expr AND expr                         # AndExpr
 	| expr OR expr                          # OrExpr
 	
 	| LPAR expr RPAR						# parExpr	
 	| BOOL									# Bool
    | ID                            		# Variable
    | DOUBLE 	                      		# Double
    | INT									# Int
    | STRING								# String
    ;
 
print:
 PRINT '(' expr ')' ';'
 ;
 
read:
 'read' '(' STRING ',' STRING  ',' STRING ')' ';'
 ;

/* Terminal Formation rules */
TRAIN:'train';
ACTFUNC:'sigmoid' | 'Sigmoid' | 'relu' | 'Relu' | 'ReLu' | 'LeakyReLu' | 'Leakyrelu'|'leakyrelu';
NEURALNETWORK:'NeuralNetwork';
SETUP:'Setup' | 'setup';
DATASET: 'Dataset' | 'dataset';
ADDDATA: 'AddData' | 'addData';
READDATA: 'ReadData' | 'Readdata' | 'readdata';
PREDICT: 'predict' | 'Predict';
READIMAGE: 'Readimage' | 'readimage';
PRINT: 'Print' | 'print' | 'PRINT';

/* Arithmatic operator */
MULT: '*';
DIV: '/';
ADD: '+';
SUB: '-';

 /* Boolean operators */
OR : '||';
AND : '&&';
EQ : '=='; 
NEQ : '!=';
GT : '>';
LT : '<';
GTEQ : '>=';
LTEQ : '<=';
LPAR : '(';
RPAR : ')';


/* Types */
BOOL 
: ('true' | 'TRUE' | 'false' | 'FALSE');

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