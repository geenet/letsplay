# include all files here
#for f in /home/a/code/ginstall/basics/bash_functions/*.sh; 
#do 
#   source $f; 
#done

function mcd () { mkdir -p "$@" && eval cd "\"\$$#\""; }

function xcopy()
{
   #$($@)|xsel;
   #$($@)|xsel --clipboard;
   eval "$@"|xsel;
   eval "$@"|xsel --clipboard;
   # eval "$@";
   #$1|tr -d '\n'|xsel;
   #$1|tr -d '\n'|xsel --clipboard;
}

function compress()
{
   tar -zcvf "$1.tar.gz" "$1";
}

function bzcompress()
{
   tar -cjf "$1.tar.bz2" "$1";
}

function decompress()
{
   tar xvf "$1";
}



function times()
{
  for (( c=1; c<=$2; c++ ))
  do
     printf "$1"
  done
}

function port()
{
   if [ ! -z "$2" ]; then #debug
       echo "> sudo netstat -lnptu|grep :$1"
   fi;
   sudo netstat -lnptu |sed -n "2,1p"
   sudo netstat -lnptu|grep ":$1"
   echo $(times '-' 60)
   if [ ! -z "$2" ]; then #debug
      echo "> ps -auxw|grep \$(sudo netstat -lnptu|grep \":$1\"|sed \"s/.*LISTEN\s\+\([0-9]\+\).*/\1/ig\")|grep -v grep;"
   fi;
   sudo ps -auxw|head -1
   sudo ps -auxw|grep "\s"$(sudo netstat -lnptu|grep ":$1"|sed "s/.*LISTEN\s\+\([0-9]\+\).*/\1/ig")"\s"|grep -v grep;
}

function loca(){
   locate -i -b --regex "$@"|grep --color "$(pwd)"
}



#tar -cjf file.tar.bz2 dir

#!/bin/bash

function search_and_replace(){
    #echo "1=$1";
    #echo "2=$2";
    #echo "3=$3";
    local REGEX=""
    local SEARCH=""
    local REPLACE=""
    while [[ $# > 0 ]]
    do
        key="$1"
        case $key in
            -f|--file)
            REGEX="$2"
            shift # past argument
            ;;
            -s|--search)
            SEARCH="$2"
            shift # past argument
            ;;
            -r|--replace)
            REPLACE="$2"
            shift # past argument
            ;;
            *)
            # unknown option
            if [ -z "$SEARCH" ]; then
                SEARCH="$1";
            else
                REPLACE="$1";
            fi;
            ;;
        esac
        shift # past argument or value
    done
    
    if [ -z "$REGEX" ]; then
        REGEX='.*';
    fi;
    
    if [ -z "$SEARCH" ]; then
        echo "nothing to search for"
        exit;
    fi;
    echo "find . -regextype posix-extended -type f -regex \"$REGEX\" -exec sed -i -e \"s/$SEARCH/$REPLACE/g\" '{}' \;"
    #printf "sure? y/n: ";
    #read proceed;
    read -p "Are you sure?" -n 1 proceed;
    echo ""
    #read -p ":" proceed;
    #echo "$proceed";
    if [ "$proceed" == "y" ]; then
        find . -regextype posix-extended -type f -regex "$REGEX" -exec sed -i -e "s/$SEARCH/$REPLACE/g" '{}' \;
        echo "$(date +'%Y-%m-%d %H:%M:%S') - search and replace done"
    else
        echo "$(date +'%Y-%m-%d %H:%M:%S') - nothing done"
    fi;
}

#search_and_replace "$@"


function ffr(){
    echo "1=$1";
    echo "2=$2";
    echo "3=$3";
    local SEARCH="$1"
    local REGEX="$2"
    if [ -z "$REGEX" ]; then
        REGEX='.*';
    fi;
    #echo "find . -regextype posix-extended -type f -regex \"$REGEX\" -exec grep -H -niE -a \"$SEARCH\" --color '{}' \;"
    #find . -regextype posix-extended -type f -regex "$REGEX" -exec grep -H -niE -a --color "$SEARCH" '{}' \;
    echo "find . -type f -regex \"$REGEX\" -exec grep -H -niE \"$SEARCH\" --color '{}' \;"
          find . -type f -regex ".*$REGEX" -exec grep -H -niE --color "$SEARCH" '{}' \;
}

