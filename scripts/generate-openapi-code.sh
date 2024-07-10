#!/bin/bash

# Directory containing your OpenAPI spec files
SPEC_DIR="src/main/resources/specs/otp"

# BASE_DIR="/home/yveyeh/Documents/Projects/demo-spring-rest-api"

# echo $BASE_DIR

for spec_file in $(ls $SPEC_DIR/*.yaml); do
  # Extract filename without extension
  filename=$(basename $spec_file .yaml)

  echo ${filename}
  
  # Generate code for each spec with a separate output directory
  mvn openapi-generator:generate #-DopenapiSpec=$SPEC_DIR/$spec_file -Doutput="src/main/java/generated-code/$filename"
done
