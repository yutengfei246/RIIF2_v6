// §RIIF-2 version 6

grammar RIIF2;

program
    : typeDeclaration+ EOF
    ;

/*Declarations in RIIF-2 */

typeDeclaration
    : componentDeclaration
    | templateDeclaration      //RIIF-2: template
    | environmentDeclaration
    | requirementDeclaration
    ;

// §RIIF-2 component declaration

componentDeclaration
    : COMPONENT Identifier
      (extendsList)?
      (implementsList)?  ';'
      componentBodyElement*
      END_COMPONENT
    ;

componentBodyElement
    : fieldDeclaration
    | childComponentDeclaration
    | failModeDeclaration
    | assignmentDeclaration
    | setDeclaration
    | assertion
    ;

fieldDeclaration
    : fieldType fieldDeclaratorType ';'
    ;

fieldDeclaratorType
    : primitiveFieldDeclarator
    | associativeIndexDeclarator
    | tableFieldDeclarator
    | listFieldDeclarator
    ;

childComponentDeclaration
    : CHILD_COMPONENT childComponentDeclarator ';'
    ;

failModeDeclaration
    : FAIL_MODE failModeDeclarator ';'
    ;

assignmentDeclaration
    : ASSIGN aisDeclarator ';'
    ;

setDeclaration
    : SET aisDeclarator ';'
    ;

aisDeclaration
    : ( IMPOSE | ASSIGN | SET ) aisDeclarator ';'
    ;

assertion
    : ASSERT (attributeId) ('<' | '>') expression ';'
    ;

// §RIIF-2 template

templateDeclaration
    : TEMPLATE Identifier
      ( extendsList ) ? ';'
      templateBodyElement*
      END_TEMPLATE
    ;

templateBodyElement
    : abstractFieldDeclaration
    | abstractFailModeDeclaration
    | abstractChildComponentDeclaration
    | abstractPlatformDeclaration
    | imposeDeclaration // predefined value
    ;

abstractFieldDeclaration
    : ABSTRACT fieldDeclaration
    ;

abstractFailModeDeclaration
    : ABSTRACT failModeDeclaration
    ;

abstractChildComponentDeclaration
    : ABSTRACT childComponentDeclaration
    ;

abstractPlatformDeclaration
    : ABSTRACT PLATFORM Identifier ';'
    ;

imposeDeclaration //in all hierachy
    : IMPOSE aisDeclarator ';'
    ;

// §RIIF-2-v4 environment

environmentDeclaration
    : ENVIRONMENT Identifier ';'
      environmentBodyElement*
      END_ENVIRONMENT
    ;

environmentBodyElement
    : assignment
    | envParameterDeclaration
    ;

assignment
    : ASSIGN aisDeclarator ';'
    ;

envParameterDeclaration
    : (INPUT|OUTPUT) PARAMETER variableId ':' primitiveType (':=' expression)? ';'
    ;

// §RIIF-2 requirement

requirementDeclaration
    : REQUIREMENT Identifier ';'
      assertion*
      END_REQUIREMENT
    ;

// §RIIF-2 declarator

primitiveFieldDeclarator
    : primitiveFieldDeclaratorId
      ( ':' primitiveType )
      ( ':=' fieldInitializer )?
    ;

associativeIndexDeclarator
    : associativeIndexDeclaratorId
      ( ':=' fieldInitializer )?
    ;

tableFieldDeclarator
    : tableFieldDeclaratorId ':' TYPE_TABLE
    ;

listFieldDeclarator
    : listFieldDeclaratorId ':=' listInitializer
    ;

childComponentDeclarator
    : childComponentType
      childComponentDeclaratorId
    ;

failModeDeclarator
    : failModeDeclaratorId
    ;

aisDeclarator
    : aisDeclaratorId
      '=' aisInitializer
    ;

// §RIIF-2 initializer

fieldInitializer
    : listInitializer
    | arrayInitializer
    | arrayInitializerWrapper
    | expression
    ;

arrayInitializerWrapper
    : '{' arrayInitializer ( ',' arrayInitializer )*  '}'
    ;

arrayInitializer
    : '[' arrayItem ( ',' arrayItem )* ']'
    ;

arrayItem
    : expression
    ;

