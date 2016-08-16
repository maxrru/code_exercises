#!/bin/bash
#
#Autor: Max Ungar
#Matrikelnummer: 634893
#
#Autor: Christian Degenhardt
#Matrikelnummer: 435009
#
#
#Zuletzt bearbeitet: 2015-02-16
#
#
#"Formal education will make you a living; self-education will make you a fortune" ~ Jim Rohn
#
#################################################################################


#################################################################################
#Diverse statische Daten werden ermittelt
#
#


TAB="	"
USERNAME=`whoami`
REALNAME=`finger | grep  \`whoami\` | head -1 | awk '{print $2,$3}'`
WSNAME=`hostname | awk -F'.' '{print $1}'`
DOMAINNAME=`domainname`
FILENAME="${WSNAME}_info.txt"       #Hier soll der Titel fuer das Formular
#
#################################################################################


#################################################################################
#Datum und Zeit ermitteln. 
#Wird im Hauptmenue und in datenSpeichernED und datenSpeichernSED verwendet
#
datumUndZeit(){

	SAVETIME=`date +"%H:%M"`
	SAVEDATE=`date +"%d"."%m"."%Y"`

}
#
#################################################################################


#################################################################################
#Ermittelt die in das Formular zu schreibende Daten
#Speichert alle Daten in variablen ab
#
datenErmitteln(){


IPADDRESS=`host $WSNAME | awk '{print $4}'`
LASTBOOTTIME=`who -b | awk '{print $5}'`
LASTBOOTDATE=`who -b | awk '{printf "%s.%s\n",$4,$3}'`
OSVERSION=`uname -s`
PROCESSORTYPE=`uname -p`
PHYSCPU=`/usr/sbin/psrinfo -p` 
CORESPERCPU=`/usr/sbin/psrinfo -pv | head -1 | awk '{print $5}'` 
TOTALCORES=$(($PHYSCPU*$CORESPERCPU))
RAM=`/usr/sbin/prtconf | awk '/Memory/ {print $3}'` 
OSRELEASE=`uname -r` 
INSTALLED_PROGRAMS_BIN=`ls -1 /usr/bin /usr/local/bin | wc -w` 
INSTALLED_PROGRAMS_SBIN=`ls -1 /usr/sbin /usr/local/sbin | wc -w` 
FREESPACE=`df -h | grep \`whoami\` | head -1 | awk '{print $4}'`
TOTALSPACE=`df -h | grep \`whoami\` | head -1 | awk '{print $2}'` 

}
#
#################################################################################


#################################################################################
# Speichere bei Zustimmung ermittelte Informationen in einer Datei
saveInfo()
{
	
	printf "Ein neues Formular wird wird erstellt ...\n\n "
	FILENAME="${WSNAME}_info.txt"
	cp "serverinfo.txt" "$FILENAME"
	datumUndZeit
	
	ed "$FILENAME" <<EOF >> /dev/null
	1,\$s/\(Dateiname:\)/\1${TAB}${TAB}${FILENAME}/g
	1,\$s/\(erstellt am:\)/\1${TAB}${TAB}${SAVEDATE} /g
	1,\$s/\(um:\)/\1 ${SAVETIME}/g
	1,\$s/\(erstellt von:\)/\1${TAB}${TAB}${REALNAME}/g
	1,\$s/\(Speicherplatzinformationen fuer den User:\)/\1 ${USERNAME}${TAB} /g
	1,\$s/\(frei:von:\)/\1 ${TOTALSPACE}B/g
	1,\$s/\(frei:\)/\1 ${FREESPACE}B /g
	1,\$s/\(Hostname:\)/\1${TAB}${TAB}${TAB}${TAB}${WSNAME}/g
	1,\$s/\(Domainname:\)/\1${TAB}${TAB}${TAB}${TAB}${DOMAINNAME}/g
	1,\$s/\(IP Adresse:\)/\1${TAB}${TAB}${TAB}${TAB}${IPADDRESS}/g
	1,\$s/\(Betriebssystem:\)/\1${TAB}${TAB}${TAB}${TAB}${OSVERSION}/g
	1,\$s/\(Betriebsystem Release:\)/\1${TAB}${TAB}${TAB}${OSRELEASE}/g
	1,\$s/\(Processor Typ (Architektur):\)/\1${TAB}${TAB}${PROCESSORTYPE}/g
	1,\$s/\(Anzahl der CPUs:\)/\1${TAB}${TAB}${TAB}physikalisch: ${PHYSCPU} \/ virtuell: ${TOTALCORES}/g
	1,\$s/\(Hauptspeicher:\)/\1${TAB}${TAB}${TAB}${TAB}${RAM} Megabytes/g
	1,\$s/\(\/usr\/bin und \/usr\/local\/bin:\)/\1${TAB}${TAB}${INSTALLED_PROGRAMS_BIN}/g
	1,\$s/\(\/usr\/sbin und \/usr\/local\/sbin:\)/\1${TAB}${INSTALLED_PROGRAMS_SBIN}/g

	1,\$s/\(Letzter System boot am:\)/\1${TAB}${TAB}${TAB}${LASTBOOTDATE} um: ${LASTBOOTTIME}/g
	.
	w
	q
EOF
	
	if [ "$?" != 0 ]
	then
	    printf "\n Fehler beim Schreiben in $FILENAME!\n\n"
	else
	    printf "\nDie Datei $FILENAME wurde gespeichert.\n\n"
	fi
	
	read -p "Weiter mit ENTER ..."
	return
}
#
#################################################################################


