#!/bin/sh

APPNAME=@project.name@
JAR=@project.build.finalName@
pkg=@pkg.format@

jarName=$JAR.$pkg

tar -xzvf target/$jarName -C target

## rsync folder
rsync -e "ssh -i ub.key" -ravzP --exclude 'config/application.yml' target/${APPNAME}/ ubuntu@t.bittx.net:app/${APPNAME}
rsync -e "ssh -i ub.key" -ravzP  import.xlsx ubuntu@t.bittx.net:~/upload/template/
# rsync -e "ssh -i ub.key" -ravzP ShanXue.apk ubuntu@t.bittx.net:~/upload/dl/
## restart the process
ssh -i ub.key ubuntu@t.bittx.net "cd /home/ubuntu/app/${APPNAME}/;sh bin/stop.sh && sh bin/start.sh"

echo ""
date
#path=/home/ubuntu/upload
#target=/app/bd/config/static
#for dir in `find ${path} -type d`; do
#    if [ -d $dir -a "$dir" != "${path}" ]; then
#	    echo "ln -s "$dir $target"/"`basename $dir`
#    fi
#done

# kill -s 9 `pgrep java`
#pgrep java | xargs kill -s 9
#
#cd bdd
#bin/start.sh