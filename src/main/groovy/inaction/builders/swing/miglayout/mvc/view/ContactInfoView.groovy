package inaction.builders.swing.miglayout.mvc.view

import groovy.beans.Bindable
import groovy.swing.SwingBuilder
import inaction.builders.swing.miglayout.mvc.model.ContactInfoModel
import net.miginfocom.swing.MigLayout

import javax.swing.*
import java.awt.*

import static javax.swing.WindowConstants.EXIT_ON_CLOSE

class ContactInfoView {
    private SwingBuilder swing
    private JFrame frame
    private Step step

    ContactInfoView(ContactInfoModel contactInfoModel) {
        step = new Step()
        swing = new SwingBuilder()
        swing.build() {
            frame = frame(
                    title: "Contact Info",
                    pack: true,
                    visible: true,
                    defaultCloseOperation: EXIT_ON_CLOSE,
                    layout: new MigLayout(
                            "fill, debug",
                            "[][]", //Column constraints
                            "[]10[]"  //Row constraints
                    ),


            ) {
                Point cp = GraphicsEnvironment.localGraphicsEnvironment.centerPoint
                current.location = new Point((int)(cp.x - current.width), (int)(cp.y - current.height))

                panel(id: "infoPanels", constraints: "wrap, span 2") {
                    panel(id: "nameInfo", visible: true, constraints: "hidemode 3", layout: new MigLayout("fill", "[][]", "[]10[]")) {
                        label(text: "First name", constraints: "width 100!")
                        textField(id: "firstName", constraints: "width 130!, wrap, align right", text: bind("firstName", target: contactInfoModel, mutual: true))
                        label(text: "Surname")
                        textField(id: "surName", constraints: "width 130!", text: bind("surName", target: contactInfoModel, mutual: true))
                    }
                    panel(id: "adressInfo", visible: false, constraints: "hidemode 3", layout: new MigLayout("fill", "[][]", "[]10[]")) {
                        label(text: "Address", constraints: "width 100!")
                        textField(id: "address", constraints: "width 130!, wrap, align right", text: bind("address", target: contactInfoModel, mutual: true))
                        label(text: "City")
                        textField(id: "city", constraints: "width 130!", text: bind("city", target: contactInfoModel, mutual: true))
                    }
                    panel(id: "webInfo", visible: false, constraints: "hidemode 3", layout: new MigLayout("fill", "[][]", "[]10[]")) {
                        label(text: "E-mail", constraints: "width 100!")
                        textField(id: "email", constraints: "width 130!, wrap, align right", text: bind("email", target: contactInfoModel, mutual: true))
                        label(text: "Home page")
                        textField(id: "homePage", constraints: "width 130!", text: bind("homePage", target: contactInfoModel, mutual: true))
                    }
                    panel(id: "summary", visible: false, constraints: "hidemode 3", layout: new MigLayout("fill", "[][]", "[]10[]")) {

                        label(text: "First name", constraints: "width 100!")
                        textField(id: "firstName", constraints: "width 130!, wrap, align right", text: bind { contactInfoModel.firstName })

                        label(text: "Surname")
                        textField(id: "surName", constraints: "width 130!, wrap", text: bind { contactInfoModel.surName })

                        label(text: "Address", constraints: "width 100!")
                        textField(id: "address", constraints: "width 130!, wrap, align right", text: bind { contactInfoModel.address })

                        label(text: "City")
                        textField(id: "city", constraints: "width 130!, wrap", text: bind { contactInfoModel.city })

                        label(text: "E-mail", constraints: "width 100!")
                        textField(id: "email", constraints: "width 130!, wrap, align right", text: bind { contactInfoModel.email })

                        label(text: "Home page")
                        textField(id: "homePage", constraints: "width 130!", text: bind { contactInfoModel.homePage })
                    }
                }
                button(
                        id: "prevButton",
                        text: "Prev",
                        constraints: "width 70!",
                        enabled: bind { step.currentPanel > 0 },
                        action: swing.action(name: "Previous", closure: this.&previousButtonClosure),
                        actionCommand: "previous"
                )
                button(
                        id: "nextButton",
                        text: "Next",
                        constraints: "align right, width 70!",
                        enabled: bind { step.currentPanel < 3 },
                        action: swing.action(name: "Next", closure: this.&nextButtonClosure),
                        actionCommand: "next"
                )
            }
        }
    }

    /** Controller related **/

    void previousButtonClosure(event) {
        if(step.currentPanel == 0) return
        swing.infoPanels.components[step.currentPanel].visible = false
        swing.infoPanels.components[--step.currentPanel].visible = true
        frame.pack()
    }

    void nextButtonClosure(event) {
        if(step.currentPanel == swing.infoPanels.components.length - 1) return
        swing.infoPanels.components[step.currentPanel].visible = false
        swing.infoPanels.components[++step.currentPanel].visible = true
        frame.pack()
    }

    @Bindable
    private class Step {
        int currentPanel = 0
    }

}
