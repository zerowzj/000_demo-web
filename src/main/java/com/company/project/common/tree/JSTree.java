package com.company.project.common.tree;

import java.io.Serializable;

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
    private State state = null;


    public class State {
        /**  */
        private boolean opened;
        /**  */
        private boolean disabled;
        /**  */
        private boolean selected;
    }
}
