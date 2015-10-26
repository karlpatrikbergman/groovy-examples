package builders.swing.miglayout.mvc

import builders.swing.miglayout.mvc.view.ContactInfoView
import builders.swing.miglayout.mvc.model.ContactInfoModel

ContactInfoModel contactModel = new ContactInfoModel()
ContactInfoView contactInfoView = new ContactInfoView(contactModel)