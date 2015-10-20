package inaction.builders.swing.miglayout.mvc

import inaction.builders.swing.miglayout.mvc.view.ContactInfoView
import inaction.builders.swing.miglayout.mvc.model.ContactInfoModel

ContactInfoModel contactModel = new ContactInfoModel()
ContactInfoView contactInfoView = new ContactInfoView(contactModel)