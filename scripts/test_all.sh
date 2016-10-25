#!/bin/bash -eux

pushd 01_grader_app
	sbt test
popd

pushd 02_pattern_match_app
	sbt test
popd

pushd 03_lists
	sbt test
popd

pushd 04_tuples
	sbt test
popd

pushd 05_maps
	sbt test
popd

pushd 06_options
	sbt test
popd

pushd 07_for_yield
	sbt test
popd

#pushd 08_futures
#	sbt test
#popd

exit 0
