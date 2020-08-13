#!/bin/bash
# compiles java progams
# doesnt need args
# run from root as ./lib/compile.sh
find -name *.java > sources.txt
javac @sources.txt