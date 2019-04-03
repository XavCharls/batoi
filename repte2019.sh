#!/bin/bash
numeros=( 1 2 3 4 5 6 7 8 9 10 11 12 )
palos=( ♥ ♦ ♣ ♠ )
cartas=""
baraja=""
cJugador=()
cMaquina=()
gJugador=""
gMaquina=""
#0 persona 1 maquina
jugadorActual=0
restantes=0
acabar=0
frontEnd=""
empezarPartida=""
a=0
k=0

#Crea la baraja a partir de los vectores numeros y palos
function iniciaBaraja(){

#Limpiamos la baraja para cuando se llama al método al inicio de cada partida
for (( i = 0; i <48; i++ )); do
		cartas[$i]=""
		baraja[$i]=""
	done	

for (( i = 0; i < 4; i++ )); do
	for (( j = 0; j < 12; j++ )); do
		cartas[$k]="${numeros[$j]}${palos[$i]}"
		k=$((k+1))
	done
done

#Desordena (baraja) las cartas
baraja=($(printf "%s\n" "${cartas[@]}" | shuf))
#Reaprovechamos la variable cartas para guardar la baraja en el mismo orden sin el palo (para poder hacer operaciones con ella)
for (( i = 0; i < 48; i++ )); do
	cartas[$i]=${baraja[$i]:0:${#baraja[$i]}-1}
done

}

#Comprueba segun el jugador si tiene 4 grupos
function comprobarGrupos(){
	
	cont=0
	aux=0
	cAux=()

	#si el jugador es la persona
	if [ $jugadorActual -eq $1 ];then

		cont=0
		aux=0
		cAux=()

		for n in ${cJugador[@]};do
			#lo de los grupos va bien
			for m in ${cJugador[@]};do
				if [ $n -eq $m ];then
					cont=$(($cont+1))
				fi
			done
			#si cuenta 4 cartas iguales
			if [ $cont -eq 4 ];then
				#actualiza los grupos
				gJugador=$gJugador" "$n
				#-----no se aqui como actualizar las cartas-----
				cAux=()
				for x in ${cJugador[@]};do
					if [ $x -ne $n ];then
						cAux[$aux]=$x
						aux=$(($aux+1))
					fi
				done
				cJugador=()
				i=0
				for (( i = 0; i < ${#cAux[@]}; i++)); do
					cJugador[$i]=${cAux[$i]}
				done
			fi
			cont=0
		done
		
	else	
		cont=0
		aux=0
		cAux=()
		for n in ${cMaquina[@]};do
			for m in ${cMaquina[@]};do
				if [ $n -eq $m ];then
					cont=$(($cont+1))
				fi
			done
			if [ $cont -eq 4 ];then
				gMaquina=$gMaquina" "$n
				cAux=()
				for x in ${cMaquina[@]};do
					if [ $x -ne $n ];then
						cAux[$aux]=$x
						aux=$(($aux+1))
					fi
				done
				cMaquina=()
				i=0
				for (( i = 0; i < ${#cAux[@]}; i++)); do
					cMaquina[$i]=${cAux[$i]}
				done
			fi
			cont=0
		done
		
	fi

}

#se piden las cartas y se comprueba el resultado
function pedirCarta(){
	aux=0
	cAux=()
	cont=0
	posicion=0
	pedir=0

	if [ $1 -eq 0 ];then
		
		#-Jugador-si la maquina no tiene cartas y quedan en la baraja roba
		if ([ ${#cMaquina[@]} -eq 0 ] && [ $restantes -lt 48 ]);then
			echo "A pescar!"
			jugadorActual=1
			cJugador[${#cJugador[@]}]=${cartas[$restantes]}
			restantes=$(($restantes+1))
		else
			echo "que carta quieres"
			read pedir
			
			#comprueba que sean numeros
			while ([ -z `echo $pedir | grep ^[0-9]*$` ] || [ $pedir -eq 0 ] || [ $pedir -gt 12 ]);do
				echo "introduce otra carta"
				read pedir
			done

			for n in ${cMaquina[@]};do
				if [ $n -eq $pedir ];then
					#el jugador acierta y se le suma la carta
					cJugador[${#cJugador[@]}]=$pedir
					aux=1
				fi
			done
			
			if [ $aux -eq 1 ];then
				#se actualizan las cartas de la maquina
				echo "acertaste"
				for x in ${cMaquina[@]};do
					if [ $x -ne $pedir ];then
						cAux[$cont]=$x
						cont=$(($cont+1))
					fi
				done
				cMaquina=()
				for (( i = 0; i < ${#cAux[@]}; i++)); do
					cMaquina[$i]=${cAux[$i]}
				done
			elif [ $restantes -lt 48 ];then
				echo "A pescar!"
				cJugador[${#cJugador[@]}]=${cartas[$restantes]}
				restantes=$(($restantes+1))
				jugadorActual=1
			else
				jugadorActual=1
			fi
		fi
	else
		#-Maquina-si el jugador no tiene cartas y quedan en la baraja roba
		if ([ ${#cJugador[@]} -eq 0 ] && [ $restantes -lt 48 ]);then
			echo "A pescar!"
			jugadorActual=0				
			cMaquina[${#cMaquina[@]}]=${cartas[$restantes]}
			echo "La maquina roba "${cartas[$restantes]}
			restantes=$(($restantes+1))
		else
			#cartas que pide la maquina
			if [ ${#cMaquina[@]} -eq 0 ];then
				pedir=`shuf -i 1-12 -n 1`
			else
				pedir=`shuf -i 0-$((${#cMaquina[@]}-1)) -n 1`
				pedir=${cMaquina[$pedir]}
			fi
			echo "la maquina pide $pedir"
			for n in ${cJugador[@]};do
				if [ $n -eq $pedir ];then
					cMaquina[${#cMaquina[@]}]=$n
					aux=1
				fi
			done
		
			#si acierta una carta
			if [ $aux -eq 1 ];then
				for x in ${cJugador[@]};do
					if [ $x -ne $pedir ];then
						cAux[$cont]=$x
						cont=$(($cont+1))
					fi
				done
				cJugador=()
				for (( i = 0; i < ${#cAux[@]}; i++)); do
					cJugador[$i]=${cAux[$i]}
				done
			#si no acierta y quedan en la baraja
			elif [ $restantes -lt 48 ];then
				echo "A pescar!"
				cMaquina[${#cMaquina[@]}]=${cartas[$restantes]}
				#echo "La maquina roba "${cartas[$restantes]}
				restantes=$(($restantes+1))
				jugadorActual=0
			else
				jugadorActual=0
			fi
		fi
	fi
}

function burbuja {
	cJugador=$1
	tam=${#cJugador[@]}
 
	for i in $(seq 1 $[$tam-1]); do
		for j in $(seq 0 $[$tam - $i - 1]); do
			if [ ${cJugador[$j]} -gt ${cJugador[$j+1]} ] ; then
			k=${cJugador[$[$j+1]]}
			cJugador[$j+1]=${cJugador[$j]}
			cJugador[$j]=$k
		fi
		done
	done
}

iniciaBaraja
#repartir las cartas
for (( i = 0; i < 7; i++)); do
	cJugador[$i]=${cartas[$i]}
	restantes=$(($restantes+1))
done

for (( i = 0; i < 7; i++)); do
	cMaquina[$i]=${cartas[$restantes]}
	restantes=$(($restantes+1))
done

#se le pasa el jugador por parametro
comprobarGrupos 0
comprobarGrupos 1
clear
echo "Quieres empezar, s para si cualquier otro para no"
read empezarPartida
if [ "$empezarPartida" != "s" ];then
	acabar=1
fi

clear

while [ $acabar -eq 0 ];do
#ordena las cartas
burbuja $cJugador
#comprueba los grupos
comprobarGrupos 0
comprobarGrupos 1
frontEnd=""

for (( i = 0; i < ${#cMaquina[@]}; i++)); do
	frontEnd=$frontEnd" X"
done

echo ""
echo "-----------------------------"
echo "cartas restantes" $((48-$restantes))
echo ""
echo ${cJugador[@]} "cartas Jugador"
echo $gJugador "grupos Jugador"
echo ""
#echo ${cMaquina[@]}
echo $frontEnd "cartas Maquina"
echo $gMaquina "grupos Maquina"
echo "-----------------------------"
echo ""
if ([ ${#cMaquina[@]} -eq 0 ] && [ $restantes -eq 48 ]);then
	if [ ${#gJugador} -gt ${#gMaquina} ];then
		echo "Gana el jugador"
	elif [ ${#gJugador} -eq ${#gMaquina} ];then
		echo "Empate"
	else
		echo "Gana la maquina"
	fi
	acabar=1
else
	pedirCarta $jugadorActual
fi

done
