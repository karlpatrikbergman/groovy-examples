package builders.swing.miglayout.simple

import groovy.swing.SwingBuilder
import net.miginfocom.swing.MigLayout

import static javax.swing.WindowConstants.EXIT_ON_CLOSE

swing = new SwingBuilder()
swing.build {
    frame(
            pack: true,
            show: true,
            defaultCloseOperation: EXIT_ON_CLOSE,
            layout: new MigLayout(
                    "fill",
                    "[][][][]", //Column constraints
                    "[]10[]"  //Row constraints
            )
    ) {
        label(text: "First name")
        textField(id: "firstName", constraints: "width 70!")

        label(text: "Surname", constraints: "gap unrelated")
        textField(id: "surname", constraints: "wrap, width 70!")

        label(text: "Address")
        textField(id: "address", constraints: "span, grow")

        button(text: "Prev", constraints: "width 70!, span 2")

        button(text: "Next", constraints: "align right, width 70!, span 2")
    }
}
