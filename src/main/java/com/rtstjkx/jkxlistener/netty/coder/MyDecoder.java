package com.rtstjkx.jkxlistener.netty.coder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.string.StringDecoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyDecoder extends StringDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        String HEXES = "0123456789ABCDEF";
        byte[] req = new byte[msg.readableBytes()];
        msg.readBytes(req);
        final StringBuilder hex = new StringBuilder(2 * req.length);

        for (int i = 0; i < req.length; i++) {
            byte b = req[i];
            hex.append(HEXES.charAt((b & 0xF0) >> 4))
                    .append(HEXES.charAt((b & 0x0F)));
        }
        out.add(hex.toString());
    }
}
