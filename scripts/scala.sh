#!/usr/bin/env bash
ACTIVATOR_VERSION="1.3.6"
SBT_VERSION="0.13.9"
###############################################
# Install Scala
###############################################
sudo apt-get -y install scala

###############################################
# Install SBT
###############################################
echo "Download SBT..."
wget http://dl.bintray.com/sbt/debian/sbt-${SBT_VERSION}.deb
sudo dpkg -i sbt-${SBT_VERSION}.deb
sudo apt-get update
sudo apt-get install sbt
rm sbt-${SBT_VERSION}.deb
echo "SBT done."

###############################################
# Install typesafe activator
###############################################
cd /home/vagrant
echo "Download Typesafe Activator..."
wget http://downloads.typesafe.com/typesafe-activator/${ACTIVATOR_VERSION}/typesafe-activator-${ACTIVATOR_VERSION}-minimal.zip
unzip -d /home/vagrant typesafe-activator-${ACTIVATOR_VERSION}-minimal.zip
rm typesafe-activator-${ACTIVATOR_VERSION}-minimal.zip
echo "Typesafe Activator done."

###############################################
# Add activator to environment variables
###############################################
echo "export PATH=/home/vagrant/activator-$ACTIVATOR_VERSION-minimal:\$PATH" >> ~/.bashrc

