# This bbclass is mainly used for image level user/group configuration.
# Inherit this class if you want to make EXTRA_USERS_PARAMS effective.

# Below is an example showing how to use this functionality.
# INHERIT += "extrapermissions"
# EXTRA_PERMISSIONS_PARAMS = "\
# chmod 700 ${IMAGE_ROOTFS}/home/rpi ; 
# chmod -R 700 ${IMAGE_ROOTFS}/home/rpi ; \
# chmod 644 ${IMAGE_ROOTFS}/home/rpi/file; \
# "

# Image level user / group settings
ROOTFS_POSTPROCESS_COMMAND_append = " set_permission_files;"

# contains(string, substring)
# From https://stackoverflow.com/questions/2829613/how-do-you-tell-if-a-string-contains-another-string-in-unix-shell-scripting
#
# Returns 0 if the specified string contains the specified substring,
# otherwise returns 1.
contains() {
    string="$1"
    substring="$2"
    if test "${string#*$substring}" != "$string"
    then
        return 0    # $substring is in $string
    else
        return 1    # $substring is not in $string
    fi
}

perform_chmod () {
	local rootdir="$1"
	local opts="$2"
	bbnote "${PN}: Performing chmod with [$opts]"

  eval flock -x $rootdir${sysconfdir} -c  \"$PSEUDO chmod \$opts\" || true
}

perform_chown () {
	local rootdir="$1"
	local opts="$2"
	bbnote "${PN}: Performing chown with [$opts]"

  eval flock -x $rootdir${sysconfdir} -c  \"$PSEUDO chown \$opts\" || true
}

# Set permission to files / directories
set_permission_files () {
	user_settings="${EXTRA_PERMISSIONS_PARAMS}"
	path="${IMAGE_ROOTFS}"
	export PSEUDO="${FAKEROOTENV} ${STAGING_DIR_NATIVE}${bindir}/pseudo"
	setting=`echo $user_settings | cut -d ';' -f1`
	remaining=`echo $user_settings | cut -d ';' -f2-`

	while test "x$setting" != "x"; do
		cmd=`echo $setting | cut -d ' ' -f1`
		opts=`echo $setting | cut -d ' ' -f2-`

		contains "$opts" "$path" || bbfatal "Path have to contains IMAGE_ROOTFS: $cmd $opts $path"

		case $cmd in
			chmod)
				perform_chmod "${IMAGE_ROOTFS}" "$opts"
				;;
			chown)
				perform_chown "${IMAGE_ROOTFS}" "$opts"
				;;
			*)
				bbfatal "Invalid command in EXTRA_PERMISSIONS_PARAMS: $cmd"
				;;
		esac
		# Avoid infinite loop if the last parameter doesn't end with ';'
		if [ "$setting" = "$remaining" ]; then
			break
		fi
		# iterate to the next setting
		setting=`echo $remaining | cut -d ';' -f1`
		remaining=`echo $remaining | cut -d ';' -f2-`
	done
}

