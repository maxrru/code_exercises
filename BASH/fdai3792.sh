#!/bin/bash
#
#Autor: Max Ungar
#Matrikelnummer: 634893
#
#Erstellungsdatum: 2015-01-15
#Zuletzt bearbeitet: 2015-02-11
#
#
#"Formal education will make you a living; self-education will make you a fortune" ~ Jim Rohn
#
#################################################################################

#Frage Datum ermitteln: soll das Datum der Abfrage oder das Datum des Speicherns ermittelt werden?




#################################################################################
#Servername wird ermittelt
#die Eingabevariable fuer das Hauptmenue wird initialisiert. Eigentlich obsolet
#
AKTFORMULAR=0                              #Hier soll der Titel fuer das Formular
					   #gespeichert werden

servername=`uname -n|awk -F. '{print $1}'` #Servername ohne Domainanteil
servnamecache=`echo \"$servername\"`       #Servername mit Anfuehrungszeichen
trennlinie="---------------------------------------------------------------"
TAB="	"
#
#################################################################################




#################################################################################
#Datum und Zeit ermitteln. 
#Wird im Hauptmenue und in datenSpeichernED und datenSpeichernSED verwendet
#
datumUndZeit(){

DATUM=`date +"%d.%m.%Y"`
ZEIT=`date +"%H.%M.%S"`

}
#
#################################################################################




#################################################################################
#Ermittelt die in das Formular zu schreibende Daten
#Speichert alle Daten in variablen ab
#
datenErmitteln(){

IPADRESSE=`host \`hostname\`|awk '{print $4}'`

LETZTERBOOT=`uptime|awk '{print $3}'`
BETRIEBSSYSTEM=`uname -s`
KERNELVERSION=`uname -r`
KERNELARCHITEKTUR=`uname -p`
PHYSCPU=`/usr/sbin/psrinfo -p`
RAMGROESSE=`/usr/sbin/prtconf|grep Memory|awk '{print $3}'`

RAMMITBEZ=`/usr/sbin/prtconf|grep Memory|awk '{print $3 " " $4}'`


}
#
#################################################################################




#################################################################################
#Gibt die ermittelten Daten auf den Bildschirm aus.
#
datenAusgeben(){

    printf "IP-Adresse:\t\t\t%-40s\n" $IPADRESSE
    
    if [ $LETZTERBOOT = 1 ]
    then
	printf "Letzter Boot vor:\t\t%s Tag\n" $LETZTERBOOT
	else
	    printf "Letzter Boot vor:\t\t%s Tagen\n" $LETZTERBOOT
    fi

    printf "Betriebssystem:\t\t\t%s\n" $BETRIEBSSYSTEM

    printf "Kernelversion:\t\t\t%s\n" $KERNELVERSION
    
    printf "Kernelarchitektur:\t\t%s\n" $KERNELARCHITEKTUR

    printf "Anzahl physikalischer CPUs:\t%d\n" $PHYSCPU

    printf "Groesse des Hauptspeichers:\t%s Megabytes\n" $RAMGROESSE

}
#
#################################################################################




