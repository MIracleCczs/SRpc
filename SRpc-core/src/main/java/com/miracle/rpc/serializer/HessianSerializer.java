package com.miracle.rpc.serializer;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import com.miracle.rpc.exception.SRpcException;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @program: SRpc
 * @description:
 * @author: miracle
 * @create: 2020-11-16 21:28
 **/
public class HessianSerializer implements Serializer {

    @Override
    public <T> byte[] serialize(T obj) throws IOException {
        if (obj == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        HessianOutput hessianOutput = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            hessianOutput = new HessianOutput(byteArrayOutputStream);
            hessianOutput.writeObject(obj);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception var) {
            throw new SRpcException(var);
        } finally {
            IOUtils.closeQuietly(byteArrayOutputStream);
            if (hessianOutput != null) {
                hessianOutput.close();
            }
        }
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        if (null == data) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = null;
        HessianInput hessianInput = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(data);
            hessianInput = new HessianInput(byteArrayInputStream);
            return (T) hessianInput.readObject();
        } catch (IOException e) {
            throw new SRpcException(e);
        } finally {
            if (hessianInput != null) {
                hessianInput.close();
            }
            IOUtils.closeQuietly(byteArrayInputStream);
        }
    }
}
