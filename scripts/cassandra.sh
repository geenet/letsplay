#!/usr/bin/env bash
CASSANDRA_VERSION="2.1.5"
###############################################
# Install Cassandra
###############################################
echo "Installing Cassandra (DataStax 2.2)..."
echo "deb http://debian.datastax.com/community stable main" | sudo tee -a /etc/apt/sources.list.d/cassandra.sources.list
echo "deb http://some.debian.mirror/debian/ $distro main contrib non-free" | sudo tee -a /etc/apt/sources.list
curl -L --silent http://debian.datastax.com/debian/repo_key | sudo apt-key add -
sudo apt-get update 
sudo apt-get -y install dsc21=${CASSANDRA_VERSION}-1 cassandra=${CASSANDRA_VERSION}
sudo apt-get -y install cassandra-tools=${CASSANDRA_VERSION} ## Optional utilities
sudo service cassandra stop
sudo rm -rf /var/lib/cassandra/data/system/*
sudo service cassandra start