#################################################################################
#     Uebertraegt Daten in das Formular
#     Ruft Benutzername, Datum und Zeit auf, um die Zeit zu ermitteln, zu der das
#     Formular gespeichert wird
#     Verwendet sed
#
datenSichernSED(){
BENUTZERTITEL=`finger \`whoami\`|head -1 | awk -F: '{print $3}'|awk '{print $1 $2}'`
BENUTZERLEER=`finger \`whoami\`|head -1 | awk -F: '{print $3}'|awk '{print $1 " " $2}'`
AKTFORMULAR="${BENUTZERTITEL}_${DATUM}_${ZEIT}_FORMULAR"

datumUndZeit


cp Formular "${AKTFORMULAR}"

touch tmpfile #ein Buffer wird angelegt
printf "Formular kopiert!\nSchreibe in Datei...\n"


sed "s/\(NAME:\)/\1${TAB}${BENUTZERLEER}\n/g" < "$AKTFORMULAR" > "tmpfile"; mv "tmpfile" "$AKTFORMULAR"
sed "s/\(DATUM:\)/\1${TAB}${DATUM}\n/g" < "$AKTFORMULAR" > "tmpfile"; mv "tmpfile" "$AKTFORMULAR"

sed "s/\(IP-ADRESSE:\)/\1${TAB}${IPADRESSE}\n/g" < "$AKTFORMULAR" > "tmpfile"; mv "tmpfile" "$AKTFORMULAR"

sed "s/\(BOOT:\)/\1${TAB}${LETZTERBOOT}\n/g" < "$AKTFORMULAR" > "tmpfile"; mv "tmpfile" "$AKTFORMULAR"

sed "s/\(BETRIEBSSYSTEM:\)/\1${TAB}${BETRIEBSSYSTEM}\n/g" < "$AKTFORMULAR" > "tmpfile"; mv "tmpfile" "$AKTFORMULAR"
sed "s/\(KERNELVERSION:\)/\1${TAB}${KERNELVERSION}\n/g" < "$AKTFORMULAR" > "tmpfile"; mv "tmpfile" "$AKTFORMULAR"
sed "s/\(KERNELARCHITEKTUR:\)/\1${TAB}${KERNELARCHITEKTUR}\n/g" < "$AKTFORMULAR" > "tmpfile"; mv "tmpfile" "$AKTFORMULAR"

sed "s/\(PHYSCPU:\)/\1${TAB}${PHYSCPU}\n/g" < "$AKTFORMULAR" > "tmpfile"; mv "tmpfile" "$AKTFORMULAR"
sed "s/\(RAMGROESSE:\)/\1${TAB}${RAMMITBEZ}\n/g" < "$AKTFORMULAR" > "tmpfile"; mv "tmpfile" "$AKTFORMULAR"

printf "Schreiben erfolgreich!\n"


}
#
#################################################################################



#################################################################################
#Daten sichern, mit dem ED statt dem SED. 
#
datenSichernED(){

BENUTZERTITEL=`finger \`whoami\`|head -1 | awk -F: '{print $3}'|awk '{print $1 $2}'`
BENUTZERLEER=`finger \`whoami\`|head -1 | awk -F: '{print $3}'|awk '{print $1 " " $2}'`

datumUndZeit

AKTFORMULAR="${BENUTZERTITEL}_${DATUM}_${ZEIT}_FORMULAR"

cp Formular "${AKTFORMULAR}"
#Testen, ob Formular geschrieben und gespeichert wurde!

ed "$AKTFORMULAR" <<EOF >> /dev/null
1,\$s/\(NAME:\)/\1${TAB}${TAB}${TAB}${BENUTZERLEER}/g
1,\$s/\(DATUM:\)/\1${TAB}${TAB}${TAB}${DATUM}/g
1,\$s/\(UHRZEIT:\)/\1${TAB}${TAB}${ZEIT}/g
1,\$s/\(IP-ADRESSE:\)/\1${TAB}${TAB}${IPADRESSE}/g
1,\$s/\(BOOT:\)/\1${TAB}${TAB}${TAB}${LETZTERBOOT}/g
1,\$s/\(BETRIEBSSYSTEM:\)/\1${TAB}${TAB}${BETRIEBSSYSTEM}/g
1,\$s/\(KERNELVERSION:\)/\1${TAB}${TAB}${KERNELVERSION}/g4222222
1,\$s/\(KERNELARCHITEKTUR:\)/\1${TAB}${KERNELARCHITEKTUR}/g
1,\$s/\(PHYSCPU:\)/\1${TAB}${TAB}${PHYSCPU}/g
1,\$s/\(RAMGROESSE:\)/\1${TAB}${TAB}${RAMMITBEZ}/g
.
w
q
EOF

if [ "$?" = 0 ]
then
    printf "Datei %s erfolgreich geschrieben!\n" $AKTFORMULAR
    else
	printf "Fehler bei Datei %s!\n" $AKTFORMULAR
fi






}
#
#################################################################################




