package com.company.jmixpm.screen.project;

import com.company.jmixpm.entity.Project;
import com.company.jmixpm.screen.projecttasksbrowser.ProjectTasksBrowser;
import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.GroupTable;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Project.browse")
@UiDescriptor("project-browse.xml")
@LookupComponent("projectsTable")
public class ProjectBrowse extends StandardLookup<Project> {
    @Autowired
    private ScreenBuilders screenBuilders;
    @Autowired
    private GroupTable<Project> projectsTable;

    @Subscribe("projectsTable.showTasks")
    public void onProjectsTableShowTasks(final Action.ActionPerformedEvent event) {
        Project selected = projectsTable.getSingleSelected();
        if (selected == null) {
            return;
        }

        screenBuilders.screen(this)
                .withScreenClass(ProjectTasksBrowser.class)
                .build()
                .withProject(selected)
                .show();
    }
}