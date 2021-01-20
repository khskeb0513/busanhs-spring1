#!/bin/bash

REPOSITORY=/home/ubuntu/app/step2
PROJECT_NAME=busanhs-spring1

cp $REPOSITORY/zip/*.jar $REPOSITORY/

CURRENT_PID=$(pgrep -fl $PROJECT_NAME | grep jar | awk '{print $1}')

echo ""
echo "> Running PID: $CURRENT_PID"

if [ -z "$CURRENT_PID" ]; then
    echo ""
    echo "> Any Process Killed Because Application not Running."
else
    echo ""
    echo "> Kill -15 $CURRENT_PID."
    kill -15 "$CURRENT_PID"
    sleep 5
fi

echo ""
echo "> Start New Application Deploy."

JAR_NAME=$(find $REPOSITORY -name "*.jar" | tail -n 1)

echo ""
echo "> JAR Name: $JAR_NAME"
echo "> Give Execution Privilege to JAR File."
chmod +x "$JAR_NAME"

echo ""
echo "> Run JAR File."

nohup java -jar \
    $REPOSITORY/"$JAR_NAME" \
    -Dspring.config.location=classpath:/application.yml, \
        /home/ubuntu/app/application-oauth.yml \
        /home/ubuntu/app/application-real-db.yml \
2>&1 &

echo ""
echo "Deploy Finished."