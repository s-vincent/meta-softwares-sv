SUMMARY = "Custom files"
DESCRIPTION = "Custom files"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"
SECTION = "core"

S = "${WORKDIR}"

SRC_URI = "file://rw.sh \
           file://ro.sh \
          "

# Additionnal commands
do_install () {
  install -d ${D}/usr/local/bin
  install -m 0755 ${WORKDIR}/rw.sh ${D}/usr/local/bin/rw.sh
  install -m 0755 ${WORKDIR}/ro.sh ${D}/usr/local/bin/ro.sh
}

FILES_${PN} += "/usr/local/bin/*"

