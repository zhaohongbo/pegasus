package net.eric.service;

import org.activiti.engine.*;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.StartFormData;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Eric Zhao
 * @date 2018/4/15
 */
@Service
public class BpmnService {
    private final RepositoryService repositoryService;
    private final RuntimeService runtimeService;
    private final TaskService taskService;
    private final HistoryService historyService;
    private final FormService formService;
    private final IdentityService identityService;

    @Autowired
    public BpmnService(final RepositoryService repositoryService,
                       final RuntimeService runtimeService,
                       final TaskService taskService,
                       final HistoryService historyService,
                       final FormService formService,
                       final IdentityService identityService) {
        this.repositoryService = repositoryService;
        this.runtimeService = runtimeService;
        this.taskService = taskService;
        this.historyService = historyService;
        this.formService = formService;
        this.identityService = identityService;
    }

    public List<ProcessDefinition> queryProcessDefinitionList() {
        return repositoryService.createProcessDefinitionQuery().list();
    }

    public ProcessDefinition queryProcessDefinition(String processDefinitionId) {
        return repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefinitionId).singleResult();
    }

    public List<FormProperty> queryStartFormData(String processDefinitionId) throws ActivitiObjectNotFoundException {
        StartFormData formData = formService.getStartFormData(processDefinitionId);
        return formData.getFormProperties();
    }

    public void createProcess(String userId, String processDefinitionId, Map<String, String> formValue) {
        identityService.setAuthenticatedUserId(userId);
        ProcessInstance instance = formService.submitStartFormData(processDefinitionId, formValue);


    }
}
