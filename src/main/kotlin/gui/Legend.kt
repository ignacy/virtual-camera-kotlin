package gui

import java.awt.Color
import java.awt.Graphics
import javax.swing.JPanel


class Legend() : JPanel() {
    override fun paintComponent(graphics: Graphics) {
        super.setBackground(Color.decode("#ffffff"))
    }
}
