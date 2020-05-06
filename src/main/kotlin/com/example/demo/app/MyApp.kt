package com.example.demo.app

import com.example.demo.view.MainView
import javafx.application.Platform
import javafx.scene.image.Image
import javafx.stage.Stage
import javafx.stage.StageStyle
import tornadofx.*
import java.awt.*
import java.awt.event.ActionListener
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent


class MyApp: App(MainView::class, Styles::class){
    var trayIcon: TrayIcon? = null
    //var stage: Stage? = null
    override fun start(stage: Stage) {
        Platform.setImplicitExit(false)
        stage.initStyle(StageStyle.TRANSPARENT);
        //stage.isFullScreen = true
        //stage.fullScreenExitHint="ds"
        //stage.isResizable = false
        with(stage){
            minWidth = 600.0
            minHeight = 400.0
        }
        try {
            stage.icons.add(Image("/icon.png"))
        }catch (e:Exception){
            e.printStackTrace();
        }
        super.start(stage)

        if (SystemTray.isSupported()) {
            val tray = SystemTray.getSystemTray()

            val image: java.awt.Image = Toolkit.getDefaultToolkit().getImage(javaClass.classLoader.getResource("icon.png"))
            val exitListener = ActionListener {
                println("Exiting...")
                tray.remove(trayIcon)
                Platform.exit()
                //exitProcess(0)
            }

            val popup = PopupMenu()
            val defaultItem = MenuItem("Show")
            defaultItem.addActionListener(ActionListener {
                Platform.runLater {
                    stage?.show()
                }
            })
            val defaultItem1 = MenuItem("Exit")
            defaultItem1.addActionListener(exitListener)
            popup.add(defaultItem)
            popup.addSeparator()
            popup.add(defaultItem1)

            /*val popup = JPopupMenu()
            val defaultItem = JMenuItem("Exit",ImageIcon(javaClass.classLoader.getResource("icon.png")))
            defaultItem.addActionListener(exitListener)
            popup.add(defaultItem)*/
            trayIcon = TrayIcon(image, "Tray Demo", popup)
            val actionListener = ActionListener {
                trayIcon!!.displayMessage("Action Event",
                        "An Action Event Has Been Performed!",
                        TrayIcon.MessageType.INFO)
            }
            trayIcon!!.isImageAutoSize = true
            trayIcon!!.addActionListener(actionListener)
            trayIcon!!.addMouseListener(object : MouseAdapter() {
                override fun mouseReleased(e: MouseEvent) {
                    /*if (e.isPopupTrigger()) {
                        popup.setLocation(e.getX(), e.getY())
                        popup.invoker = popup
                        popup.isVisible = true
                    }*/
                }
            })
            try {
                tray.add(trayIcon)
            } catch (e: AWTException) {
                System.err.println("TrayIcon could not be added.")
            }
        }
        stage.setOnCloseRequest {
           // SystemTray.getSystemTray().remove(trayIcon)
          //  Platform.exit()
        }
    }
}