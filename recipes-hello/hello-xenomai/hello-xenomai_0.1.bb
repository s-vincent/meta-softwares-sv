SUMMARY = "Hello world (Xenomai)"
DESCRIPTION = "Hello world (Xenomai)"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"
SECTION = "examples"

DEPENDS = "xenomai"
SRC_URI = "file://hello.c"

S = "${WORKDIR}"

do_compile() {
  xenoconfig="${STAGING_DIR_TARGET}/usr/xenomai/bin/xeno-config"
  xenocc=`DESTDIR=${STAGING_DIR_TARGET} ${xenoconfig} --cc --cflags --ldflags --skin=native`
  echo ${xenocc}
  ${xenocc} ${LDFLAGS} hello.c -o hello_xenomai
}

do_install() {
  install -d ${D}${bindir}
  install -m 0755 hello_xenomai ${D}${bindir}
}

