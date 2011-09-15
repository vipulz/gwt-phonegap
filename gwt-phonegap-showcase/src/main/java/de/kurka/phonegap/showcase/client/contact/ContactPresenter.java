package de.kurka.phonegap.showcase.client.contact;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;

import de.kurka.gwt.collection.shared.GwtCollectionFactory;
import de.kurka.gwt.collection.shared.LightArray;
import de.kurka.phonegap.client.PhoneGap;
import de.kurka.phonegap.client.contacts.Contact;
import de.kurka.phonegap.client.contacts.ContactError;
import de.kurka.phonegap.client.contacts.ContactFindCallback;
import de.kurka.phonegap.client.contacts.ContactFindOptions;

public class ContactPresenter {

	private final PhoneGap phoneGap;
	private final Display display;

	public interface Display {
		public Widget asWidget();

		public HasClickHandlers getFindButton();

		public HasValue<String> getFindValue();

		public HasHTML getFoundContacts();

		public HasClickHandlers getCreateButton();

		public HasValue<String> getCreateValue();

		public HasHTML getCreateFeedback();

	}

	public ContactPresenter(Display display, PhoneGap phoneGap) {
		this.display = display;
		this.phoneGap = phoneGap;

		bind();
	}

	protected void bind() {
		display.getFindButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String searchString = display.getFindValue().getValue();

				LightArray<String> fields = GwtCollectionFactory.<String> constructArray();

				fields.push("displayName");
				fields.push("name");

				display.getFoundContacts().setHTML("Searching...");

				ContactFindOptions findOptions = new ContactFindOptions(searchString, true);

				phoneGap.getContacts().find(fields, new ContactFindCallback() {

					@Override
					public void onSuccess(LightArray<Contact> contacts) {
						StringBuffer buffer = new StringBuffer();

						for (int i = 0; i < contacts.length(); i++) {
							buffer.append(contacts.get(i).getName().getFormatted() + "; ");
						}

						display.getFoundContacts().setHTML(buffer.toString());
					}

					@Override
					public void onFailure(ContactError error) {
						display.getFoundContacts().setHTML("Error...");

					}
				}, findOptions);

			}
		});

		display.getCreateButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String value = display.getCreateValue().getValue();

				if (value == null || "".equals(value)) {
					display.getCreateFeedback().setHTML("please enter a name");
				}

				Contact contact = phoneGap.getContacts().create();

				contact.getName().setFamilyName(value);

				contact.getPhoneNumbers().push(phoneGap.getContacts().getFacotry().createContactField("home", "012345 678", true));
				contact.save();

				display.getCreateFeedback().setHTML("saved");

			}
		});
	}

	public Widget getDisplay() {
		return display.asWidget();
	}
}