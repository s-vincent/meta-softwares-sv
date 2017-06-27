SUMMARY = "Hello world (autotools)"
DESCRIPTION = "Hello world (autotools)"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"
SECTION = "examples"
PR = "r0"

SRC_URI = "file://hello-autotools.tar.bz2"
SRC_URI[md5sum] = "853dd9e2c3aafef173e0c3ab823e78c3"
SRC_URI[sha256sum] = "bbf2cd123f59bb1375ade6174146384e0f82c5febc54445da5a76089fc81faaa"

S = "${WORKDIR}/hello-autotools"

inherit autotools

