/*******************************************************************************
 * Copyright (c) 2012-2016 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.ide.extension.machine.client.processes;

import com.google.gwt.user.client.ui.IsWidget;

import org.eclipse.che.ide.api.mvp.View;

import javax.validation.constraints.NotNull;

/**
 * View of {@link ConsolesPanelPresenter}.
 *
 * @author Anna Shumilova
 * @author Roman Nikitenko
 */
public interface ConsolesPanelView extends View<ConsolesPanelView.ActionDelegate> {
    /**
     * Sets whether this view is visible.
     *
     * @param visible
     *         <code>true</code> to show the view, <code>false</code> to
     *         hide it
     */
    void setVisible(boolean visible);

    /** Add process widget */
    void addProcessWidget(String processId, IsWidget widget);

    /** Add process node */
    void addProcessNode(@NotNull ProcessTreeNode node);

    /** Remove process node */
    void removeProcessNode(@NotNull ProcessTreeNode node);

    /**
     * Set process data to be displayed.
     *
     * @param root
     *         data which will be displayed
     */
    void setProcessesData(@NotNull ProcessTreeNode root);

    /** Select given process node */
    void selectNode(ProcessTreeNode node);

    /** Displays output for process with given ID */
    void showProcessOutput(String processId);

    /** Hides output for process with given ID */
    void hideProcessOutput(String processId);

    /** Marks process with a badge in process tree */
    void markProcessHasOutput(String processId);

    /** Removes all process widgets from the view */
    void clear();

    /** Returns index for node with given ID */
    int getNodeIndex(String processId);

    /** Returns node by given index */
    ProcessTreeNode getNodeByIndex(@NotNull int index);

    /** Returns node by given ID */
    ProcessTreeNode getNodeById(@NotNull String nodeId);

    /**
     * Sets visibility of 'Stop process' button for node with given ID
     *
     * @param nodeId
     *         id of process node
     */
    void setStopButtonVisibility(String nodeId, boolean visible);

    interface ActionDelegate {

        /**
         * Will be called when user clicks 'Add new terminal' button
         *
         * @param machineId
         *         id of machine in which the terminal will be added
         */
        void onAddTerminal(@NotNull String machineId);

        /**
         * Will be called when user clicks 'Preview Ssh' button
         *
         * @param machineId
         *         id of machine in which ssh keys are located
         */
        void onPreviewSsh(@NotNull String machineId);

        /**
         * Perform actions when tree node is selected.
         *
         * @param node
         *         selected tree node
         */
        void onTreeNodeSelected(@NotNull ProcessTreeNode node);

        /**
         * Will be called when user clicks 'Stop' button
         *
         * @param node
         *         node of process to stop without closing output
         */
        void onStopCommandProcess(@NotNull ProcessTreeNode node);

        /**
         * Will be called when user clicks 'Close' button
         *
         * @param node
         *         terminal node to close
         */
        void onCloseTerminal(@NotNull ProcessTreeNode node);

        /**
         * Will be called when user clicks 'Close' button
         *
         * @param node
         *         node of process to stop with closing output
         */
        void onCloseCommandOutputClick(@NotNull ProcessTreeNode node);

        /**
         * Is called when user clicked right mouse button.
         *
         * @param mouseX
         *          mouse x coordinate
         * @param mouseY
         *          mouse y coordinate
         * @param node
         *          process tree node
         */
        void onContextMenu(int mouseX, int mouseY, ProcessTreeNode node);
    }

}
