package inaction.builders.swing.miglayout.mvc.view
import groovy.swing.SwingBuilder
import inaction.builders.swing.miglayout.mvc.model.ContactInfoModel
import net.miginfocom.swing.MigLayout
import org.codehaus.groovy.binding.ClosureTriggerBinding

import javax.swing.*

import static javax.swing.WindowConstants.EXIT_ON_CLOSE

class ContactInfoView {
    private SwingBuilder swing
    private Action previousAction
    private Action nextAction
    Step step = new Step()

    ContactInfoView(ContactInfoModel contactInfoModel) {
        swing = new SwingBuilder()

        previousAction = swing.action(
                name: "Previous",
                closure:this.&previousButtonClosure
        )

        nextAction = swing.action(
                name: "Next",
                closure:this.&nextButtonClosure
        )

        swing.build() {
            frame(
                    title: "Contact Info",
                    pack: true,
                    visible: true,
                    defaultCloseOperation: EXIT_ON_CLOSE,
                    layout: new MigLayout(
                            "fill, debug",
                            "[][]", //Column constraints
                            "[]10[]"  //Row constraints
                    )
            ) {
                panel(id: "infoPanels", constraints: "wrap, span 2") {
                    infoPanel("nameInfo", true, "First name", "firstName", "Surename", "surename")
//                    infoPanel("adressInfo", false, "Address", "address", "City", "city")
//                    infoPanel("webInfo", false, "E-mail", "email", "Home page", "homePage")
                }
                navButton("prevButton", "Prev", "width 70!", previousAction, "previous", bind { step.current > 0 })
                navButton("nextButton", "Next", "align right, width 70!", nextAction, "next", bind { step.current < 3 })
            }
        }
    }

    /** Controller related **/

    void previousButtonClosure(event) {
        hidePanels()
        swing.infoPanels.components[--step.current].visible = true
    }

    void nextButtonClosure(event) {
        hidePanels()
        swing.infoPanels.components[++step.current].visible = true
    }

    void hidePanels() {
        swing.infoPanels.components.each{component ->
            component.visible = false
        }
    }

    /** Factory methods **/

    def infoPanel(String panelId, boolean visible, String labelOneText, String textFieldOneId, String labelTwoText, String textFieldTwoId) {
        swing.panel(
                id: panelId,
                visible: visible,
                constraints: "hidemode 3",
                layout: new MigLayout(
                        "fill",
                        "[][]", //Column constraints
                        "[]10[]"  //Row constraints
                )
        ) {
//            label(text: labelOneText, constraints: "width 100!")
//            textField(id: textFieldOneId, constraints: "width 130!, wrap, align right")
            inputWidget(labelOneText, "width 100!", textFieldOneId, "width 130!, wrap, align right")

//            label(text: labelTwoText)
//            textField(id: textFieldTwoId, constraints: "width 130!")
            inputWidget(labelTwoText, "width 100!", textFieldTwoId, "width 130!, wrap, align right")
        }
    }

    def inputWidget(String labelText, String labelConstraints, String textFieldId, String textFieldConstraints) {
        swing.label(text: labelText, constraints: labelConstraints)
        swing.textField(id: textFieldId, constraints: textFieldConstraints)
    }

    def navButton(String id, String text, String constraints, Action action, String actionCommand,
                  ClosureTriggerBinding closureTriggerBinding) {
        swing.button(
                id: id,
                text: text,
                constraints: constraints,
                enabled: closureTriggerBinding,
                action: action,
                actionCommand: actionCommand
        )
    }
}
