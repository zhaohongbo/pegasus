package net.eric.protocol;

import org.activiti.engine.form.FormProperty;

import java.util.List;

/**
 * @author Eric Zhao
 * @date 2018/4/21
 */
public class WorkflowPropertyResponse {
    private String id;
    private List<FormProperty> formProperties;

    public WorkflowPropertyResponse(String id, List<FormProperty> formProperties) {
        this.id = id;
        this.formProperties = formProperties;
    }

    public String getId() {
        return id;
    }

    public List<FormProperty> getFormProperties() {
        return formProperties;
    }
}
