package com.example.demo.app

import eu.hansolo.tilesfx.Tile
import eu.hansolo.tilesfx.colors.TileColor
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

class Styles : Stylesheet() {
    companion object {
        val heading by cssclass()
        val zip by cssclass()
    }

    init {
        root {
            backgroundColor += Tile.BACKGROUND
        }
        s(zip) {
            backgroundColor += Tile.BLUE
        }
        label and heading {
            padding = box(10.px)
            fontSize = 20.px
            fontWeight = FontWeight.BOLD
        }
    }
}