#################################################################################
#Beginn des Programms
#
FINDERG=`find serverinfo.txt 2>> /dev/null`

if [ "$FINDERG" = "serverinfo.txt" ]
    then
    :
    else
    clear
    printf "Die Datei \"serverinfo.txt ist nicht vorhanden!\n"
    printf "Das Programm wird beendet.\n"
    sleep 3s
    clear
    exit
fi
#
#
#################################################################################


#################################################################################
#Hauptmenue des Programms
#Whileschleife, die mit E oder e beendet werden soll.
#ist eine Endlosschleife, da Test nur 1 zugewiesen bekommt
#
while [ 1 ]
do 

clear

#Auswahloptionen
    printf "*****************************************************************\n"
    printf "*%63s*\n" " "
    printf "*\tPruefungsscript von: %-35s*\n" `whoami`
    printf "*\tErmitteln von Systeminformationen fuer %s\t--> 1\t*\n" $WSNAME
    printf "*\tAnzeige der erstellten Infodatei\t\t--> 2\t*\n"
    printf "*\tProgramm beenden\t\t\t\t--> e/E\t*\n"
    printf "*%63s*\n" " "
    printf "*****************************************************************\n"
    printf "\tIhre Wahl: "
    read EINGABE

#Auswahl ausfuehren
    case $EINGABE in 

    1) 
    clear
    datenErmitteln
    if [[ `find "${WSNAME}_info.txt"` == "$FILENAME" ]] 2>> /dev/null
    then 
	printf "Es existiert schon eine Datei %s\n" $FILENAME
	printf "Moechten Sie diese ueberschreiben j/n: "
	read SPEICHERWAHL
	else
	SPEICHERWAHL="j"
    fi
#modified
    if [ "$SPEICHERWAHL" = "j" ]
    then
	saveInfo
	else
	    printf "\nDie Daten wurden nicht gespeichert!\n"
	    read -p "Weiter mit Eingabe..."
	    
    fi
    ;;
    
    2) 
    FINDFORM=`find "$FILENAME" 2>> /dev/null`
    if [ "$FILENAME" = "$FINDFORM" ]
    then
	clear
    cat $FILENAME
    read -p "Weiter mit Eingabe..."
    
    else
	clear
	printf "Die Datei %s existiert nicht!\n" $FILENAME
	read -p "Weiter mit Eingabe..."
    
    fi
    ;;

    e|E) 
    #Programmende mit Ausgabe
    clear
    printf "Das Programm wird beendet...\n"
    sleep 1s
    clear
    exit
    ;;
    
    *) 
    printf "Fehlerhafte Eingabe!!!\n"
    ;;

    esac
	
#sleep 2s

done
#
#Ende Hauptmenue
#################################################################################
