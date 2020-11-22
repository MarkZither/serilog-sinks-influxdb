// ------------------------------------------------------------------------------
// <auto-generated>
//
//     This code was generated.
//
//     - To turn off auto-generation set:
//
//         [TeamCity (AutoGenerate = false)]
//
//     - To trigger manual generation invoke:
//
//         nuke --generate-configuration TeamCity --host TeamCity
//
// </auto-generated>
// ------------------------------------------------------------------------------

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildFeatures.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.*
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.*
import jetbrains.buildServer.configs.kotlin.v2018_1.vcs.*

version = "2020.1"

project {
    buildType(Clean)
    buildType(Restore)
    buildType(Compile)

    buildTypesOrder = arrayListOf(Clean, Restore, Compile)

    params {
        select (
            "env.Verbosity",
            label = "Verbosity",
            description = "Logging verbosity during build execution. Default is 'Normal'.",
            value = "Normal",
            options = listOf("Minimal" to "Minimal", "Normal" to "Normal", "Quiet" to "Quiet", "Verbose" to "Verbose"),
            display = ParameterDisplay.NORMAL)
        select (
            "env.Configuration",
            label = "Configuration",
            description = "Configuration to build - Default is 'Debug' (local) or 'Release' (server)",
            value = "Release",
            options = listOf("Debug" to "Debug", "Release" to "Release"),
            display = ParameterDisplay.NORMAL)
    }
}
object Clean : BuildType({
    name = "Clean"
    vcs {
        root(DslContext.settingsRoot)
        cleanCheckout = true
    }
    steps {
        exec {
            path = "build.sh"
            arguments = "Clean --skip"
        }
    }
    triggers {
        vcs {
            branchFilter = "nuke"
            triggerRules = "+:**"
        }
    }
})
object Restore : BuildType({
    name = "Restore"
    vcs {
        root(DslContext.settingsRoot)
        cleanCheckout = true
    }
    steps {
        exec {
            path = "build.sh"
            arguments = "Restore --skip"
        }
    }
    triggers {
        vcs {
            branchFilter = "nuke"
            triggerRules = "+:**"
        }
    }
})
object Compile : BuildType({
    name = "Compile"
    vcs {
        root(DslContext.settingsRoot)
        cleanCheckout = true
    }
    steps {
        exec {
            path = "build.sh"
            arguments = "Compile --skip"
        }
    }
    triggers {
        vcs {
            branchFilter = "nuke"
            triggerRules = "+:**"
        }
    }
    dependencies {
        snapshot(Restore) {
            onDependencyFailure = FailureAction.FAIL_TO_START
            onDependencyCancel = FailureAction.CANCEL
        }
    }
})
