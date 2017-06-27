SUMMARY = "Hello world (generic Makefile)"
DESCRIPTION = "Hello world (generic Makefile)"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"
SECTION = "examples"

S = "${WORKDIR}/hello-generic"

SRC_URI = "file://hello-generic.tar.bz2"
SRC_URI[md5sum] = "bf4ab397bc3a3bb4c2a656caba5e53aa"
SRC_URI[sha256sum] = "f618241fb39b21961d67cf1614a7b2f2cee963fe58774b5afe5923a76b757c55"

EXTRA_OEMAKE = "'CC=${CC}' 'RANLIB=${RANLIB}' 'AR=${AR}' \
    'CFLAGS=${CFLAGS} -I${S}/include -DWITHOUT_XATTR' 'BUILDDIR=${S}'"

do_install () {
  install -d ${D}/usr/bin
	oe_runmake install DESTDIR=${D} SBINDIR=${sbindir} MANDIR=${mandir} \
        INCLUDEDIR=${includedir}
}

