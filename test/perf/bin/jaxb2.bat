@echo off
REM   -------------------------------------------------------------------------
REM    Copyright 2004 The Apache Software Foundation
REM
REM    Licensed under the Apache License, Version 2.0 (the "License");
REM    you may not use this file except in compliance with the License.
REM    You may obtain a copy of the License at
REM
REM        http://www.apache.org/licenses/LICENSE-2.0
REM
REM    Unless required by applicable law or agreed to in writing, software
REM    distributed under the License is distributed on an "AS IS" BASIS,
REM    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
REM    See the License for the specific language governing permissions and
REM    limitations under the License.
REM   -------------------------------------------------------------------------

REM SUPPORTED PARAMS
REM TODO: Make command line arg parsing cleaner
set MEM=64
set FLAVOR=
set FILENAME=

REM SCAN FIRST PARAM
if not "%2"=="" goto %2
goto default
goto end
:memory
set MEM=%3
goto end
:flavor
set FLAVOR=%3
goto end
:filename
set FILENAME=%3
goto end
:default
goto end
:end

REM SCAN SECOND PARAM
if not "%4"=="" goto %4
goto default
goto end
:memory
set MEM=%5
goto end
:flavor
set FLAVOR=%5
goto end
:filename
set FILENAME=%5
goto end
:default
goto end
:end

REM SCAN THIRD PARAM
if not "%6"=="" goto %6
goto default
goto end
:memory
set MEM=%7
goto end
:flavor
set FLAVOR=%7
goto end
:filename
set FILENAME=%7
goto end
:default
goto end
:end

echo on
java -Xmx%MEM%m -Xbootclasspath/p:%XMLBEANS_PERFROOT%\3rdparty\xerces\xerces-2_7_1\xml-apis.jar:%XMLBEANS_PERFROOT%\3rdparty\xerces\xerces-2_7_1\xercesImpl.jar -classpath %XMLBEANS_PERFROOT%\build;%XMLBEANS_PERFROOT%\schema_build\jaxb2-purchase-order.jar;%XMLBEANS_PERFROOT%\schema_build\jaxb2-primitives.jar;%XMLBEANS_PERFROOT%\schema_build\jaxb2-non-primitives.jar;%JAXB2_LIBDIR%\lib\jaxb-impl.jar;%JAXB2_LIBDIR%\lib\jaxb-api.jar;%JAXB2_LIBDIR%\lib\activation.jar;%JAXB2_LIBDIR%\lib\jsr173_1.0_api.jar -DPERF_ROOT=%XMLBEANS_PERFROOT% org.apache.xmlbeans.test.performance.jaxb2.%1 %FLAVOR% %FILENAME% 

