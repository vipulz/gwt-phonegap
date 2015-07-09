# Finding a contact #

```
LightArray<String> fields = CollectionFactory.<String> constructArray();
fields.push("displayName"); //search in displayname 
fields.push("name"); //search in name as well
ContactFindOptions findOptions = new ContactFindOptions("<string to search>", true);

phoneGap.getContacts().find(fields, new ContactFindCallback() {

	@Override
	public void onSuccess(LightArray<Contact> contacts) {
		//read contacts here..
	}

	@Override
	public void onFailure(ContactError error) {
		//something went wrong, doh!

	}
}, findOptions);
```

# Creating a contact #
```
Contact contact = phoneGap.getContacts().create();
contact.getPhoneNumbers().push(phoneGap.getContacts().getFacotry().createContactField("home", "012345 678", true));
contact.getName().setFamilyName(value);
contact.save();
```

# Deleting a contact #
```
contact.remove();//calling remove on an contact instance deletes the contact
```

# Contact Module in Dev mode #
The contact module is implemented using LocalStorage in Dev mode and behaves like the phonegap contact module