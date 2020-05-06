package com.example.demo.view

import eu.hansolo.medusa.Clock
import eu.hansolo.medusa.ClockBuilder
import eu.hansolo.tilesfx.Tile.*
import eu.hansolo.tilesfx.TileBuilder
import eu.hansolo.tilesfx.tools.Country
import eu.hansolo.tilesfx.tools.FlowGridPane
import javafx.application.Platform
import javafx.scene.control.Button
import javafx.scene.paint.Color
import javafx.stage.Stage
import tornadofx.*
import java.awt.*
import java.awt.event.ActionListener
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.time.LocalTime
import java.util.*


class MainView : View("Hello TornadoFX") {

    override val root = borderpane {
        setPrefSize(800.0, 480.0)
        center {
            //hbox {
                val clockTile = TileBuilder.create()
                        .prefSize(150.0, 150.0)
                        .skinType(SkinType.CLOCK)
                        .title("Clock Tile")
                        .text("Whatever text")
                        .dateVisible(true)
                        .secondsVisible(false)
                        .secondColor(Color.AQUA)
                        .locale(Locale.getDefault())
                        .running(true)
                        .animated(false)
                        .build();
                val slimClock = ClockBuilder.create()
                        .prefSize(150.0, 150.0)
                        .skinType(Clock.ClockSkinType.SLIM)
                        .secondColor(FOREGROUND)
                        .minuteColor(BLUE)
                        .hourColor(FOREGROUND)
                        .dateColor(FOREGROUND)
                        .locale(Locale.getDefault())
                        .running(true)
                        .build();
                val slimClockTile = TileBuilder.create()
                        .prefSize(150.0, 150.0)
                        .skinType(SkinType.CUSTOM)
                        .title("Medusa Clock")
                        .graphic(slimClock)
                        .textVisible(false)
                        .build();
                val numberTile = TileBuilder.create()
                        .prefSize(150.0, 150.0)
                        .skinType(SkinType.NUMBER)
                        .title("Number Tile")
                        .text("Whatever text")
                        .value(13.0)
                        .unit("mb")
                        .description("Test")
                        .textVisible(true)
                        .build();
                val timeTile = TileBuilder.create()
                        .prefSize(150.0, 150.0)
                        .skinType(SkinType.TIME)
                        .title("Time Tile")
                        .text("Whatever text")
                        .duration(LocalTime.of(1, 22))
                        .description("Average reply time")
                        .textVisible(true)
                        .build();
                val stockTile = TileBuilder.create()
                        .skinType(SkinType.STOCK)
                        .prefSize(150.0, 150.0)
                        .maxValue(1000.0)
                        .title("Stock Tile")
                        .textVisible(false)
                        .build();
            val countryTile = TileBuilder.create().skinType(SkinType.COUNTRY)
                    .prefSize(150.0, 150.0)
                    .minValue(0.1)
                    .maxValue(40.0)
                    .value(5.6)
                    .title("Country Tile")
                    .unit("Unit")
                    .country(Country.RU)
                    .tooltipText("")
                    .animated(true)
                    .build();
            val plusMinusTile = TileBuilder.create()
                    .prefSize(150.0, 150.0)
                    .skinType(SkinType.SWITCH_SLIDER)
                    .maxValue(30.0)
                    .minValue(0.0)
                    .value(12.0)
                    .activeColor(Color.BLUE)
                    .valueColor(Color.AQUA)
                    .title("PlusMinus Tile")
                    .text("Whatever text")
                    .description("Test")
                    .unit("\u00B0C")
                    .build();
            val b = Button("Click Me")
            val customTile = TileBuilder.create()
                    .prefSize(50.0, 50.0)
                    .skinType(SkinType.CUSTOM)
                    .title("Custom Tile")
                    .text("Whatever text")
                    .graphic(b)
                    .roundedCorners(false)
                    .build();
                FlowGridPane(4,3, clockTile, slimClockTile,numberTile,timeTile,stockTile, countryTile, plusMinusTile, customTile)
                        .attachTo(this)

                numberTile.value = 4.4

            b.setOnMouseClicked {
                if(SystemTray.isSupported()) {
                    currentStage?.hide()
                } else {
                    Platform.exit()
                }
            }
            //}


        }
    }
}