#!/usr/bin/env bash

if [ -f .env ]
then
  while read line; do
      echo export "$line";
      export "$line";
  done < .env
fi

quarkus dev
