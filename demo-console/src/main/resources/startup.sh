#!/bin/bash

#do not edit in windows

# generating the proper classpath
CLASSPATH=""
for N in lib/*.jar; do CLASSPATH="$CLASSPATH$N:"; done

# startup Server
java -jar demo-console.jar -Xms512m -Xmx964m -classpath $CLASSPATH com.autfish.demo.StartService &
