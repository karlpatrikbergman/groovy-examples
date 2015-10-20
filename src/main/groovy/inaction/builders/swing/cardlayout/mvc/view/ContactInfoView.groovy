package inaction.builders.swing.cardlayout.mvc.view
import groovy.swing.SwingBuilder
import inaction.builders.swing.cardlayout.mvc.model.ContactInfoModel
import inaction.builders.swing.cardlayout.mvc.model.Step

import javax.swing.*
import java.awt.*

class ContactInfoView {
    final String NEXT = "next"
    final String PREVIOUS = "previous"
    private SwingBuilder swing
    private JFrame frame
    def cards = ["name", "address", "phoneNumber", "summary"]
    Step step = new Step()

    /** Controller, move to separate class? **/
    def buttonClicked = { evt ->
        if (evt.actionCommand == NEXT) {
            step.current++
        } else if (evt.actionCommand == PREVIOUS) {
            step.current--
        }
        def cardLayout = (CardLayout) swing.cards.getLayout()
        cardLayout.show(swing.cards, cards[step.current])
    }

    ContactInfoView(ContactInfoModel contactInfoModel) {
        swing = new SwingBuilder()
        frame = swing.frame(title: "Wizard",
                location: [100, 100],
                size: [350, 300],
                defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE) {
            panel {
                panel(id: "cards") {
                    cardLayout()
                    panel(constraints: "name") {
                        hbox {
                            label(text: "Name")
                            textField(id: "name", columns: 20, text: bind("name", target: contactInfoModel, mutual: true))
                        }
                    }
                    panel(constraints: "address") {
                        hbox {
                            label(text: "Address")
                            textField(id: "address", columns: 20, text: bind("address", target: contactInfoModel, mutual: true))
                        }
                    }
                    panel(constraints: "phoneNumber") {
                        label(text: "Phone number")
                        textField(id: "phoneNumber", columns: 20, text: bind(targetProperty: "phoneNumber", target: contactInfoModel, mutual: true))
                    }
                    panel(constraints: "summary") {
                        gridLayout(columns: 2, rows: 3)
                        label(text: "Name")
                        textField(editable: false, text: bind { contactInfoModel.name })

                        label(text: "Address")
                        textField(editable: false, text: bind { contactInfoModel.address })

                        label(text: "Phone number")
                        textField(editable: false, text: bind { contactInfoModel.phoneNumber })

                    }
                }
                vbox() {
                    hbox() {
                        rigidArea()
                        button(
                                id: "previous",
                                text: "Previous",
                                enabled: bind { step.current > 0 },
                                actionPerformed: buttonClicked,
                                actionCommand: PREVIOUS
                        )
                        rigidArea()
                        button(
                                id: "next",
                                text: "Next",
                                enabled: bind { step.current < 3 },
                                actionPerformed: buttonClicked,
                                actionCommand: NEXT
                        )
                        rigidArea()
                    }
                    rigidArea()
                }
            }
        }
        frame.visible = true
    }
}
