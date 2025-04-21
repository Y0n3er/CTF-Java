#!/bin/bash

echo $FLAG > /flag
unset FLAG

chown ctf:ctf /flag
chmod 000 /flag

su -p ctf -c "/app/graalvm-espresso-jdk-21.0.2+13.1/bin/java --experimental-options --java.Continuum=true -jar /app/EspressoCoffee.jar"
