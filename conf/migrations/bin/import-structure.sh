#!/bin/bash
clear
echo "# Importing Structure to Core #"

echo "Dropping keyspace..."
echo "DROP KEYSPACE core;" | ~/apache-cassandra-2.1.4/bin/cqlsh
echo "Creating keyspace..."
echo "CREATE KEYSPACE core WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };" | ~/apache-cassandra-2.1.4/bin/cqlsh
echo "Importing structure..."
cd ./data
java -jar pillar.jar initialize aapi
java -jar pillar.jar migrate aapi
echo "- ALL DONE -"
