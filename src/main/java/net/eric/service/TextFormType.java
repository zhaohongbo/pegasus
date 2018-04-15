package net.eric.service;

import org.activiti.engine.impl.form.StringFormType;

/**
 * @author Eric Zhao
 * @date 2018/4/15
 */
public class TextFormType extends StringFormType {
    @Override
    public String getName() {
        return "text";
    }
}
