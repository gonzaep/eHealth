/**
 * Copyright (c) 2009-2011 University of Cardiff and others
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 * <p>
 * Contributors:
 * University of Cardiff - initial API and implementation
 * -
 */

package org.openhealthtools.openatna.audit.process;

/**
 * A processor of an AtnaMessage. Processors sit between
 * the message successfully being parsed, and being persisted.
 * processing can involve any activity, typically verification
 * and triggering events based on message content.
 *
 * @author Andrew Harrison
 * @version $Revision:$
 */

public interface AtnaProcessor {

    /**
     * process an incoming message wrapped in a context
     *
     * @param context
     * @throws Exception
     */
    void process(ProcessContext context) throws Exception;

    /**
     * process an exception that has occured further up the processing chain.
     * When an exception occurs, then processors are invoked in reverse order
     * with this method. The context will contain a Throwable object which is
     * the exception that was thrown.
     *
     * @param context
     */
    void error(ProcessContext context);
}
