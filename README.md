# Install and run in testing environments

http://stackoverflow.com/questions/24100007/install-play-with-activator-on-linux

wget https://downloads.typesafe.com/typesafe-activator/1.3.5/typesafe-activator-1.3.5.zip

unzip ./typesafe-activator-1.3.5.zip

cd ./typesafe-activator*

export JAVA_HOME=/usr/lib/jvm/java-7-oracle

export PATH=$PATH:/Users/myuser/path-to/activator-dist-1.3.5


git clone https://github.com/sparks42/aapi

cd aapi

activator run 

--files used are unreadable, when pulling real products may 
 work correctly.. for now use the following command.


activator run -Dfile.encoding=UTF-8

# start app in production node


activator start -Dapplication.secret=abcdefghijk
 
 
activator
run
compile 


https://www.playframework.com/documentation/2.4.x/Production
activator dist 

ls -l target/universal/

total 64744

-rw-r--r--  1 a  staff  33148417 Jul 10 03:33 aapi-1.0-SNAPSHOT.zip


mkdir -p /tmp/myapi

cp ./target/universal/aapi-1.0-SNAPSHOT.zip /tmp/aapi

cd /tmp/aapi

unzip aapi-1.0-SNAPSHOT.zip

aapi-1.0-SNAPSHOT/bin/a2pi
#aapi-1.0-SNAPSHOT/bin/a2pi -Dplay.crypto.secret=abcdefghijk