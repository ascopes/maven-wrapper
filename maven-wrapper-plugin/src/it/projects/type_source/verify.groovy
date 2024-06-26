
/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

assert new File(basedir,'mvnw').exists()
assert new File(basedir,'mvnw.cmd').exists()
assert !(new File(basedir,'mvnwDebug').exists())
assert !(new File(basedir,'mvnwDebug.cmd').exists())
assert new File(basedir,'.mvn/wrapper/maven-wrapper.properties').exists()
assert new File(basedir,'.mvn/wrapper/MavenWrapperDownloader.java').exists()

log = new File(basedir, 'build.log').text
// check "mvn wrapper:wrapper" output
assert log.contains('[INFO] Unpacked source type wrapper distribution org.apache.maven.wrapper:maven-wrapper-distribution:zip:source:')

// check "mvnw -v" output
assert log.contains("Couldn't find ")
assert log.contains(", downloading it ...")
assert new File(basedir,'.mvn/wrapper/maven-wrapper.jar').exists()

Properties props = new Properties()
new File(basedir,'.mvn/wrapper/maven-wrapper.properties').withInputStream {
    props.load(it)
}
assert props.wrapperVersion.equals(wrapperCurrentVersion)
