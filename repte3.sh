#!/bin/bash

rellenar=0
secreto=()
input=()
fallo=0
aciertos=0
intentos=1
posicionesBien=0

while [ $rellenar -lt 4 ];do
	secreto[${#secreto[@]}]=`shuf -i 1-9 -n 1`
	rellenar=$(($rellenar+1))
done

echo "numero secreto" ${secreto[0]}${secreto[1]}${secreto[2]}${secreto[3]}
echo "A ver cuánto tardas en averiguar el código que he generado"
read numero

while [ $fallo -eq 0 ];do

	while  ([ $numero -lt 1000 ] || [ $numero -gt 9999 ]);do
		echo numero de 4 cifras
		read numero
	done
	input[0]=$(($numero/1000))
	input[1]=$(($numero/100%10))
	input[2]=$(($numero/10%10))
	input[3]=$(($numero%10))
	
	for i in ${secreto[@]};do
		for j in ${input[@]};do
			if [ $j -eq $i ];then
				aciertos=$(($aciertos+1))
				break
			fi
		done
	done
	
	for n in 0 1 2 3;do
		if [ ${secreto[n]} -eq ${input[n]} ];then
			posicionesBien=$(($posicionesBien+1))
		fi
	done

	if ([ ${secreto[0]} -eq ${input[0]} ] && [ ${secreto[1]} -eq ${input[1]} ] && [ ${secreto[2]} -eq ${input[2]} ] && [ ${secreto[3]} -eq ${input[3]} ]);then
		fallo=1
		echo "Muy bien! Has acertado el código! Has tardado" $intentos "intentos"
	else
		echo "Has acertado" $aciertos "números," $posicionesBien "de ellos en la posicion correcta." 
		read numero
		aciertos=0
		intentos=$(($intentos+1))
		posicionesBien=0
	fi
done
