%{
int yystopparser = 0;
%}

%token START END IDENTIFICADOR ENTERO DECIMAL CADENA BOOLEANO INTEGER FLOAT BOOLEAN CHARACTER ASIGNADOR SUMA RESTA MULTIPLICACION DIVISION AUMENTAR DECREMENTO PRINT READ IF MAYOR MENOR IGUAL MAYORIGUAL MENORIGUAL DIFERENTE ELSE ELSEIF FOR WHILE VOID   

%start lenguaje

%%
lenguaje 	: inicio funciones 
			| inicio;
			
inicio		: START '{' lineascodigo  END '}';

lineascodigo	: lineascodigo linea 
				| linea;
				
linea		: llamarmetodo ';'
			| crearvariable ';'
			| cambiavalor ';'
			| imprimir ';'
			| leer ';'
			| bucleocondicion;

llamarmetodo : IDENTIFICADOR '(' parametrosenvio ')';

parametrosenvio : parametrosenvio ',' penvio
				| penvio
				|;

penvio	: valor 
		| IDENTIFICADOR;

valor	: ENTERO
		| DECIMAL
		| CADENA
		| BOOLEANO;

crearvariable	: tipodato IDENTIFICADOR
				| tipodato IDENTIFICADOR asignavalor;

tipodato	: '$'INTEGER
			| '$'FLOAT
			| '$'BOOLEAN
			| '$'CHARACTER;
			
asignavalor	: ASIGNADOR operacionasignar 
			| ASIGNADOR valor
			| ASIGNADOR IDENTIFICADOR;

operacionasignar 	: aritmetica
					| llamarmetodo
					| varincredismi;

aritmetica	: operacion 
			| operacion oprextra;
			
operacion	: valor operador valor 
			| valor operador IDENTIFICADOR
			| IDENTIFICADOR operador valor
			| IDENTIFICADOR operador IDENTIFICADOR;

operador	: SUMA
			| RESTA 
			| MULTIPLICACION
			| DIVISION;

oprextra	: oprextra complemento 
			| complemento;

complemento : operador valor | operador IDENTIFICADOR;

varincredismi : IDENTIFICADOR AUMENTAR
			  | IDENTIFICADOR DECREMENTO;

cambiavalor	: IDENTIFICADOR ASIGNADOR valor 
			| IDENTIFICADOR ASIGNADOR operacionasignar
			| IDENTIFICADOR ASIGNADOR IDENTIFICADOR;

imprimir	:  PRINT '(' CADENA ')';
			| PRINT '(' CADENA ',' IDENTIFICADOR')';
		
leer 	: READ '(' IDENTIFICADOR ')';				
			
bucleocondicion : condicionif
				| ciclofor
				| ciclowhile;

condicionif	: condicionsi
			| condicionsi condicionsino
			| condicionsi condicionesinosi
			| condicionsi condicionesinosi condicionsino;

condicionsi	: IF '(' condicion ')' '{' lineascodigo '}';

condicion	: valor opcondicional valor
			| valor opcondicional IDENTIFICADOR
			| IDENTIFICADOR opcondicional valor
			| IDENTIFICADOR opcondicional IDENTIFICADOR;

opcondicional	: MAYOR
				| MENOR
				| IGUAL
				| MAYORIGUAL
				| MENORIGUAL
				| DIFERENTE;

condicionsino	: ELSE '{' lineascodigo '}';

condicionesinosi : condicionesinosi condicionsinosi
				| condicionsinosi;

condicionsinosi	: ELSEIF '(' condicion ')' '{' lineascodigo '}';	
			
ciclofor	: FOR '(' iniciofor ';' condicion ';' varincredismi ')' '{' lineascodigo '}';
				
iniciofor	: tipodato IDENTIFICADOR asignavalor
			| IDENTIFICADOR asignavalor;

ciclowhile : WHILE '('condicion')' '{' lineascodigo '}';

funciones	: funciones funcion 
			| funcion;

funcion 	: tiporetorno IDENTIFICADOR '(' parametros ')' '{' lineascodigo '}';

tiporetorno	: tipodato | VOID;
 
parametros	: parametros ',' parametro 
			| parametro;

parametro	: tipodato IDENTIFICADOR;




