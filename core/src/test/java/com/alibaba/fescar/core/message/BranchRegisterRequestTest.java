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

import com.alibaba.fescar.core.model.BranchType;
import com.alibaba.fescar.core.protocol.transaction.BranchRegisterRequest;

import org.junit.Assert;
import org.junit.Test;

/**
 * The type Branch register request test.
 */
public class BranchRegisterRequestTest {
    /**
     * To string test.
     */
    @Test
    public void toStringTest() {
        BranchRegisterRequest branchRegisterRequest = new BranchRegisterRequest();
        branchRegisterRequest.setXid("127.0.0.1:8091:1249853");
        branchRegisterRequest.setBranchType(BranchType.AT);
        branchRegisterRequest.setResourceId("resource1");
        branchRegisterRequest.setLockKey("lock_key_1");
        Assert.assertEquals("xid=127.0.0.1:8091:1249853,branchType=AT,resourceId=resource1,lockKey=lock_key_1",
            branchRegisterRequest.toString());

    }

    /**
     * Test decode.
     */
    @Test
    public void testDecode() {
        BranchRegisterRequest branchRegisterRequest = new BranchRegisterRequest();
        branchRegisterRequest.setXid("127.0.0.1:8091:1249853");
        branchRegisterRequest.setBranchType(BranchType.AT);
        branchRegisterRequest.setResourceId("resource1");
        branchRegisterRequest.setLockKey("lock_key_1");
        branchRegisterRequest.setApplicationData("test app data");
        byte[] encodeResult = branchRegisterRequest.encode();
        ByteBuffer byteBuffer = ByteBuffer.allocate(encodeResult.length);
        byteBuffer.put(encodeResult);
        byteBuffer.flip();
        BranchRegisterRequest decodeBranchRegisterRequest = new BranchRegisterRequest();
        decodeBranchRegisterRequest.decode(byteBuffer);
        Assert.assertEquals(branchRegisterRequest.getXid(), decodeBranchRegisterRequest.getXid());
        Assert.assertEquals(branchRegisterRequest.getLockKey(), decodeBranchRegisterRequest.getLockKey());
        Assert.assertEquals(branchRegisterRequest.getResourceId(), decodeBranchRegisterRequest.getResourceId());
        Assert.assertEquals(branchRegisterRequest.getApplicationData(),
            decodeBranchRegisterRequest.getApplicationData());
    }
}
