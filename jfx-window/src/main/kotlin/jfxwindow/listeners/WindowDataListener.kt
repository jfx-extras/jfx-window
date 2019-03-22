package jfxwindow.listeners

import javafx.stage.Stage
import java.io.File

class WindowDataListener {
    companion object {
        @get:JvmSynthetic @set:JvmSynthetic
        lateinit var stage: Stage
        @get:JvmSynthetic @set:JvmSynthetic
        internal var savePosIsEnabled: Boolean = false
        var domain: String = File(
            WindowDataListener::class.java.protectionDomain
                .codeSource
                .location.toURI()
                .path
        ).name

        @JvmSynthetic
        internal fun addPosListener() {
            val filePath = "${System.getProperty("java.io.tmpdir")}$domain"
            val file = "$filePath\\app.prefx"

            File(filePath).mkdirs()

            stage.setOnHiding {
                if (savePosIsEnabled) {
                    var state = "DEFAULT"

                    when {
                        stage.isMaximized -> state = "MAXIMIZED"
                        stage.isIconified -> state = "MINIMIZED"
                    }

                    File(file).writeText("POS: ${stage.x} x ${stage.y}\nSIZE: ${stage.height} x ${stage.width}\nSTATE: $state")
                }
            }

            if (savePosIsEnabled) {
                val configuration = readData(file)
                loadWindowPos(configuration)
                loadWindowSize(configuration)
                loadWindowState(configuration)
            }
        }

        @JvmSynthetic
        internal fun loadWindowPos(configuration: List<String>) {
            if (!configuration.isEmpty()) {
                val positions =
                    configuration[0]
                        .replace("POS: ", "", true)
                        .split(" x ")

                if (!positions.isEmpty()) {
                    stage.x = positions[0].toDouble()
                    stage.y = positions[1].toDouble()
                }
            }
        }

        @JvmSynthetic
        internal fun loadWindowSize(configuration: List<String>) {
            if (!configuration.isEmpty()) {
                val sizes =
                    configuration[1]
                        .replace("SIZE: ", "", true)
                        .split(" x ")

                if (!sizes.isEmpty()) {
                    stage.height = sizes[0].toDouble()
                    stage.width = sizes[1].toDouble()
                }
            }
        }

        @JvmSynthetic
        internal fun loadWindowState(configuration: List<String>) {
            if (!configuration.isEmpty()) {
                val state =
                    configuration[2]
                        .replace("STATE: ", "", true)

                if (state.toUpperCase() == "NORMAL"
                    || state.toUpperCase() == "DEFAULT"
                ) {
                    if (stage.isMaximized) stage.isMaximized = false
                } else if (state.toUpperCase() == "MAXIMIZED" ||
                    state.toUpperCase() == "MAX"
                ) {
                    if (!stage.isMaximized) stage.isMaximized = true
                } else if (state.toUpperCase() == "MINIMIZED" ||
                    state.toUpperCase() == "MIN"
                ) {
                    if (!stage.isIconified) stage.isIconified = true
                }
            }
        }

        private fun readData(fileName: String): List<String> {
            return if (File(fileName).exists() && File(fileName).isFile) {
                File(fileName).readLines(Charsets.UTF_8)
            } else {
                emptyList()
            }
        }
    }
}