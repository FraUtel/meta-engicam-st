SUMMARY = "Engicam hardware test image"
LICENSE = "Proprietary"

include recipes-st/images/st-image.inc

inherit core-image distro_features_check

IMAGE_LINGUAS = "en-us"

IMAGE_FEATURES += "\
    hwcodecs \
    \
    package-management \
    \
    splash \
    ssh-server-openssh \
    \    
    tools-profile \
    "

#
# Multimedia part addons
#
IMAGE_MM_PART = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'gstreamer', 'packagegroup-gstreamer1-0', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'kmscube', '', d)} \
    \
    libv4l \
    rc-keymaps \
    \
    tiff \
    "

#
# INSTALL addons
#
CORE_IMAGE_EXTRA_INSTALL += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'systemd-networkd-configuration', '', d)} \    
    \
    brcm-patchram-plus \
    \
    cantest \
    \
    devmem2 \
    \
    lwb-bcm4343w-fw \
    \
    mtd-utils \
    \
    obexftp \
    \
    packagegroup-framework-tools-core-base      \
    packagegroup-framework-tools-kernel-base    \
    packagegroup-framework-tools-network-base   \
    packagegroup-framework-tools-audio-base     \
    packagegroup-framework-tools-python2-base   \
    packagegroup-framework-tools-python3-base   \
    packagegroup-framework-tools-core           \
    packagegroup-framework-tools-kernel         \
    packagegroup-framework-tools-network        \
    packagegroup-framework-tools-audio          \
    packagegroup-framework-tools-ui             \
    packagegroup-framework-tools-python2        \
    packagegroup-framework-tools-python3        \    
    packagegroup-gstreamer1-0 \
    ppp \      
    \
    serialtools \
    \
    test-sound \
    "
