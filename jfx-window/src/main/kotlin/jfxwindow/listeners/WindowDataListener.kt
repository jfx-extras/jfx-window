package jfxwindow.listeners

import javafx.stage.Stage
import jfxwindow.json.WindowSettings
import kotlinx.serialization.json.Json
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
        @get:JvmSynthetic @set:JvmSynthetic
        internal lateinit var file: String

        @JvmSynthetic
        internal fun addPosListener() {
            val filePath = "${System.getProperty("java.io.tmpdir")}$domain"
            file = "$filePath\\settings.json"

            File(filePath).mkdirs()

            stage.setOnHiding {
                if (savePosIsEnabled) {
                    val windowData = Json.stringify(
                        WindowSettings.Window.serializer(),
                        WindowSettings.Window(
                            WindowSettings.Window.Positions(
                                stage.x.toString(),
                                stage.y.toString()
                            ),
                            WindowSettings.Window.Sizes(
                                stage.height.toString(),
                                stage.width.toString()
                            ),
                            WindowSettings.Window.States(
                                stage.isMaximized.toString(),
                                stage.isIconified.toString()
                            )
                        )
                    )

                    File(file).writeText(windowData, Charsets.UTF_8)
                }
            }
        }

        @JvmSynthetic
        internal fun loadWindowSettings() {
            if (savePosIsEnabled) {
                val obj = Json.parse(WindowSettings.Window.serializer(), readData(file))
                if (WindowSettings(obj).window.states.isMaximized.toBoolean()) {
                    stage.isMaximized = true
                } else {
                    stage.x = WindowSettings(obj).window.positions.x.toDouble()
                    stage.y = WindowSettings(obj).window.positions.y.toDouble()
                    stage.height = WindowSettings(obj).window.sizes.height.toDouble()
                    stage.width = WindowSettings(obj).window.sizes.width.toDouble()
                    stage.isIconified = WindowSettings(obj).window.states.isMinimized.toBoolean()
                }
            }
        }

        private fun readData(fileName: String): String {
            return if (File(fileName).exists() && File(fileName).isFile) {
                File(fileName).readText(Charsets.UTF_8)
            } else {
                "{\"positions\":{\"x\":\"${stage.x}\",\"y\":\"${stage.y}\"},\"sizes\":{\"height\":\"${stage.height}\",\"width\":\"${stage.width}\"},\"states\":{\"isMaximized\":\"${stage.isMaximized}\",\"isMinimized\":\"${stage.isIconified}\"}}"
            }
        }
    }
}