package com.astontech.hr.services;

import com.astontech.hr.domain.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> listAllContacts ();
    Contact getContactById (Integer id);

    Contact saveContact(Contact contact);
    Iterable<Contact> saveListOfContacts(Iterable<Contact> contactList);

    void deleteContact(Integer id);
}
