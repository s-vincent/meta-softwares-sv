SUMMARY = "Hello world (source)"
DESCRIPTION = "Hello world (source)"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"
SECTION = "examples"

SRC_URI = "file://hello.c"

S = "${WORKDIR}"

do_compile() {
	     ${CC} -std=c11 ${LDFLAGS} hello.c -o hello_source
}

do_install() {
	     install -d ${D}${bindir}
	     install -m 0755 hello_source ${D}${bindir}
}

