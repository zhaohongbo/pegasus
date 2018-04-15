package net.eric.protocol;

import org.activiti.engine.form.FormProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eric Zhao
 * @date 2018/4/15
 */
public class WorkflowDefinitionListResponse {
    private List<WorkflowDefinition> workflowDefinitionList;
    private WorkflowProperty firstWorkflowFormProperty;

    public void addWorkflowDefinition(String id, String name) {
        if (null == workflowDefinitionList) {
            workflowDefinitionList = new ArrayList<>();
        }
        workflowDefinitionList.add(new WorkflowDefinition(id, name));
    }

    public void setFirstWorkflowDefinition(String id, List<FormProperty> formProperties) {
        this.firstWorkflowFormProperty = new WorkflowProperty(id, formProperties);
    }

    public List<WorkflowDefinition> getWorkflowDefinitionList() {
        return workflowDefinitionList;
    }

    public WorkflowProperty getFirstWorkflowFormProperty() {
        return firstWorkflowFormProperty;
    }

    public static class WorkflowDefinition {
        private String id;
        private String name;

        WorkflowDefinition(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static class WorkflowProperty {
        private String id;
        private List<FormProperty> formProperties;

        WorkflowProperty(String id, List<FormProperty> formProperties) {
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
}
