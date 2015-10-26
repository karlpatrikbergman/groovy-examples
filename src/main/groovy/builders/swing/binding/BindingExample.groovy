package builders.swing.binding
import groovy.beans.Bindable
import groovy.beans.ListenerList
import groovy.beans.Vetoable
import groovy.swing.SwingBuilder

import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.beans.PropertyVetoException

class Person implements ActionListener {
    @Bindable
    String name
    @Vetoable
    int age

    @Override
    void actionPerformed(ActionEvent e) {
        if (e.actionCommand == name) setAge(age + 1)
    }
}

class BirthdayNotifier {
    @ListenerList List<ActionListener> listeners

    def triggerBirthday(name) {
        def event = new ActionEvent(this, 0, name)
        fireActionPerformed(event)
    }
}

data = [
    new Person(name: 'Bruce', age: 57),
    new Person(name: 'Steve', age: 57),
    new Person(name: 'Adrian', age: 58),
    new Person(name: 'Dave', age: 58),
    new Person(name: 'Nicko', age: 63)
]

swing = new SwingBuilder()
frame = swing.frame(title: 'Binding Demo') {
    table {
        tableModel(list: data, id: 'tableModel') {
            propertyColumn(header: 'Name', propertyName: 'name', editable: true)
            propertyColumn(header: 'Age', propertyName: 'age', type: Integer, editable: true)
        }
    }
}
frame.pack()
frame.visible = true

notifier = new BirthdayNotifier()
data.each {
    it.addPropertyChangeListener { event ->
        println "$event.newValue has replaced $event.oldValue"
    }
    it.addVetoableChangeListener { event ->
        if(event.newValue < 0)
            throw new PropertyVetoException("Can't have -ve age", event)
        else
            println "$event.source.name now has age $event.newValue"
    }
    notifier.addActionListener(it)
}

//try {
//    data[0].age = - 99
//} catch (e) {
//    println "Change ignored: $e.message"
//}

data[0].name = "Blaze"
data[1].age = 58
notifier.triggerBirthday(data[2].name)