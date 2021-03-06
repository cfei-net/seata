/*
 *  Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.alibaba.fescar.core.message;

import java.nio.ByteBuffer;

import com.alibaba.fescar.core.protocol.transaction.GlobalRollbackRequest;

import org.junit.Assert;
import org.junit.Test;

/**
 * The type Global rollback request test.
 */
public class GlobalRollbackRequestTest {

    /**
     * Test to string.
     */
    @Test
    public void testToString() {
        GlobalRollbackRequest globalRollbackRequest = new GlobalRollbackRequest();
        globalRollbackRequest.setXid("127.0.0.1:8091:1249853");
        globalRollbackRequest.setExtraData("test_extra_data");
        Assert.assertEquals("xid=127.0.0.1:8091:1249853,extraData=test_extra_data", globalRollbackRequest.toString());
    }

    /**
     * Test decode.
     */
    @Test
    public void testDecode() {
        GlobalRollbackRequest globalRollbackRequest = new GlobalRollbackRequest();
        globalRollbackRequest.setXid("127.0.0.1:8091:1249853");
        globalRollbackRequest.setExtraData("test_extra_data");
        byte[] encodeResult = globalRollbackRequest.encode();
        ByteBuffer byteBuffer = ByteBuffer.allocate(encodeResult.length);
        byteBuffer.put(encodeResult);
        byteBuffer.flip();
        GlobalRollbackRequest decodeGlobalRollbackRequest = new GlobalRollbackRequest();
        decodeGlobalRollbackRequest.decode(byteBuffer);
        Assert.assertEquals(globalRollbackRequest.getXid(), decodeGlobalRollbackRequest.getXid());
        Assert.assertEquals(globalRollbackRequest.getExtraData(), decodeGlobalRollbackRequest.getExtraData());
    }
}