#################################################################################
#ANFANG DES PROGRAMMS
#Test, ob der Name der Datei korrekt ist
#

#clear
if [ `basename $0` = "`whoami`.sh" ]
   then 
   printf "Name OK. Fortfahren...\n" 
	
   else 
     printf "*****************************************************************\n"
     printf "* Der Skriptname \"`basename $0`\" entspricht nicht der Vorgabe!!!\n"
     printf "* Das Skript \"`basename $0`\" wird in \"`whoami`.sh\" umbenannt \n"

     mv `basename $0` `whoami`.sh

     printf "* Das Umbenennen war erfolgreich!                                \n"
     printf "*****************************************************************\n"
fi
#sleep 3s

#
#################################################################################




#################################################################################
#Hauptmenue des Programms
#Whileschleife, die mit E oder e beendet werden soll.
#ist eine Endlosschleife, da Test nur 1 zugewiesen bekommt
#
while [ 1 ]
do 

datumUndZeit


#    clear

#Auswahloptionen
    printf "*****************************************************************\n"
    printf "*%63s*\n" " "
    printf "*\tServer: %-48s*\n" $servnamecache
    printf "*\tDatum: %s\tUhrzeit: %-23s*\n" $DATUM $ZEIT
    printf "*\tErmitteln von Systeminformationen:\t\t--> 1\t*\n"
    printf "*\tListe vorhandener Infodateien:\t\t\t--> 2\t*\n"
    printf "*\tAnzeige der zuletzt erstellten Infodatei:\t--> 3\t*\n"
    printf "*\tProgramm beenden:\t\t\t\t--> e/E\t*\n"
    printf "*%63s*\n" " "
    printf "*****************************************************************\n\n"
    printf "\tIhre Wahl: "
    read EINGABE

#Auswahl ausfuehren
    case $EINGABE in 

    1) 
    datenErmitteln
    datenAusgeben
    printf "\nWollen sie die Daten speichern? (y/n): "
    read SPEICHERWAHL
    
    if [ "$SPEICHERWAHL" = "y" ]
    then

#Hier kann man waehlen, ob man datenSichernED oder datenSichernSED verwenden will
	datenSichernED
	else
	    printf "\nDie Daten wurden nicht gespeichert!\n"
	    read -p "Weiter mit Eingabe..."
	    
    fi
    ;;
    
    2) 
    if [ -z "`ls | grep FORMULAR`" ]
    then
	printf "Keine Dateien vorhanden!\n"
	read -p "Weiter mit Eingabe..."
	else
	printf "Liste vorhandener Infodateien...\n"
	printf "%s\n" `ls -t|grep FORMULAR`
	read -p "Weiter mit Eingabe... "
    fi
    ;;

    3) 

    if [ "$AKTFORMULAR" = "0" ]
    then
	AKTFORMULAR=`ls -t | grep FORMULAR | head -1`

    fi

    if [ -z "$AKTFORMULAR" ]
	then
	printf "Keine Infodatei vorhanden!\n"
	else
	    printf "Anzeige der letzten Infodatei...\n"
	    cat $AKTFORMULAR
    fi

    read -p "Weiter mit Eingabe..."
    ;;
    
    e|E) 
    break;;
    
    *) 
    printf "Fehlerhafte Eingabe!!!\n"
    ;;

    esac
	
#sleep 2s

done
#
#Ende Hauptmenue
#################################################################################



#################################################################################
#Programmende mit Ausgabe
#

#clear
printf "Programm wird beendet...\n"
sleep 1s
#clear
exit
#
#################################################################################











#################################################################################
#################################################################################



