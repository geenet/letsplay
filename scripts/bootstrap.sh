#!/usr/bin/env bash
JAVA_INSTALL_VERSION="8"
ACTIVATOR_VERSION="1.3.6"
SBT_VERSION="0.13.9"
ELASTICSEARCH_VERSION="1.7.1"
CASSANDRA_VERSION="2.1.5"

###############################################
# Install bash
###############################################
#source ~/.bashrc
#/bin/bash ./basic.sh
#pushd /vagrant
echo "here - $(pwd) "
ls -ail

cat > /tmp/source.list.tmp <<"EOF"
deb mirror://mirrors.ubuntu.com/mirrors.txt trusty main restricted universe multiverse
deb mirror://mirrors.ubuntu.com/mirrors.txt trusty-updates main restricted universe multiverse
deb mirror://mirrors.ubuntu.com/mirrors.txt trusty-backports main restricted universe multiverse
deb mirror://mirrors.ubuntu.com/mirrors.txt trusty-security main restricted universe multiverse

EOF

sudo cat /etc/apt/sources.list >> /tmp/source.list.tmp
sudo cp /tmp/source.list.tmp /etc/apt/sources.list

#sudo apt-get update

###############################################
# install prerequisits
###############################################
#sudo apt-get -y -q upgrade
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get -y -q update
sudo apt-get -y -q install software-properties-common htop
sudo apt-get -y -q install build-essential
sudo apt-get -y -q install tcl8.5

###############################################
# Install Java 8
###############################################
echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | sudo /usr/bin/debconf-set-selections
sudo apt-get -y -q install oracle-java8-installer
sudo update-java-alternatives -s java-8-oracle


#/bin/bash /vagrant/basic.sh
#/bin/bash /vagrant/java.sh
#/bin/bash /vagrant/cassandra.sh
#/bin/bash /vagrant/elasticsearch.sh


javac -version
cqlsh --version
nodejs -v
coffee --version
npm -v
sass -v
curl -XGET 'localhost:9200'
