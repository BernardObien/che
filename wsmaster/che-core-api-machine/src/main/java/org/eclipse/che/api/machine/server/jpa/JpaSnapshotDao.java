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
package org.eclipse.che.api.machine.server.jpa;

import com.google.inject.persist.Transactional;

import org.eclipse.che.api.core.NotFoundException;
import org.eclipse.che.api.machine.server.exception.SnapshotException;
import org.eclipse.che.api.machine.server.model.impl.SnapshotImpl;
import org.eclipse.che.api.machine.server.spi.SnapshotDao;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import java.util.List;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

/**
 * JPA based {@link SnapshotDao} implementation.
 *
 * @author Yevhenii Voevodin
 */
@Singleton
public class JpaSnapshotDao implements SnapshotDao {

    @Inject
    private Provider<EntityManager> managerProvider;

    @Override
    @Transactional
    public SnapshotImpl getSnapshot(String snapshotId) throws NotFoundException, SnapshotException {
        requireNonNull(snapshotId, "Required non-null snapshotId");
        try {
            final SnapshotImpl snapshot = managerProvider.get().find(SnapshotImpl.class, snapshotId);
            if (snapshot == null) {
                throw new NotFoundException(format("Snapshot with id '%s' doesn't exist", snapshotId));
            }
            return snapshot;
        } catch (RuntimeException x) {
            throw new SnapshotException(x.getLocalizedMessage(), x);
        }
    }

    @Override
    @Transactional
    public SnapshotImpl getSnapshot(String workspaceId, String envName, String machineName) throws NotFoundException, SnapshotException {
        requireNonNull(workspaceId, "Required non-null workspace id");
        requireNonNull(envName, "Required non-null environment name");
        requireNonNull(machineName, "Required non-null machine name");
        g
    }

    @Override
    public void saveSnapshot(SnapshotImpl snapshot) throws SnapshotException {

    }

    @Override
    public List<SnapshotImpl> findSnapshots(String namespace, String workspaceId) throws SnapshotException {
        return null;
    }

    @Override
    public void removeSnapshot(String snapshotId) throws NotFoundException, SnapshotException {

    }
}
