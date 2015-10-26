package builders.swing.cardlayout.simple
import groovy.swing.SwingBuilder

import java.awt.*

swing = new SwingBuilder()

def itemStateChanged = { evt ->
    cardLayout = (CardLayout)swing.cards.getLayout()
    cardLayout.show(swing.cards, (String)swing.cb.getSelectedItem())
}

frame = swing.frame(size:[200,200], title:'CardLayout Demo', layout:new BorderLayout()) {
    panel(id:'comboPane',constraints:BorderLayout.NORTH) {
        comboBox(id:'cb', items:['Card with JButtons', 'Card with JTextField', 'Card with JSlider'], actionPerformed:itemStateChanged )
    }
    panel(id:'cards', constraints:BorderLayout.SOUTH) {
        cardLayout()
        panel(constraints:'Card with JButtons') {
            button('Button 1')
            button('Button 2')
            button('Button 3')
        }
        panel(constraints:'Card with JTextField') {
            textField(columns:20)
        }
        panel(constraints:'Card with JSlider') {
            slider()
        }
    }
}
frame.pack()
frame.visible = true