#!/bin/bash

# find current script directory
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )/.." && pwd )"
# go to current script directory
cd "$DIR";
echo "$(date +'%Y-%m-%d %H:%M:%S') - cd $DIR";
echo "$(date +'%Y-%m-%d %H:%M:%S') - searching for JAVA_HOME...";
JAVA_HOME="$(jrunscript -e 'java.lang.System.out.println(java.lang.System.getProperty("java.home"));')"
echo "$(date +'%Y-%m-%d %H:%M:%S') - JAVA_HOME=$JAVA_HOME";
#JAVA_HOME="/usr"
APP_ROOT="$DIR"
PILLAR_ROOT="$DIR"

export JAVA_HOME APP_ROOT PILLAR_ROOT

CLASS=com.chrisomeara.pillar.cli.App
CLASS_PATH="${APP_ROOT}/conf:${APP_ROOT}/src/main/resources:${PILLAR_ROOT}/lib/pillar.jar:${PILLAR_ROOT}/conf"
JAVA_OPTIONS="-Dlog4j.configuration=${PILLAR_ROOT}/conf/pillar-log4j.properties"

echo "$(date +'%Y-%m-%d %H:%M:%S') - calling pillar with the following paramenters...";
echo "$(date +'%Y-%m-%d %H:%M:%S') - $JAVA_HOME/bin/java -cp $CLASS_PATH $JAVA_OPTIONS $CLASS $*";

/usr/bin/java -cp "$CLASS_PATH" "$JAVA_OPTIONS" "$CLASS" $*

echo "$(date +'%Y-%m-%d %H:%M:%S') - done";
# java -cp ".:./conf:./pillar-assembly-2.0.1.jar" com.chrisomeara.pillar.cli.App initialize faker2
