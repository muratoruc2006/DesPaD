#! /bin/bash

START=$(date +%s)

CONT=9
GENERATE=0

#initilization

/home/murat/Masaüstü/eclipse/workspace/AST/Subdue/sgiso -dot /home/murat/Masaüstü/eclipse/workspace/AST/Projects/AJP_COMMAND/outputs/COMMAND_outputs/out1.g   -threshold 0.0 /home/murat/Masaüstü/eclipse/workspace/AST/Projects/AJP_COMMAND/inputs/COMMAND_inputs/COMMAND_1.g /home/murat/Masaüstü/eclipse/workspace/AST/Projects/AJP_COMMAND/source/AJP_COMMAND.g

#first_loop(M combination)
for (( c=2; c<=4; c++ ))
do
/home/murat/Masaüstü/eclipse/workspace/AST/Subdue/sgiso -dot /home/murat/Masaüstü/eclipse/workspace/AST/Projects/AJP_COMMAND/outputs/COMMAND_outputs/out$c.g -threshold 0.0 /home/murat/Masaüstü/eclipse/workspace/AST/Projects/AJP_COMMAND/inputs/COMMAND_inputs/COMMAND_$c.g /home/murat/Masaüstü/eclipse/workspace/AST/Projects/AJP_COMMAND/source/AJP_COMMAND.g

GENERATE=`expr $GENERATE + 1`

declare -i NUMBER
NUMBER=1

declare -i LASTNUMBER
LASTNUMBER=9

S1="/"
S2=""
S3="d"

while read line
do
V=${line:0:1}

if [ "$V" == "$S1" ]; then
continue;
fi
if [ "$V" == "$S2" ]; then
continue;
fi
if [ "$V" == "$S3" ]; then
continue;
fi
if [ "$NUMBER" == "$V" ]; then

if [ "$NUMBER" == "$LASTNUMBER" ]; then 
CONT=`expr $CONT + 1`
break;	
fi
NUMBER=`expr $NUMBER + 1`
else
break;
fi
done</home/murat/Masaüstü/eclipse/workspace/AST/Projects/AJP_COMMAND/outputs/COMMAND_outputs/out$c.g
if [ "$CONT" == "$LASTNUMBER" ]; then
continue;
else
break;
fi
done

/home/murat/Masaüstü/eclipse/workspace/AST/Subdue/graph2dot /home/murat/Masaüstü/eclipse/workspace/AST/Projects/AJP_COMMAND/source/AJP_COMMAND.g /home/murat/Masaüstü/eclipse/workspace/AST/Projects/AJP_COMMAND/source/AJP_COMMAND.dot

END=$(date +%s)
DIFF=$(( $END - $START ))
echo "It took $DIFF seconds"


