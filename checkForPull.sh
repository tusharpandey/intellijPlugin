# Check return value to see if there are incoming updates.
if ! git diff --quiet remotes/origin/HEAD; then
 echo 1
fi
 echo 2

echo Press Enter...
read