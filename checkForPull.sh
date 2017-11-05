#!/usr/bin/env bash
# Check return value to see if there are incoming updates.
readonly dirName=D:\intellij_plugin_development\
cd $dirName
dir
#if ! git diff --quiet remotes/origin/HEAD; then
# echo 1
#fi
# echo 2

[ "`git log --pretty=%H ...refs/heads/master^ | head -n 1`" = "`git ls-remote origin -h refs/heads/master |cut -f1`" ] && echo "up to date" || echo "not up to date"

echo Press Enter...
read 