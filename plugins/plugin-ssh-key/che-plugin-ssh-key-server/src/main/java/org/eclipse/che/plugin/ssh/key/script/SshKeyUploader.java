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
package org.eclipse.che.plugin.ssh.key.script;

import org.eclipse.che.api.core.UnauthorizedException;

import java.io.IOException;

/**
 * Uploads ssh keys to Repository management.
 *
 * @author Anton Korneta
 */
public interface SshKeyUploader {

    /**
     * Upload public key part to Repository management.
     *
     * @throws IOException
     *         if an i/o error occurs
     * @throws UnauthorizedException
     *         if user is not authorized to access SSH key storage
     */
    void uploadKey(String publicKey) throws IOException, UnauthorizedException;

    /**
     * Check if specified url matched to use current upload provider.
     *
     * @param url
     *         input url to check
     * @return true if current uploader can be applied to upload key to host specified in url, passed as parameter
     */
    boolean match(String url);
}
