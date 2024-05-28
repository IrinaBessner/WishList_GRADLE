package com.wishlist.data;

import com.wishlist.models.Gift;

public class GiftData {
    public static final String LINK_WHERE="www.douglas.de";
    public static final String NAME="CHANEL";
    public static final String PRICE="100";
    public static final String CURRENCY="USD";
    public static final String PHOTO="C:\\Tools\\Libre.jpg";
    public static final String LINK_OF_PHOTO="";
    public static final String COMMENT="I want this";

    public static final Gift GIFT_FOR_LENA=new Gift(
            "www.douglas.de",
            "CHANEL",
            "100",
            "USD",
            "C:\\Tools\\Libre.jpg",
            "",
            "I want this"
    );
}
