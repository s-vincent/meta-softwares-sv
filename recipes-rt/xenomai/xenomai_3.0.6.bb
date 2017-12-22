SUMMARY = "Xenomai userland binaries and libraries"
DESCRIPTION = "Xenomai userland binaries and libraries"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"
SECTION = "xenomai"
PR = "r0"

SRC_URI = "http://xenomai.org/downloads/xenomai/stable/xenomai-3.0.6.tar.bz2 \
          "
SRC_URI[md5sum] = "6017203d0992bb5334498c196bf6f25d"
SRC_URI[sha256sum] = "2c0dd3f0e36e4a10f97e0028989bb873e80f4d1ce212ac55fd3b28857c464f94"

S = "${WORKDIR}/xenomai-3.0.6"

inherit autotools pkgconfig

includedir = "/usr/include/xenomai"
prefix = "/usr/xenomai"
bindir = "/usr/xenomai/bin"
libdir = "/usr/lib"

# Fixes QA Issues: non debug package contains .debug directory
FILES_${PN}-dbg += "/usr/bin/regression/posix/.debug"
FILES_${PN}-dbg += "/usr/bin/regression/native/.debug"
FILES_${PN}-dbg += "/usr/bin/regression/native+posix/.debug"
FILES_${PN}-dbg += "/usr/demo/.debug/*"

# Fixes QA Error - Non -dev package contains symlink .so
FILES_${PN}-dev += "/usr/lib/*.se"

# Fixes QA Error
FILES_${PN} += "/dev"
FILES_${PN} += "/dev/*"
FILES_${PN} += "/usr/xenomai/bin/*"
FILES_${PN} += "/usr/xenomai/sbin/*"
FILES_${PN} += "/usr/lib/*"
FILES_${PN} += "/usr/include/*"
FILES_${PN} += "/usr/share/doc/*"
FILES_${PN} += "/usr/share/man/*"
FILES_${PN} += "/usr/xenomai/demo/*"

PACKAGE_ARCH = "${MACHINE_ARCH}"
EXTRA_OECONF_append = " --with-core=cobalt --enable-smp --enable-pshared"
EXTRA_OEMAKE_append = " 'LDFLAGS=${LDFLAGS}'"

