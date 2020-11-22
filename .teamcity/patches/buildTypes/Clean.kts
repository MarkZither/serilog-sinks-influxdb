package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.VcsTrigger
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2018_1.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'Clean'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("Clean")) {
    triggers {
        val trigger1 = find<VcsTrigger> {
            vcs {
                triggerRules = "+:**"
                branchFilter = "nuke"
            }
        }
        trigger1.apply {
            perCheckinTriggering = true
            enableQueueOptimization = false
        }
    }
}