#!/usr/bin/env bash
set -euo pipefail
SCRIPT_DIR="$(cd -- "$(dirname "$0")" && pwd)"
WRAPPER_JAR="$SCRIPT_DIR/.mvn/wrapper/maven-wrapper.jar"

if [ ! -f "$WRAPPER_JAR" ]; then
  # Read distribution URL from properties
  DIST_URL="$(grep -E '^distributionUrl=' -m1 "$SCRIPT_DIR/.mvn/wrapper/maven-wrapper.properties" | cut -d'=' -f2-)"
  if [ -z "$DIST_URL" ]; then
    echo "Error: distributionUrl not found in .mvn/wrapper/maven-wrapper.properties" >&2
    exit 1
  fi
  mkdir -p "$SCRIPT_DIR/.mvn/wrapper"
  if command -v curl >/dev/null 2>&1; then
    curl -fL "$DIST_URL" -o "$SCRIPT_DIR/.mvn/wrapper/maven-wrapper.jar"
  elif command -v wget >/dev/null 2>&1; then
    wget -q "$DIST_URL" -O "$SCRIPT_DIR/.mvn/wrapper/maven-wrapper.jar"
  else
    echo "Error: curl or wget is required to download the Maven Wrapper jar." >&2
    exit 1
  fi
fi

exec java -jar "$WRAPPER_JAR" "$@"
