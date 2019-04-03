#!/bin/bash

cont=0
contAux=0
romanos=(I IV V IX X XL L XC C CD D CM M)
decimales=(1 4 5 9 10 40 50 90 100 400 500 900 1000)
output=0
outputR=""
valor=0
valorCar=0
valorNext=0
salir=0
read input
tam=${#input}
#ir comprobando de mayor a menor si te pasan 8 vas comprobando 8 es mayor que 1000 no pues vas bajando hasta que llegues a 8 es mayor que 9 no 8 es mayor que 5 si entonces pones una V y le restas 5 al 8 y sigues 3 es mayor que 5 no 3 es mayor que 4 no 3 es mayor que 1 si pones una I a la V y le restas 1 al 3 ...

#falta saber si le pasas letras si son romanas o no

if ([ `echo $input | grep '[^0-9]'` ] || [ $input -ge 2000 ]);then
	if [ `echo $input | grep '[^MDCLXVI]'` ];then
		echo "El valor introducido no es decimal o romano o fuera de rango"
	else	
		while [ $tam -gt 0 ];do
		car=${input:$cont:1}
		next=${input:$(($cont+1)):1}
		for n in ${romanos[@]};do
			if [ "$car" = "$n" ];then
				valorCar=${decimales[contAux]}
			fi
	
        	        if [ "$next" = "$n" ];then
       	                 valorNext=${decimales[contAux]}
        	        fi
	
			contAux=$(($contAux+1))
		done
		contAux=0
		if [ $tam -eq 1 ];then
			valorNext=0
		fi
	
		if ([ $valorCar -gt $valorNext ] || [ $valorCar -eq $valorNext ]);then
			output=$(($output+$valorCar))
		else
			output=$(($output - $valorCar))
		fi
	
		cont=$(($cont+1))
		tam=$(($tam-1))
		done
		echo $output
		salir=1
	fi
else
if [ $input -eq 0 ];then
	echo "0 no existe en romano"
else
while ([ $(($input/1000)) -ge 1 ] && [ $salir -eq 0 ]);do
		outputR=$outputR"M"
		input=$(($input-1000))
	done

	while [ $(($input/900)) -ge 1 ];do
		outputR=$outputR"CM"
		input=$(($input-900))
	done

	while [ $(($input/500)) -ge 1 ];do
		outputR=$outputR"D"
		input=$(($input-500))
	done

	while [ $(($input/400)) -ge 1 ];do
		outputR=$outputR"CD"
		input=$(($input-400))
	done

	while [ $(($input/100)) -ge 1 ];do
		outputR=$outputR"C"
		input=$(($input-100))
	done

	while [ $(($input/90)) -ge 1 ];do
		outputR=$outputR"XC"
		input=$(($input-90))
	done

	while [ $(($input/50)) -ge 1 ];do
		outputR=$outputR"L"
		input=$(($input-50))
	done

	while [ $(($input/40)) -ge 1 ];do
		outputR=$outputR"XL"
		input=$(($input-40))
	done

	while [ $(($input/10)) -ge 1 ];do
		outputR=$outputR"X"
		input=$(($input-10))
	done

	while [ $(($input/9)) -ge 1 ];do
		outputR=$outputR"IX"
		input=$(($input-9))
	done

	while [ $(($input/5)) -ge 1 ];do
		outputR=$outputR"V"
		input=$(($input-5))
	done

	while [ $(($input/4)) -ge 1 ];do
		outputR=$outputR"IV"
		input=$(($input-4))
	done

	while [ $(($input-1)) -ge 0 ];do
		outputR=$outputR"I"
		input=$(($input-1))
	done

echo $outputR
fi
fi
