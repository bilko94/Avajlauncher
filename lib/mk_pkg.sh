#!/bin/bash
# make package script
# first arg is the name of the package you want to create
# the src/com/avajlaucnher has to be created mnually 
# run from root of project as ./lib/mk_pkg.sh
# your package shoult be created 
# the package will be present in a folder named after the package
# in the package folder the .java files will be created

if [ $1 ]
	then
		if [ ! -f src/com/avajlauncher/$1/$1.java ];
			then
				tput setaf 2
				mkdir src/com/avajlauncher/$1
				touch src/com/avajlauncher/$1/$1.java
				# its a string litteral so i guess we rolling with the poor indentation but it fixes the output file
				echo 'package com.avajlauncher.'$1';

public class '$1' {
	public static void main(String[] args) {
		megumin();
	}
	public static void megumin(){
		System.out.println("ex-u-plosion");
	}
}' 				> src/com/avajlauncher/$1/$1.java
				echo "Packge Created"
			else
				tput setaf 2
				echo "Package Already Exists"
		fi
	else
		tput setaf 1
		echo "No Package Name"
		exit 0
fi