package com.concurrent.demo.lock.redislock.redisoper.jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.params.sortedset.ZAddParams;
import redis.clients.jedis.params.sortedset.ZIncrByParams;
import redis.clients.jedis.BitOP;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.Tuple;
import redis.clients.jedis.ZParams;

@Service("JedisClient")
public class JedisClient implements IJedisClient {

    private static Logger logger = LoggerFactory.getLogger(JedisClient.class);

    @Autowired
    private JedisPool redisPoolFactory;

    public JedisPool getJedisPool() {
        return redisPoolFactory;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.redisPoolFactory = jedisPool;
    }

    public Jedis getResource(){
        if(this.redisPoolFactory == null){
            throw new RuntimeException("Jedis连接池未初始化");
        }
        return this.redisPoolFactory.getResource();
    }

    @Deprecated
    @Override
    public Set<byte[]> keys(byte[] pattern){
        Set<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.keys(pattern);
        }catch(Exception e){
            logger.error("[异常]keys[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Deprecated
    @Override
    public Set<String> keys(String pattern){
        Set<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.keys(pattern);
        }catch(Exception e){
            logger.error("[异常]keys[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public ScanResult<byte[]> scan(byte[] cursor){
        ScanResult<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.scan(cursor);
        }catch(Exception e){
            logger.error("[异常]scan[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public ScanResult<byte[]> scan(byte[] cursor, ScanParams params){
        ScanResult<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.scan(cursor, params);
        }catch(Exception e){
            logger.error("[异常]scan[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Deprecated
    @Override
    public ScanResult<String> scan(int cursor){
        ScanResult<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.scan(cursor);
        }catch(Exception e){
            logger.error("[异常]scan[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Deprecated
    @Override
    public ScanResult<String> scan(int cursor, ScanParams params){
        ScanResult<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.scan(cursor, params);
        }catch(Exception e){
            logger.error("[异常]scan[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public ScanResult<String> scan(String cursor){
        ScanResult<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.scan(cursor);
        }catch(Exception e){
            logger.error("[异常]scan[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public ScanResult<String> scan(String cursor, ScanParams params){
        ScanResult<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.scan(cursor, params);
        }catch(Exception e){
            logger.error("[异常]scan[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long dbSize(){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.dbSize();
        }catch(Exception e){
            logger.error("[异常]dbSize[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Boolean exists(byte[] key){
        Boolean result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.exists(key);
        }catch(Exception e){
            logger.error("[异常]exists[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long exists(byte[]... keys){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.exists(keys);
        }catch(Exception e){
            logger.error("[异常]exists[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Boolean exists(String key){
        Boolean result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.exists(key);
        }catch(Exception e){
            logger.error("[异常]exists[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long exists(String... keys){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.exists(keys);
        }catch(Exception e){
            logger.error("[异常]exists[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String type(byte[] key){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.type(key);
        }catch(Exception e){
            logger.error("[异常]type[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String type(String key){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.type(key);
        }catch(Exception e){
            logger.error("[异常]type[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public byte[] objectEncoding(byte[] key){
        byte[] result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.objectEncoding(key);
        }catch(Exception e){
            logger.error("[异常]objectEncoding[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String objectEncoding(String key){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.objectEncoding(key);
        }catch(Exception e){
            logger.error("[异常]objectEncoding[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public List<byte[]> sort(byte[] key){
        List<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sort(key);
        }catch(Exception e){
            logger.error("[异常]sort[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public List<String> sort(String key){
        List<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sort(key);
        }catch(Exception e){
            logger.error("[异常]sort[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public List<byte[]> sort(byte[] key, SortingParams sortingParameters){
        List<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sort(key, sortingParameters);
        }catch(Exception e){
            logger.error("[异常]sort[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public List<String> sort(String key, SortingParams sortingParameters){
        List<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sort(key, sortingParameters);
        }catch(Exception e){
            logger.error("[异常]sort[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long sort(byte[] key, byte[] dstkey){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sort(key, dstkey);
        }catch(Exception e){
            logger.error("[异常]sort[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long sort(String key, String dstkey){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sort(key, dstkey);
        }catch(Exception e){
            logger.error("[异常]sort[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long sort(byte[] key, SortingParams sortingParameters, byte[] dstkey){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sort(key, sortingParameters, dstkey);
        }catch(Exception e){
            logger.error("[异常]sort[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long sort(String key, SortingParams sortingParameters, String dstkey){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sort(key, sortingParameters, dstkey);
        }catch(Exception e){
            logger.error("[异常]sort[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String rename(byte[] oldkey, byte[] newkey){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.rename(oldkey, newkey);
        }catch(Exception e){
            logger.error("[异常]rename[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String rename(String oldkey, String newkey){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.rename(oldkey, newkey);
        }catch(Exception e){
            logger.error("[异常]rename[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long renamenx(byte[] oldkey, byte[] newkey){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.renamenx(oldkey, newkey);
        }catch(Exception e){
            logger.error("[异常]renamenx[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long renamenx(String oldkey, String newkey){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.renamenx(oldkey, newkey);
        }catch(Exception e){
            logger.error("[异常]renamenx[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String randomKey(byte[] oldkey, byte[] newkey){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.randomKey();
        }catch(Exception e){
            logger.error("[异常]randomKey[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String select(int dbIndex){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.select(dbIndex);
        }catch(Exception e){
            logger.error("[异常]select[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long move(byte[] key, int dbIndex){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.move(key, dbIndex);
        }catch(Exception e){
            logger.error("[异常]move[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long move(String key, int dbIndex){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.move(key, dbIndex);
        }catch(Exception e){
            logger.error("[异常]move[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public byte[] dump(byte[] key){
        byte[] result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.dump(key);
        }catch(Exception e){
            logger.error("[异常]dump[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public byte[] dump(String key){
        byte[] result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.dump(key);
        }catch(Exception e){
            logger.error("[异常]dump[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String restore(byte[] key, int ttl, byte[] serializedValue){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.restore(key, ttl, serializedValue);
        }catch(Exception e){
            logger.error("[异常]restore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String restore(String key, int ttl, byte[] serializedValue){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.restore(key, ttl, serializedValue);
        }catch(Exception e){
            logger.error("[异常]restore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String migrate(byte[] host, int port, byte[] key, int destinationDb, int timeout){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.migrate(host, port, key, destinationDb, timeout);
        }catch(Exception e){
            logger.error("[异常]migrate[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String migrate(String host, int port, String key, int destinationDb, int timeout){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.migrate(host, port, key, destinationDb, timeout);
        }catch(Exception e){
            logger.error("[异常]migrate[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long del(byte[] key){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.del(key);
        }catch(Exception e){
            logger.error("[异常]del[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long del(byte[]... keys){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.del(keys);
        }catch(Exception e){
            logger.error("[异常]del[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long del(String key){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.del(key);
        }catch(Exception e){
            logger.error("[异常]del[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long del(String... keys){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.del(keys);
        }catch(Exception e){
            logger.error("[异常]del[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long expire(byte[] key, int seconds){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.expire(key, seconds);
        }catch(Exception e){
            logger.error("[异常]expire[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long expire(String key, int seconds){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.expire(key, seconds);
        }catch(Exception e){
            logger.error("[异常]expire[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Deprecated
    @Override
    public Long pexpire(byte[] key, int milliseconds){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.pexpire(key, milliseconds);
        }catch(Exception e){
            logger.error("[异常]pexpire[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Deprecated
    @Override
    public Long pexpire(String key, int milliseconds){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.pexpire(key, milliseconds);
        }catch(Exception e){
            logger.error("[异常]pexpire[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long expireAt(byte[] key, long unixTime){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.expireAt(key, unixTime);
        }catch(Exception e){
            logger.error("[异常]expireAt[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long expireAt(String key, long unixTime){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.expireAt(key, unixTime);
        }catch(Exception e){
            logger.error("[异常]expireAt[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long pexpireAt(byte[] key, long millisecondsTimestamp){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.pexpireAt(key, millisecondsTimestamp);
        }catch(Exception e){
            logger.error("[异常]pexpireAt[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long pexpireAt(String key, long millisecondsTimestamp){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.pexpireAt(key, millisecondsTimestamp);
        }catch(Exception e){
            logger.error("[异常]pexpireAt[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long ttl(byte[] key){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.ttl(key);
        }catch(Exception e){
            logger.error("[异常]ttl[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long ttl(String key){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.ttl(key);
        }catch(Exception e){
            logger.error("[异常]ttl[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long pttl(byte[] key){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.pttl(key);
        }catch(Exception e){
            logger.error("[异常]pttl[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long pttl(String key){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.pttl(key);
        }catch(Exception e){
            logger.error("[异常]pttl[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long persist(byte[] key){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.persist(key);
        }catch(Exception e){
            logger.error("[异常]persist[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long persist(String key){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.persist(key);
        }catch(Exception e){
            logger.error("[异常]persist[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String set(byte[] key, byte[] value){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.set(key, value);
        }catch(Exception e){
            logger.error("[异常]set[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String set(byte[] key, byte[] value, byte[] nxxx){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.set(key, value, nxxx);
        }catch(Exception e){
            logger.error("[异常]set[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String set(byte[] key, byte[] value, byte[] nxxx, byte[] expx, int time){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.set(key, value, nxxx, expx, time);
        }catch(Exception e){
            logger.error("[异常]set[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String set(byte[] key, byte[] value, byte[] nxxx, byte[] expx, long time){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.set(key, value, nxxx, expx, time);
        }catch(Exception e){
            logger.error("[异常]set[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String set(String key, String value){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.set(key, value);
        }catch(Exception e){
            logger.error("[异常]set[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String set(String key, String value, String nxxx){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.set(key, value, nxxx);
        }catch(Exception e){
            logger.error("[异常]set[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String set(String key, String value, String nxxx, String expx, int time){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.set(key, value, nxxx, expx, time);
        }catch(Exception e){
            logger.error("[异常]set[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String set(String key, String value, String nxxx, String expx, long time){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.set(key, value, nxxx, expx, time);
        }catch(Exception e){
            logger.error("[异常]set[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String setex(byte[] key, int seconds, byte[] value){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.setex(key, seconds, value);
        }catch(Exception e){
            logger.error("[异常]setex[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String setex(String key, int seconds, String value){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.setex(key, seconds, value);
        }catch(Exception e){
            logger.error("[异常]setex[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String psetex(byte[] key, long milliseconds, byte[] value){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.psetex(key, milliseconds, value);
        }catch(Exception e){
            logger.error("[异常]psetex[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String psetex(String key, long milliseconds, String value){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.psetex(key, milliseconds, value);
        }catch(Exception e){
            logger.error("[异常]psetex[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long setnx(byte[] key, byte[] value){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.setnx(key, value);
        }catch(Exception e){
            logger.error("[异常]setnx[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long setnx(String key, String value){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.setnx(key, value);
        }catch(Exception e){
            logger.error("[异常]setnx[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Boolean setbit(byte[] key, long offset, byte[] value){
        Boolean result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.setbit(key, offset, value);
        }catch(Exception e){
            logger.error("[异常]setbit[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Boolean setbit(byte[] key, long offset, boolean value){
        Boolean result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.setbit(key, offset, value);
        }catch(Exception e){
            logger.error("[异常]setbit[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Boolean setbit(String key, long offset, String value){
        Boolean result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.setbit(key, offset, value);
        }catch(Exception e){
            logger.error("[异常]setbit[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Boolean setbit(String key, long offset, boolean value){
        Boolean result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.setbit(key, offset, value);
        }catch(Exception e){
            logger.error("[异常]setbit[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public byte[] get(byte[] key){
        byte[] result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.get(key);
        }catch(Exception e){
            logger.error("[异常]get[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String get(String key){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.get(key);
        }catch(Exception e){
            logger.error("[异常]get[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String mset(byte[]... keysvalues){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.mset(keysvalues);
        }catch(Exception e){
            logger.error("[异常]mset[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String mset(String... keysvalues){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.mset(keysvalues);
        }catch(Exception e){
            logger.error("[异常]mset[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long msetnx(byte[]... keysvalues){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.msetnx(keysvalues);
        }catch(Exception e){
            logger.error("[异常]msetnx[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long msetnx(String... keysvalues){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.msetnx(keysvalues);
        }catch(Exception e){
            logger.error("[异常]msetnx[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public List<byte[]> mget(byte[]... keys){
        List<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.mget(keys);
        }catch(Exception e){
            logger.error("[异常]mget[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public List<String> mget(String... keys){
        List<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.mget(keys);
        }catch(Exception e){
            logger.error("[异常]mget[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Boolean getbit(byte[] key, long offset){
        Boolean result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.getbit(key, offset);
        }catch(Exception e){
            logger.error("[异常]getbit[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Boolean getbit(String key, long offset){
        Boolean result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.getbit(key, offset);
        }catch(Exception e){
            logger.error("[异常]getbit[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long incr(byte[] key){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.incr(key);
        }catch(Exception e){
            logger.error("[异常]incr[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long incr(String key){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.incr(key);
        }catch(Exception e){
            logger.error("[异常]incr[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long decr(byte[] key){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.decr(key);
        }catch(Exception e){
            logger.error("[异常]decr[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long decr(String key){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.decr(key);
        }catch(Exception e){
            logger.error("[异常]decr[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long incrBy(byte[] key, long increment){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.incrBy(key, increment);
        }catch(Exception e){
            logger.error("[异常]incrBy[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long incrBy(String key, long increment){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.incrBy(key, increment);
        }catch(Exception e){
            logger.error("[异常]incrBy[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long decrBy(byte[] key, long increment){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.decrBy(key, increment);
        }catch(Exception e){
            logger.error("[异常]decrBy[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long decrBy(String key, long increment){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.decrBy(key, increment);
        }catch(Exception e){
            logger.error("[异常]decrBy[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Double incrByFloat(byte[] key, double increment){
        Double result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.incrByFloat(key, increment);
        }catch(Exception e){
            logger.error("[异常]incrByFloat[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Double incrByFloat(String key, double increment){
        Double result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.incrByFloat(key, increment);
        }catch(Exception e){
            logger.error("[异常]incrByFloat[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long append(byte[] key, byte[] value){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.append(key, value);
        }catch(Exception e){
            logger.error("[异常]append[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long append(String key, String value){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.append(key, value);
        }catch(Exception e){
            logger.error("[异常]append[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long strlen(byte[] key){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.strlen(key);
        }catch(Exception e){
            logger.error("[异常]strlen[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long strlen(String key){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.strlen(key);
        }catch(Exception e){
            logger.error("[异常]strlen[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public byte[] getSet(byte[] key, byte[] value){
        byte[] result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.getSet(key, value);
        }catch(Exception e){
            logger.error("[异常]getSet[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String getSet(String key, String value){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.getSet(key, value);
        }catch(Exception e){
            logger.error("[异常]getSet[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long setrange(byte[] key, long offset, byte[] value){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.setrange(key, offset, value);
        }catch(Exception e){
            logger.error("[异常]setrange[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long setrange(String key, long offset, String value){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.setrange(key, offset, value);
        }catch(Exception e){
            logger.error("[异常]setrange[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public byte[] getrange(byte[] key, long startOffset, long endOffset){
        byte[] result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.getrange(key, startOffset, endOffset);
        }catch(Exception e){
            logger.error("[异常]getrange[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String getrange(String key, long startOffset, long endOffset){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.getrange(key, startOffset, endOffset);
        }catch(Exception e){
            logger.error("[异常]getrange[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long bitcount(byte[] key){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.bitcount(key);
        }catch(Exception e){
            logger.error("[异常]bitcount[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long bitcount(String key){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.bitcount(key);
        }catch(Exception e){
            logger.error("[异常]bitcount[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long bitcount(byte[] key, long start, long end){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.bitcount(key, start, end);
        }catch(Exception e){
            logger.error("[异常]bitcount[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long bitcount(String key, long start, long end){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.bitcount(key, start, end);
        }catch(Exception e){
            logger.error("[异常]bitcount[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long bitop(BitOP op, byte[] destKey, byte[]... srcKeys){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.bitop(op, destKey, srcKeys);
        }catch(Exception e){
            logger.error("[异常]bitop[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long bitop(BitOP op, String destKey, String... srcKeys){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.bitop(op, destKey, srcKeys);
        }catch(Exception e){
            logger.error("[异常]bitop[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long hset(byte[] key, byte[] field, byte[] value){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hset(key, field, value);
        }catch(Exception e){
            logger.error("[异常]hset[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long hset(String key, String field, String value){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hset(key, field, value);
        }catch(Exception e){
            logger.error("[异常]hset[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long hsetnx(byte[] key, byte[] field, byte[] value){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hsetnx(key, field, value);
        }catch(Exception e){
            logger.error("[异常]hsetnx[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long hsetnx(String key, String field, String value){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hsetnx(key, field, value);
        }catch(Exception e){
            logger.error("[异常]hsetnx[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public byte[] hget(byte[] key, byte[] field){
        byte[] result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hget(key, field);
        }catch(Exception e){
            logger.error("[异常]hget[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String hget(String key, String field){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hget(key, field);
        }catch(Exception e){
            logger.error("[异常]hget[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long hdel(byte[] key, byte[]... fields){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hdel(key, fields);
        }catch(Exception e){
            logger.error("[异常]hdel[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long hdel(String key, String... fields){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hdel(key, fields);
        }catch(Exception e){
            logger.error("[异常]hdel[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long hlen(byte[] key){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hlen(key);
        }catch(Exception e){
            logger.error("[异常]hlen[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long hlen(String key){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hlen(key);
        }catch(Exception e){
            logger.error("[异常]hlen[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String hmset(byte[] key, Map<byte[], byte[]> hash){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hmset(key, hash);
        }catch(Exception e){
            logger.error("[异常]hmset[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String hmset(String key, Map<String, String> hash){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hmset(key, hash);
        }catch(Exception e){
            logger.error("[异常]hmset[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public List<byte[]> hmget(byte[] key, byte[]... fields){
        List<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hmget(key, fields);
        }catch(Exception e){
            logger.error("[异常]hmget[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public List<String> hmget(String key, String... fields){
        List<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hmget(key, fields);
        }catch(Exception e){
            logger.error("[异常]hmget[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Boolean hexists(byte[] key, byte[] field){
        Boolean result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hexists(key, field);
        }catch(Exception e){
            logger.error("[异常]hexists[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Boolean hexists(String key, String field){
        Boolean result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hexists(key, field);
        }catch(Exception e){
            logger.error("[异常]hexists[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<byte[]> hkeys(byte[] key){
        Set<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hkeys(key);
        }catch(Exception e){
            logger.error("[异常]hkeys[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<String> hkeys(String key){
        Set<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hkeys(key);
        }catch(Exception e){
            logger.error("[异常]hkeys[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public List<byte[]> hvals(byte[] key){
        List<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hvals(key);
        }catch(Exception e){
            logger.error("[异常]hvals[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public List<String> hvals(String key){
        List<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hvals(key);
        }catch(Exception e){
            logger.error("[异常]hvals[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Map<byte[], byte[]> hgetAll(byte[] key){
        Map<byte[], byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hgetAll(key);
        }catch(Exception e){
            logger.error("[异常]hgetAll[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Map<String, String> hgetAll(String key){
        Map<String, String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hgetAll(key);
        }catch(Exception e){
            logger.error("[异常]hgetAll[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long hincrBy(byte[] key, byte[] field, long value){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hincrBy(key, field, value);
        }catch(Exception e){
            logger.error("[异常]hincrBy[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long hincrBy(String key, String field, long value){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hincrBy(key, field, value);
        }catch(Exception e){
            logger.error("[异常]hincrBy[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Double hincrByFloat(byte[] key, byte[] field, double value){
        Double result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hincrByFloat(key, field, value);
        }catch(Exception e){
            logger.error("[异常]hincrByFloat[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Double hincrByFloat(String key, String field, double value){
        Double result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hincrByFloat(key, field, value);
        }catch(Exception e){
            logger.error("[异常]hincrByFloat[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public ScanResult<Map.Entry<byte[], byte[]>> hscan(byte[] key, byte[] cursor){
        ScanResult<Map.Entry<byte[], byte[]>> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hscan(key, cursor);
        }catch(Exception e){
            logger.error("[异常]hscan[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Deprecated
    @Override
    public ScanResult<Map.Entry<String, String>> hscan(String key, int cursor){
        ScanResult<Map.Entry<String, String>> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hscan(key, cursor);
        }catch(Exception e){
            logger.error("[异常]hscan[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public ScanResult<Map.Entry<String, String>> hscan(String key, String cursor){
        ScanResult<Map.Entry<String, String>> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hscan(key, cursor);
        }catch(Exception e){
            logger.error("[异常]hscan[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public ScanResult<Map.Entry<byte[], byte[]>> hscan(byte[] key, byte[] cursor, ScanParams params){
        ScanResult<Map.Entry<byte[], byte[]>> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hscan(key, cursor, params);
        }catch(Exception e){
            logger.error("[异常]hscan[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Deprecated
    @Override
    public ScanResult<Map.Entry<String, String>> hscan(String key, int cursor, ScanParams params){
        ScanResult<Map.Entry<String, String>> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hscan(key, cursor, params);
        }catch(Exception e){
            logger.error("[异常]hscan[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public ScanResult<Map.Entry<String, String>> hscan(String key, String cursor, ScanParams params){
        ScanResult<Map.Entry<String, String>> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.hscan(key, cursor, params);
        }catch(Exception e){
            logger.error("[异常]hscan[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long rpush(byte[] key, byte[]... strings){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.rpush(key, strings);
        }catch(Exception e){
            logger.error("[异常]rpush[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long rpush(String key, String... strings){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.rpush(key, strings);
        }catch(Exception e){
            logger.error("[异常]rpush[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long rpushx(byte[] key, byte[]... strings){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.rpushx(key, strings);
        }catch(Exception e){
            logger.error("[异常]rpushx[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long rpushx(String key, String... strings){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.rpushx(key, strings);
        }catch(Exception e){
            logger.error("[异常]rpushx[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long lpush(byte[] key, byte[]... strings){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.lpush(key, strings);
        }catch(Exception e){
            logger.error("[异常]lpush[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long lpush(String key, String... strings){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.lpush(key, strings);
        }catch(Exception e){
            logger.error("[异常]lpush[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long lpushx(byte[] key, byte[]... strings){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.lpushx(key, strings);
        }catch(Exception e){
            logger.error("[异常]lpushx[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long lpushx(String key, String... strings){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.lpushx(key, strings);
        }catch(Exception e){
            logger.error("[异常]lpushx[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long linsert(byte[] key, LIST_POSITION where, byte[] pivot, byte[] value){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.linsert(key, where, pivot, value);
        }catch(Exception e){
            logger.error("[异常]linsert[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long linsert(String key, LIST_POSITION where, String pivot, String value){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.linsert(key, where, pivot, value);
        }catch(Exception e){
            logger.error("[异常]linsert[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public List<byte[]> lrange(byte[] key, long start, long end){
        List<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.lrange(key, start, end);
        }catch(Exception e){
            logger.error("[异常]lrange[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public List<String> lrange(String key, long start, long end){
        List<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.lrange(key, start, end);
        }catch(Exception e){
            logger.error("[异常]lrange[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public byte[] lindex(byte[] key, long index){
        byte[] result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.lindex(key, index);
        }catch(Exception e){
            logger.error("[异常]lindex[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String lindex(String key, long index){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.lindex(key, index);
        }catch(Exception e){
            logger.error("[异常]lindex[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long llen(byte[] key){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.llen(key);
        }catch(Exception e){
            logger.error("[异常]llen[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long llen(String key){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.llen(key);
        }catch(Exception e){
            logger.error("[异常]llen[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public byte[] lpop(byte[] key){
        byte[] result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.lpop(key);
        }catch(Exception e){
            logger.error("[异常]lpop[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String lpop(String key){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.lpop(key);
        }catch(Exception e){
            logger.error("[异常]lpop[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public byte[] rpop(byte[] key){
        byte[] result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.rpop(key);
        }catch(Exception e){
            logger.error("[异常]rpop[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String rpop(String key){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.rpop(key);
        }catch(Exception e){
            logger.error("[异常]rpop[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long lrem(byte[] key, long count, byte[] value){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.lrem(key, count, value);
        }catch(Exception e){
            logger.error("[异常]lrem[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long lrem(String key, long count, String value){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.lrem(key, count, value);
        }catch(Exception e){
            logger.error("[异常]lrem[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String ltrim(byte[] key, long start, long end){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.ltrim(key, start, end);
        }catch(Exception e){
            logger.error("[异常]ltrim[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String ltrim(String key, long start, long end){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.ltrim(key, start, end);
        }catch(Exception e){
            logger.error("[异常]ltrim[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String lset(byte[] key, long index, byte[] value){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.lset(key, index, value);
        }catch(Exception e){
            logger.error("[异常]lset[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String lset(String key, long index, String value){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.lset(key, index, value);
        }catch(Exception e){
            logger.error("[异常]lset[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Deprecated
    @Override
    public List<byte[]> blpop(byte[] key){
        List<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.blpop(key);
        }catch(Exception e){
            logger.error("[异常]blpop[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Deprecated
    @Override
    public List<String> blpop(String key){
        List<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.blpop(key);
        }catch(Exception e){
            logger.error("[异常]blpop[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public List<byte[]> blpop(byte[]... keys){
        List<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.blpop(keys);
        }catch(Exception e){
            logger.error("[异常]blpop[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public List<String> blpop(String... key){
        List<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.blpop(key);
        }catch(Exception e){
            logger.error("[异常]blpop[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public List<byte[]> blpop(int timeout, byte[]... keys){
        List<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.blpop(timeout, keys);
        }catch(Exception e){
            logger.error("[异常]blpop[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public List<String> blpop(int timeout, String... keys){
        List<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.blpop(timeout, keys);
        }catch(Exception e){
            logger.error("[异常]blpop[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Deprecated
    @Override
    public List<byte[]> brpop(byte[] key){
        List<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.brpop(key);
        }catch(Exception e){
            logger.error("[异常]brpop[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Deprecated
    @Override
    public List<String> brpop(String key){
        List<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.brpop(key);
        }catch(Exception e){
            logger.error("[异常]brpop[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public List<byte[]> brpop(byte[]... keys){
        List<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.brpop(keys);
        }catch(Exception e){
            logger.error("[异常]brpop[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public List<String> brpop(String... key){
        List<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.brpop(key);
        }catch(Exception e){
            logger.error("[异常]brpop[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public List<byte[]> brpop(int timeout, byte[]... keys){
        List<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.brpop(timeout, keys);
        }catch(Exception e){
            logger.error("[异常]brpop[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public List<String> brpop(int timeout, String... keys){
        List<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.brpop(timeout, keys);
        }catch(Exception e){
            logger.error("[异常]brpop[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public byte[] rpoplpush(byte[] srckey, byte[] dstkey){
        byte[] result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.rpoplpush(srckey, dstkey);
        }catch(Exception e){
            logger.error("[异常]rpoplpush[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String rpoplpush(String srckey, String dstkey){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.rpoplpush(srckey, dstkey);
        }catch(Exception e){
            logger.error("[异常]rpoplpush[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public byte[] brpoplpush(byte[] source, byte[] destination, int timeout){
        byte[] result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.brpoplpush(source, destination, timeout);
        }catch(Exception e){
            logger.error("[异常]brpoplpush[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String brpoplpush(String source, String destination, int timeout){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.brpoplpush(source, destination, timeout);
        }catch(Exception e){
            logger.error("[异常]brpoplpush[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long sadd(byte[] key, byte[]... members){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sadd(key, members);
        }catch(Exception e){
            logger.error("[异常]sadd[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long sadd(String key, String... members){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sadd(key, members);
        }catch(Exception e){
            logger.error("[异常]sadd[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long scard(byte[] key){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.scard(key);
        }catch(Exception e){
            logger.error("[异常]scard[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long scard(String key){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.scard(key);
        }catch(Exception e){
            logger.error("[异常]scard[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<byte[]> sdiff(byte[]... keys){
        Set<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sdiff(keys);
        }catch(Exception e){
            logger.error("[异常]sdiff[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<String> sdiff(String... keys){
        Set<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sdiff(keys);
        }catch(Exception e){
            logger.error("[异常]sdiff[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long sdiffstore(byte[] dstkey, byte[]... keys){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sdiffstore(dstkey, keys);
        }catch(Exception e){
            logger.error("[异常]sdiffstore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long sdiffstore(String dstkey, String... keys){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sdiffstore(dstkey, keys);
        }catch(Exception e){
            logger.error("[异常]sdiffstore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<byte[]> sinter(byte[]... keys){
        Set<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sinter(keys);
        }catch(Exception e){
            logger.error("[异常]sinter[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<String> sinter(String... keys){
        Set<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sinter(keys);
        }catch(Exception e){
            logger.error("[异常]sinter[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long sinterstore(byte[] dstkey, byte[]... keys){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sinterstore(dstkey, keys);
        }catch(Exception e){
            logger.error("[异常]sinterstore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long sinterstore(String dstkey, String... keys){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sinterstore(dstkey, keys);
        }catch(Exception e){
            logger.error("[异常]sinterstore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Boolean sismember(byte[] key, byte[] member){
        Boolean result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sismember(key, member);
        }catch(Exception e){
            logger.error("[异常]sismember[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Boolean sismember(String key, String member){
        Boolean result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sismember(key, member);
        }catch(Exception e){
            logger.error("[异常]sismember[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<byte[]> smembers(byte[] key){
        Set<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.smembers(key);
        }catch(Exception e){
            logger.error("[异常]smembers[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<String> smembers(String key){
        Set<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.smembers(key);
        }catch(Exception e){
            logger.error("[异常]smembers[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long smove(byte[] srckey, byte[] dstkey, byte[] member){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.smove(srckey, dstkey, member);
        }catch(Exception e){
            logger.error("[异常]smove[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long smove(String srckey, String dstkey, String member){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.smove(srckey, dstkey, member);
        }catch(Exception e){
            logger.error("[异常]smove[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public byte[] spop(byte[] key){
        byte[] result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.spop(key);
        }catch(Exception e){
            logger.error("[异常]spop[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String spop(String key){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.spop(key);
        }catch(Exception e){
            logger.error("[异常]spop[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<byte[]> spop(byte[] key, long count){
        Set<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.spop(key, count);
        }catch(Exception e){
            logger.error("[异常]spop[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<String> spop(String key, long count){
        Set<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.spop(key, count);
        }catch(Exception e){
            logger.error("[异常]spop[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public byte[] srandmember(byte[] key){
        byte[] result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.srandmember(key);
        }catch(Exception e){
            logger.error("[异常]srandmember[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String srandmember(String key){
        String result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.srandmember(key);
        }catch(Exception e){
            logger.error("[异常]srandmember[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public List<byte[]> srandmember(byte[] key, int count){
        List<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.srandmember(key, count);
        }catch(Exception e){
            logger.error("[异常]srandmember[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public List<String> srandmember(String key, int count){
        List<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.srandmember(key, count);
        }catch(Exception e){
            logger.error("[异常]srandmember[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long srem(byte[] key, byte[]... members){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.srem(key, members);
        }catch(Exception e){
            logger.error("[异常]srem[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long srem(String key, String... members){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.srem(key, members);
        }catch(Exception e){
            logger.error("[异常]srem[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<byte[]> sunion(byte[]... keys){
        Set<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sunion(keys);
        }catch(Exception e){
            logger.error("[异常]sunion[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<String> sunion(String... keys){
        Set<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sunion(keys);
        }catch(Exception e){
            logger.error("[异常]sunion[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long sunionstore(byte[] dstkey, byte[]... keys){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sunionstore(dstkey, keys);
        }catch(Exception e){
            logger.error("[异常]sunionstore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long sunionstore(String dstkey, String... keys){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sunionstore(dstkey, keys);
        }catch(Exception e){
            logger.error("[异常]sunionstore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public ScanResult<byte[]> sscan(byte[] key, byte[] cursor){
        ScanResult<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sscan(key, cursor);
        }catch(Exception e){
            logger.error("[异常]sscan[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Deprecated
    @Override
    public ScanResult<String> sscan(String key, int cursor){
        ScanResult<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sscan(key, cursor);
        }catch(Exception e){
            logger.error("[异常]sscan[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public ScanResult<String> sscan(String key, String cursor){
        ScanResult<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sscan(key, cursor);
        }catch(Exception e){
            logger.error("[异常]sscan[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public ScanResult<byte[]> sscan(byte[] key, byte[] cursor, ScanParams params){
        ScanResult<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sscan(key, cursor, params);
        }catch(Exception e){
            logger.error("[异常]sscan[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Deprecated
    @Override
    public ScanResult<String> sscan(String key, int cursor, ScanParams params){
        ScanResult<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sscan(key, cursor, params);
        }catch(Exception e){
            logger.error("[异常]sscan[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public ScanResult<String> sscan(String key, String cursor, ScanParams params){
        ScanResult<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.sscan(key, cursor, params);
        }catch(Exception e){
            logger.error("[异常]sscan[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zadd(byte[] key, Map<byte[], Double> scoreMembers){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zadd(key, scoreMembers);
        }catch(Exception e){
            logger.error("[异常]zadd[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zadd(String key, Map<String, Double> scoreMembers){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zadd(key, scoreMembers);
        }catch(Exception e){
            logger.error("[异常]zadd[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zadd(byte[] key, double score, byte[] member){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zadd(key, score, member);
        }catch(Exception e){
            logger.error("[异常]zadd[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zadd(String key, double score, String member){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zadd(key, score, member);
        }catch(Exception e){
            logger.error("[异常]zadd[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zadd(byte[] key, Map<byte[], Double> scoreMembers, ZAddParams params){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zadd(key, scoreMembers, params);
        }catch(Exception e){
            logger.error("[异常]zadd[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zadd(String key, Map<String, Double> scoreMembers, ZAddParams params){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zadd(key, scoreMembers, params);
        }catch(Exception e){
            logger.error("[异常]zadd[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zadd(byte[] key, double score, byte[] member, ZAddParams params){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zadd(key, score, member, params);
        }catch(Exception e){
            logger.error("[异常]zadd[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zadd(String key, double score, String member, ZAddParams params){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zadd(key, score, member, params);
        }catch(Exception e){
            logger.error("[异常]zadd[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zcard(byte[] key){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zcard(key);
        }catch(Exception e){
            logger.error("[异常]zcard[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zcard(String key){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zcard(key);
        }catch(Exception e){
            logger.error("[异常]zcard[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zcount(byte[] key, byte[] min, byte[] max){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zcount(key, min, max);
        }catch(Exception e){
            logger.error("[异常]zcount[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zcount(byte[] key, double min, double max){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zcount(key, min, max);
        }catch(Exception e){
            logger.error("[异常]zcount[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zcount(String key, double min, double max){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zcount(key, min, max);
        }catch(Exception e){
            logger.error("[异常]zcount[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zcount(String key, String min, String max){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zcount(key, min, max);
        }catch(Exception e){
            logger.error("[异常]zcount[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Double zincrby(byte[] key, double score, byte[] member){
        Double result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zincrby(key, score, member);
        }catch(Exception e){
            logger.error("[异常]zincrby[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Double zincrby(String key, double score, String member){
        Double result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zincrby(key, score, member);
        }catch(Exception e){
            logger.error("[异常]zincrby[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Double zincrby(byte[] key, double score, byte[] member, ZIncrByParams params){
        Double result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zincrby(key, score, member, params);
        }catch(Exception e){
            logger.error("[异常]zincrby[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Double zincrby(String key, double score, String member, ZIncrByParams params){
        Double result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zincrby(key, score, member, params);
        }catch(Exception e){
            logger.error("[异常]zincrby[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<byte[]> zrange(byte[] key, long start, long end){
        Set<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrange(key, start, end);
        }catch(Exception e){
            logger.error("[异常]zrange[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<String> zrange(String key, long start, long end){
        Set<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrange(key, start, end);
        }catch(Exception e){
            logger.error("[异常]zrange[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<byte[]> zrangeByScore(byte[] key, byte[] min, byte[] max){
        Set<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrangeByScore(key, min, max);
        }catch(Exception e){
            logger.error("[异常]zrangeByScore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<byte[]> zrangeByScore(byte[] key, double min, double max){
        Set<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrangeByScore(key, min, max);
        }catch(Exception e){
            logger.error("[异常]zrangeByScore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<String> zrangeByScore(String key, double min, double max){
        Set<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrangeByScore(key, min, max);
        }catch(Exception e){
            logger.error("[异常]zrangeByScore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<String> zrangeByScore(String key, String min, String max){
        Set<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrangeByScore(key, min, max);
        }catch(Exception e){
            logger.error("[异常]zrangeByScore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(byte[] key, byte[] min, byte[] max){
        Set<Tuple> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrangeByScoreWithScores(key, min, max);
        }catch(Exception e){
            logger.error("[异常]zrangeByScoreWithScores[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(byte[] key, double min, double max){
        Set<Tuple> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrangeByScoreWithScores(key, min, max);
        }catch(Exception e){
            logger.error("[异常]zrangeByScoreWithScores[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max){
        Set<Tuple> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrangeByScoreWithScores(key, min, max);
        }catch(Exception e){
            logger.error("[异常]zrangeByScoreWithScores[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(String key, String min, String max){
        Set<Tuple> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrangeByScoreWithScores(key, min, max);
        }catch(Exception e){
            logger.error("[异常]zrangeByScoreWithScores[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<byte[]> zrangeByScore(byte[] key, byte[] min, byte[] max, int offset, int count){
        Set<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrangeByScore(key, min, max, offset, count);
        }catch(Exception e){
            logger.error("[异常]zrangeByScore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<byte[]> zrangeByScore(byte[] key, double min, double max, int offset, int count){
        Set<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrangeByScore(key, min, max, offset, count);
        }catch(Exception e){
            logger.error("[异常]zrangeByScore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<String> zrangeByScore(String key, double min, double max, int offset, int count){
        Set<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrangeByScore(key, min, max, offset, count);
        }catch(Exception e){
            logger.error("[异常]zrangeByScore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<String> zrangeByScore(String key, String min, String max, int offset, int count){
        Set<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrangeByScore(key, min, max, offset, count);
        }catch(Exception e){
            logger.error("[异常]zrangeByScore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(byte[] key, byte[] min, byte[] max, int offset, int count){
        Set<Tuple> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrangeByScoreWithScores(key, min, max, offset, count);
        }catch(Exception e){
            logger.error("[异常]zrangeByScoreWithScores[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(byte[] key, double min, double max, int offset, int count){
        Set<Tuple> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrangeByScoreWithScores(key, min, max, offset, count);
        }catch(Exception e){
            logger.error("[异常]zrangeByScoreWithScores[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max, int offset, int count){
        Set<Tuple> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrangeByScoreWithScores(key, min, max, offset, count);
        }catch(Exception e){
            logger.error("[异常]zrangeByScoreWithScores[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(String key, String min, String max, int offset, int count){
        Set<Tuple> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrangeByScoreWithScores(key, min, max, offset, count);
        }catch(Exception e){
            logger.error("[异常]zrangeByScoreWithScores[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zrank(byte[] key, byte[] member){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrank(key, member);
        }catch(Exception e){
            logger.error("[异常]zrank[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zrank(String key, String member){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrank(key, member);
        }catch(Exception e){
            logger.error("[异常]zrank[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zrem(byte[] key, byte[]... members){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrem(key, members);
        }catch(Exception e){
            logger.error("[异常]zrem[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zrem(String key, String... members){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrem(key, members);
        }catch(Exception e){
            logger.error("[异常]zrem[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zremrangeByRank(byte[] key, long start, long end){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zremrangeByRank(key, start, end);
        }catch(Exception e){
            logger.error("[异常]zremrangeByRank[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zremrangeByRank(String key, long start, long end){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zremrangeByRank(key, start, end);
        }catch(Exception e){
            logger.error("[异常]zremrangeByRank[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zremrangeByScore(byte[] key, byte[] start, byte[] end){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zremrangeByScore(key, start, end);
        }catch(Exception e){
            logger.error("[异常]zremrangeByScore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zremrangeByScore(byte[] key, double start, double end){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zremrangeByScore(key, start, end);
        }catch(Exception e){
            logger.error("[异常]zremrangeByScore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zremrangeByScore(String key, double start, double end){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zremrangeByScore(key, start, end);
        }catch(Exception e){
            logger.error("[异常]zremrangeByScore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zremrangeByScore(String key, String start, String end){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zremrangeByScore(key, start, end);
        }catch(Exception e){
            logger.error("[异常]zremrangeByScore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<byte[]> zrevrange(byte[] key, long start, long end){
        Set<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrevrange(key, start, end);
        }catch(Exception e){
            logger.error("[异常]zrevrange[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<String> zrevrange(String key, long start, long end){
        Set<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrevrange(key, start, end);
        }catch(Exception e){
            logger.error("[异常]zrevrange[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<byte[]> zrevrangeByScore(byte[] key, byte[] max, byte[] min){
        Set<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrevrangeByScore(key, max, min);
        }catch(Exception e){
            logger.error("[异常]zrevrangeByScore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<byte[]> zrevrangeByScore(byte[] key, double max, double min){
        Set<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrevrangeByScore(key, max, min);
        }catch(Exception e){
            logger.error("[异常]zrevrangeByScore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<String> zrevrangeByScore(String key, double max, double min){
        Set<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrevrangeByScore(key, max, min);
        }catch(Exception e){
            logger.error("[异常]zrevrangeByScore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<String> zrevrangeByScore(String key, String max, String min){
        Set<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrevrangeByScore(key, max, min);
        }catch(Exception e){
            logger.error("[异常]zrevrangeByScore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, byte[] max, byte[] min){
        Set<Tuple> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrevrangeByScoreWithScores(key, max, min);
        }catch(Exception e){
            logger.error("[异常]zrevrangeByScoreWithScores[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, double max, double min){
        Set<Tuple> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrevrangeByScoreWithScores(key, max, min);
        }catch(Exception e){
            logger.error("[异常]zrevrangeByScoreWithScores[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min){
        Set<Tuple> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrevrangeByScoreWithScores(key, max, min);
        }catch(Exception e){
            logger.error("[异常]zrevrangeByScoreWithScores[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(String key, String max, String min){
        Set<Tuple> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrevrangeByScoreWithScores(key, max, min);
        }catch(Exception e){
            logger.error("[异常]zrevrangeByScoreWithScores[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<byte[]> zrevrangeByScore(byte[] key, byte[] max, byte[] min, int offset, int count){
        Set<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrevrangeByScore(key, max, min, offset, count);
        }catch(Exception e){
            logger.error("[异常]zrevrangeByScore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<byte[]> zrevrangeByScore(byte[] key, double max, double min, int offset, int count){
        Set<byte[]> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrevrangeByScore(key, max, min, offset, count);
        }catch(Exception e){
            logger.error("[异常]zrevrangeByScore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<String> zrevrangeByScore(String key, double max, double min, int offset, int count){
        Set<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrevrangeByScore(key, max, min, offset, count);
        }catch(Exception e){
            logger.error("[异常]zrevrangeByScore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<String> zrevrangeByScore(String key, String max, String min, int offset, int count){
        Set<String> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrevrangeByScore(key, max, min, offset, count);
        }catch(Exception e){
            logger.error("[异常]zrevrangeByScore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, byte[] max, byte[] min, int offset, int count){
        Set<Tuple> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrevrangeByScoreWithScores(key, max, min, offset, count);
        }catch(Exception e){
            logger.error("[异常]zrevrangeByScoreWithScores[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, double max, double min, int offset, int count){
        Set<Tuple> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrevrangeByScoreWithScores(key, max, min, offset, count);
        }catch(Exception e){
            logger.error("[异常]zrevrangeByScoreWithScores[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min, int offset, int count){
        Set<Tuple> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrevrangeByScoreWithScores(key, max, min, offset, count);
        }catch(Exception e){
            logger.error("[异常]zrevrangeByScoreWithScores[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(String key, String max, String min, int offset, int count){
        Set<Tuple> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrevrangeByScoreWithScores(key, max, min, offset, count);
        }catch(Exception e){
            logger.error("[异常]zrevrangeByScoreWithScores[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zrevrank(byte[] key, byte[] member){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrevrank(key, member);
        }catch(Exception e){
            logger.error("[异常]zrevrank[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zrevrank(String key, String member){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zrevrank(key, member);
        }catch(Exception e){
            logger.error("[异常]zrevrank[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Double zscore(byte[] key, byte[] member){
        Double result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zscore(key, member);
        }catch(Exception e){
            logger.error("[异常]zscore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Double zscore(String key, String member){
        Double result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zscore(key, member);
        }catch(Exception e){
            logger.error("[异常]zscore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zunionstore(byte[] dstkey, byte[]... sets){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zunionstore(dstkey, sets);
        }catch(Exception e){
            logger.error("[异常]zunionstore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zunionstore(String dstkey, String... sets){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zunionstore(dstkey, sets);
        }catch(Exception e){
            logger.error("[异常]zunionstore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zunionstore(byte[] dstkey, ZParams params, byte[]... sets){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zunionstore(dstkey, params, sets);
        }catch(Exception e){
            logger.error("[异常]zunionstore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zunionstore(String dstkey, ZParams params, String... sets){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zunionstore(dstkey, params, sets);
        }catch(Exception e){
            logger.error("[异常]zunionstore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zinterstore(byte[] dstkey, byte[]... sets){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zinterstore(dstkey, sets);
        }catch(Exception e){
            logger.error("[异常]zinterstore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zinterstore(String dstkey, String... sets){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zinterstore(dstkey, sets);
        }catch(Exception e){
            logger.error("[异常]zinterstore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zinterstore(byte[] dstkey, ZParams params, byte[]... sets){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zinterstore(dstkey, params, sets);
        }catch(Exception e){
            logger.error("[异常]zinterstore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Long zinterstore(String dstkey, ZParams params, String... sets){
        Long result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zinterstore(dstkey, params, sets);
        }catch(Exception e){
            logger.error("[异常]zinterstore[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public ScanResult<Tuple> zscan(byte[] key, byte[] cursor){
        ScanResult<Tuple> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zscan(key, cursor);
        }catch(Exception e){
            logger.error("[异常]zscan[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Deprecated
    @Override
    public ScanResult<Tuple> zscan(String key, int cursor){
        ScanResult<Tuple> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zscan(key, cursor);
        }catch(Exception e){
            logger.error("[异常]zscan[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public ScanResult<Tuple> zscan(String key, String cursor){
        ScanResult<Tuple> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zscan(key, cursor);
        }catch(Exception e){
            logger.error("[异常]zscan[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public ScanResult<Tuple> zscan(byte[] key, byte[] cursor, ScanParams params){
        ScanResult<Tuple> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zscan(key, cursor, params);
        }catch(Exception e){
            logger.error("[异常]zscan[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Deprecated
    @Override
    public ScanResult<Tuple> zscan(String key, int cursor, ScanParams params){
        ScanResult<Tuple> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zscan(key, cursor, params);
        }catch(Exception e){
            logger.error("[异常]zscan[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public ScanResult<Tuple> zscan(String key, String cursor, ScanParams params){
        ScanResult<Tuple> result = null;
        Jedis jedis = null;
        try{
            jedis = this.getResource();
            result = jedis.zscan(key, cursor, params);
        }catch(Exception e){
            logger.error("[异常]zscan[" + e.getMessage() + "]");
            throw e;
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return result;
    }
}
