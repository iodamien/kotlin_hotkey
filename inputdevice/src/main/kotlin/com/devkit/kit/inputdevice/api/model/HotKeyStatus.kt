package com.devkit.kit.inputdevice.api.model

class HotKeyStatus {

    private val status: MutableMap<NativeKey, Boolean> = mutableMapOf()

    fun onPress(key: NativeKey) {
        status[key] = true
    }

    fun onRelease(key: NativeKey) {
        status[key] = false
    }

    fun isPressed(key: NativeKey): Boolean {
        return status[key] ?: false
    }

    val isAPressed: Boolean
        get() = isPressed(NativeKey.KEY_A)

    val isBPressed: Boolean
        get() = isPressed(NativeKey.KEY_B)

    val isCPressed: Boolean
        get() = isPressed(NativeKey.KEY_C)

    val isDPressed: Boolean
        get() = isPressed(NativeKey.KEY_D)

    val isEPressed: Boolean
        get() = isPressed(NativeKey.KEY_E)

    val isFPressed: Boolean
        get() = isPressed(NativeKey.KEY_F)

    val isGPressed: Boolean
        get() = isPressed(NativeKey.KEY_G)

    val isHPressed: Boolean
        get() = isPressed(NativeKey.KEY_H)

    val isIPressed: Boolean
        get() = isPressed(NativeKey.KEY_I)

    val isJPressed: Boolean
        get() = isPressed(NativeKey.KEY_J)

    val isKPressed: Boolean
        get() = isPressed(NativeKey.KEY_K)

    val isLPressed: Boolean
        get() = isPressed(NativeKey.KEY_L)

    val isMPressed: Boolean
        get() = isPressed(NativeKey.KEY_M)

    val isNPressed: Boolean
        get() = isPressed(NativeKey.KEY_N)

    val isOPressed: Boolean
        get() = isPressed(NativeKey.KEY_O)

    val isPPressed: Boolean
        get() = isPressed(NativeKey.KEY_P)

    val isQPressed: Boolean
        get() = isPressed(NativeKey.KEY_Q)

    val isRPressed: Boolean
        get() = isPressed(NativeKey.KEY_R)

    val isSPressed: Boolean
        get() = isPressed(NativeKey.KEY_S)

    val isTPressed: Boolean
        get() = isPressed(NativeKey.KEY_T)

    val isUPressed: Boolean
        get() = isPressed(NativeKey.KEY_U)

    val isVPressed: Boolean
        get() = isPressed(NativeKey.KEY_V)

    val isWPressed: Boolean
        get() = isPressed(NativeKey.KEY_W)

    val isXPressed: Boolean
        get() = isPressed(NativeKey.KEY_X)

    val isYPressed: Boolean
        get() = isPressed(NativeKey.KEY_Y)

    val isZPressed: Boolean
        get() = isPressed(NativeKey.KEY_Z)

    val is0Pressed: Boolean
        get() = isPressed(NativeKey.KEY_0)

    val is1Pressed: Boolean
        get() = isPressed(NativeKey.KEY_1)

    val is2Pressed: Boolean
        get() = isPressed(NativeKey.KEY_2)

    val is3Pressed: Boolean
        get() = isPressed(NativeKey.KEY_3)

    val is4Pressed: Boolean
        get() = isPressed(NativeKey.KEY_4)

    val is5Pressed: Boolean
        get() = isPressed(NativeKey.KEY_5)

    val is6Pressed: Boolean
        get() = isPressed(NativeKey.KEY_6)

    val is7Pressed: Boolean
        get() = isPressed(NativeKey.KEY_7)

    val is8Pressed: Boolean
        get() = isPressed(NativeKey.KEY_8)

    val is9Pressed: Boolean
        get() = isPressed(NativeKey.KEY_9)

    val isF1Pressed: Boolean
        get() = isPressed(NativeKey.KEY_F1)

    val isF2Pressed: Boolean
        get() = isPressed(NativeKey.KEY_F2)

    val isF3Pressed: Boolean
        get() = isPressed(NativeKey.KEY_F3)

    val isF4Pressed: Boolean
        get() = isPressed(NativeKey.KEY_F4)

    val isF5Pressed: Boolean
        get() = isPressed(NativeKey.KEY_F5)

    val isF6Pressed: Boolean
        get() = isPressed(NativeKey.KEY_F6)

    val isF7Pressed: Boolean
        get() = isPressed(NativeKey.KEY_F7)

    val isF8Pressed: Boolean
        get() = isPressed(NativeKey.KEY_F8)

    val isF9Pressed: Boolean
        get() = isPressed(NativeKey.KEY_F9)

    val isF10Pressed: Boolean
        get() = isPressed(NativeKey.KEY_F10)

    val isF11Pressed: Boolean
        get() = isPressed(NativeKey.KEY_F11)

    val isF12Pressed: Boolean
        get() = isPressed(NativeKey.KEY_F12)

    val isF13Pressed: Boolean
        get() = isPressed(NativeKey.KEY_F13)

