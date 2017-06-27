SUMMARY = "Hello world (cmake)"
DESCRIPTION = "Hello world (cmake)"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"
SECTION = "examples"
PR = "r0"

SRC_URI = "file://hello-cmake.tar.bz2"
SRC_URI[md5sum] = "5937e4fccb6fd166f2f18153d622cf79"
SRC_URI[sha256sum] = "f8ce28b84696887bdbca7446e56a139efc78f98ef6115f0dae285bf1ecd51709"

S = "${WORKDIR}/hello-cmake"

inherit cmake

