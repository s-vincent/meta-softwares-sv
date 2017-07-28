
# Adds load of modules to existing /etc/modules files
ROOTFS_POSTPROCESS_COMMAND += "custom_add_modules; "

custom_add_modules() {
  echo "ipv6" >> ${IMAGE_ROOTFS}/etc/modules
}

