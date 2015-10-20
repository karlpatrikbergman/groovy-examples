package inaction.builders.swing.miglayout.mvc.model

import groovy.beans.Bindable
import groovy.transform.ToString

@ToString(includeNames=true)
class ContactInfoModel {
    @Bindable String firstName
    @Bindable String surName
    @Bindable String address
    @Bindable String city
    @Bindable String email
    @Bindable String homePage
}