#!/bin/bash

SRC_DIR=./
DST_DIR=./src/

protoc -I=$SRC_DIR --java_out=$DST_DIR $SRC_DIR/DummyObject.proto