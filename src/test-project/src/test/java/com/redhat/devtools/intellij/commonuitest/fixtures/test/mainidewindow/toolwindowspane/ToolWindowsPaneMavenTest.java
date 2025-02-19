/*******************************************************************************
 * Copyright (c) 2021 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v2.0 which accompanies this distribution,
 * and is available at https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 * Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package com.redhat.devtools.intellij.commonuitest.fixtures.test.mainidewindow.toolwindowspane;

import com.redhat.devtools.intellij.commonuitest.LibraryTestBase;
import com.redhat.devtools.intellij.commonuitest.fixtures.mainidewindow.toolwindowspane.ToolWindowsPane;
import com.redhat.devtools.intellij.commonuitest.fixtures.mainidewindow.toolwindowspane.buildtoolpane.MavenBuildToolPane;
import com.redhat.devtools.intellij.commonuitest.utils.project.CreateCloseUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

/**
 * ToolWindowsPane Maven test
 *
 * @author zcervink@redhat.com
 */
class ToolWindowsPaneMavenTest extends LibraryTestBase {
    private static final String PROJECT_NAME = "tool_windows_pane_java_maven_project";
    private ToolWindowsPane toolWindowsPane;

    @BeforeAll
    public static void prepareProject() {
        CreateCloseUtils.createNewProject(remoteRobot, PROJECT_NAME, CreateCloseUtils.NewProjectType.MAVEN);
    }

    @AfterAll
    public static void closeCurrentProject() {
        CreateCloseUtils.closeProject(remoteRobot);
    }

    @BeforeEach
    public void createToolWindowsPaneFixture() {
        toolWindowsPane = remoteRobot.find(ToolWindowsPane.class, Duration.ofSeconds(10));
    }

    @Test
    public void mavenBuildTest() {
        toolWindowsPane.openMavenBuildToolPane();
        MavenBuildToolPane mavenBuildToolPane = toolWindowsPane.find(MavenBuildToolPane.class, Duration.ofSeconds(10));
        mavenBuildToolPane.buildProject("install");
    }
}