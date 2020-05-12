package com.example.demo.view

import com.example.demo.ClockX
import com.example.demo.app.HEIGHT
import com.example.demo.app.Styles
import com.example.demo.app.TITLE
import com.example.demo.app.WIDTH
import javafx.geometry.Pos
import javafx.scene.paint.Color
import tornadofx.*
import java.util.*

class MainView : View(TITLE) {
    private var tileSize = HEIGHT / 3

    override val root = pane {
        setPrefSize(WIDTH, HEIGHT)
        //alignment = Pos.CENTER
        hbox {
            addClass(Styles.clock)
            alignment = Pos.CENTER
            setPrefSize(tileSize, tileSize)
            label("...")
        }

        val clock = ClockX()
        clock.attachTo(this) {
            addClass(Styles.clock)
            setPrefSize(tileSize * 2, tileSize * 2)
            layoutX = WIDTH / 2 - prefWidth / 2
            layoutY = HEIGHT / 2 - prefHeight / 2

            isSecondsVisible = true
            isDateVisible = true
            isDayVisible = true
            hourColor = Color.WHITE
            minuteColor = Color.rgb(0, 191, 255)
            secondColor = Color.WHITE
            dateColor = Color.WHITE
            isRunning = true
            locale = Locale.getDefault()
        }


        /* val slimClock = ClockBuilder.create()
                 .prefSize(tileSize, tileSize)
                 .skinType(Clock.ClockSkinType.SLIM)
                 .secondColor(FOREGROUND)
                 .minuteColor(BLUE)
                 .hourColor(FOREGROUND)
                 .dateColor(FOREGROUND)
                 .locale(Locale.getDefault())
                 .running(true)
                 .build();
         val slimClockTile = TileBuilder.create()
                 .prefSize(tileSize*2, tileSize*2)
                 .skinType(SkinType.CUSTOM)
                 .graphic(slimClock)
                 .build();

         slimClockTile.attachTo(this){
             layoutX = WIDTH/2 - tileSize
             layoutY = HEIGHT/2 - tileSize
         }*/

        /*val clockTile = TileBuilder.create()
                .prefSize(tileSize, tileSize)
                .skinType(Tile.SkinType.CLOCK)
                .dateVisible(false)
                .secondsVisible(false)
                .secondColor(Color.AQUA)
                .locale(Locale.getDefault())
                .running(true)
                .animated(false)
                .build();
        clockTile.attachTo(this)*/
        /* hbox {
             addClass(Styles.zip)
             alignment = Pos.CENTER
             setPrefSize(tileSize, tileSize)
             label("If you can see this, you are successfully logged in!")
             layoutX = WIDTH/2 - tileSize/2
             layoutY = HEIGHT/2 - tileSize/2
         }*/

        /*center {
                val clockTile = TileBuilder.create()
                        .prefSize(tileSize, tileSize)
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
                        .prefSize(tileSize, tileSize)
                        .skinType(Clock.ClockSkinType.SLIM)
                        .secondColor(FOREGROUND)
                        .minuteColor(BLUE)
                        .hourColor(FOREGROUND)
                        .dateColor(FOREGROUND)
                        .locale(Locale.getDefault())
                        .running(true)
                        .build();
                val slimClockTile = TileBuilder.create()
                        .prefSize(tileSize, tileSize)
                        .skinType(SkinType.CUSTOM)
                        .title("Medusa Clock")
                        .graphic(slimClock)
                        .textVisible(false)
                        .build();
                val numberTile = TileBuilder.create()
                        .prefSize(tileSize, tileSize)
                        .skinType(SkinType.NUMBER)
                        .title("Number Tile")
                        .text("Whatever text")
                        .value(13.0)
                        .unit("mb")
                        .description("Test")
                        .textVisible(true)
                        .build();
                val timeTile = TileBuilder.create()
                        .prefSize(tileSize, tileSize)
                        .skinType(SkinType.TIME)
                        .title("Time Tile")
                        .text("Whatever text")
                        .duration(LocalTime.of(1, 22))
                        .description("Average reply time")
                        .textVisible(true)
                        .build();
                val stockTile = TileBuilder.create()
                        .skinType(SkinType.STOCK)
                        .prefSize(tileSize, tileSize)
                        .maxValue(1000.0)
                        .title("Stock Tile")
                        .textVisible(false)
                        .build();
            val countryTile = TileBuilder.create().skinType(SkinType.COUNTRY)
                    .prefSize(tileSize, tileSize)
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
                    .prefSize(tileSize, tileSize)
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
                FlowGridPane(gridSize.first,gridSize.second, clockTile, slimClockTile,numberTile,timeTile,stockTile, countryTile, plusMinusTile, customTile)
                        .attachTo(this)

                numberTile.value = 4.4

            b.setOnMouseClicked {
                if(SystemTray.isSupported()) {
                    currentStage?.hide()
                } else {
                    Platform.exit()
                }
            }
        }*/
    }
}