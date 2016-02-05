#! /bin/bash

START=$(date +%s)

CONT=9
GENERATE=0

#initilization

/home/murat/Masaüstü/eclipse/workspace/AST/Subdue/sgiso -dot /home/murat/Masaüstü/eclipse/workspace/AST/Projects/awt_deneme/outputs/TEMPLATE_METHOD_outputs/out4.g   -threshold 0.0 /home/murat/Masaüstü/eclipse/workspace/AST/Projects/awt_deneme/inputs/TEMPLATE_METHOD_inputs/TEMPLATE_METHOD_4.g /home/murat/Masaüstü/eclipse/workspace/AST/Projects/awt_deneme/source/awt_deneme.g

END=$(date +%s)
DIFF=$(( $END - $START ))
echo "It took $DIFF seconds"
read


