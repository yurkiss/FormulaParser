grammar LabeledExpr;

prog: stat+;

stat:   expr NEWLINE            # printExpr
    |   ID '=' expr NEWLINE     # assign
    |   NEWLINE                 # blank
    ;

expr:   expr op=(MUL|DIV) expr  # MulDiv
    |   expr op=(ADD|SUB) expr  # AddSub
    |   INT                     # int
    |   ID                      # id
    |   '(' expr ')'            # parens
    ;

MUL:    '*';
DIV:    '/';
ADD:    '+';
SUB:    '-';

ID:         [a-zA-Z]+;
INT:        [0-9]+;
NEWLINE:    '\r'? '\n';
WS:         [ \t]+ -> skip;