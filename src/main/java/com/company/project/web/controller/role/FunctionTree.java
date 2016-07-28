package com.company.project.web.controller.role;

/**
 * @author wangzhj
 */
public class FunctionTree {

    private String id = null;

    private String parent = null;

    private String text = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
