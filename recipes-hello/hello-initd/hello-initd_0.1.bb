SUMMARY = "Hello world (initd service)"
DESCRIPTION = "Hello world (initd service)"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"
SECTION = "examples"

S = "${WORKDIR}"
SRC_URI = "file://init"

inherit update-rc.d
INITSCRIPT_NAME = "hello"
INITSCRIPT_PARAMS = "defaults 99"

do_install () {
  install -d ${D}${sysconfdir}/init.d
  install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/hello
}

