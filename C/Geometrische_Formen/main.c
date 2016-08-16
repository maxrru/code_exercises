#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define PI 3.141592653589793238
#define MAX 20
#define WERT 100

char enter;
struct datum
{
int jahr;
int monat;
int tag;
int stunde;
int minute;
int sekunde;
};

struct geoForm
{
char form;
float wert1;
float wert2;
float wert3;
float ergebnis;

struct datum erstellung;
struct geoForm *next;

}struct geoForm;

int menue(void);
void kreisBerechnung(void);
void rechteckBerechnung(void);
void dreieckBerechnung(void);
void kugelBerechnung(void);
void quaderBerechnung(void);
void elementAnhaengen(float wert1, float wert2, float wert3, float ergebnis, char form);
struct geoForm *erzeugeListenElement(float wert1, float wert2, float wert3, float ergebnis, char form);

void zufallsElemente(void);
void listeAusgeben(void);

struct geoForm *anfang = NULL;
struct geoForm *next = NULL;
struct geoForm *element = NULL;

int main()
{
   menue();
   return 0;
}

int menue(void)
{
    while(1)
    {
    char auswahl;

    printf("\nGeometrische Formen\n");
    printf("\n\nAuswahlmenue");
    printf("\nBitte waehlen Sie eine Aktion!");
    printf("\nKreis berechnen:\t\tk");
    printf("\nRechteck berechnen:\t\tr");
    printf("\nDreieck berechnen:\t\td");
    printf("\nKugel berechnen:\t\tg");
    printf("\nQuader berechnen:\t\tq");
    printf("\n\nZufallselemente erstellen:\tz");
    printf("\nListe ausgeben:\t\t\ta");
    printf("\n\nEnde:\t\t\t\tE oder e");

    printf("\n\nAuswahl: ");

    auswahl = getchar();
    fflush(stdin);

        switch(auswahl)
        {
        case 'k':
            kreisBerechnung();
        break;

        case 'r':
            rechteckBerechnung();
        break;

        case 'd':
            dreieckBerechnung();
        break;

        case 'g':
            kugelBerechnung();
        break;

        case 'q':
            quaderBerechnung();
        break;

        case 'z':
            zufallsElemente();
        break;

        case 'a':
            listeAusgeben();
        break;

        case 'e':
        case 'E':
            printf("\nFunktioniert =D\n\n");
            return 0;
        break;

        default:
            printf("\nUngueltige Eingabe!! Du Lutscher! :D");
        break;
        }
    }
    return 0;
}

void kreisBerechnung()
{
    float radius;
    float wert2=0;
    float wert3=0;
    char form = 'k';

    printf("\nKreis ausgewaehlt!");
    printf("\nRadius:");
    scanf("%f%c",&radius,&enter);
    fflush(stdin);
    float ergebnis = PI*radius*radius;

    printf("\nDer Radius betraegt %f", radius);
    printf("\nDas Ergebnis betraegt %f", ergebnis);
    elementAnhaengen(radius, wert2, wert3, ergebnis, form);
}

void rechteckBerechnung()
{
    float seiteA;
    float seiteB;
    float wert3 = 0;
    char form = 'r';
    printf("\nRechteck ausgewaehlt!");
    printf("\nSeite A:");
    scanf("%f%c", &seiteA,&enter);
    fflush(stdin);
    printf("\nSeite B:");
    scanf("%f%c", &seiteB,&enter);
    fflush(stdin);

    float ergebnis = seiteA*seiteB;

    printf("\nSeite A betraegt %f", seiteA);
    printf("\nSeite B betraegt %f", seiteB);
    printf("\nDas Ergebnis betraegt %f", ergebnis);
    elementAnhaengen(seiteA, seiteB, wert3, ergebnis, form);
}

