#!/usr/bin/env bash
JAVA_JDK_VERSION="8"
###############################################
# Install Java 8
###############################################
#sudo add-apt-repository ppa:webupd8team/java
sudo -E add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get -f install
echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | sudo /usr/bin/debconf-set-selections
sudo apt-get -y -q install oracle-java8-installer
#sudo apt-get install oracle-java8-installer
sudo update-java-alternatives -s java-8-oracle

