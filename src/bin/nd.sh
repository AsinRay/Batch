#!/bin/sh
APPNAME=@project.name@
JAR=@project.build.finalName@
pkg=@pkg.format@
INSLDIR=~/.dev

tar -xzvf target/$JAR.$pkg -C target
[ -d $INSLDIR ] || mkdir -p $INSLDIR
rsync -avz target/$APPNAME $INSLDIR


PID=$(ps -ef | grep "${JAR}.jar" | grep -v 'grep' | awk '{ print $2 }')

if [ -z "${PID}" ]
then
    echo ${APPNAME} is already stopped.
else
    echo "shutdown application ${APPNAME} ..."
    kill ${PID} &&  echo ${APPNAME} stopped successfully.
fi

sh $INSLDIR/$APPNAME/bin/test.sh

#path=/home/ubuntu/upload
#target=/app/bd/config/static
#for dir in `find ${path} -type d`; do
#    if [ -d $dir -a "$dir" != "${path}" ]; then
#	    echo "ln -s "$dir $target"/"`basename $dir`
#    fi
#done

# kill -s 9 `pgrep java`
# pgrep java | xargs kill -s 9