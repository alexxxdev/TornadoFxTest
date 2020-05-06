package com.example.demo.app

import com.example.demo.view.MainView
import dorkbox.systemTray.SystemTray.TrayType
import javafx.application.Platform
import javafx.scene.image.Image
import javafx.stage.Stage
import javafx.stage.StageStyle
import tornadofx.*
import java.awt.*
import java.awt.event.ActionListener
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.UIManager





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
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
        } catch (e: Throwable) {
            e.printStackTrace();
        }
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
        } else {
            /*try {
                dorkbox.systemTray.SystemTray.DEBUG = true
                //dorkbox.systemTray.SystemTray.FORCE_GTK2 = false
                //dorkbox.systemTray.SystemTray.PREFER_GTK3 = true
                dorkbox.systemTray.SystemTray.FORCE_TRAY_TYPE = TrayType.AWT
                val tray = dorkbox.systemTray.SystemTray.get()
                if(tray!=null){
                    /*tray.setTooltip("Mail Checker");
                    //tray.setImage(Toolkit.getDefaultToolkit().getImage(javaClass.classLoader.getResource("icon.png")));
                    tray.setStatus("No Mail");
                    val mainMenu = tray.getMenu()
                    val m = dorkbox.systemTray.MenuItem("Quit", ActionListener{
                        tray.shutdown();
                        Platform.exit()
                    })
                    mainMenu.add(m)*/
                }
            } catch (e: Exception) {
                e.printStackTrace();
            }*/
        }
        stage.setOnCloseRequest {
           // SystemTray.getSystemTray().remove(trayIcon)
          //  Platform.exit()
        }
    }
}