SUMMARY = "Xenomai userland binaries and libraries"
DESCRIPTION = "Xenomai userland binaries and libraries"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"
SECTION = "xenomai"
PR = "r0"

# based on an article from OpenSilicium 16 magazine
SRC_URI = "http://xenomai.org/downloads/xenomai/stable/xenomai-3.0.8.tar.bz2 \
           file://xeno-config-cc.patch \
          "
SRC_URI[xeno.md5sum] = "eafe3b789651f0db9575599dffc60a19"
SRC_URI[xeno.sha256sum] = "c373261ddb8280d9d7078cdd9cd9646dfb7d70d8cd3aa9693d9148f03990d711"

S = "${WORKDIR}/xenomai-3.0.8"

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

# Adds xeno-config to sysroot
SYSROOT_DIRS += "${bindir}"

