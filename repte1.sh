#!/bin/bash

echo "1. abadsfkj 83" >> usuarios.txt
echo "2. abcmsdjs 22" >> usuarios.txt
echo "3. alcacopd 62" >> usuarios.txt

cut -f 3 -d" " --output-delimiter=" " usuarios.txt >> accesos.txt
total=0
menor=0
IFS=$'\n'
for linea in `cat accesos.txt`; do
	total=$((linea+total))
	if [ $linea -gt $menor ]; then
		menor=$linea
	fi

done

for men in `cat accesos.txt`; do
	if [ $men -lt $menor ]; then
		menor=$men
	fi
done

echo "Total de accesos "$total
echo "Menos accesos "`grep $menor usuarios.txt`
rm usuarios.txt
rm accesos.txt

