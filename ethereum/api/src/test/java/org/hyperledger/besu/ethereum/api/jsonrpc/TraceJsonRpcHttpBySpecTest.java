/*
 * Copyright ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package org.hyperledger.besu.ethereum.api.jsonrpc;

import org.hyperledger.besu.ethereum.core.BlockchainSetupUtil;

import java.net.URL;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TraceJsonRpcHttpBySpecTest extends AbstractJsonRpcHttpBySpecTest {

  public TraceJsonRpcHttpBySpecTest(final String specName, final URL specURL) {
    super(specName, specURL);
  }

  @Override
  public void setup() throws Exception {
    super.setup();
    startService();
  }

  @Override
  protected BlockchainSetupUtil<Void> getBlockchainSetupUtil() {
    return createBlockchainSetupUtil(
        "trace/chain-data/genesis.json", "trace/chain-data/blocks.bin");
  }

  @Parameters(name = "{index}: {0}")
  public static Object[][] specs() {
    return AbstractJsonRpcHttpBySpecTest.findSpecFiles(
        "trace/specs/flat",
        "trace/specs/vm-trace",
        "trace/specs/statediff",
        "trace/specs/all",
        "trace/specs/halt-cases");
  }
}
