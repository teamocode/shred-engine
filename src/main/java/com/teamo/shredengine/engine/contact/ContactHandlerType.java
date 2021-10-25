package com.teamo.shredengine.engine.contact;

public interface ContactHandlerType {
    boolean isContacting(Contactable firstContactable,
                         Contactable secondContactable);
}
