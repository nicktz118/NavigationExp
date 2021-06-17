package com.nicktz9.navigationsample.util

import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph

object NavigationUtil {

    fun findStartDestination(graph: NavGraph): NavDestination? {
        var startDestination: NavDestination? = graph
        while (startDestination is NavGraph) {
            val parent = startDestination
            startDestination = parent.findNode(parent.startDestination)
        }
        return startDestination
    }
}

fun NavController.popToStartDest() = NavigationUtil.findStartDestination(this.graph)?.also { startDest ->
    this.popBackStack(startDest.id, false)
}

fun NavController.resetAndBuildStack(vararg actionIds: Int) {
    this.popToStartDest()
    actionIds.forEach { this.navigate(it) }
}
