grammar Expr;

/* grammar name and file name must match */


@header {
package antlr;
}

//start variable
prog: (decl | expr | print | if_stat | while_stat | train | read | neural_network | read_image_data | setup | dataset | add_data | read_data | predict | arraydecl)+ EOF            # Program
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
 : '{' (expr | decl | print | if_stat | while_stat | train | read | neural_network | read_image_data | setup | train | dataset | add_data | read_data | predict)* '}'
 | (expr | decl | print | if_stat | while_stat | train | read | neural_network | read_image_data | setup | train | dataset | add_data | read_data | predict)
 ;

while_stat: 'while' '(' expr ')' stat_block
 ;

neural_network
 : NEURALNETWORK ID '(' atom ',' atom ',' atom ')' ';'
 ;

setup
 : ID '.' SETUP '(' DATASET atom (',' ACTFUNC)? (',' atom)? ')' ';'
 ;

dataset
 : DATASET ID ';'
 ;

add_data
 : ID '.' ADDDATA '(' (array ',' array ( ';' array ',' array)* )?  ')' ';'
 ;

read_data
 : ID '.' READDATA '(' atom ',' atom  ',' atom ',' atom ')' ';'
 ;

read_image_data
 : ID '.' READIMAGE '(' atom ',' atom ',' atom ',' atom ')' ';'
 ;

predict
 : ID '.' PREDICT '(' atom (',' atom)? ')' ';'
 ;

/* TRAIN */
train
 : ID '.' TRAIN '(' expr ')'
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

expr: expr op=(MULT | DIV) expr				# MultiOp
    | expr op=(ADD | SUB) expr              # AdditiveOp
    | expr op=(LTEQ | GTEQ | LT | GT) expr  # RelationalExpr
    | expr op=(EQ | NEQ) expr               # EqualityExpr
 	| expr AND expr                         # AndExpr
 	| expr OR expr                          # OrExpr
 	| atom									# Types
 	;

atom: LPAR expr RPAR						# ParExpr
 	| BOOL									# Bool
    | ID                            		# Variable
    | DOUBLE 	                      		# Double
    | INT									# Int
    | STRING								# String
    ;

networkExpr: decl							
	| if_stat								
	| while_stat							
	| neural_network						
	| setup									
	| dataset								
	| add_data								
	| read_data								
	| read_image_data						
	| predict								
	| train									
	| arraydecl
	| print
	| read								
	;
	
print
 : 'Print' '(' (expr | ID) ')' ';'
 ;
 
read
 : 'read' '(' STRING ',' STRING  ',' STRING ')' ';'
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
FUNCTION: 'Function' | 'function' | 'FUNCTION';

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