/**
 * The FreeBSD Copyright
 * Copyright 1994-2008 The FreeBSD Project. All rights reserved.
 * Copyright (C) 2013-2017 Philip Helger philip[at]helger[dot]com
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 *    2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE FREEBSD PROJECT ``AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE FREEBSD PROJECT OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation
 * are those of the authors and should not be interpreted as representing
 * official policies, either expressed or implied, of the FreeBSD Project.
 */
package com.helger.as2lib.util.dump;

import java.io.IOException;

import javax.annotation.Nonnull;

/**
 * Base interface to dump outgoing HTTP requests
 *
 * @author Philip Helger
 * @since 3.1.0 - totally redesigned
 */
public interface IHTTPOutgoingDumper extends AutoCloseable
{
  /**
   * Get notified on a single outgoing HTTP headers. For HTTP headers usually
   * the ISO-8859-1 charset is used.
   *
   * @param sName
   *        HTTP header name. Never <code>null</code>.
   * @param sValue
   *        HTTP header value. Never <code>null</code>.
   */
  void dumpHeader (@Nonnull String sName, @Nonnull String sValue);

  /**
   * Called after all headers were emitted.
   */
  default void finishedHeaders ()
  {}

  /**
   * Dump a single payload byte. May not throw an IOException!
   *
   * @param nByte
   *        Current byte
   */
  void dumpPayload (int nByte);

  /**
   * Called after the payload was emitted.
   */
  default void finishedPayload ()
  {}

  /**
   * Close the dumper.
   */
  default void close () throws IOException
  {}
}