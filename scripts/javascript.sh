#!/usr/bin/env bash

###############################################
# Install NodeJS
###############################################
sudo apt-get -y install nodejs
ln -s /usr/bin/nodejs /user/bin/node

###############################################
# Install Node related stuff required by Play
###############################################
sudo apt-get -y install nodejs-legacy

###############################################
# Install CoffeeScript
###############################################
sudo apt-get -y install coffeescript

###############################################
# Install NPM
###############################################
sudo apt-get -y install npm

###############################################
# Install Bower
###############################################
sudo npm install -g bower

###############################################
# Install Sass
###############################################
sudo gem install sass
