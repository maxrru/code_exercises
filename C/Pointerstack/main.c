#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>

#define GROESSE 100
#define TRUE 1
#define FALSE 0

char enter;
char *zeichenkette[GROESSE];
char **stackzeiger = zeichenkette;
int it = 0;

void push(char *meinString);
char *pop();
char *top();
void ausgeben();
int isFull();
int isEmpty();
int Anzahl();
int ende();

void callPush(void);
void callPop(void);
void callTop(void);
void callAusgeben(void);
void callAnzahl(void);
void callEnde(void);


void (*functable[6])(void)= {callPush,callPop,callTop,callAnzahl,callAusgeben,callEnde};

int main()
{
    while(1)
    {
//        char buffer[GROESSE];
        int auswahl;
        printf("\n\n\nStackmenue");
        printf("\nAktion auswaehlen: ");
        printf("\n\nEin Element hinzufuegen: 1");
        printf("\nEin Element auslesen und entfernen: 2");
        printf("\nEin Element auslesen: 3");
        printf("\nAnzahl der Elemente anzeigen: 4");
        printf("\nAlle Elemente ausgeben: 5");
        printf("\nEnde: 6");
        printf("\nEingabe: ");
        scanf("%d%c",&auswahl,&enter);
        fflush(stdin);

        functable[auswahl-1]();






//         switch(auswahl)
//        {
//            case '1':
//                printf("Bitte geben sie eine Zeichenkette ein:\n");
//                fflush(stdin);
//
//                scanf("%s", buffer);
//                printf("%d",strlen(buffer)+1);
//                buffer[strlen(buffer)+1]='\0';
//              // meintext = (char*)malloc(strlen(meintext)+1); // +1 steht für \0
//                push(buffer);
//                fflush(stdin);
//                break;
//            case '2':
//                pop();
//                break;
//            case '3':
//                top();
//                break;
//            case '4':
//                Anzahl();
//                break;
//            case '5':
//                ausgeben();
//                break;
//            case 'e':
//            case 'E':
//                return 0;
//                break;
//            default:
//                printf("\nDiese Eingabe ist ungueltig. Bitte erneut versuchen.\n");
//                break;
//        }
    }
}


void push(char *buffer)
{
    if(strlen(buffer)+1 >= GROESSE)
        printf("\nDie Zeichenfolge ist zu lang!\n");
    else if(isFull()==TRUE)
        printf("\nDer Stack ist voll!\n");
    else
    {
        *stackzeiger = (char*)malloc(strlen(buffer)+1);  // +1 steht für \0
        strncpy(*stackzeiger, buffer, GROESSE);                            // strncpy ist das gleiche wie strcpy. Zusätzlich wird Länge angegeben
        printf("\n%s auf den Stack gelegt.\n", *stackzeiger);
        free(buffer);
        stackzeiger++;
        it++;
    }
}

char *pop()
{
    if(isEmpty()==TRUE)
    {
        printf("Der Stack ist leer!\n");
        return 0;
    }
    else
    {
       top();
        it--;
        printf(" entfernt.\n");
        free(*stackzeiger);
        stackzeiger--;
        return *stackzeiger;
    }
}

char *top()
{
    if(isEmpty()==TRUE)
    {
        printf("Der Stack ist leer!\n");
        return 0;
    }
    else
    {
        printf("Oberstes Element im Stack: %s", *(stackzeiger-1));
        return (*stackzeiger-1);
    }
}

void ausgeben()
{
    int n = it;
    char **ausgabeString = stackzeiger;
    if(isEmpty()== FALSE)
    {
        while(n>0)
        {
            ausgabeString--;
            printf("Element %d: %s\t\t",n,(*ausgabeString));
            printf("Adresse: %p\n" ,(*ausgabeString));
            n--;
        }
    }
    else
        printf("Der Stack ist leer.\n");
}

int isFull()
{
    if(it>=GROESSE)
        return TRUE;
    else
        return FALSE;
}

int isEmpty()
{
    if(it<=0)
        return TRUE;
    else
        return FALSE;
}

int Anzahl()
{
    printf("Auf dem Stapel befinden sich %d Elemente.\n", (it));
    return it;
}

int ende()
{
    return 0;
}

void callPush(void)
{

    char buffer[GROESSE];
    printf("Bitte geben sie eine Zeichenkette ein:\n");
//    fflush(stdin);
    getch;
    scanf("%s", buffer);
    printf("%d",strlen(buffer)+1);
    buffer[strlen(buffer)+1]='\0';
              // meintext = (char*)malloc(strlen(meintext)+1); // +1 steht für \0
    push(buffer);
    fflush(stdin);

}




void callPop(void)
{
    pop();
}
void callTop(void)
{
    top();
}
void callAusgeben(void)
{
    ausgeben();
}
void callAnzahl(void)
{
    Anzahl();
}
void callEnde(void)
{
   int ende();
}

