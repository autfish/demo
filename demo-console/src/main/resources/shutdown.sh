#!/bin/bash

#do not edit in windows

ID=`ps -ef | grep "java -jar demo-console.jar" | grep -v "grep" | awk '{print $2}'`
for id in $ID
do
kill -9 $id
echo "killed $id"
done
