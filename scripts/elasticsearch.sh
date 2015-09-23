#!/usr/bin/env bash
ELASTICSEARCH_VERSION="1.7.1"
###############################################
# Install elasticsearch
###############################################
wget https://download.elastic.co/elasticsearch/elasticsearch/elasticsearch-${ELASTICSEARCH_VERSION}.deb
sudo dpkg -i elasticsearch-${ELASTICSEARCH_VERSION}.deb
sudo service elasticsearch start
rm elasticsearch-${ELASTICSEARCH_VERSION}.deb