#################################################################################
#Gedoens
#
#speichergroesse=`cat /proc/meminfo | awk '/^MemTotal/{print $2}'`
#speicherausgabe=`expr $speichergroesse / 1048576`
#printf "Groessee des Hauptspeichers:\t%.2f GB\n" $speicherausgabe ;;
#printf "Anzahl CPU-Kerne:\t\t%s\n" `cat /proc/cpuinfo | awk '/^processor/{print $3}' | wc -l`;;
#Laenge eines Strings anzeigen lassen: printf "servername length: ${#servername}"
#So kann man die IP-Adresse unter XUbuntu herausfinden
#printf "IP-Adresse:\t\t\t%s\n" `/usr/sbin/ifconfig | grep inet |head -1 | awk '{print $2}' | awk -F: '{print $2}'`;;
#Mit read VAR kann man texte anzeigen lassen, bis eine Eingabe getaetigt wird
#cp Formular "${BENUTZER}_${DATUM}_${ZEIT}_FORMULAR"
#
#################################################################################


#################################################################################
#Alle ED-Aufrufe einzeln!
#
#ed "$AKTFORMULAR" <<EOF
#1,\$s/\(NAME:\)/\1${TAB} ${BENUTZERLEER}`\\n`/g
#.
#w
#q
#EOF

#ed "$AKTFORMULAR" <<EOF
#1,\$s/\(DATUM:\)/\1${TAB}${DATUM}`\\n`/g
#.
#w
#q
#EOF

#ed "$AKTFORMULAR" <<EOF
#1,\$s/\(NAME:\)/\1${TAB}${TAB}${TAB}${BENUTZERLEER}/g
#.
#w
#q
#EOF#

#ed "$AKTFORMULAR" <<EOF
#1,\$s/\(DATUM:\)/\1${TAB}${TAB}${TAB}${DATUM}/g
#.
#w
#q
#EOF

#ed "$AKTFORMULAR" <<EOF
#1,\$s/\(UHRZEIT:\)/\1${TAB}${TAB}${ZEIT}/g
#.
#w
#q
#EOF


#ed "$AKTFORMULAR" <<EOF
#1,\$s/\(IP-ADRESSE:\)/\1${TAB}${TAB}${IPADRESSE}/g
#.
#w
#q
#EOF


#ed "$AKTFORMULAR" <<EOF
#1,\$s/\(BOOT:\)/\1${TAB}${TAB}${TAB}${LETZTERBOOT}/g
#.
#w
#q
#EOF

#ed "$AKTFORMULAR" <<EOF
#1,\$s/\(BETRIEBSSYSTEM:\)/\1${TAB}${TAB}${BETRIEBSSYSTEM}/g
#.
#w
#q
#EOF

#ed "$AKTFORMULAR" <<EOF
#1,\$s/\(KERNELVERSION:\)/\1${TAB}${TAB}${KERNELVERSION}/g
#.
#w
#q
#EOF

#ed "$AKTFORMULAR" <<EOF
#1,\$s/\(KERNELARCHITEKTUR:\)/\1${TAB}${KERNELARCHITEKTUR}/g
#.
#w
#q
#EOF

#ed "$AKTFORMULAR" <<EOF
#1,\$s/\(PHYSCPU:\)/\1${TAB}${TAB}${PHYSCPU}/g
#.
#w
#q
#EOF

#ed -s "$AKTFORMULAR" <<EOF 
#1,\$s/\(RAMGROESSE:\)/\1${TAB}${TAB}${RAMMITBEZ}/g
#.
#w
#q
#EOF
#printf "%s\n" $?
#
#################################################################################



