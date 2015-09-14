#!/bin/bash
clear
echo "############################################"

~/apache-cassandra-2.1.4/bin/cqlsh -k core -f ./src/main/resources/data.cql

echo "INSERT INTO client_tokens (client_id,auth_token) VALUES ('abc8be4f-fe2f-45e1-acf1-1af5cc875596', 'e15fe426-ee01-415b-95de-146a61ef9c3c');" | ~/apache-cassandra-2.1.4/bin/cqlsh -k core

echo "INSERT INTO customers(customer_id,email,mobile_phone,first_name,last_name,date_of_birth,gender,facebook_id,facebook_token,facebook_name,facebook_link,facebook_locale,facebook_timezone,facebook_updated_time,created_at,tac_confirmed,device_ids,client_ids,logged_in) VALUES ('4211ee97-0ea4-4d18-bfab-525fdd7cea9e','','','','','','','','','','','','','','1440487307151',false,{'sm'},{'abc8be4f-fe2f-45e1-acf1-1af5cc875596'},false);" | ~/apache-cassandra-2.1.4/bin/cqlsh -k core

echo "INSERT INTO customer_wishlist (customerid,wishlistid,articles, createdat, title) values ('4211ee97-0ea4-4d18-bfab-525fdd7cea9e','0f45b2a2-a296-4f70-8f5e-e14fa3ac7d13',null,'1440487307019','Wishlist');" | ~/apache-cassandra-2.1.4/bin/cqlsh -k core

echo "- ALL DONE -"