void dreieckBerechnung()
{
    float grundseite;
    float hoehe;
    float wert3=0;
    char form = 'd';

     printf("\nDreieck ausgewaehlt!");
    printf("\nGrundseite:");
    scanf("%f%c", &grundseite,&enter);
    fflush(stdin);
    printf("\nHoehe:");
    scanf("%f%c", &hoehe,&enter);
    fflush(stdin);

    float ergebnis = (grundseite*hoehe)/2;

    printf("\nDie Hoehe betraegt %f", hoehe);
    printf("\nDie Grundseite betraegt %f", grundseite);
    printf("\nDas Ergebnis betraegt %f", ergebnis);
    elementAnhaengen(grundseite, hoehe, wert3, ergebnis, form);

}

void kugelBerechnung()
{
    float radius;
    float wert2 = 0;
    float wert3 = 0;
    char form = 'g';

    printf("\nKugel ausgewaehlt!");
    printf("\nRadius:");
    scanf("%f%c", &radius,&enter);
    fflush(stdin);

    float ergebnis = 4/3*(PI*radius*radius*radius);

    printf("\nDer Radius betraegt %f", radius);
    printf("\nDas Ergebnis betraegt %f", ergebnis);
    elementAnhaengen(radius, wert2, wert3, ergebnis, form);

}

void quaderBerechnung()
{
    float seiteA;
    float seiteB;
    float seiteC;
    char form = 'q';

    printf("\nQuader ausgewaehlt!");
    printf("\nSeite A:");
    scanf("%f%c", &seiteA,&enter);
    fflush(stdin);
    printf("\nSeite B:");
    scanf("%f%c", &seiteB,&enter);
    fflush(stdin);
    printf("\nSeite C:");
    scanf("%f%c", &seiteC,&enter);
    fflush(stdin);

    float ergebnis = seiteA*seiteB*seiteC;

    printf("\nDas Ergebnis betraegt %f",ergebnis);
    elementAnhaengen(seiteA, seiteB, seiteC, ergebnis, form);
}

void elementAnhaengen(float wert1, float wert2, float wert3, float ergebnis, char form)
{
    /* Zeiger zum Zugriff auf die einzelnen Elemente der Struktur*/
    struct geoForm *zeiger;
struct geoForm *element = erzeugeListenElement(wert1, wert2,  wert3, ergebnis, form);
    if(anfang==NULL)
        {   anfang = element;
//            if((anfang=malloc(sizeof(struct geoForm)))==NULL)
//                {
//                    printf("Kein Speicherplatz vorhanden!!!");
//                    return;
//                }
//
//            time_t t;
//            struct tm *ts;
//
//            time(&t);
//            ts = localtime(&t);
//
//         anfang->form=form;
//         anfang->wert1=wert1;
//         anfang->wert2=wert2;
//         anfang->wert3=wert3;
//         anfang->ergebnis=ergebnis;
//
//         anfang->erstellung.jahr=ts->tm_year+1900;
//         anfang->erstellung.monat=ts->tm_mon+1;
//         anfang->erstellung.tag=ts->tm_mday;
//         anfang->erstellung.stunde=ts->tm_hour;
//         anfang->erstellung.minute=ts->tm_min;
//         anfang->erstellung.sekunde=ts->tm_sec;
//
//         anfang->next=NULL;

        printf("\n\n1. Element angehaengt!");

        }
        else{
            zeiger=anfang;
            while(zeiger->next!=NULL)
            {
                zeiger=zeiger->next;
            }
            zeiger->next = element;
//            if((zeiger->next=malloc(sizeof(struct geoForm)))==NULL)
//            {
//                printf("Kein Speicherplatz verfuegbar!!");
//                return;
//            }
//            /*Zeiger auf das naechste leere Element*/
//            zeiger=zeiger->next;
//
//                time_t t;
//                struct tm *ts;
//
//                time(&t);
//                ts = localtime(&t);
//
//            zeiger->form=form;
//            zeiger->wert1=wert1;
//            zeiger->wert2=wert2;
//            zeiger->wert3=wert3;
//            zeiger->ergebnis=ergebnis;
//
//            zeiger->erstellung.jahr=ts->tm_year+1900;
//            zeiger->erstellung.monat=ts->tm_mon+1;
//            zeiger->erstellung.tag=ts->tm_mday;
//            zeiger->erstellung.stunde=ts->tm_hour;
//            zeiger->erstellung.minute=ts->tm_min;
//            zeiger->erstellung.sekunde=ts->tm_sec;
//
//            zeiger->next=NULL;

            printf("\n\nElement angehaengt!");
        }
}
struct geoForm *erzeugeListenElement(float wert1, float wert2, float wert3, float ergebnis, char form)
{
     struct geoForm *zeiger;
     if((zeiger=malloc(sizeof(struct geoForm)))==NULL)
            {
                printf("Kein Speicherplatz verfuegbar!!");
                return NULL;
            }

