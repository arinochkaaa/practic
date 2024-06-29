package com.epam.rd.contactbook;

public class Contact {
    private String contactName;
    private ContactInfo phoneNumber;
    private ContactInfo[] emails = new ContactInfo[3];
    private ContactInfo[] socialMedias = new ContactInfo[5];
    private int emailCount = 0;
    private int socialCount = 0;

    public Contact(String contactName) {
        if (contactName == null || contactName.trim().isEmpty()) {
            throw new IllegalArgumentException("Contact name cannot be null or empty");
        }
        this.contactName = contactName;
    }

    public void rename(String newName) {
        if (newName == null || newName.trim().isEmpty()) {
            throw new IllegalArgumentException("New name cannot be null or empty");
        }
        this.contactName = newName;
    }

    public Email addEmail(String localPart, String domain) {
        if (emailCount < 3) {
            Email email = new Email(localPart + "@" + domain);
            emails[emailCount++] = email;
            return email;
        }
        return null;
    }

    public Email addEpamEmail(String firstname, String lastname) {
        if (emailCount < 3) {
            Email epamEmail = new Email(firstname + "_" + lastname + "@epam.com") {
                @Override
                public String getTitle() {
                    return "Epam Email";
                }
            };
            emails[emailCount++] = epamEmail;
            return epamEmail;
        }
        return null;
    }

    public ContactInfo addPhoneNumber(int code, String number) {
        if (this.phoneNumber == null) {
            this.phoneNumber = new ContactInfo() {
                @Override
                public String getTitle() {
                    return "Tel";
                }

                @Override
                public String getValue() {
                    return "+" + code + " " + number;
                }
            };
            return this.phoneNumber;
        }
        return null;
    }

    public Social addTwitter(String twitterId) {
        return addSocialMedia("Twitter", twitterId);
    }

    public Social addInstagram(String instagramId) {
        return addSocialMedia("Instagram", instagramId);
    }

    public Social addSocialMedia(String title, String id) {
        if (socialCount < 5) {
            Social social = new Social(title, id);
            socialMedias[socialCount++] = social;
            return social;
        }
        return null;
    }

    public ContactInfo[] getInfo() {
        int size = 1 + (phoneNumber != null ? 1 : 0) + emailCount + socialCount;
        ContactInfo[] info = new ContactInfo[size];
        int index = 0;
        info[index++] = new NameContactInfo();
        if (phoneNumber != null) {
            info[index++] = phoneNumber;
        }
        for (int i = 0; i < emailCount; i++) {
            info[index++] = emails[i];
        }
        for (int i = 0; i < socialCount; i++) {
            info[index++] = socialMedias[i];
        }
        return info;
    }

    private class NameContactInfo implements ContactInfo {
        @Override
        public String getTitle() {
            return "Name";
        }

        @Override
        public String getValue() {
            return contactName;
        }
    }

    public static class Email implements ContactInfo {
        private final String email;

        public Email(String email) {
            this.email = email;
        }

        @Override
        public String getTitle() {
            return "Email";
        }

        @Override
        public String getValue() {
            return email;
        }
    }

    public static class Social implements ContactInfo {
        private final String title;
        private final String id;

        public Social(String title, String id) {
            this.title = title;
            this.id = id;
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getValue() {
            return id;
        }
    }
}