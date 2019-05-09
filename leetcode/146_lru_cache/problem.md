Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 ); /* capacity */ 

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4


## 链表解决思路
    * 链表实现LRU缓存算法：维护一个有序单链表，越靠近链表末尾的节点是越早之前访问的。当有一个新的数据被访问时，从链表头开始顺序遍历链表
            1. 如果数据之前已经被缓存在链表中，我们遍历得到这个数据对应的节点，并将其从原来的位置删除，然后再插入到链表的头部
            2. 如果此数据不在缓存链表中，又可以分为两种情况：
                2.1. 此时缓存未满，则将此结点直接插入到链表的头部；
                2.2. 如果此时缓存已满，则链表尾部结点删除，将新的数据结点插入链表的头部
            note: 加入**散列表**可以降LRU访问的时间复杂度由O(n)优化到O(1)

