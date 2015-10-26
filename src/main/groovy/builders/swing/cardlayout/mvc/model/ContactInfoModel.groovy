package builders.swing.cardlayout.mvc.model

import groovy.beans.Bindable
import groovy.transform.ToString

@ToString(includeNames=true)
class ContactInfoModel {
    @Bindable String name
    @Bindable String address
    @Bindable String phoneNumber
}