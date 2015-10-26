package builders.swing.simple

import groovy.swing.SwingBuilder

swing = new SwingBuilder()
frame = swing.build() {
    frame(
            title: 'Demo',
            pack: true,
            visible: true) {
        panel {
            textField(id: 'message', columns: 10)
            button(text: 'Print', actionPerformed: { event ->
                println swing.message.text
            })
        }
    }
}