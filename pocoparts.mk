# Device Settings
PRODUCT_PACKAGES += \
    XiaomiParts

PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/parts/init.xiaomiparts.rc:$(TARGET_COPY_OUT_PRODUCT)/etc/init/init.xiaomiparts.rc \
    $(LOCAL_PATH)/parts/privapp-permissions-parts.xml:$(TARGET_COPY_OUT_PRODUCT)/etc/permissions/privapp-permissions-parts.xml

# Sepolicy
BOARD_PLAT_PRIVATE_SEPOLICY_DIR += $(LOCAL_PATH)/sepolicy/private
BOARD_SEPOLICY_DIRS += $(LOCAL_PATH)/sepolicy/vendor
TARGET_SEPOLICY_DIR := msmsteppe
