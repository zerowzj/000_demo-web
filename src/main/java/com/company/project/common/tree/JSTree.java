package com.company.project.common.tree;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author wangzhj
 */
public class JSTree implements Serializable {

    /**  */
    private String id = null;
    /**  */
    private String parent = null;
    /**  */
    private String text = null;
    /**  */
    private String icon = null;
    /**  */
//    private State state = null;

    private Map<String, Boolean> state = null;


 /*   public class State {
        *//**  *//*
        private boolean opened;
        *//**  *//*
        private boolean disabled;
        *//**  *//*
        private boolean selected;

        public State(){};
    }*/

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Map<String, Boolean> getState() {
        return state;
    }

    public void setState(Map<String, Boolean> state) {
        this.state = state;
    }
}
