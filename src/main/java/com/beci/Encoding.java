package com.beci;

import lombok.Getter;

public enum Encoding {
    TIS_620("TIS-620"),
    UTF_8("UTF-8"),
    UNICODE("unicode"),
    DEFAULT("default"),
    ISO_8859_1("ISO-8859-1");

    @Getter private String encoding;
    @Getter private String encodingHeadTag;

    private Encoding(String encoding) {
        this.encoding = encoding;
        this.encodingHeadTag = "<? xml version=\"1.0\" encoding=\""+ encoding +"\" ?>";
    }
}
