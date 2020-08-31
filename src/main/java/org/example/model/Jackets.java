package org.example.model;

import javax.persistence.Entity;

@Entity
public class Jackets extends  Product
{
    private String Composition;

    private String Style;

    public String getComposition() {
        return Composition;
    }

    public void setComposition(String composition) {
        Composition = composition;
    }

    public String getStyle() {
        return Style;
    }

    public void setStyle(String style) {
        Style = style;
    }

}
