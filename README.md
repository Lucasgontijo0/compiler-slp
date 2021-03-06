# Micro Scripts Imperativos Baseados em LISP e Português.

**Extensão:** *.slp

### Definições:

* A Linguagem possui escopo de **função e global**.
* Tipagem **forte e estática**.
* Estruturas de controle **if, while, for**.
* LISP like (Somente sintaticamente).

### Vocabulário

**Palavras Reservadas (PR):**

|Palavra |      Equivalente     |
|--------|----------------------|
|fun     |function              |
|int     |int                   |
|real    |double                |
|texto   |string                |
|logico  |bool, boolean         |
|nada    |void                  |
|enquanto|while                 |
|se      |if                    |
|senao   |else                  |
|retorna |return                |
|:       | tipo do retorno 'fun foo()`: int` {...}' |

**Delimitadores (DE):**

|Símbolo|       Descrição     |
|-------|---------------------|
|(      |Abertura do escopo   |
|)      |Fechamento do escopo |
|[      |Abertura Parâmetros  |
|]      |Fechamento Parâmetros|

**Operadores (OP):**

|Símbolo|Descrição|
|-------|---------|
|`=`    |Atribuição|
|`+`    |Soma|
|`-`    |Substração|
|`*`    |Multiplicação|
|`/`    |Divisão|
|`&&`   |Comparação **AND**|
|<code>&#124;&#124;</code>| Comparação **OR**|
|`.`    |Concatenar|
|`==`   |Comparacão é igual á|
|`!=`   |Comparação é diferente de|
|`>`    |Maior que|
|`<`    |Menor que|
|`>=`   |Maior ou igual á|
|`<=`   |Menor ou igual á|

**Constante Literal (CL):**

|Constante Literal | Expressão Regular | Exemplo |
|------------------|-------------------|-----------|
|ID Identificador  | l(l+d)* | myFunction, resultado|
|CL Inteira (CLI)  | dd* | 10, 29, 34550 |
|CL Real (CLR)     | dd*.dd* | 1.23, 0.0003, 1.234 |
|CL Lógica (CLL)   | V <code>&#124;</code> F | true or false |
|CL String (CLS)| \"(l+d+BLANKSPACE)\" | (= x `"um texto qualquer"`) |


**Gramática:**

```
<programa> ::= <comando> <programa> | <funcao> <programa> | &
<funcao> ::= '(' <funcao-interna> ')'
<funcao-interna> ::= 'fun' id <params> ':' <tipo> <comandos>
<params> ::= <param> <params> | &
<param> ::= '(' <tipo> id ')'
<tipo> ::= 'int' | 'real' | 'texto' | 'logico' | 'nada'
<comandos> ::= <comando> <comandos> | &
<comando> ::= '(' <comando-interno> ')'
<comando-interno> ::= <decl> | <atrib> | <invoca> | <se> | <leitura> | <enquanto> | <para> | <retorno> | <mostrar>
<decl> ::= <tipo> <ids>
<ids> ::= id <ids2>
<ids2> ::= id <ids2> | &
<atrib> ::= '=' id <expr>
<expr> :: <operan> | '(' <op2> <expr> <expr> ')' | '(' <op1> id ')' | '(' <invoca> ')'
<op2> ::= '&&' | '||' | '>' | '>=' | '<' | '<=' | '==' | '!=' | '.' | '+' | '-' | '*' | '/'
<op1> ::= '++' | '--'
<invoca> ::= id <args>
<args> ::= <expr> <args> | &
<operan> ::= id | cli | clr | cll | cls
<se> ::= 'se' <expr> '(' <comandos> ')' <senao>
<senao> ::= '(' <comandos> ')' | &
<leitura> ::= 'le' id
<mostrar> ::= 'mostra '<expr>
<enquanto> ::= 'enquanto' <expr> <comandos>
<para> ::= 'para' '(' <atrib> ')' <expr> '(' <atrib> ')' <comandos>
<retorno> ::= 'ret' <expr>
```


**Exemplo programas:**

```
( fun soma ( int a ) ( int b ) : int
     ( int aux )
     ( = aux ( + a ( sub a b ) ) )
     ( ret aux )
)

( int resultado )
( = resultado ( soma 3 4 ) )
( mostra resultado )

```

```
( fun teste ( int a1 ) : int
    ( se ( < a1 100 )
        ( ( = a1 100 ) )
        ( ( = a1 20 ) )
    )
    ( ret a1 )
)
```

```
( fun teste2 ( int a ) : int
    ( enquanto ( < a 10 )
        ( ++ a )
    )
    ( ret a )
)
```
