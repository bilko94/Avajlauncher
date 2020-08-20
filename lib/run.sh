#!/bin/bash
# run java script
# 1st arg will be the package you are running 
# 2nd argument will be the arguments going into the program
# run from root ./lib/run.sh
#
./lib/compile.sh
java -cp src com.simulator.Simulator $1