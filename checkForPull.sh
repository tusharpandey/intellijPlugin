#!/usr/bin/env bash
# Check return value to see if there are incoming updates.
readonly dirName=D:\intellij_plugin_development\
cd $dirName
dir
if ! git diff --quiet remotes/origin/HEAD; then
 echo 1
fi
 echo 2

echo Press Enter...
read 