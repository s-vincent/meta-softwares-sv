SUMMARY = "Hello world kernel module"
DESCRIPTION = "Hello world kernel module"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"
SECTION = "examples"

inherit module

SRC_URI = "file://hello-module.tar.bz2" 

S = "${WORKDIR}/${PN}"

