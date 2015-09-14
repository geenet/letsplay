#!/usr/bin/env bash

CORE_MIGRATIONS="$(dirname "${0}")/data/conf/pillar/migrations/aapi/"

MATCH_TIMESTAMP_REGEX="/([0-9]+)_"
DESCRIPTION_TEXT_REGEX="description: *([^\$]+)"
totalCount=`find ${CORE_MIGRATIONS} -maxdepth 1| wc -l| tr -d "[[:space:]]"`
for f in ${CORE_MIGRATIONS}*; do
  if [[ ${f} =~ $MATCH_TIMESTAMP_REGEX ]]; then
    timestamp=${BASH_REMATCH[1]}
  fi
  if [ -z "${timestamp}" ]; then
    echo "No timestamp found for file $(basename ${f})."
    exit 1
  fi
  match=`grep "${timestamp}000" ${f}`
  if [ -z "${match}" ]; then
    echo "$(basename ${f}): Filename's timestamp does not match authoredAt's timestamp"
    exit 1
  fi
  count=`find ${CORE_MIGRATIONS} -maxdepth 1 -name "${timestamp}*"| wc -l| tr -d "[[:space:]]"`
  if [ "${count}" != "1" ]; then
    echo "More than one file for timestamp ${timestamp}"
    exit 1
  fi
  if [[ `cat -e ${f}` =~ $DESCRIPTION_TEXT_REGEX ]]; then
    desc=${BASH_REMATCH[1]}
  fi
  if [ -z "${desc}" ]; then
    echo "Missing description for file $(basename ${f})"
  fi
  count=`echo ${desc}| wc -w| tr -d "[[:space:]]"`
  if [ "${count}" -lt "5" ]; then
    echo "WARNING: Less than 5 words in description for $(basename ${f})"
    # This will be an error in the future, please prevent this warning from occuring!
    # exit 1
  fi
  count=`grep "${desc}\$" ${CORE_MIGRATIONS}*| wc -l| tr -d  "[[:space:]]"`
  if [ "${count}" != "1" ]; then
    echo "Duplicate description for file $(basename ${f})"
    exit 1
  fi
done
echo "Succefully validated ${totalCount} migrations."
