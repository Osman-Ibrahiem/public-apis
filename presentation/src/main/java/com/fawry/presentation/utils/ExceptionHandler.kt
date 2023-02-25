package com.fawry.presentation.utils

import androidx.annotation.StringRes
import com.rubikans.challenge.presentation.R
import java.net.UnknownHostException

internal object ExceptionHandler {

    @StringRes
    fun parse(t: Throwable): Int {
        return when (t) {
            is UnknownHostException, is java.net.SocketException -> R.string.error_check_internet_connection
            else -> R.string.error_oops_error_occured
        }
    }
}