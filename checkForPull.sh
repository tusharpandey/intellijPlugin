#!/usr/bin/env bash
# Check return value to see if there are incoming updates.
readonly dirName=D:\intellij_plugin_development\
cd $dirName

GITNAME="intellijPlugin"

if [ "`git log --pretty=%H ...refs/heads/master^ | head -n 1`" = "`git ls-remote origin -h refs/heads/master |cut -f1`" ] ; then
    status=0
    statustxt="up to date"
else
    status=2
    statustxt="not up to date"
fi

if [[ `git status --porcelain` ]]; then
    status=1
    statustxt="uncommited"
fi

echo "$status git_status_$GITNAME - $statustxt"

echo Press Enter...
read