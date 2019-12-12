package com.hyb.algorithm.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.Date;


/**
 * Netty4 客户端代码
 *
 */

public class HelloWorldClient{
    public static void main(String[] args) {
        //Bootstrap,且构造函数变化很大，这里用无参构造。
        Bootstrap bootstrap=new Bootstrap();
        //指定channel【通道】类型
        bootstrap.channel(NioSocketChannel.class);
        //指定Handler [操纵者]
        bootstrap.handler(new ChannelInitializer<Channel>() {

            @Override
            protected  void initChannel(Channel ch) throws Exception{
                ChannelPipeline pipeline=ch.pipeline();

                 //必须和服务端对应上。否则无法正常解码和编码
                pipeline.addLast("framer",new DelimiterBasedFrameDecoder(8192,
                        Delimiters.lineDelimiter()));

                pipeline.addLast("decoder",new StringDecoder());
                pipeline.addLast("encoder",new StringEncoder());

                //客户端的逻辑，自己对数据处理
                pipeline.addLast(new HelloClientHandler());
            }
        });

        // 指定EventLoopGroup [事件 组]
        bootstrap.group(new NioEventLoopGroup());

        //连接到本地8080 端口的服务端
        bootstrap.connect(new InetSocketAddress("127.0.0.1",8000));
    }


    /***
     * 客户端的逻辑，自己对数据处理
     */
    private static  class  HelloClientHandler extends  ChannelInboundHandlerAdapter{

        //监听 服务器 发送来的数据
        @Override
        public void channelRead(ChannelHandlerContext ctx,Object msg) throws Exception{

            System.out.println("Server say:"+msg.toString());
        }

        // 启动客户端时触发
        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception{
            System.out.println("Client active ");
            ctx.writeAndFlush("我是 client "+new Date()+"\n");
            super.channelActive(ctx);
        }

        //关闭 客户端 触发
        @Override
        public void channelInactive(ChannelHandlerContext ctx) throws  Exception{
            System.out.println("Client close");
            super.channelInactive(ctx);
        }
    }
}


