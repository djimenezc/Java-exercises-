#!/usr/bin/env bash

echo "name of the exercise: "
read name

echo "type of exercise: "
echo "*) algorithms"
echo "*) implementation"
echo "*) java"
echo "*) strings"
echo "*) sorting"
read type

mkdir $PWD/files/${name}
touch $PWD/files/${name}/input1.txt
touch $PWD/files/${name}/output1.txt

cp $PWD/src/com/company/hackerrank/algorithms/SolutionMini.java $PWD/src/com/company/hackerrank/${type}/${name}.java