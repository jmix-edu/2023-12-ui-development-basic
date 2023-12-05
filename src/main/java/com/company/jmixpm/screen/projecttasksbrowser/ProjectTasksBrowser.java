package com.company.jmixpm.screen.projecttasksbrowser;

import com.company.jmixpm.entity.Project;
import com.company.jmixpm.entity.Task;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Nullable;

@UiController("ProjectTasksBrowser")
@UiDescriptor("project-tasks-browser.xml")
public class ProjectTasksBrowser extends Screen {

    @Autowired
    private CollectionLoader<Task> tasksDl;

    public ProjectTasksBrowser withProject(@Nullable Project project) {
        if (project != null) {
            tasksDl.setParameter("projectId", project.getId());
        } else {
            tasksDl.removeParameter("projectId");
        }

        tasksDl.load();

        return this;
    }
}