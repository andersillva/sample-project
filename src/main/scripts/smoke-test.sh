#!/bin/bash

URL="$1"

STATUS_CODE=$(curl -s -o /dev/null -w "%{http_code}" "$URL")

if [ "$STATUS_CODE" -eq 200 ]; then
  echo "Service is healthy."
  exit 0
else
  echo "Service responded HTTP $STATUS_CODE."
  exit 1
fi
