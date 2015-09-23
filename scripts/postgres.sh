#!/usr/bin/env bash
POSTGRES_VERSION="9.4"
###############################################
# Install Cassandra
###############################################
echo "Installing Postgres ${POSTGRES_VERSION}..."
sudo sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt/ $(lsb_release -cs)-pgdg main" > /etc/apt/sources.list.d/pgdg.list'
# installing certificates
sudo apt-get install -y wget ca-certificates
wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | sudo apt-key add -
sudo apt-get update
sudo apt-get upgrade
sudo apt-get install -y libpq-dev
sudo apt-get install -y postgresql-server-dev-${POSTGRES_VERSION}
sudo apt-get install -y postgresql-contrib
sudo apt-get install -y postgresql-plpython-${POSTGRES_VERSION}
sudo apt-get install -y pgxnclient
sudo apt-get install -y pgadmin3