listInitializer
    : '{' listItem ( ',' listItem )* '}'
    ;

listItem
    : DecimalLiteral #listItemDecimalLiteral
    | FloatingPointLiteral #listItemFloatingPointLiteral
    | Identifier  #listItemIdentifier // Identifier means nothing in List expressed as String in JAVA
    ;

tableItemInitializer
    : '{' row ( ',' row )* '}'
    ;

row
    : '[' rowItem ( ',' rowItem ) * ']' #rowArray
    | expression    #rowExpression
    ;

rowItem
    : expression #rowItemExpression
    | listInitializer #rowItemListInitializer
    ;

aisInitializer
    : listInitializer
    | expression
    | arrayInitializerWrapper
    | tableItemInitializer
    ;

// §RIIF-2 version 6 Declarator Id

primitiveFieldDeclaratorId
    : Identifier ( typeType ) ? ( attributeIndex ) ? #primitiveFieldDeclaratorId1
    | Identifier associativeIndex attributeIndex  #primitiveFieldDeclaratorId2
    ;

associativeIndexDeclaratorId
    : Identifier associativeIndex
    ;

tableFieldDeclaratorId
    : Identifier
    ;

listFieldDeclaratorId
    : Identifier
    ;

childComponentDeclaratorId
    : Identifier
      ( typeType | associativeIndex ) ?
    ;

failModeDeclaratorId
    : Identifier ( typeType ) ? ( attributeIndex) ? #failModeDeclaratorId1
    | Identifier associativeIndex attributeIndex ?  #failModeDeclaratorId2
    ;

aisDeclaratorId
    : primitiveId /* hier id */
      ( aisType | associativeIndex ) ?
      ( hierPostfix ) ? attributeIndex ? #aisDeclaratorId1
    | tableId #aisDeclaratorId2
    ;

// §RIIF-2 version 6 Id

primitiveId
    : Identifier #primitiveIdIdentifier
    | primitiveId ( hierPostfix ) #primitiveIdId
    ;

associativeId
    : primitiveId associativeIndex
    ;

attributeId
    : primitiveId attributeIndex #attributePrimitiveIdIndex
    | associativeId attributeIndex #attributeAssociativeIdIndex
    ;

variableId
    : primitiveId
    | associativeId
    | attributeId
    | tableId
    ;

attributeIndex
    : '\'' Identifier
    ;

associativeIndex
    : '[' Identifier ']'
    ;

hierPostfix
    : '.' Identifier
    ;

//  only if attribute name is Item has to be checked
tableId
    : attributeId
      '[' (op='#'| Identifier) ']'
      '[' Identifier ']'
    ;

extendsList
    : EXTENDS Identifier ( ',' Identifier )*
    ;

implementsList
    : IMPLEMENTS Identifier ( ',' Identifier )*
    ;


// §RIIF-2 type

primitiveType
    : TYPE_FLOAT
    | TYPE_INTEGER
    | TYPE_STRING
    | TYPE_BOOLEAN
    | TYPE_TIME
    | Identifier
    | enumType
    ;

typeType
    : associativeType
    | vector
    ;

aisType
    : associativeType
    | flatVector
    ;

associativeType
    : '[' ']'
    ;

vector
    : '[' expression ':' expression ']'
    ;

flatVector
    : '[' expression ' .. ' expression ']'
    ;

fieldType
    : PARAMETER
    | CONSTANT
    ;

enumType
    : TYPE_ENUM '{' Identifier ( ',' Identifier)* '}'
    ;

childComponentType
    : Identifier
    ;

/*RIIF-2: ANTlr.4 expression (Same with JAVA)*/
expression
    : primary   #expPrimary
    | op=('+'|'-') expression  #expPositiveOrNegative
    | op=('~'|'!') expression  #expWaveOrNot
    | expression op=( '*' | '/' | '%' ) expression #expStarOrDivOrMod
    | expression op=( '-' | '+' ) expression   #expMinusOrPlus
    | expression op=('<=' | '>=' | '>' | '<') expression #expCmp
    | expression op=('==' | '!=') expression #expEqOrNotEq
    | expression op='&' expression #expSingleAnd
    | expression op='^' expression #expPower
    | expression op='|' expression #expSingleOr
    | expression op='&&' expression #expDoubleAnd
    | expression op='||' expression #expDoubleOr
    | expression op='?' expression op=':' expression #expIfElse
    | <assoc=right> expression op='=' expression #expAssign
    ;

