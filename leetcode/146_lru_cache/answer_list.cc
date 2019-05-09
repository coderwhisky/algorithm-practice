/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.
* File Name : answer_list.cc
* Purpose :
* Creation Date : 2019-02-13 11:23:09
* Last Modified : 2019-02-13 13:04:08
* Created By : chenjiang
* Modified By : chenjiang
_._._._._._._._._._._._._._._._._._._._._.*/


struct {
    
};


class LRUCache {
private:
    int _capacity = 0;
    unordered_map<int, list<CacheEntry>::iterator> m_map;
    list<CacheEntry> m_lru_cache;

    void MoveToHead(int key) {
        auto updateEntry = *m_map[key];
        m_lru_cache.erase(m_map[key]);
        m_lru_cache.push_front(updateEntry);
        m_map[key] = m_lru_cache.begin();
    }


public:
    struct CacheEntry {
        int key;
        int value;
        CacheEntry(int k, int v): key(k), value(v){}
    };

    LRUCache(int capacity) {
        _capacity = capacity;
    }
    
    int get(int key) {
        if (m_map.find(key) == m_map.end()) {
            return -1;
        }

        MoveToHead(key);
        return m_map[key]->value;
        
    }
    
    void put(int key, int value) {
        if (m_map.find(key) == m_map.end()) {
            CacheEntry newItem(key, value);
            if (m_lru_cache.size() >= _capacity) {
                // remove from tail
                m_map.erase(m_lru_cache.back().key);
                m_lru_cache.pop_back();
            }
            m_lru_cache.push_front(newItem);
            m_map[key] = m_lru_cache.begin();
            return;
        }
        m_map[key]->value = value;
        MoveToHead(key);
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

int main() {
}


