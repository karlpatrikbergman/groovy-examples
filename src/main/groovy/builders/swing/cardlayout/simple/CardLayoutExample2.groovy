package builders.swing.cardlayout.simple

import groovy.beans.Bindable
import groovy.swing.SwingBuilder
import java.awt.*
import static javax.swing.SwingConstants.CENTER

final String NEXT = "next"
final String PREVIOUS = "previous"

@Bindable
class Step {
    def current = 0
}

def step = new Step()
def panelColors = ['RED', 'YELLOW', 'BLUE']
swing = new SwingBuilder()

def buttonClicked = { evt ->
    if (evt.actionCommand == NEXT) {
        step.current++
    } else if (evt.actionCommand == PREVIOUS) {
        step.current--
    }
    cardLayout = (CardLayout) swing.cards.getLayout()
    cardLayout.show(swing.cards, panelColors[step.current])
}

frame = swing.frame(title: 'Demo') {
    panel {
        borderLayout()
        panel(id: 'cards', constraints: CENTER) {
            cardLayout()
            panelColors.each { color ->
                label(
                        text: color,
                        horizontalAlignment: CENTER,
                        opaque: true,
                        background: Color."${color}",
                        constraints: color
                )
            }
        }
        hbox(constraints: SOUTH) {
            button(
                    id: 'previous',
                    text: 'Previous',
                    enabled: bind { step.current > 0 },
                    actionPerformed: buttonClicked,
                    actionCommand: PREVIOUS
            )
            button(
                    id: 'next',
                    text: 'Next',
                    enabled: bind { step.current < 2 },
                    actionPerformed: buttonClicked,
                    actionCommand: NEXT
            )
        }
    }
}
frame.pack()
frame.visible = true