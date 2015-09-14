#!/bin/bash
clear
set +x

echo "# Clean Old Tests Keyspaces #"
TODAY=`date +%Y%m%d`
KEYSPACES=`echo "desc keyspaces" | cqlsh | xargs -n1 echo | grep -v ^system | grep aapi_tests`
for KEYSPACE in $KEYSPACES; do
    KEYSPACE_DATE=`echo $KEYSPACE | cut -d'_' -f 3`
    if [ ${KEYSPACE_DATE} != ${TODAY} ]; then
        echo "Dropping keyspace $KEYSPACE..."
        echo "drop keyspace $KEYSPACE;" | cqlsh
    fi
done

echo "- ALL DONE -"
