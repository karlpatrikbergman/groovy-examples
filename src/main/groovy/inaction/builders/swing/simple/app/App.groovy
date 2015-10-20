package inaction.builders.swing.simple.app

import groovy.swing.SwingBuilder

class App {
    def swing
    def frame

    App() {
        swing = new SwingBuilder()
        frame = swing.frame(title: 'Demo') {
            panel {
                textField(id: 'message', columns: 10)
                button(text: 'Print', actionPerformed: { event ->
                    println swing.message.text
                })
            }
        }
        frame.pack()
        frame.visible = true

    }
}