primary
    : '(' expression ')' #primaryParentheses
    | SELF  #primarySelf
    | TRUE  #primaryTrue
    | FALSE #primaryFalse
    | variableId   #primaryVariableId
    | literal   #primaryLiteral
    | funcCall  #primaryFuncCall
    | arrayInitializer  #primaryArrayInitializer
    ;

funcCall
    : funcName '(' funcArg ( ',' funcArg ) ? ')'
    ;
funcName
    : FUNC_LOG
    | FUNC_EXP
    | FUNC_AGG_SINGLE
    | FUNC_GT_N_FAIL
    ;
funcArg
    : (aisDeclaratorId) vector
    | expression
    ;

/*Literal*/
literal
    : StringLiteral #literalString
    | DecimalLiteral #literalDecimal
    | FloatingPointLiteral #literalFloatingPoint
    ;

// Lexer

// §RIIF-2-v4 Keywords

COMPONENT: 'component';
END_COMPONENT: 'endcomponent';
ENVIRONMENT: 'environment';
END_ENVIRONMENT: 'endenvironment';
REQUIREMENT: 'requirement';
END_REQUIREMENT: 'endrequirement';
CHILD_COMPONENT: 'child_component';
FAIL_MODE: 'fail_mode';
EXTENDS: 'extends';
ASSIGN: 'assign';
ASSERT: 'assert';
INPUT: 'input';
OUTPUT: 'output';
PARAMETER: 'parameter';
CONSTANT: 'constant';
TYPE_FLOAT: 'float';
TYPE_INTEGER: 'integer';
TYPE_STRING: 'string';
TYPE_ENUM: 'enum';
TYPE_BOOLEAN: 'boolean';
TYPE_TIME: 'time';
FUNC_AGG_SINGLE: 'agg_single_fail';
FUNC_GT_N_FAIL: 'agg_gt_n_fail';
FUNC_LOG: 'LOG';
FUNC_EXP: 'EXP';
//Second part
TEMPLATE: 'template';
END_TEMPLATE: 'endtemplate';
IMPOSE: 'impose';
ABSTRACT: 'abstract';
IMPLEMENTS: 'implements';
SELF: 'self';
SET: 'set';
TYPE_TABLE: 'table';
PLATFORM: 'platform';
TRUE: 'true';
FALSE: 'false';
/*Identification */
Identifier
    : (LETTER) (LETTER|DIGIT|UNDERSCORE)*
    ;

/*Literal Tokens */
StringLiteral
    : '"' ( ~('\\' | '"') )* '"'
    ;

FloatingPointLiteral
    : DIGIT+ '.' DIGIT* Exponent? FloatTypeSuffix?
    | '.' DIGIT+ Exponent? FloatTypeSuffix?
    | DIGIT+ Exponent FloatTypeSuffix?
    ;

DecimalLiteral
    : DIGIT+
    ;

WS: (' ' | '\r' | '\t' |' \u000C' | '\n' ) ->channel(HIDDEN) ;

COMMENT
    : '/*' .*? '*/'  ->channel(HIDDEN)
    ;

LINE_COMMENT
    : '//' ~('\n'|'\r')* '\r'? '\n' -> channel(HIDDEN)
    ;

fragment
DIGIT: '0'..'9';
fragment
LETTER: ( 'a'..'z' | 'A'..'Z' );
fragment
UNDERSCORE: '_';
fragment
EscapeSequence
    : '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    | UnicodeEscape
    | OctalEscape
    ;
fragment
OctalEscape
    : '\\' ('0'..'3')('0'..'7')('0'..'7')
    | '\\' ('0'..'7')('0'..'7')
    | '\\' ('0'..'7')
    ;
fragment
HexDigit
    : ('0'..'9' | 'a'..'f' | 'A'..'F')
    ;
fragment
UnicodeEscape
    : '\\' 'u' HexDigit HexDigit HexDigit HexDigit
    ;
fragment
Exponent
    : ('e'|'E')('+'|'-')?DIGIT+
    ;
fragment
FloatTypeSuffix
    : ('f'|'F'|'d'|'D')
    ;













