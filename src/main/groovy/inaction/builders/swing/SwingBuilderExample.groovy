package inaction.builders.swing

import groovy.swing.SwingBuilder

swing = new SwingBuilder(

)
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