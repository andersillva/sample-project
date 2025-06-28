#!/bin/bash

URL="http://sample-project-alb-2025945722.us-east-2.elb.amazonaws.com/api/v1/sample/health-check"

STATUS_CODE=$(curl -s -o /dev/null -w "%{http_code}" "$URL")

if [ "$STATUS_CODE" -eq 200 ]; then
  echo "Service is healthy."
  exit 0
else
  echo "Service responded HTTP $STATUS_CODE."
  exit 1
fi
