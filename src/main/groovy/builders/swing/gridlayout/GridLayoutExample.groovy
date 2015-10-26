package builders.swing.gridlayout
import groovy.swing.SwingBuilder

import javax.swing.*
import java.awt.*

import static java.awt.GridBagConstraints.EAST
import static java.awt.GridBagConstraints.REMAINDER
import static javax.swing.SwingConstants.HORIZONTAL

swing = new SwingBuilder()

def defaultInsets = [0,10,10,0]

frame = swing.build {
    frame(title: 'Demo') {
        panel(border:BorderFactory.createEmptyBorder(10,10,10,10)){
            gridBagLayout()
            label(
                    text: "Name",
                    constraints: gbc(gridx:0, gridy:0, fill:HORIZONTAL, insets:defaultInsets)
            )
            textField(
                    preferredSize: new Dimension(300,20),
                    constraints: gbc(gridx:1, gridy:0, gridwidth:REMAINDER, fill:HORIZONTAL, insets:defaultInsets)
            )
            label(
                    text:"Address",
                    constraints: gbc(gridx:0, gridy:1, fill:HORIZONTAL, insets:defaultInsets)
            )

            textField(
                    preferredSize: new Dimension(300,20),
                    constraints: gbc(gridx:1, gridy:1, fill:HORIZONTAL, insets: defaultInsets)
            )

            label(
                    text: "Phone",
                    constraints: gbc(gridx:0, gridy:2, fill:HORIZONTAL, insets: defaultInsets)
            )

            textField(
                    preferredSize: new Dimension(300,20),
                    constraints: gbc(gridx:1, gridy:2, insets:defaultInsets)
            )

            button(
                    text:'Save Record',
                    constraints:gbc(gridx:0,gridy:3,insets:[10,0,0,0],gridwidth:3, anchor: EAST)
            )
        }
    }
}

frame.pack()
frame.visible = true