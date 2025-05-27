#!/usr/bin/env sh

#
# Copyright 2015 the original author or authors.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

# Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass JVM options to this script.
DEFAULT_JVM_OPTS='"-Xmx64m" "-Xms64m"'

APP_NAME="Gradle"
APP_BASE_NAME=$(basename "$0")

# Use the maximum available, or set MAX_FD != -1 to use that value.
MAX_FD="maximum"

warn () {
    echo "$*"
}

die () {
    echo
    echo "$*"
    echo
    exit 1
}

# OS specific support (must be 'true' or 'false').
cygwin=false
msys=false
darwin=false
nonstop=false
case "$(uname)" in
  CYGWIN* )
    cygwin=true
    ;;
  Darwin* )
    darwin=true
    ;;
  MINGW* )
    msys=true
    ;;
  NONSTOP* )
    nonstop=true
    ;;
esac

CLASSPATH_SEPARATOR=:
if $cygwin || $msys; then
  CLASSPATH_SEPARATOR=";"
fi

# Attempt to set APP_HOME
# Resolve links: $0 may be a link
PRG="$0"
# Need this for relative symlinks.
while [ -h "$PRG" ] ; do
    ls=$(ls -ld "$PRG")
    link=$(expr "$ls" : '.*-> \(.*\)$')
    if expr "$link" : '/.*' > /dev/null; then
        PRG="$link"
    else
        PRG=$(dirname "$PRG")"/$link"
    fi
done

APP_HOME=$(dirname "$PRG")

# Absolutize APP_HOME
APP_HOME=$(cd "$APP_HOME" > /dev/null && pwd -P)

# Ensure that APP_HOME is set to the directory where the script is located
if [ ! -d "$APP_HOME" ]; then
    die "Error: APP_HOME is not a valid directory. APP_HOME = $APP_HOME"
fi


# Determine the Java command to use to start the JVM.
if [ -n "$JAVA_HOME" ] ; then
    if [ -x "$JAVA_HOME/jre/sh/java" ] ; then
        # IBM's JDK on AIX uses strange locations for the executables
        JAVACMD="$JAVA_HOME/jre/sh/java"
    else
        JAVACMD="$JAVA_HOME/bin/java"
    fi
    if [ ! -x "$JAVACMD" ] ; then
        die "ERROR: JAVA_HOME is set to an invalid directory: $JAVA_HOME

Please set the JAVA_HOME variable in your environment to match the
location of your Java installation."
    fi
else
    JAVACMD="java"
    which java >/dev/null 2>&1 || die "ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.

Please set the JAVA_HOME variable in your environment to match the
location of your Java installation."
fi

# Increase the maximum number of open files if necessary.
if ! $cygwin && ! $msys && ! $nonstop ; then
    MAX_FD_LIMIT=$(ulimit -H -n)
    if [ $? -eq 0 ] ; then
        if [ "$MAX_FD" = "maximum" -o "$MAX_FD" = "max" ] ; then
            # use the system max
            MAX_FD="$MAX_FD_LIMIT"
        fi
        ulimit -S -n "$MAX_FD"
        if [ $? -ne 0 ] ; then
            warn "Could not set maximum file descriptor limit: $MAX_FD"
        fi
    else
        warn "Could not query maximum file descriptor limit: $MAX_FD_LIMIT"
    fi
fi

# For Darwin, add options to specify how the application appears in the dock;
# also pass INVOCATION_ID to process that is launched.
if $darwin ; then
    GRADLE_OPTS="$GRADLE_OPTS \"-Xdock:name=$APP_NAME\" \"-Xdock:icon=$APP_HOME/media/gradle.icns\""
fi

# For Cygwin or MSYS, switch paths to Windows format before running java
if $cygwin || $msys ; then
    APP_HOME=$(cygpath --path --mixed "$APP_HOME")
    CLASSPATH=$(cygpath --path --mixed "$CLASSPATH")
    JAVACMD=$(cygpath --unix "$JAVACMD")

    # We build the pattern for arguments to be converted to Windows paths
    ROOTDIRSRAW=$(find -L / -maxdepth 1 -mindepth 1 -type d 2>/dev/null)
    SEP=""
    for dir in $ROOTDIRSRAW ; do
        ROOTDIRS="$ROOTDIRS$SEP$dir"
        SEP="|"
    done
    OURCYGPATTERN="(^($ROOTDIRS))"
    # Add a trailing slash to only match directories according to cygpath behavior
    if [ "$OURCYGPATTERN" != "(^())" ] && [ "$(echo "$OURCYGPATTERN"|grep "^(^/)$")" = "" ] ; then
        OURCYGPATTERN="$OURCYGPATTERN/"
    fi
    # Add a special case for arguments like "/C:/Users/..."
    if [ "$OURCYGPATTERN" != "(^())" ] ; then
        OURCYGPATTERN="$OURCYGPATTERN|^\/[a-zA-Z]:\/"
    else
        OURCYGPATTERN="^\/[a-zA-Z]:\/"
    fi
    # Add a special case for arguments like "/Users/..."
    if [ "$OURCYGPATTERN" != "(^())" ] ; then
        OURCYGPATTERN="$OURCYGPATTERN|^\/[^:]"
    else
        OURCYGPATTERN="^\/[^:]"
    fi
fi

# Split up the JVM options only if DEFAULT_JVM_OPTS is specified
if [ -n "$DEFAULT_JVM_OPTS" ]; then
    set -- $DEFAULT_JVM_OPTS # Temporarily set arguments to the JVM options
    JVM_OPTS=()
    for opt in "$@"; do
        JVM_OPTS+=("$opt")
    done
    set -- # Reset arguments
fi


# Add GRADLE_OPTS to JVM_OPTS (leaving current value in place)
if [ -n "$GRADLE_OPTS" ]; then
    set -- $GRADLE_OPTS # Temporarily set arguments to the GRADLE_OPTS
    for opt in "$@"; do
        JVM_OPTS+=("$opt")
    done
    set -- # Reset arguments
fi


# Add JAVA_OPTS to JVM_OPTS (leaving current value in place)
if [ -n "$JAVA_OPTS" ];
then
   set -- $JAVA_OPTS # Temporarily set arguments to the JAVA_OPTS
   for opt in "$@"; do
       JVM_OPTS+=("$opt")
   done
   set -- # Reset arguments
fi

# Collect all arguments for the java command, following the shell quoting and substitution rules
# This is a simplified version, actual gradlew scripts might handle quoting more robustly
PROCESS_ARGS=()
for arg in "$@"; do
    PROCESS_ARGS+=("$arg")
done


# For Cygwin or MSYS, convert arguments which are paths to Windows format
if $cygwin || $msys ; then
    CONVERTED_ARGS=()
    for arg in "${PROCESS_ARGS[@]}"; do
        if [[ "$arg" =~ $OURCYGPATTERN ]] ; then
            CONVERTED_ARGS+=("$(cygpath --path --mixed "$arg")")
        else
            CONVERTED_ARGS+=("$arg")
        fi
    done
    PROCESS_ARGS=("${CONVERTED_ARGS[@]}")
fi

# Change to APP_HOME directory, to avoid issues with relative paths
cd "$APP_HOME" || exit 1

# Add the jar to the classpath
CLASSPATH="$APP_HOME/gradle/wrapper/gradle-wrapper.jar${CLASSPATH_SEPARATOR}${CLASSPATH:-}"

# Execute the JVM
exec "$JAVACMD" "${JVM_OPTS[@]}" -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "${PROCESS_ARGS[@]}"
