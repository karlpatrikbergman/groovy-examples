package inaction.builders.swing.cardlayout.mvc

import inaction.builders.swing.cardlayout.mvc.model.ContactInfoModel
import inaction.builders.swing.cardlayout.mvc.view.ContactInfoView

ContactInfoModel contactModel = new ContactInfoModel()
ContactInfoView contactInfoView = new ContactInfoView(contactModel)
