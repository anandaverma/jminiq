#!/bin/bash
echo "putting values"
start=`date +%s`
for i in {1..100}
do
   curl -s -XPUT http://localhost:9000/v1/$i/$i  
   #echo "\n" 
   #sleep 1s
done
end=`date +%s`
qruntime=$((end-start))
echo $qruntime "seconds"
echo "getting values"
start=`date +%s`
for i in {1..100}
do
   curl -GET -s http://localhost:9000/v1/$i
   echo "\n"
   #sleep 1s
done
end=`date +%s`
dqruntime=$((end-start))
echo $dqruntime "seconds"
echo $qruntime "seconds"
