#!/bin/bash
# remove package file
# first arg is the name of the package
# run from root as ./lib/rm_pkg.sh
# will remove package and its respective folder
if [ $1 ];
    then
        tput setaf 1
        if [ ! -f src/com/avajlauncher/$1/$1.java ];
            then
                echo "Package does not exist"
            else
                echo "Are you sure you want to remove package $1"
                echo "Press [ Y ] to remove"
                read -n 1 -s key
                if [ $key == 'Y' ] || [ $key == 'y' ];
                then
                    tput setaf 2
                    rm -rf src/com/avajlauncher/$1
                    echo "Packge removed"
                else
                    tput setaf 2
                    echo "Package not removed"
                fi
        fi
    else
        tput setaf 1
        echo "No Package Name"
        exit 0
fi
