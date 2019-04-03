#!/bin/bash
#SCRIPT QUE IMPLEMENTA EL JUEGO DE LA CARTA MÁS ALTA

#Variales globales
numeros=( 1 2 3 4 5 6 7 8 9 10 11 12 )
palos=( ♥ ♦ ♣ ♠ )
cartas=""
baraja=""
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

function jugarOtra(){
	echo "quieres jugar otra? s para si otro para no"
	ganancias=1
	read continuar
	if [ "$continuar" != "s" ];then
		jugarOtra=1
		break;
	fi
}
#-------------------------------------------------------------

cSaldo=0
jugarOtra=0
continuar=""
apuesta=0
crupierApues=0
ganancias=1

clear
echo "nombre del jugador"
read jugador

#comprobar que se mete el nombre
while [ -z $jugador ];do
	echo "vacio"
	read jugador
done

echo ""
echo "saldo"
read saldo

#comprobar que el saldo sean numeros
while [ $cSaldo -eq 0 ];do
	if [ -z `echo $saldo | grep ^[0-9]*$` ];then
		echo "introduce el saldo otra vez"
		read saldo
	else
		cSaldo=1
	fi
done

clear
#partida
while [ $jugarOtra -eq 0 ];do
iniciaBaraja
ganancias=1
crupierApues=0
	if [ $saldo -le 0 ];then
		echo "Te has quedado sin saldo"
		jugarOtra=1
	else
		#ronda 1
		clear
		echo "Ronda 1"
		saldo=$(($saldo-1))
		echo "saldo actual $saldo"
		echo "apuesta actual 1"
		echo ""
		echo "Crupier"
		echo "X X X"
		echo ""
		echo $jugador
		echo "${baraja[0]} ${baraja[1]} ${baraja[2]}"
		echo ""
		echo "Quieres continuar? s para si otro para no"
		read continuar
		if [ "$continuar" = "s" ];then
			echo "Cuanto quieres apostar? actual $saldo"
			read apuesta
			while [ $apuesta -gt $saldo ];do
				echo "no puedes apostar mas de lo que tienes apuesta otra vez"
				read apuesta
			done
			saldo=$(($saldo-$apuesta))
			apuesta=$(($apuesta+1))
			ganancias=$(($apuesta*2))
			#ronda 2
			clear
			echo "Ronda 2"
			echo "saldo actual $saldo"
			echo "apuesta actual $apuesta"
			echo ""
			echo "Crupier"
			echo "${baraja[3]} ${baraja[4]} X"
			echo ""
			echo $jugador
			echo "${baraja[0]} ${baraja[1]} ${baraja[2]}"
			
			echo "Quieres continuar? se doblara tu apuesta de $apuesta o all in"
			echo "s para si otro para no"
			read continuar
			if [ "$continuar" = "s" ];then
				#cruprier apuesta o no
				if (([ $((${cartas[3]}+${cartas[4]}+6)) -ge $((${cartas[0]}+${cartas[1]}+${cartas[2]})) ] || [ `shuf -i 1-10 -n 1` -eq 10 ]) && [ $((${cartas[3]}+${cartas[4]}+12)) -ge $((${cartas[0]}+${cartas[1]}+${cartas[2]})) ]);then
					crupierApues=1
					#doblar apuesta
					if [ $(($apuesta*2)) -gt $saldo ];then
						apuesta=$(($saldo+$apuesta))
						saldo=0
					else
						saldo=$(($saldo-$apuesta))
						apuesta=$(($apuesta*2))
					fi
					ganancias=$(($apuesta*2))
				fi
				
				if [ $crupierApues -eq 1 ];then
					#ronda 3
					clear
					echo "ronda 3"
					echo "saldo actual $saldo"
					echo "apuesta actual $apuesta"
					echo ""
					echo "Crupier"
					echo "${baraja[3]} ${baraja[4]} ${baraja[5]}"
					echo ""
					echo $jugador
					echo "${baraja[0]} ${baraja[1]} ${baraja[2]}"
					
					if [ $((${cartas[3]}+${cartas[4]}+${cartas[5]})) -eq $((${cartas[0]}+${cartas[1]}+${cartas[2]})) ];then
						#empate
						echo "empate ganas "$(($ganancias/2))
						saldo=$(($saldo+$(($ganancias/2))))
						echo "saldo actual $saldo"
						jugarOtra
					elif [ $((${cartas[3]}+${cartas[4]}+${cartas[5]})) -gt $((${cartas[0]}+${cartas[1]}+${cartas[2]})) ];then
						#gana maquina
						echo "perdiste "$apuesta
						saldo=$(($saldo-$apuesta))
						echo "saldo actual $saldo"
						jugarOtra
					else
						#gana jugador
						echo "ganaste "$ganancias
						saldo=$(($saldo+$ganancias))
						echo "saldo actual $saldo"
						jugarOtra
					fi
				else
					#DE3
					#gana jugador por retirada
					clear
					echo "Ronda 3"	
					echo "saldo actual $saldo"
					echo "apuesta actual $apuesta"
					echo ""
					echo "Crupier"
					echo "${baraja[3]} ${baraja[4]} ${baraja[5]}"
					echo ""
					echo $jugador
					echo "${baraja[0]} ${baraja[1]} ${baraja[2]}"
					echo ""
					echo "Ganaste $ganancias el crupier no apuesta"
					saldo=$(($saldo+$ganancias))
					jugarOtra
				fi
			else
				#DE2
				echo "Perdiste"
				jugarOtra
			fi
			
		else
			#DE1
			echo "Perdiste"
			jugarOtra
		fi
	fi

done

echo "fin del juego"
































