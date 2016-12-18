grammar Formulas;


expr: (MINUS) expr                              # Unar
    | expr AMP expr                         # Concatenation
    | expr POWER expr                       # Power
    | expr op=(MUL|DIV) expr                # MulDiv
    | expr op=(ADD|MINUS) expr                # AddSub
    | expr op=( GT | LT | LTEQ | GTEQ ) expr   # Comparison
    | expr op=( EQ | NEQ ) expr                # ComparisonEquals
    | expr ( AND_OP ) expr                  # ComparisonAnd
    | expr ( OR_OP) expr                    # ComparisonOR
    | function                              # FunctionCall
    | qualifiedName                         # Name
    | literal                               # Liter
    | LPAR expr RPAR                        # Parens
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
NUMBER: ( DIGIT )+ ( DOT ( DIGIT )+ )? ;
DIGIT : [0-9]+ ;
//MINUS	: '-' ;

/* Text operators */
AMP		: '&' ;

/* Arithmetic operators */
ADD	    : '+' ;
MINUS	    : '-' ;
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