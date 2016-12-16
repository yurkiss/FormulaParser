grammar Formulas;


expr: expr AMP expr
    | expr POWER expr
    | expr op=(MUL|DIV) expr
    | expr op=(ADD|SUB) expr
    | expr ( GT | LT | LTEQ | GTEQ ) expr
    | expr ( EQ | NEQ ) expr
    | expr ( AND_OP ) expr
    | expr ( OR_OP) expr
    | function
    | qualifiedName
    | literal
    | LPAR expr RPAR
;

function:
    IDENTIFIER LPAR ( expr ( COMMA expr )* )? RPAR
	;

qualifiedName
    :   ('$')? IDENTIFIER ( '.' IDENTIFIER )*
    ;
literal
    : STRING
    | NUMBER
    ;

IDENTIFIER
// :'"' (~'"' | '""')* '"'
// | '`' (~'`' | '``')* '`'
// | '[' ~']'* ']'
 : [a-zA-Z_] [a-zA-Z_0-9]* // TODO check: needs more chars in set
 ;

/* String literals, i.e. anything inside the delimiters */
STRING
	:	QUOT .*? QUOT
	;

QUOT: '"';

/* Numeric literals */
NUMBER: (MINUS)? ( DIGIT )+ ( DOT ( DIGIT )+ )? ;
DIGIT : [0-9]+ ;
MINUS	: '-' ;

/* Text operators */
AMP		: '&' ;

/* Arithmetic operators */
ADD	    : '+' ;
SUB	    : '-' ;
MUL	    : '*' ;
DIV		: '/' ;
POWER	: '^' ;
PERCENT : '%' ;

/* Reference operators */
ABS     : '$' ;
EXCL    : '!' ;
COLON   : ':' ;

/* Miscellaneous operators */
COMMA	: ',' ;
DOT	    : '.' ;
SEMI	: ';' ;
LPAR	: '(' ;
RPAR	: ')' ;

/* Comparison operators */
EQ		: '=' | '==' ;
NEQ		: '<>' | '!=' ;
LTEQ	: '<=' ;
GTEQ	: '>=' ;
GT		: '>' ;
LT		: '<' ;
AND_OP	: '&&' ;
OR_OP	: '||' ;


/* White-space (ignored) */
WS : [ \r\t\n]+ -> skip ;