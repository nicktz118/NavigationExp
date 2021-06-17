package com.nicktz9.navigationsample.ext

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun <T : Any> Fragment.setBackStackData(key: String, data: T, doBack: Boolean = true) {
    findNavController().previousBackStackEntry?.savedStateHandle?.set(key, data)
    if (doBack)
        findNavController().popBackStack()
}

fun <T : Any> Fragment.setParticularBackStackData(@IdRes destinationId: Int, key: String, data: T) {
    findNavController().getBackStackEntry(destinationId).savedStateHandle.set(key, data)
}

fun <T : Any> Fragment.getBackStackData(key: String, result: (T) -> (Unit)) {
    findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<T>(key)
        ?.observe(viewLifecycleOwner) {
            result(it)
        }
}
