/*
 * Firebase GeoFire Java Library
 *
 * Copyright © 2014 Firebase - All Rights Reserved
 * https://www.firebase.com
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binaryform must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY FIREBASE AS IS AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO
 * EVENT SHALL FIREBASE BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.firebase.geofire;

import com.firebase.client.FirebaseError;

/**
 * GeoQuery notifies listeners with this interface about keys that entered, exited or moved within the query
 */
public interface GeoQueryEventListener {

    /**
     * Called if a key entered the search area of the GeoQuery. This method is called for every key currently in the
     * search area at the time of adding the listener.
     *
     * This method is once per key, and is only called again if onKeyExited was called in the mean time.
     *
     * @param key The key that entered the search area
     * @param location The location for this key as latitude-longitude coordinates
     */
    public void onKeyEntered(String key, GeoLocation location);

    /**
     * Called if a key exited the search area of the GeoQuery. This is method is only called if onKeyEntered was called
     * for the key.
     *
     * @param key The key that exited the search area
     */
    public void onKeyExited(String key);

    /**
     * Called if a key moved within the search area.
     *
     * This method can be called multiple times
     *
     * @param key The key that moved within the search area
     * @param location The location for this key as latitude-longitude coordinates
     */
    public void onKeyMoved(String key, GeoLocation location);

    /**
     * This method is called after all initial key entered events have been fired for a query.
     * It is called immediately if all events have been fired before the listener was added.
     * After any search criteria is updated, it is called again once the new data was loaded from the server
     * and all corresponding events have been fired.
     */
    public void onGeoQueryReady();

    /**
     * Called in case an error occurred while retrieving locations for a query, e.g. violating security rules.
     * @param error The error that occurred while retrieving the query
     */
    public void onGeoQueryError(FirebaseError error);

}