                time_t t;
                struct tm *ts;

                time(&t);
                ts = localtime(&t);

            zeiger->form=form;
            zeiger->wert1=wert1;
            zeiger->wert2=wert2;
            zeiger->wert3=wert3;
            zeiger->ergebnis=ergebnis;

            zeiger->erstellung.jahr=ts->tm_year+1900;
            zeiger->erstellung.monat=ts->tm_mon+1;
            zeiger->erstellung.tag=ts->tm_mday;
            zeiger->erstellung.stunde=ts->tm_hour;
            zeiger->erstellung.minute=ts->tm_min;
            zeiger->erstellung.sekunde=ts->tm_sec;

            zeiger->next=NULL;
            return zeiger;

};
void listeAusgeben()
{
    struct geoForm *zeiger;

    zeiger=anfang;

    while(zeiger!=NULL)
    {
        printf("\n\n\n\nForm: %c", zeiger->form);
        printf("\nWert 1: %f", zeiger->wert1);
        if(zeiger->wert2!=0)
        {
                printf("\nWert 2: %f", zeiger->wert2);
        }
        if(zeiger->wert3!=0)
        {
                printf("\nWert 3: %f", zeiger->wert3);
        }
        printf("\nErgebnis: %f", zeiger->ergebnis);

        printf("\nJahr: %d", zeiger->erstellung.jahr);
        printf("\nMonat: %d", zeiger->erstellung.monat);
        printf("\nTag: %d", zeiger->erstellung.tag);

        printf("\nStunde: %d", zeiger->erstellung.stunde);
        printf("\nMinute: %d", zeiger->erstellung.minute);
        printf("\nSekunde: %d", zeiger->erstellung.sekunde);

        zeiger=zeiger->next;
    }
}

void zufallsElemente(void)
{
    int it;
    char zform;
    float zwert1;
    float zwert2;
    float zwert3;
    float zergebnis;

    time_t ti;
    time(&ti);
    srand((unsigned int)ti);

    for(it=0; it<MAX; it++)
    {
        int dieForm = rand() % 5 +1;

        switch(dieForm)
        {
            case 1:
                 zform = 'k';
                 zwert1 = rand() % WERT +1;
                 zwert2 = 0;
                 zwert3 = 0;
                 zergebnis = PI*zwert1*zwert1;

            //    printf("\nKreis erstellt.");
            break;
            case 2:
                 zform = 'r';
                 zwert1 = rand() % WERT +1;
                 zwert2 = rand() % WERT +1;
                 zwert3 = 0;
                 zergebnis = zwert1*zwert2;

              //  printf("\nRechteck erstellt.");
            break;
            case 3:
                 zform = 'd';
                 zwert1 = rand() % WERT +1;
                 zwert2 = rand() % WERT +1;
                 zwert3 = 0;
                 zergebnis = (zwert1*zwert2)/2;

            //    printf("\nDreieck erstellt.");
            break;
            case 4:
                 zform = 'g';
                 zwert1 = rand() % WERT +1;
                 zwert2 = 0;
                 zwert3 = 0;
                 zergebnis = 4/3*(PI*zwert1*zwert1*zwert1);

              //  printf("\nKugel erstellt.");
            break;
            case 5:
                 zform = 'q';
                 zwert1 = rand() % WERT +1;
                 zwert2 = rand() % WERT +1;
                 zwert3 = rand() % WERT +1;
                 zergebnis = zwert1*zwert2*zwert3;
             //  printf("\nQuader erstellt.");
            break;
        }
        elementAnhaengen(zwert1, zwert2, zwert3, zergebnis, zform);
    }
}

//funktioniere!








