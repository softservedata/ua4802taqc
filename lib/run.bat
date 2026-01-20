@echo off

curl -X GET http://localhost:8080/tokenlifetime
if errorlevel == 1 goto error

curl -i -X PUT http://localhost:8080/tokenlifetime -d "token=YPM6THRYGPKNO8RJ8TZ2R9V3ZWLP214G&time=900002"
if errorlevel == 1 goto error
echo "Update done"

goto quit

:error
echo ERROR

:quit
echo The End
