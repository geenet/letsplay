#!/usr/bin/env bash

echo "=========================================="
echo "basic installation"
echo "=========================================="

###############################################
# solve/prevent locale issues
###############################################
export LANGUAGE=en_US.UTF-8
export LANG=en_US.UTF-8
export LC_ALL=en_US.UTF-8
sudo locale-gen en_US.UTF-8
sudo dpkg-reconfigure locales
sudo apt-get update
###############################################
# read file
###############################################
# read lines from a file
function read_file(){
    #read_file "ffmpeg/ppa.txt"
    for line in $(cat $1); do
       if [[ $line != "#"* ]]; then # ignore lines starting with a hash comment tag
          echo "$line"
       fi
    done;
}

#function set_var()
#    var_name="$1"
#    var_value="${$var_name}"
#    default_var_value="$2"
#    if [ -z "$var_value" ]; then
#       var_value="$default_var_value"
#    fi;
#    echo $var_value
#}

###############################################
# install packages
###############################################
# go to install directory
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
#INSTALL_DIR=$(echo "$DIR/$1/install" | tr '[:upper:]' '[:lower:]')
if [ ! -d $DIR ]; then
   echo "$(date +'%Y-%m-%d %H:%M:%S') - directory $DIR does not exist. Terminating."
   exit 0;
fi

cd "$DIR";
echo "current dir contents $DIR ..."
ls -ail
# install packages
if [ -f packages.txt ]; then
    echo "$(date +'%Y-%m-%d %H:%M:%S') - Sudo Updating system repositories..."
    sudo apt-get update --quiet=2 -y
    sudo apt-get autoremove  -f  --force-yes -y
    sudo apt-get -o Dpkg::Options::="--force-confold" install -f  --force-yes -y
    #apt-get install -f
    # install ubuntu libraries using apt-get
    echo "$(date +'%Y-%m-%d %H:%M:%S') - Installing system packages from packages.txt..."
    #echo "apt-get -o Dpkg::Options::=\"--force-confold\" install --force-yes -y $(read_file packages.txt);"
    sudo apt-get -o Dpkg::Options::="--force-confold" install --force-yes -y $(read_file packages.txt);
fi

###############################################
# Export locale settings in bashrc
###############################################
echo "export LANGUAGE=en_US.UTF-8" >> ~/.bashrc
echo "export LANG=en_US.UTF-8" >> ~/.bashrc
echo "export LC_ALL=en_US.UTF-8" >> ~/.bashrc

###############################################
# Reset bash
###############################################
source ~/.bashrc
