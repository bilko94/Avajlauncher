#!/bin/bash
# auto commit script
# 1st arg is the commit message 
# run form root as ./lib/auto_commit.sh
if [ "$1" ];
then
    tput setaf 7
    git add .
    git status
    git commit -m "$1"
    echo "."
    echo "."
    tput setaf 2
    echo "Press [ P ] to push or any other key to cancel push"
    read -n 1 -s key
    if [ $key == $'p' ] || [ $key == $'P' ];        # if input == ENTER key
    then
        tput setaf 7
        echo "pushing ......"
        git push
        tput setaf 2
        echo "Done";
    else
        tput setaf 1
        echo "Aborting push......"
        exit 0
    fi
else
    tput setaf 1
    echo "Please enter a commit message"
fi