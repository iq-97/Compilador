%{
#include <stdio.h>
#include <conio.h>
#include "sintaxis.h"	
%}

%option noyywrap
%option yylineno

ignore " "|\t|\n
caracter [A-Za-z]
digito [0-9]
boolean "true"|"false"

%%
{ignore}*	{;}
"."					{printf("signo\n");return ('.');}
"$"					{printf("simbolo para iniciar variable\n");return ('$');}
"{"					{printf("delimitador\n");return ('{');}
"}"					{printf("delimitador\n");return ('}');}
";"					{printf("signo\n");return (';');}
","					{printf("signo\n");return (',');}
")"					{printf("delimitador\n");return (')');}
"("					{printf("delimitador\n");return ('(');}
"print"				{printf("PALABRA RESERVADA\n");return PRINT;}
"read"				{printf("PALABRA RESERVADA\n");return READ;}
"if"				{printf("PALABRA RESERVADA\n");return IF;}
"else if"			{printf("PALABRA RESERVADA\n");return ELSEIF;}
"else"				{printf("PALABRA RESERVADA\n");return ELSE;}
"for"				{printf("PALABRA RESERVADA\n");return FOR;}
"while"				{printf("PALABRA RESERVADA\n");return WHILE;}
"void"				{printf("PALABRA RESERVADA\n");return VOID;}	
"start"				{printf("PALABRA RESERVADA\n");return START;}
"end"				{printf("PALABRA RESERVADA\n");return END;}
"integer"			{printf("VARIABLE\n");return INTEGER;}
"float"				{printf("VARIABLE\n");return FLOAT;}
"bool"				{printf("VARIABLE\n");return BOOLEAN;}
"string"			{printf("VARIABLE\n");return CHARACTER;}
"+"					{printf("OPERADOR\n");return SUMA;}
"-"					{printf("OPERADOR\n");return RESTA;}
"*"					{printf("OPERADOR\n");return MULTIPLICACION;}
"/"					{printf("OPERADOR\n");return DIVISION;}
"++"				{printf("INCREMENTO\n");return AUMENTAR;}
"--"				{printf("DECREMENTO\n");return DECREMENTO;}
"=>"				{printf("ASIGNADOR\n");return ASIGNADOR;}
">"					{printf("OPERADOR CONDICIONAL\n");return MAYOR;}
"<"					{printf("OPERADOR CONDICIONAL\n");return MENOR;}
"=="				{printf("OPERADOR CONDICIONAL\n");return IGUAL;}
">="				{printf("OPERADOR CONDICIONAL\n");return MAYORIGUAL;}
"<="				{printf("OPERADOR CONDICIONAL\n");return MENORIGUAL;}
"!="				{printf("OPERADOR CONDICIONAL\n");return DIFERENTE;}
{digito}+		    {printf("VALOR ENTERO\n");return ENTERO;}
{digito}+"."{digito}		    {printf("VALOR DECIMAL\n");return DECIMAL;}
{boolean}						{printf("VALOR BOOL\n");return BOOLEANO;}
"\""({digito}|{caracter}|" ")*"\""	{printf("CADENA O MENSAJE\n");return CADENA;}
{caracter}({caracter}|(digito))*	{printf("IDENTIFICADOR\n");return IDENTIFICADOR;}
.					{printf("Error en linea: %d\n",yylineno);} 
%%

yyerror(char * msg)
{
printf("%s\n",msg);
}

int main(void)
{
char NombreArchivo[50];
printf("Ruta del archivo: ");
gets(NombreArchivo);
yyin=fopen(NombreArchivo,"rt");
	if(yyin==NULL)
		printf("\nNo se puede leer el archivo");
	else
		yyparse();
fclose(yyin);
getch();
}