#################################################################################
#Funktion fuer Menue Nummer 1
#beinhaltet die Anzeige, das case und die Ausgabe auf dem Bildschirm
#Ruft datenErmitteln() auf
#Systeminfo ist obsolet, es sollen immer alle daten ermittelt und in das Formular gespeichert werden
#
systeminfo()
{

syswahl=0
failzaehler=0
    

while [ $failzaehler -le 2 ]

do
    #clear
    printf "*****************************************************************\n"
    printf "*%63s*\n" " "
    printf "*\tErmittlung von Systeminformationen zu \"$servername\"\t\t*\n"
    printf "*%s*\n" $trennlinie
    printf "*\tIP Adresse\t\t\t\t--> 1\t\t*\n"
    printf "*\tLetzter Boot vor\t\t\t--> 2\t\t*\n"
    printf "*\tBetriebssystem\t\t\t\t--> 3\t\t*\n"
    printf "*\tKernelversion\t\t\t\t--> 4\t\t*\n"
    printf "*\tKernelarchitektur\t\t\t--> 5\t\t*\n"
    printf "*\tAnzahl der CPUs\t\t\t\t--> 6\t\t*\n"
    printf "*\tGroesse des Hauptspeichers\t\t--> 7\t\t*\n"
    printf "*\tAlle Systemeigentschaften\t\t--> all / ALL\t*\n"
    printf "*\tProgrammabbruch\t\t\t\t--> q / Q\t*\n"
    printf "*****************************************************************\n"
    printf "Ihre Wahl (durch Leerzeichen getrennt): "
    read syswahl

    datenErmitteln

    if [ -z "$syswahl" ]
	then
#	clear
	printf "Daten des Servers:\t\t\"$servername\"\n"
	printf "%s\n" $trennlinie
 	printf "Es wurden keine Parameter ausgewaehlt!\n"
	printf "%s\n" $trennlinie
	sleep 1s


	elif [ "$syswahl" = q ]
	    then
#	    clear
	    printf "Hauptmenue...\n"
	    return

	elif [ "$syswahl" = Q ]
	    then
#	    clear
	    printf "Hauptmenue...\n"
	    return


	else

	    read -a syswahlarray <<< "$syswahl"

#	    clear
	    printf "Server: \t\t$servername\n"
	    printf "%s\n" $trennlinie

	    for aktAuswahl in "${syswahlarray[@]}"
	    do

  	        case $aktAuswahl in
			
		1)
		failzaehler=0
		printf "IP-Adresse:\t\t\t%-40s\n" $IPADRESSE
		;;
			

		2) 
		failzaehler=0
					
		if [ $LETZTERBOOT = 1 ]
		   then
		   printf "Letzter Boot vor:\t\t%s Tag\n" $LETZTERBOOT
		   else
		   printf "Letzter Boot vor:\t\t%s Tagen\n" $LETZTERBOOT
		fi;;
			

		3) 
		failzaehler=0
		printf "Betriebssystem:\t\t\t%s\n" $BETRIEBSSYSTEM;;

		4)
		failzaehler=0
		printf "Kernelversion:\t\t\t%s\n" $KERNELVERSION;;


		5)
		failzaehler=0
		printf "Kernelarchitektur:\t\t%s\n" $KERNELARCHITEKTUR;;


		6)
		failazehler=0

		printf "Anzahl physikalischer CPUs:\t%d\n" $PHYSCPU;;

		7)
		failzaehler=0

		printf "Groesse des Hauptspeichers:\t%s Megabytes\n" $RAMGROESSE;;

		all|ALL) printf "all";;


		q|Q) 
		:;;

		*) 

#    	        clear
	        let "failzaehler++"
		printf "$failzaehler . falsche Eingabe!\n"
		
		if [ $failzaehler -le 2 ]
		    then
		    printf "Nach 3 aufeinander folgenden Falscheingaben wird das Hauptmenue aufgerufen!\n"
		fi;;



   	        esac


#               sleep 1s

	#Ende der Forschleife
	    done



	if [ $failzaehler -lt 3 ]
	    then
	    printf "\n%s\n" $trennlinie
	   
	    elif [ $failzaehler -ge 3 ]
	    then
	    printf "%d Falscheingaben! Hauptmenue wird aufgerufen..." $failzaehler
	    break

	fi


#Hier muss die Abfrage hin, ob die datei abgespeichert werden soll oder nicht
	printf "\nSollen die Daten abgespeichert werden? (y/n)\n"
	printf "\tIhre Wahl: "
    	read SAVEDAT
	
	if [ "$SAVEDAT" = y ]
	   then 
	   datenSichernSED
	   else
	   :
	fi
	



#       sleep 3s
    fi


#Ende der Whileschleife
done


}
#Ende von systeminfo
#Funktion obsolet
#################################################################################
