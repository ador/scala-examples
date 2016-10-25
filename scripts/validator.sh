#!/bin/bash -eux

echo "hello "
pushd 01_grader_app
	sbt test
popd

exit 0
