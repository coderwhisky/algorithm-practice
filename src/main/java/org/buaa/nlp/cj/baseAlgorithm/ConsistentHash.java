package org.buaa.nlp.cj.baseAlgorithm;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 一致性 hash 算法
 * Created by Administrator on 2015/10/26.
 */
public class ConsistentHash<S> { // S类封装了机器节点的信息 ，如name、password、ip、port等
//    class ShareNode {
//        String name;
//        String passwd;
//        String ip;
//        int port;
//    }
    private TreeMap<Long, S> virtualNodes; // 虚拟节点
    private List<S> shards; // 真实机器节点
    private final int NODE_NUM = 100; // 每个机器节点关联的虚拟节点个数

    /**
     * // 初始化一致性hash环
     */
    private void init() {
        virtualNodes = new TreeMap<Long, S>();
        // 每个真实机器节点都需要关联虚拟节点
        for (int i = 0; i < shards.size(); i++) {
            final S shardInfo = shards.get(i);
            // 一个真实机器节点关联NODE_NUM个虚拟节点，最后共有 NODE_NUM*shards.size() 个虚拟节点
            for (int n = 0; n < NODE_NUM; n++) {
                virtualNodes.put(hash("SHARD-" + i + "NODE-" + n), shardInfo);
            }
        }
    }

    /**
     * 获得数据的存储节点
     * @param key
     * @return
     */
    public S getShardInfo(String key) {
        // 沿环的顺时针找到一个虚拟节点
        SortedMap<Long, S> tail = virtualNodes.tailMap(hash(key));
        if (tail.size() == 0) {
            return virtualNodes.get(virtualNodes.firstKey());
        }
        // 返回该虚拟节点对应的真实机器节点的信息
        return tail.get(tail.firstKey());
    }


    /**
     *  MurMurHash算法，是非加密HASH算法，性能很高，
     *  比传统的CRC32,MD5，SHA-1（这两个算法都是加密HASH算法，复杂度本身就很高，带来的性能上的损害也不可避免）
     *  等HASH算法要快很多，而且据说这个算法的碰撞率很低.
     *  http://murmurhash.googlepages.com/
     */
    private Long hash(String key) {

        ByteBuffer buf = ByteBuffer.wrap(key.getBytes());
        int seed = 0x1234ABCD;

        ByteOrder byteOrder = buf.order();
        buf.order(ByteOrder.LITTLE_ENDIAN);

        long m = 0xc6a4a7935bd1e995L;
        int r = 47;

        long h = seed ^ (buf.remaining() * m);

        long k;
        while (buf.remaining() >= 8) {
            k = buf.getLong();

            k *= m;
            k ^= k >>> r;
            k *= m;

            h ^= k;
            h *= m;
        }

        if (buf.remaining() > 0) {
            ByteBuffer finish = ByteBuffer.allocate(8).order(
                    ByteOrder.LITTLE_ENDIAN);
            // for big-endian version, do this first:
            // finish.position(8-buf.remaining());
            finish.put(buf).rewind();
            h ^= finish.getLong();
            h *= m;
        }

        h ^= h >>> r;
        h *= m;
        h ^= h >>> r;

        buf.order(byteOrder);
        return h;
    }

}
