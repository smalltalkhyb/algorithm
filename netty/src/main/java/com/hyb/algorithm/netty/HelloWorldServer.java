package com.hyb.algorithm.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetAddress;


/**
 * Netty4 服务端代码
 * <p>
 * https://www.cnblogs.com/lemon-flm/p/7813484.html
 */

public class HelloWorldServer {

    public static void main(String[] args) {
        //EventLoop 代替原来的ChannelFactory
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {

            //创建一个netty 服务器
            ServerBootstrap serverBootstrap = new ServerBootstrap();

            // server端采用简洁的连写方式，client端才用分段普通写法。
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class) //// 指定channel[通道]类型
                    .childHandler(new ChannelInitializer<SocketChannel>() {  //指定Handler [操纵者]

                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            //以("\n") 为结尾分割的解码器
                            ch.pipeline().addLast("framer", new DelimiterBasedFrameDecoder(8192,
                                    Delimiters.lineDelimiter()));

                            //字符串解码和编码默认的StringDecoder 字符串形式输出
                            ch.pipeline().addLast("decoder", new StringDecoder());
                            ch.pipeline().addLast("encoder", new StringEncoder());

                            ch.pipeline().addLast(new HelloServerHandler()); //添加自己的对 上传数据的处理
                        }
                    }).option(ChannelOption.SO_KEEPALIVE, true);


            ChannelFuture f = serverBootstrap.bind(8000).sync(); // 绑定 8000 端口
            f.channel().closeFuture().sync();

        } catch (Exception e) {

        } finally {
            workerGroup.shutdownGracefully(); //销毁netty
            bossGroup.shutdownGracefully();
        }
    }

    /**
     * 自己对 处理数据
     */
    private static class HelloServerHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            //收到消息直接打印输出
            System.out.println(ctx.channel().remoteAddress() + "Say:" + msg);

            //返回客户端消息 --我已经接收到了你的消息
            ctx.writeAndFlush("server Received your message! \n");
        }


        /***
         *
         *  覆盖channelActive 方法 在channel 被启用的时候触发（在建立连接的时候）
         *
         *  channelActive 和channelInActive 在后面的内容中讲述，这里先不做详细的描述
         * */
        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {

            System.out.println("RemoteAddress:" + ctx.channel().remoteAddress() + " active!");
            ctx.writeAndFlush("Welcome to " + InetAddress.getLocalHost().getHostName() + " service!\n");//回复

            super.channelActive(ctx);
        }
    }
}