    val isF14Pressed: Boolean
        get() = isPressed(NativeKey.KEY_F14)

    val isF15Pressed: Boolean
        get() = isPressed(NativeKey.KEY_F15)

    val isF16Pressed: Boolean
        get() = isPressed(NativeKey.KEY_F16)

    val isF17Pressed: Boolean
        get() = isPressed(NativeKey.KEY_F17)

    val isF18Pressed: Boolean
        get() = isPressed(NativeKey.KEY_F18)

    val isF19Pressed: Boolean
        get() = isPressed(NativeKey.KEY_F19)

    val isF20Pressed: Boolean
        get() = isPressed(NativeKey.KEY_F20)

    val isF21Pressed: Boolean
        get() = isPressed(NativeKey.KEY_F21)

    val isF22Pressed: Boolean
        get() = isPressed(NativeKey.KEY_F22)

    val isF23Pressed: Boolean
        get() = isPressed(NativeKey.KEY_F23)

    val isF24Pressed: Boolean
        get() = isPressed(NativeKey.KEY_F24)

    val isBackquotePressed: Boolean
        get() = isPressed(NativeKey.KEY_BACKQUOTE)

    val isMinusPressed: Boolean
        get() = isPressed(NativeKey.KEY_MINUS)

    val isEqualsPressed: Boolean
        get() = isPressed(NativeKey.KEY_EQUALS)

    val isBackspacePressed: Boolean
        get() = isPressed(NativeKey.KEY_BACKSPACE)

    val isTabPressed: Boolean
        get() = isPressed(NativeKey.KEY_TAB)

    val isCapsLockPressed: Boolean
        get() = isPressed(NativeKey.KEY_CAPS_LOCK)

    val isControlPressed: Boolean
        get() = isPressed(NativeKey.KEY_CONTROL)

    val isMetaPressed: Boolean
        get() = isPressed(NativeKey.KEY_META)

    val isNumLockPressed: Boolean
        get() = isPressed(NativeKey.KEY_NUM_LOCK)

    val isScrollLockPressed: Boolean
        get() = isPressed(NativeKey.KEY_SCROLL_LOCK)

    val isShiftPressed: Boolean
        get() = isPressed(NativeKey.KEY_SHIFT)

    val isAltPressed: Boolean
        get() = isPressed(NativeKey.KEY_ALT)

    val isDeletePressed: Boolean
        get() = isPressed(NativeKey.KEY_DELETE)

    val isEnterPressed: Boolean
        get() = isPressed(NativeKey.KEY_ENTER)

    val isOpenBracketPressed: Boolean
        get() = isPressed(NativeKey.KEY_OPEN_BRACKET)

    val isCloseBracketPressed: Boolean
        get() = isPressed(NativeKey.KEY_CLOSE_BRACKET)

    val isBackSlashPressed: Boolean
        get() = isPressed(NativeKey.KEY_BACK_SLASH)

    val isSemicolonPressed: Boolean
        get() = isPressed(NativeKey.KEY_SEMICOLON)

    val isQuotePressed: Boolean
        get() = isPressed(NativeKey.KEY_QUOTE)

    val isCommaPressed: Boolean
        get() = isPressed(NativeKey.KEY_COMMA)

    val isPeriodPressed: Boolean
        get() = isPressed(NativeKey.KEY_PERIOD)

    val isSlashPressed: Boolean
        get() = isPressed(NativeKey.KEY_SLASH)

    val isSpacePressed: Boolean
        get() = isPressed(NativeKey.KEY_SPACE)

    val isPrintScreenPressed: Boolean
        get() = isPressed(NativeKey.KEY_PRINTSCREEN)

    val isPausePressed: Boolean
        get() = isPressed(NativeKey.KEY_PAUSE)

    val isInsertPressed: Boolean
        get() = isPressed(NativeKey.KEY_INSERT)

    val isHomePressed: Boolean
        get() = isPressed(NativeKey.KEY_HOME)

    val isEndPressed: Boolean
        get() = isPressed(NativeKey.KEY_END)

    val isPageUpPressed: Boolean
        get() = isPressed(NativeKey.KEY_PAGE_UP)

    val isPageDownPressed: Boolean
        get() = isPressed(NativeKey.KEY_PAGE_DOWN)

    val isUpPressed: Boolean
        get() = isPressed(NativeKey.KEY_UP)

    val isLeftPressed: Boolean
        get() = isPressed(NativeKey.KEY_LEFT)

    val isRightPressed: Boolean
        get() = isPressed(NativeKey.KEY_RIGHT)

    val isDownPressed: Boolean
        get() = isPressed(NativeKey.KEY_DOWN)

    val isClearPressed: Boolean
        get() = isPressed(NativeKey.KEY_CLEAR)

    fun copy(): HotKeyStatus {
        val copy = HotKeyStatus()
        copy.status.putAll(status)
        return copy
    }

    override fun equals(other: Any?): Boolean {
        if (other !is HotKeyStatus) {
            return false
        }

        return status == other.status
    }
}
