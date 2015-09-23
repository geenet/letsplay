#!/bin/bash
# pgxn extensions
sudo pgxnclient install  plv8
sudo pgxnclient install  pg_proctab

# standard extensions
export PGPASSWORD=postgres
extensions="
btree_gin
citext
dblink
fuzzystrmatch
gin
gist
hstore
intarray
ltree
pgcrypto
pg_grgm
plpython2u
plpython3u
plpythonu
plv8
tsearch2
\"uuid-ossp\"
xml2"
createdb -h 127.0.0.1 -U postgres -E UTF-8 -e testdb
# install contrib and extensions
for ext in $extensions; do
    #--CREATE EXTENSION IF NOT EXISTS pg_trgm;
    sql="CREATE EXTENSION IF NOT EXISTS $ext;";
    echo $sql
    psql -h 127.0.0.1 -U postgres -d testdb -c "$sql";
done
